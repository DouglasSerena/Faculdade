import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useHistory } from "react-router";
import api from "src/api";
import Button from "src/components/bootstrap/Button";
import Field from "src/components/Field";
import { useAuth } from "src/context/Auth";
import { useToasts } from "src/context/Toasts";
import { handleTry } from "src/utils/handle-try";

function Login() {
  const { login, logged } = useAuth();
  const { open } = useToasts();

  const history = useHistory();
  const { register, handleSubmit } = useForm();

  useEffect(() => {
    if (logged) {
      history.push("/");
    }
  }, [logged]); // eslint-disable-line

  const onSubmit = async (_: any) => {
    const [data, error] = await handleTry(api.post<any>("/users/login", _)); // eslint-disable-line

    if (data?.data.token) {
      login(data.data.token);
      open("Logado com sucesso.", "success");
    } else {
      open("Não foi possivel fazer o login. Tente novamente", "danger");
    }
  };

  return (
    <main className="container">
      <div className="py-3">
        <h3>Login</h3>
      </div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <Field.Input label="Usuario" {...register("user")}></Field.Input>
        <Field.Input
          label="Senha"
          type="password"
          {...register("password")}
        ></Field.Input>
        <Button className="mt-2" color="primary" type="submit">
          Logar
        </Button>
      </form>
    </main>
  );
}

export default Login;
