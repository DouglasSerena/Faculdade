import { ButtonHTMLAttributes, FC } from "react";
import { classNames } from "src/utils/class-names";

export interface IButtonProp extends ButtonHTMLAttributes<HTMLButtonElement> {
  color?:
    | "primary"
    | "danger"
    | "warning"
    | "secondary"
    | "success"
    | "info"
    | "light"
    | "dark"
    | "link";
}

const Button: FC<IButtonProp> = ({ children, color, ...attr }) => (
  <button
    {...attr}
    className={classNames(
      "d-flex align-items-center btn",
      `btn-${color}`,
      attr.className
    )}
  >
    {children}
  </button>
);

export default Button;
