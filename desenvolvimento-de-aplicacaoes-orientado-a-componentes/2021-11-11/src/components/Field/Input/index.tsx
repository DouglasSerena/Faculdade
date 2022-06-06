import { TConfigMask } from "@douglas-serena/utils";
import { FC, InputHTMLAttributes } from "react";
import { RegisterOptions, UseFormRegister } from "react-hook-form";
import { classNames } from "../../../utils/class-names";

interface IInputProp extends InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  mask?: string;
  maskConfig?: Partial<TConfigMask>;
  scale?: "large" | "small" | "default";
  register?: {
    name: string;
    register: UseFormRegister<any>;
    options?: Partial<RegisterOptions>;
  };
}

const Input: FC<IInputProp> = ({ register, ...rest }) => {
  const inputClass = classNames({
    "form-control": true,
    "form-control-lg": rest.scale === "large",
    "form-control-sm": rest.scale === "small",
  });

  return (
    <div>
      <label className="form-label" htmlFor={rest.label}>
        {rest.label}
      </label>
      <input
        type="text"
        id={rest.label}
        className={`${inputClass} ${rest.className || ""}`}
        {...register?.register(register.name, register.options)}
        {...rest}
      />
    </div>
  );
};

export default Input;
