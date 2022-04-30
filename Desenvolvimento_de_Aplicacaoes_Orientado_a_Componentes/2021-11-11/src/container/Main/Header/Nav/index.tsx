import { FC, useState } from "react";
import { Link, NavLink } from "react-router-dom";
import Icon from "src/components/Icon";
import { useAuth } from "src/context/Auth";
import { Style } from "./style";

interface INavProp {}

const Nav: FC<INavProp> = () => {
  const { isAdmin, logout } = useAuth();
  const [open, setOpen] = useState(false);

  return (
    <Style.Container>
      <Style.Toggle onClick={() => setOpen(!open)}>
        <Icon>bx-grid-alt</Icon>
      </Style.Toggle>
      <Style.Nav open={open}>
        <Style.Toggle onClick={() => setOpen(!open)}>
          <Icon>bx-x</Icon>
        </Style.Toggle>

        <NavLink
          exact
          to="/contact"
          activeClassName="-active"
          onClick={() => setOpen(false)}
        >
          CONTATO
        </NavLink>
        {isAdmin && (
          <NavLink
            onClick={() => setOpen(false)}
            exact
            to="/contact/list"
            activeClassName="-active"
          >
            LISTAR CONTATOS
          </NavLink>
        )}
        {isAdmin && (
          <NavLink
            onClick={() => setOpen(false)}
            exact
            to="/product"
            activeClassName="-active"
          >
            PRODUTOS
          </NavLink>
        )}
        <NavLink
          onClick={() => setOpen(false)}
          exact
          to="/about"
          activeClassName="-active"
        >
          SOBRE
        </NavLink>

        {!isAdmin && (
          <Link onClick={() => setOpen(false)} to="/login">
            <Style.Button>
              <Icon>bx-log-in-circle</Icon>
              Login
            </Style.Button>
          </Link>
        )}
        {isAdmin && (
          <Link onClick={() => setOpen(false)} to="/">
            <Style.Button onClick={logout}>
              <Icon>bx-log-out-circle</Icon>
              Sair
            </Style.Button>
          </Link>
        )}
      </Style.Nav>
    </Style.Container>
  );
};

export default Nav;
