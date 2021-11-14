import { FC } from "react";
import { Link } from "react-router-dom";
import Icon from "src/components/Icon";
import Nav from "./Nav";
import { Style } from "./style";

interface INavProp {}

const Header: FC<INavProp> = () => {
  return (
    <Style.Header className="container-fluid">
      <Style.Title>
        <Link to="/">
          <Icon>bxs-skull</Icon>
          Halloween
        </Link>
      </Style.Title>
      <Nav />
    </Style.Header>
  );
};

export default Header;
