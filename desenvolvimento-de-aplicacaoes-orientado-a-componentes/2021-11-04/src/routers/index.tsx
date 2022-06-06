import { BrowserRouter, Route, Switch } from "react-router-dom";
import { Container } from "../container";

import About from "../pages/About";
import Contact from "../pages/Contact";
import Landing from "../pages/Landing";
import Login from "../pages/Login";
import Product from "../pages/Product";
import RoutePrivate from "./PrivateRouter";

function Routes() {
  return (
    <BrowserRouter>
      <Container.Main>
        <Switch>
          <Route exact path="/" component={Landing} />
          <Route exact path="/login" component={Login} />
          <Route exact path="/about" component={About} />
          <Route exact path="/contact" component={Contact} />
          <RoutePrivate exact path="/contact/list" component={Contact.List} />
          <RoutePrivate exact path="/product" component={Product} />
          <RoutePrivate exact path="/product/:categoryId" component={Product} />
        </Switch>
      </Container.Main>
    </BrowserRouter>
  );
}

export default Routes;
