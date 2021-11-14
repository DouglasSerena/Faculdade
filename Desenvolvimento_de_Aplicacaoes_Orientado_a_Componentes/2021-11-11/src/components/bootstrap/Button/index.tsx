import { ButtonHTMLAttributes, FC } from "react";

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
    className={`btn ${color ? `btn-${color}` : ""} ${attr.className}`}
  >
    {children}
  </button>
);

export default Button;
