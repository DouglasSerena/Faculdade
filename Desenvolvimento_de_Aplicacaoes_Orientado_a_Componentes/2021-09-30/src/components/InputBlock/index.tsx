import {
  FC,
  InputHTMLAttributes,
  MutableRefObject,
  useEffect,
  useRef,
} from "react";
import { Container, Label, Input } from "./style";

interface IInputProp extends InputHTMLAttributes<HTMLInputElement> {
  label: string;
  register: MutableRefObject<HTMLInputElement | null>;
}

const InputBlock: FC<IInputProp> = ({ label, register, ...rest }) => {
  const inputRef = useRef<HTMLInputElement | null>(null);

  useEffect(() => {
    register.current = inputRef.current;
  }, [register, inputRef]);

  return (
    <Container>
      <Label htmlFor={label}>{label}</Label>
      <Input id={label} type="text" {...rest} ref={inputRef} />
    </Container>
  );
};

export default InputBlock;
