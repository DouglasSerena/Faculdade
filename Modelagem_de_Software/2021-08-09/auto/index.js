const { promisify } = require("util");
const glob = require("glob");
const path = require("path");
const fs = require("fs");

const globPromisify = promisify(glob);

async function main() {
  const output = path.resolve(__dirname, "..", "user_stories", "readme.md");
  const outputStream = fs.createWriteStream(output);

  const dirs = await globPromisify(
    path.resolve(__dirname, "..", "user_stories", "stories", "*"),
    {
      ignore: [path.resolve(__dirname, "..", "auto"), output],
    }
  );

  for (let dir of dirs) {
    createReadme(dir);
  }

  outputStream.write(
    fs.readFileSync(path.join(__dirname, "..", "user_stories", "header.md"))
  );
  outputStream.write("\n\n");

  const files = await globPromisify(
    path.resolve(__dirname, "..", "user_stories", "stories", "**", "readme.md"),
    {
      ignore: [path.resolve(__dirname, "..", "auto"), output],
    }
  );

  for await (let file of files) {
    await new Promise((resolve) => {
      fs.createReadStream(file)
        .on("data", (chunk) => {
          outputStream.write(chunk);
          outputStream.write("\n\n");
        })
        .on("resume", () => resolve(null));
    });
  }
}

async function createReadme(dir) {
  const outputStream = fs.createWriteStream(path.join(dir, "readme.md"));

  const files = await globPromisify(path.join(dir, "**", "*.md"), {
    ignore: [path.join(dir, "header.md"), path.join(dir, "readme.md")],
  });

  outputStream.write(fs.readFileSync(path.join(dir, "header.md")));
  outputStream.write("\n\n");

  for await (let file of files) {
    await new Promise((resolve) => {
      fs.createReadStream(file)
        .on("data", (chunk) => {
          outputStream.write(chunk);
          outputStream.write("\n\n");
        })
        .on("resume", () => resolve(null));
    });
  }
}

main();
