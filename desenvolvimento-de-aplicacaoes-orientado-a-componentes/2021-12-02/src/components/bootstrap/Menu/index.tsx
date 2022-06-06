import { ButtonHTMLAttributes, FC, HTMLAttributes } from "react";

const Menu: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <div
    {...attr}
    role="menu"
    className={`dropdown-menu dropdown-menu-dark ${attr.className || ""}`}
  >
    {children}
  </div>
);
const Item: FC<ButtonHTMLAttributes<HTMLButtonElement>> = ({
  children,
  ...attr
}) => (
  <button
    {...attr}
    role="menuitem"
    style={{ cursor: "pointer", userSelect: "none" }}
    className={`dropdown-item d-flex align-items-center ${
      attr.className || ""
    }`}
  >
    {children}
  </button>
);
const Divider: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <div {...attr} className={`dropdown-divider ${attr.className || ""}`}>
    {children}
  </div>
);

export default Object.assign(Menu, {
  Divider,
  Item,
});
