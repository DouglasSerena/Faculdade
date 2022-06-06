const toBoolean = (variable: string) => variable === "true";

export const environment = {
  PRODUCTION: toBoolean(process.env.PRODUCTION!),
  URL_API: process.env.URL_API!,
};
