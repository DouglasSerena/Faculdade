import { FC } from "react";
import { NavLink } from "react-router-dom";

interface INavProp {}

const Nav: FC<INavProp> = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container-fluid">
        <span role="link" className="navbar-brand">
          Navbar
        </span>
        <button className="navbar-toggler" type="button">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div className="navbar-nav">
            <NavLink to="/" exact activeClassName="active" className="nav-link">
              HOME
            </NavLink>
            <NavLink
              to="/contact"
              className="nav-link"
              activeClassName="active"
            >
              CONTATO
            </NavLink>
            <NavLink
              to="/product"
              className="nav-link"
              activeClassName="active"
            >
              PRODUTOS
            </NavLink>
            <NavLink to="/about" activeClassName="active" className="nav-link">
              SOBRE
            </NavLink>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Nav;
