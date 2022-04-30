import { FC, HTMLAttributes } from "react";
// import { classNames } from "src/utils/class-names";

// interface IPropIcon {}

const Icon: FC<HTMLAttributes<HTMLElement>> = ({ children, ...rest }) => {
  return <i {...rest} className={`bx  ${children} ${rest.className}`}></i>;
};

export default Icon;
