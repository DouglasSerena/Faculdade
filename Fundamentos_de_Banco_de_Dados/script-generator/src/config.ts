import { resolve } from "path";
import config from "./../config.json";

export const AMOUNT = config.AMOUNT;
export const FILE_DUMP = resolve(__dirname, "..", config.FILE_DUMP);
export const FILE_TABLES = resolve(__dirname, "..", config.FILE_TABLES);
export const FOLDER_RESULT = resolve(__dirname, "..", config.FOLDER_RESULT);
export const NAME_FILTERS = config.NAME_FILTERS;
export const TYPES_WITHOUT_ZEST = config.TYPES_WITHOUT_ZEST;
