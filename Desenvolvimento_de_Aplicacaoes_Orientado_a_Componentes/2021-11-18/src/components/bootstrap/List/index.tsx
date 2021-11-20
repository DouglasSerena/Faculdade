import { FC, HTMLAttributes } from "react";

const List: FC<HTMLAttributes<HTMLLIElement>> = ({ children, ...attr }) => (
  <li {...attr} className={`list-group ${attr.className || ""}`}>
    {children}
  </li>
);
const Item: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => {
  return (
    <div
      {...attr}
      className={`list-group-item border mb-2 rounded ${attr.className || ""}`}
    >
      {children}
    </div>
  );
};
const Header: FC<HTMLAttributes<HTMLElement>> = ({ children, ...attr }) => (
  <div
    {...attr}
    className={`mb-1 d-flex justify-content-between ${attr.className || ""}`}
  >
    {children}
  </div>
);
const Title: FC<HTMLAttributes<HTMLElement>> = ({ children, ...attr }) => (
  <h5 {...attr} className={`mb-1 ${attr.className || ""}`}>
    {children}
  </h5>
);
const Subtitle: FC<HTMLAttributes<HTMLElement>> = ({ children, ...attr }) => (
  <h6 {...attr} className={`mb-1 mt-2 fw-bold ${attr.className || ""}`}>
    {children}
  </h6>
);
const Text: FC<HTMLAttributes<HTMLParagraphElement>> = ({
  children,
  ...attr
}) => (
  <p {...attr} className={`mb-1 text-muted ${attr.className || ""}`}>
    {children}
  </p>
);

export default Object.assign(List, {
  Subtitle,
  Header,
  Title,
  Text,
  Item,
});
