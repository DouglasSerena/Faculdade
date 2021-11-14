import { useForm } from "react-hook-form";
import { useHistory } from "react-router";
import api from "src/api";
import Field from "src/components/Field";
import { handleTry } from "src/utils/handle-try";
import List from "./List";

function Contact() {
  const history = useHistory();
  const { register, handleSubmit } = useForm();

  const onSubmit = async (data: any) => {
    const [_, error] = await handleTry(api.post<any>("/contacts", data)); // eslint-disable-line
    if (!error) {
      history.push("/contact/list");
    }
  };

  return (
    <main className="container">
      <div className="py-3">
        <h3>Contatos</h3>
      </div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <Field.Input label="Nome:" register={{ name: "name", register }} />
        <Field.Input label="Email: " register={{ name: "email", register }} />
        <Field.Textarea
          label="Message: "
          register={{ name: "message", register }}
        />
        <Field.Textarea
          label="Descrição: "
          register={{ name: "description", register }}
        />
        <button className="mt-2 btn btn-primary" type="submit">
          Enviar
        </button>
      </form>
    </main>
  );
}

export default Object.assign(Contact, {
  List,
});
