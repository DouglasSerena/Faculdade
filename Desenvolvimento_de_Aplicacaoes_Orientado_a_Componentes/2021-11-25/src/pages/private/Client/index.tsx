import { calc, masked } from "@douglas-serena/utils";
import { useEffect, useState } from "react";
import { useHistory, useLocation } from "react-router";
import api from "src/api";
import Button from "src/components/bootstrap/Button";
import List from "src/components/bootstrap/List";
import Menu from "src/components/bootstrap/Menu";
import Field from "src/components/Field";
import Icon from "src/components/Icon";
import { IClient } from "src/interfaces/client.interface";
import { handleTry } from "src/utils/handle-try";
import ClientDelete from "./ClientDelete";
import ClientForm from "./ClientForm";
import { Style } from "./style";

masked.custom("TEL_FULL", {
  type: "MASK",
  config: {
    mask: [
      { mask: "(00) 0000-0000" },
      { mask: "(00) 0 0000-0000" },
      { mask: "+00 (00) 0 0000-0000" },
    ],
  },
});

function Client() {
  const [clients, setClients] = useState<IClient[]>([]);
  const location = useLocation();
  const history = useHistory();

  const handleClient = async () => {
    const [clients] = await handleTry(api.get<IClient[]>("/clients"));
    if (clients) {
      setClients(clients.data);
    }
  };

  useEffect(() => {
    if (location.pathname === "/client") {
      handleClient();
    }
  }, [location]);

  return (
    <main className="container">
      <div className="py-3 d-flex justify-content-between">
        <h3>Listagem de clientes</h3>

        <div>
          <Button color="primary" onClick={() => history.push("/client/form")}>
            <Icon>add</Icon>Adicionar
          </Button>
        </div>
      </div>

      <div className="mb-2">
        <Field.Search path="/clients/search/{value}" onSearch={setClients} />
      </div>

      <List>
        {clients.map((client, index) => (
          <List.Item key={index}>
            <List.Header>
              <List.Title>
                <b>Nome:</b> {client.name}
              </List.Title>

              <div className="dropstart">
                <Button data-bs-toggle="dropdown">
                  <Icon className="h4 m-0">more_vertical</Icon>
                </Button>
                <Menu>
                  <Menu.Item
                    onClick={() =>
                      history.push(`/client/form/${client.idClient}`)
                    }
                  >
                    <Icon className="h5 m-0">edit</Icon>
                    <span className="mx-2">Editar</span>
                  </Menu.Item>
                  <Menu.Item
                    onClick={() =>
                      history.push(`/client/delete/${client.idClient}`)
                    }
                  >
                    <Icon className="h5 m-0">delete</Icon>
                    <span className="mx-2">Deletar</span>
                  </Menu.Item>
                </Menu>
              </div>
            </List.Header>
            <div className="mb-3">
              <List.Subtitle>Contatar</List.Subtitle>
              <Style.Contact>
                Email:{" "}
                <Style.Link className="mx-1" href={`mailto:${client.email}`}>
                  {client.email}
                </Style.Link>
              </Style.Contact>

              <Style.Contact>
                Telefone:{" "}
                <Style.Link
                  className="mx-1"
                  href={`tel:${calc.parse(client.phone)}`}
                >
                  {masked("TEL_FULL").mask(client.phone)}
                </Style.Link>
              </Style.Contact>
            </div>
            <div className="mb-3">
              <List.Subtitle>Endereço</List.Subtitle>
              <List.Text>{client.address}</List.Text>
            </div>
          </List.Item>
        ))}
      </List>
    </main>
  );
}

export default Object.assign(Client, {
  ClientDelete: ClientDelete,
  ClientForm: ClientForm,
});
