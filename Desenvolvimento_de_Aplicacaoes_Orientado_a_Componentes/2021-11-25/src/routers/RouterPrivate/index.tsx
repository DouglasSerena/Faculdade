import { Route } from "react-router";
import Client from "src/pages/private/Client";
import Contact from "src/pages/private/Contact";
import Product from "src/pages/private/Product";
import Guard from "../Guard";

const RouterPrivate = () => {
  return (
    <Guard.Auth>
      <Route path="/contact/list">
        <Contact />
        <Route
          exact
          path="/contact/list/delete/:contactId"
          component={Contact.ContactDelete}
        />
        <Route
          exact
          path="/contact/list/response/:contactId"
          component={Contact.ContactResponse}
        />
      </Route>
      <Route path="/client">
        <Client />
        <Route
          exact
          path="/client/delete/:clientId"
          component={Client.ClientDelete}
        />
        <Route exact path="/client/form/:clientId" component={Client.ClientForm} />
        <Route exact path="/client/form" component={Client.ClientForm} />
      </Route>

      <Route exact path="/product" component={Product} />
      <Route exact path="/product/:categoryId" component={Product} />
    </Guard.Auth>
  );
};

export default RouterPrivate;
