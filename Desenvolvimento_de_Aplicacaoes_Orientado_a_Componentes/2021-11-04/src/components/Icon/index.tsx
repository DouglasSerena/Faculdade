import { FC } from "react";
// import { classNames } from "src/utils/class-names";

// interface IPropIcon {}

const Icon: FC = ({ children }) => {
  // const classes = classNames({});

  return <i className={`bx  ${children}`}></i>;
};

export default Icon;
