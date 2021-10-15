import { FC } from "react";
import Nav from "../Nav";

interface INavProp {}

const Header: FC<INavProp> = () => {
  return (
    <header>
      <Nav />
    </header>
  );
};

export default Header;
