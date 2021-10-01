import { FormEvent, useCallback, useRef, useState } from "react";
import InputBlock from "../InputBlock";
import { Container } from "./style";
import { Button } from "../Button";

function Login() {
  let emailRef = useRef<HTMLInputElement | null>(null);
  let passwordRef = useRef<HTMLInputElement | null>(null);

  const [email, setEmail] = useState<string>();
  const [password, setPassword] = useState<string>();

  const handleSubmit = useCallback((event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    setEmail(emailRef.current!.value);
    setPassword(passwordRef.current!.value);
  }, []);

  return (
    <Container>
      <h2 className="title">Login</h2>
      <form onSubmit={(event) => handleSubmit(event)}>
        <InputBlock
          type="email"
          label="Email"
          register={(ref) => (emailRef = ref)}
        />
        <InputBlock
          label="Senha"
          type="password"
          register={(ref) => (passwordRef = ref)}
        />
        <Button color="primary" type="submit">
          Logar
        </Button>
      </form>

      <ShowInfo email={email} password={password} />
    </Container>
  );
}

function ShowInfo({ email, password }: any) {
  return (
    <div className="info-temp">
      <h5 className="title">Informações do form</h5>
      <span>
        <b>Email:</b> {email || "-"}
      </span>
      <span>
        <b>Senha:</b> {password || "-"}
      </span>
    </div>
  );
}

export default Login;
