import { resolve } from "path";
import { readFileSync, writeFileSync } from "fs";
import faker from "faker";
import {
  AMOUNT,
  FILE_TABLES,
  FOLDER_RESULT,
  NAME_FILTERS,
  TYPES_WITHOUT_ZEST,
} from "./config";

faker.commerce.productName();
function execute(command: string) {
  return eval(`
    const faker = require('faker/locale/pt_BR');
    const dayjs = require('dayjs');
    const $ = require('./functions')

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
          let name = _.match(/^([\w\d_-]*)/gi)?.[0]
            .trim()
            .toLowerCase();
          let type = _.match(/\s([\w\d_-]*)/gi)?.[0]
            .trim()
            .toLowerCase();
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
  const tables = sql.match(/CREATE\sTABLE([.\s\S\r\n]*?)\);/gi);

  for (const table of tables ?? []) {
    const { name, fields } = tableToJson(table);
    const values = Array.from({ length: AMOUNT }).map(() => {
      const values: string[] = [];
      for (const field of Object.values(fields)) {
        if (TYPES_WITHOUT_ZEST.includes(field.type.toUpperCase())) {
          values.push(`${execute(field.command)}`);
        } else {
          values.push(`'${`${execute(field.command)}`.replace("'", "")}'`);
        }
      }
      return `(${values.join(",")})`;
    });

    writeFileSync(
      resolve(FOLDER_RESULT, `${name}.sql`),
      `${table}\n\nINSERT INTO ${name} (${Object.keys(
        fields
      )})\n\tVALUES ${values.join(",")}`
    );
  }
}

main();
