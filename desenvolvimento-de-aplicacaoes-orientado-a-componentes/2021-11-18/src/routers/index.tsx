import { BrowserRouter, Route, Switch } from "react-router-dom";
import Contact from "src/pages/Contact";
import { Container } from "../container";

import About from "../pages/About";
import Landing from "../pages/Landing";
import Login from "../pages/Login";
import RouterPrivate from "./RouterPrivate";

function Routes() {
  return (
    <BrowserRouter>
      <Container.Main>
        <Switch>
          <Route exact path="/" component={Landing} />
          <Route exact path="/login" component={Login} />
          <Route exact path="/about" component={About} />
          <Route exact path="/contact" component={Contact} />

          <RouterPrivate />
        </Switch>
      </Container.Main>
    </BrowserRouter>
  );
}

export default Routes;
