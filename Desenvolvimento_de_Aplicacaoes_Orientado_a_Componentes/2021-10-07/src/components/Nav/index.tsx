import { FC } from "react";

interface INavProp {
  onRouter?: (router: string) => void;
}

const Nav: FC<INavProp> = ({ onRouter }) => {
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
            <span
              role="link"
              className="nav-link active"
              onClick={() => onRouter?.("home")}
            >
              Home
            </span>
            <span
              role="link"
              className="nav-link"
              onClick={() => onRouter?.("features")}
            >
              Features
            </span>
            <span
              role="link"
              className="nav-link"
              onClick={() => onRouter?.("pricing")}
            >
              Pricing
            </span>
            <span
              role="link"
              tabIndex={-1}
              className="nav-link disabled"
              onClick={() => onRouter?.("disabled")}
            >
              Disabled
            </span>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Nav;
