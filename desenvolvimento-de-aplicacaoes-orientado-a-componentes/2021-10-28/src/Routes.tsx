import { BrowserRouter, Route, Switch } from "react-router-dom";
import Footer from "./components/Footer";
import Header from "./components/Header";

import About from "./pages/About";
import Contact from "./pages/Contact";
import Landing from "./pages/Landing";
import Product from "./pages/Product";

function Routes() {
  return (
    <BrowserRouter>
      <Header />
      <Switch>
        <Route exact path="/" component={Landing} />
        <Route exact path="/about" component={About} />
        <Route exact path="/contact" component={Contact} />
        <Route exact path="/contact/list" component={Contact.List} />
        <Route exact path="/product" component={Product} />
        <Route exact path="/product/:categoryId" component={Product} />
      </Switch>
      <Footer />
    </BrowserRouter>
  );
}

export default Routes;
