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

function ContactList() {
  const history = useHistory();
  const location = useLocation();
  const [contacts, setContacts] = useState<IContact[]>([]);
  const [status, setStatus] = useState<CONTACT_STATUS>(CONTACT_STATUS.ALL);

  const handleChange = useCallback((value: string) => {
    setStatus(value as CONTACT_STATUS);
  }, []);

  const handleContact = useCallback(async () => {
    const [data] = await handleTry(api.get<IContact[]>("/contacts"));
    if (data) {
      switch (status) {
        case CONTACT_STATUS.OPEN:
          setContacts(
            data.data.filter(
              (contact) => contact.status === CONTACT_STATUS.OPEN
            )
          );
          break;
        case CONTACT_STATUS.CLOSE:
          setContacts(
            data.data.filter(
              (contact) => contact.status === CONTACT_STATUS.CLOSE
            )
          );
          break;
        case CONTACT_STATUS.ALL:
          setContacts(
            data.data.sort((a, b) => a.status.localeCompare(b.status))
          );
      }
    }
  }, [status]);

  useEffect(() => {
    if (location.pathname === "/contact/list") {
      handleContact();
    }
  }, [handleContact, location]);

  return (
    <main className="container">
      <div className="py-3 d-flex justify-content-between">
        <h3>Listagem de contatos</h3>
        <div>
          <Field.Select
            value={status}
            onChange={(event) => handleChange(event.target.value)}
          >
            <Field.Select.Option value={CONTACT_STATUS.ALL}>
              Todos
            </Field.Select.Option>
            <Field.Select.Option value={CONTACT_STATUS.CLOSE}>
              Respondidos
            </Field.Select.Option>
            <Field.Select.Option value={CONTACT_STATUS.OPEN}>
              Não respondidos
            </Field.Select.Option>
          </Field.Select>
        </div>
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

              <div className="dropstart">
                <span
                  className={
                    contact.status === CONTACT_STATUS.CLOSE
                      ? "text-success"
                      : "text-danger"
                  }
                >
                  <Icon className="h4">
                    {contact.status === CONTACT_STATUS.CLOSE
                      ? "bxs-check-square"
                      : "bxs-square-rounded"}
                  </Icon>
                </span>

                <Button data-bs-toggle="dropdown">
                  <Icon className="h4 m-0">bx-dots-vertical-rounded</Icon>
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
                    <Icon className="h5 m-0">bxs-send</Icon>
                    <span className="mx-2">Responder</span>
                  </Menu.Item>
                  <Menu.Item
                    onClick={() =>
                      history.push(`/contact/list/delete/${contact.idContact}`)
                    }
                  >
                    <Icon className="h5 m-0">bx-trash</Icon>
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

export default ContactList;
