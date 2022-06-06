export function classNames(
  ...classNames: (string | undefined | { [key: string]: any } | string[])[]
) {
  let names = classNames.reduce((names: any[], name) => {
    if (typeof name === "string" || Array.isArray(name)) {
      return names.concat(name);
    }
    if (typeof name === "object") {
      return names.concat(
        Object.entries(name).reduce((prev, [key, value]) => {
          if (!!value) {
            prev.push(key);
          }
          return prev;
        }, [] as string[])
      );
    }
    return names;
  }, [] as string[]);

  return names.join(" ");
}
