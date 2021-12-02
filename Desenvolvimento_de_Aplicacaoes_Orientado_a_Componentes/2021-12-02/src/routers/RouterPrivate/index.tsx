import { Route } from "react-router";
import Clients from "src/pages/private/Clients";
import Contacts from "src/pages/private/Contacts";
import Products from "src/pages/private/Products";
import Guard from "../Guard";

const RouterPrivate = () => {
  return (
    <Guard.Auth>
      <Route path="/contact/list">
        <Contacts />
        <Route
          exact
          path="/contact/list/delete/:contactId"
          component={Contacts.ContactDelete}
        />
        <Route
          exact
          path="/contact/list/response/:contactId"
          component={Contacts.ContactResponse}
        />
      </Route>
      <Route path="/client">
        <Clients />
        <Route
          exact
          path="/client/delete/:clientId"
          component={Clients.ClientDelete}
        />
        <Route
          exact
          path="/client/form/:clientId"
          component={Clients.ClientForm}
        />
        <Route exact path="/client/form" component={Clients.ClientForm} />
      </Route>

      <Route exact path="/product" component={Products} />
      <Route exact path="/product/:categoryId" component={Products} />
    </Guard.Auth>
  );
};

export default RouterPrivate;
