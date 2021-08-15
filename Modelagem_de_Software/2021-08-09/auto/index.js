const { promisify } = require("util");
const prettier = require("prettier");
const glob = require("glob");
const path = require("path");
const fs = require("fs");

const globPromisify = promisify(glob);

async function main() {
  const output = path.resolve(__dirname, "..", "user_stories", "readme.md");
  const stream = fs.createWriteStream(output);

  const dirs = await globPromisify(
    path.resolve(__dirname, "..", "user_stories", "stories", "*"),
    { ignore: [path.resolve(__dirname, "..", "auto"), output] }
  );

  for (let dir of dirs) {
    createReadme(dir);
  }

  writeFile(path.join(__dirname, "..", "user_stories", "header.md"), stream);

  const files = await globPromisify(
    path.resolve(__dirname, "..", "user_stories", "stories", "**", "readme.md"),
    { ignore: [path.resolve(__dirname, "..", "auto"), output] }
  );

  for await (let file of files) {
    await writeFile(file, stream);
  }
}

async function createReadme(output) {
  const stream = fs.createWriteStream(path.join(output, "readme.md"));

  const files = await globPromisify(path.join(output, "**", "*.md"), {
    ignore: [path.join(output, "header.md"), path.join(output, "readme.md")],
  });

  writeFile(path.join(output, "header.md"), stream);

  for await (let file of files) {
    await writeFile(file, stream);
  }
}

function writeFile(file, outputStream) {
  return new Promise((resolve) => {
    fs.createReadStream(file)
      .on("data", (chunk) => {
        outputStream.write(
          prettier.format(chunk.toString("utf-8"), {
            parser: "markdown",
          })
        );
      })
      .on("resume", () => {
        resolve(null);
      });
  });
}

main();
