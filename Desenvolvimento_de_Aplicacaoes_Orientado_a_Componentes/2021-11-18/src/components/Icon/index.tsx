import { FC, HTMLAttributes } from "react";
// import { classNames } from "src/utils/class-names";

// interface IPropIcon {}

const Icon: FC<HTMLAttributes<HTMLElement>> = ({ children, ...rest }) => {
  return (
    <i {...rest} className={`material-icons ${rest.className}`}>
      {children}
    </i>
  );
};

export default Icon;
