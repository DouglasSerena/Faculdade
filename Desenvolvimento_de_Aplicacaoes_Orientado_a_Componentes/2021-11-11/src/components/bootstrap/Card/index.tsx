import { FC, HTMLAttributes, ImgHTMLAttributes } from "react";

const Card: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <div {...attr} className={`card ${attr.className || ""}`}>
    {children}
  </div>
);
const Header: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <div {...attr} className={`card-header ${attr.className || ""}`}>
    {children}
  </div>
);
const Body: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <div {...attr} className={`card-body ${attr.className || ""}`}>
    {children}
  </div>
);
const Title: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <h5 {...attr} className={`card-title ${attr.className || ""}`}>
    {children}
  </h5>
);
const Text: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <p {...attr} className={`card-text ${attr.className || ""}`}>
    {children}
  </p>
);
const Image: FC<ImgHTMLAttributes<HTMLImageElement>> = (attr) => (
  <img
    {...attr}
    src={attr.src}
    alt={attr.alt}
    className={`card-img-top ${attr.className || ""}`}
  />
);

export default Object.assign(Card, {
  Body,
  Text,
  Title,
  Header,
  Image,
});
