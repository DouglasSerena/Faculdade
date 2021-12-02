import api from "src/api";
import { useCallback, useEffect, useState } from "react";
import { CONTACT_STATUS, IContact } from "src/interfaces/contact.interface";
import { handleTry } from "src/utils/handle-try";
import List from "src/components/bootstrap/List";
import Button from "src/components/bootstrap/Button";
import Icon from "src/components/Icon";
import Menu from "src/components/bootstrap/Menu";
import { useHistory, useLocation } from "react-router";
import { Style } from "./style";
import Field from "src/components/Field";
import ContactResponse from "./ContactResponse";
import ContactDelete from "./ContactDelete";
import { classNames } from "src/utils/class-names";

function Contacts() {
  const history = useHistory();
  const location = useLocation();
  const [contacts, setContacts] = useState<IContact[]>([]);

  const handleContact = useCallback(async () => {
    const [data, error] = await handleTry(api.get<IContact[]>("/contacts"));
    if (!error && Array.isArray(data.data)) {
      setContacts(data.data.sort((a, b) => a.status.localeCompare(b.status)));
    }
  }, []);

  useEffect(() => {
    if (location.pathname === "/contact/list") {
      handleContact();
    }
  }, [location, handleContact]);

  return (
    <main className="main container">
      <div className="py-3 d-flex justify-content-between">
        <h3>Listagem de contatos</h3>
      </div>

      <div className="mb-2">
        <Field.Search path="/contacts/search/{value}" onSearch={setContacts} />
      </div>

      <List>
        {contacts.map((contact, index) => (
          <List.Item key={index}>
            <Style.Flag
              className={
                contact.status === CONTACT_STATUS.CLOSE
                  ? "bg-success"
                  : "bg-danger"
              }
            />

            <List.Header>
              <List.Title>
                <strong>#{contact.idContact}</strong> {contact.name}
              </List.Title>

              <div className="dropstart d-flex align-items-center">
                <span
                  className={classNames({
                    "text-success": contact.status === CONTACT_STATUS.CLOSE,
                    "text-danger": contact.status === CONTACT_STATUS.OPEN,
                  })}
                >
                  <Icon className="h4 m-0">
                    {contact.status === CONTACT_STATUS.CLOSE
                      ? "check_box"
                      : "check_box_outline_blank"}
                  </Icon>
                </span>

                <Button data-bs-toggle="dropdown">
                  <Icon className="h4 m-0">more_vertical</Icon>
                </Button>
                <Menu>
                  <Menu.Item
                    disabled={contact.status === CONTACT_STATUS.CLOSE}
                    onClick={() =>
                      history.push(
                        `/contact/list/response/${contact.idContact}`
                      )
                    }
                  >
                    <Icon className="h5 m-0">send</Icon>
                    <span className="mx-2">Responder</span>
                  </Menu.Item>
                  <Menu.Item
                    onClick={() =>
                      history.push(`/contact/list/delete/${contact.idContact}`)
                    }
                  >
                    <Icon className="h5 m-0">delete</Icon>
                    <span className="mx-2">Deletar</span>
                  </Menu.Item>
                </Menu>
              </div>
            </List.Header>
            <div className="mb-3">
              <List.Subtitle>Mensagem</List.Subtitle>
              <List.Text>{contact.message || "-"}</List.Text>
            </div>
            {contact.description && (
              <div className="mb-3">
                <List.Subtitle>Resposta</List.Subtitle>
                <List.Text>{contact.description}</List.Text>
              </div>
            )}
            <List.Text className="text-end small">
              {contact.email || "-"}
            </List.Text>
          </List.Item>
        ))}
      </List>
    </main>
  );
}

export default Object.assign(Contacts, {
  ContactResponse: ContactResponse,
  ContactDelete: ContactDelete,
});
