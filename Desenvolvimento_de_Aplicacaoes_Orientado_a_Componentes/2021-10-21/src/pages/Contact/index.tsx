import { useForm } from "react-hook-form";
import { useHistory } from "react-router";
import api from "src/api";
import Input from "src/components/form/Input";
import Textarea from "src/components/form/Textarea";
import { handleTry } from "src/utils/handle-try";

function Contact() {
  const history = useHistory();
  const { register, handleSubmit } = useForm();

  const onSubmit = async (data: any) => {
    const [_, error] = await handleTry(api.post<any>("/contacts", data)); // eslint-disable-line
    if (error) {
      history.push("/contact/list");
    }
  };

  return (
    <main className="container">
      <form onSubmit={handleSubmit(onSubmit)}>
        <Input label="Nome:" register={{ name: "nome", register }} />
        <Input label="Email: " register={{ name: "email", register }} />
        <Textarea label="Message: " register={{ name: "message", register }} />
        <button className="mt-2 btn btn-primary" type="submit">
          Enviar
        </button>
      </form>
    </main>
  );
}

export default Contact;
