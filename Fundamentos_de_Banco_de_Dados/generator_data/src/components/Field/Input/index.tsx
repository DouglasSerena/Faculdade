import { FC, forwardRef, InputHTMLAttributes } from "react";
import { classNames } from "../../../utils/class-name";

interface IInputProps extends InputHTMLAttributes<HTMLInputElement> {}

const Input: FC<IInputProps> = forwardRef(({ ...rest }, ref) => {
  return (
    <input
      {...rest}
      type="text"
      ref={ref as any}
      className={classNames("form-control", rest.className)}
    />
  );
});

export default Input;
