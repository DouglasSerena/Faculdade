import { FC } from "react";
import Nav from "../Nav";

interface INavProp {
  onRouter?: (router: string) => void;
}

const Header: FC<INavProp> = ({ onRouter }) => {
  return (
    <header>
      <Nav onRouter={onRouter} />
    </header>
  );
};

export default Header;
