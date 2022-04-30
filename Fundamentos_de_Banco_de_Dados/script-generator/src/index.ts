import { resolve } from "path";
import {
  appendFileSync,
  existsSync,
  mkdirSync,
  readFileSync,
  rmSync,
  writeFileSync,
} from "fs";
import glob from "glob-promise";
import {
  AMOUNT,
  FILE_DUMP,
  FILE_TABLES,
  FOLDER_RESULT,
  NAME_FILTERS,
  TYPES_WITHOUT_ZEST,
} from "./config";
import faker from "faker";

function execute(command: string) {
  return eval(`
    const faker = require('faker/locale/pt_BR');
    const dayjs = require('dayjs');
    const $ = require('./functions.js')

    exports.value = ${command}
  `);
}

function tableToJson(table: string): {
  name: string;
  fields: { [key: string]: { type: string; command: string } };
} {
  const tableName =
    table.match(/(?<=CREATE\sTABLE\s)([\w\d_-]*)/gi)?.[0] || "{{tableName}}";
  const fields = table
    .match(/(?<=\(\s)([\s\S]*)\s/gi)
    ?.reduce((fields, field) => {
      const lines = field
        .match(/.*/gi)
        ?.map((_) => _.trim())
        .filter((_) => _.length);

      fields.push(
        lines?.reduce((obj, _) => {
          let name = _.match(/^([\w\d_-]*)/gi)?.[0];
          name = name.trim().toLowerCase();

          let type = _.match(/\s([\w\d_-]*)/gi)?.[0];
          type = type.trim().toLowerCase();

          let command = _.match(/(?<=--eval\()(.*)/gi)?.[0].trim();

          if (name && command && type && !NAME_FILTERS.includes(name)) {
            obj = {
              ...obj,
              [name!]: { type, command: command.substr(0, command.length - 1) },
            };
          }

          return obj;
        }, {} as any)
      );

      return fields;
    }, [] as any)[0];

  return {
    name: tableName,
    fields: fields,
  };
}

async function main() {
  const sql = readFileSync(FILE_TABLES, { encoding: "utf-8" }).toString();
  const tables = sql.match(/CREATE\sTABLE([.\s\S\r\n]*?)\);/gi) ?? [];

  if (existsSync(FOLDER_RESULT)) {
    rmSync(FOLDER_RESULT, { recursive: true });
  }
  mkdirSync(FOLDER_RESULT);

  tables.forEach((table, index) => {
    const { name, fields } = tableToJson(table);
    const values = Array.from({ length: AMOUNT }).map(() => {
      const values: string[] = [];
      for (const field of Object.values(fields)) {
        if (TYPES_WITHOUT_ZEST.includes(field.type.toUpperCase())) {
          values.push(`${execute(field.command)}`);
        } else {
          values.push(`'${`${execute(field.command)}`.replace(/['"]/g, "")}'`);
        }
      }
      return `(${values.join(",")})`;
    });

    writeFileSync(
      resolve(FOLDER_RESULT, `${index}_${name}.sql`),
      `INSERT INTO ${name} (${Object.keys(fields)})\n\tVALUES ${values.join(
        ","
      )};\n\n`
    );
  });

  writeFileSync(FILE_DUMP, "");
  for (const file of await glob(`${FOLDER_RESULT}/**/*.sql`)) {
    appendFileSync(FILE_DUMP, readFileSync(file));
  }
}

main();
