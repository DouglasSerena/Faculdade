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
        <Icon>widgets</Icon>
      </Style.Toggle>
      <Style.Nav open={open}>
        <Style.Toggle onClick={() => setOpen(!open)}>
          <Icon>close</Icon>
        </Style.Toggle>

        {/* CONTATO */}
        <NavLink
          exact
          to="/contact"
          activeClassName="-active"
          onClick={() => setOpen(false)}
        >
          CONTATO
        </NavLink>

        {isAdmin && (
          <>
            {/* LISTAR CONTATOS */}
            <NavLink
              onClick={() => setOpen(false)}
              exact
              to="/contact/list"
              activeClassName="-active"
            >
              LISTAR CONTATOS
            </NavLink>

            {/* PRODUTOS */}
            <NavLink
              onClick={() => setOpen(false)}
              exact
              to="/product"
              activeClassName="-active"
            >
              PRODUTOS
            </NavLink>

            {/* CLIENTS */}
            <NavLink
              onClick={() => setOpen(false)}
              exact
              to="/client"
              activeClassName="-active"
            >
              CLIENTES
            </NavLink>
          </>
        )}

        {/* SOBRE */}
        <NavLink
          onClick={() => setOpen(false)}
          exact
          to="/about"
          activeClassName="-active"
        >
          SOBRE
        </NavLink>

        {isAdmin ? (
          // SAIR
          <Link onClick={() => setOpen(false)} to="/">
            <Style.Button onClick={logout}>
              <Icon>logout</Icon>
              Sair
            </Style.Button>
          </Link>
        ) : (
          // LOGAR
          <Link onClick={() => setOpen(false)} to="/login">
            <Style.Button>
              <Icon>login</Icon>
              Login
            </Style.Button>
          </Link>
        )}
      </Style.Nav>
    </Style.Container>
  );
};

export default Nav;
