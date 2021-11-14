import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useHistory } from "react-router";
import api from "src/api";
import Button from "src/components/bootstrap/Button";
import Field from "src/components/Field";
import { useAuth } from "src/context/Auth";
import { handleTry } from "src/utils/handle-try";

function Login() {
  const { login, logged } = useAuth();
  const history = useHistory();
  const { register, handleSubmit } = useForm();

  useEffect(() => {
    if (logged) {
      history.push("/");
    }
  }, [logged]); // eslint-disable-line

  const onSubmit = async (data: any) => {
    const [res, error] = await handleTry(api.post<any>("/users/login", data)); // eslint-disable-line

    if (res?.data.token) {
      login(res.data.token);
    } else {
      console.log(error);
    }
  };

  return (
    <main className="container">
      <div className="py-3">
        <h3>Login</h3>
      </div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <Field.Input
          label="Usuario"
          register={{ name: "user", register }}
        ></Field.Input>
        <Field.Input
          label="Senha"
          type="password"
          register={{ name: "pass", register }}
        ></Field.Input>
        <Button className="mt-2" color="primary" type="submit">
          Logar
        </Button>
      </form>
    </main>
  );
}

export default Login;
