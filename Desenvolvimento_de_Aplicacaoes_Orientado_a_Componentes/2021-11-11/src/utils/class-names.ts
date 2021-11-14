export function classNames(classNames: {
  [key: string]: undefined | null | boolean;
}) {
  const classes: any[] = [];

  for (let key in classNames) {
    if (classNames[key] && !classes.includes(key)) {
      classes.push(key);
    }
  }

  return classes.join(" ");
}
