import { ButtonHTMLAttributes, FC } from "react";

interface IButtonProp extends ButtonHTMLAttributes<HTMLButtonElement> {
  color: "primary" | "danger" | "warning";
}

const Button: FC<IButtonProp> = ({ children, color, ...attr }) => (
  <button {...attr} className={`btn btn-${color} ${attr.className}`}>
    {children}
  </button>
);

export default Button;
