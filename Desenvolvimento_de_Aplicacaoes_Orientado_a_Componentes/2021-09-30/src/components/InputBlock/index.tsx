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
  register: (ref: MutableRefObject<HTMLInputElement | null>) => void;
}

const InputBlock: FC<IInputProp> = ({ label, register, ...rest }) => {
  const inputRef = useRef<HTMLInputElement | null>(null);

  useEffect(() => {
    register(inputRef);
  }, [register, inputRef]);

  return (
    <Container>
      <Label htmlFor={label}>{label}</Label>
      <Input id={label} type="text" {...rest} ref={inputRef} />
    </Container>
  );
};

export default InputBlock;
