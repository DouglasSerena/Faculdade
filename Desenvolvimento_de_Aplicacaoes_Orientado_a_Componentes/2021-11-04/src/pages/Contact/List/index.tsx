import { useEffect, useState } from "react";
import api from "src/api";
import { IContact } from "src/interfaces/contact.interface";
import { handleTry } from "src/utils/handle-try";

function List() {
  const [contacts, setContacts] = useState<IContact[]>([]);

  useEffect(() => {
    (async () => {
      const [data] = await handleTry(api.get<IContact[]>("/contacts"));
      if (data) {
        setContacts(data.data);
      }
    })();
  }, []);

  return (
    <main className="container">
      <div className="py-3">
        <h3>Listagem de contatos</h3>
      </div>
      <table className="table w-100 table-striped table-hover table-responsive">
        <thead>
          <tr>
            <th>Codigo</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Mensagem</th>
            <th>Descrição</th>
          </tr>
        </thead>
        <tbody>
          {contacts.map((contact, index) => (
            <tr key={index}>
              <td>{contact.idContact}</td>
              <td>{contact.name}</td>
              <td>{contact.email}</td>
              <td>{contact.message}</td>
              <td>{contact.description}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </main>
  );
}

export default List;
