import { resolve } from "path";

export const AMOUNT = 1000;
export const FILE_DUMP = resolve(__dirname, "..", "dump.sql");
export const FILE_TABLES = resolve(__dirname, "..", "tables.sql");
export const FOLDER_RESULT = resolve(__dirname, "..", "data");
export const NAME_FILTERS = ["foreign"];
export const TYPES_WITHOUT_ZEST = [
  "SERIAL",
  "BINARY",
  "INT",
  "INTEGER",
  "DOUBLE",
  "DECIMAL",
  "FLOAT",
  "BOOL",
  "BOOLEAN",
];
