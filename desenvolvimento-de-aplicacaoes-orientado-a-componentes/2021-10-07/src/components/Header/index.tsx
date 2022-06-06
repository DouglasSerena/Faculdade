import { FC } from "react";
import { Link, useRoute } from "../../routers";
import Nav from "../Nav";

interface INavProp {
  onRouter?: (router: string) => void;
}

const Header: FC<INavProp> = ({ onRouter }) => {
  return (
    <header>
      <Link to="/login">login</Link>
      <Nav onRouter={onRouter} />
    </header>
  );
};

export default Header;
