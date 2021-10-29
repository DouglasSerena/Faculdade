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

const Input: FC<IInputProp> = ({ register, ...options }) => {
  const inputClass = classNames({
    "form-control": true,
    "form-control-lg": options.scale === "large",
    "form-control-sm": options.scale === "small",
  });

  return (
    <div>
      <label className="form-label" htmlFor={options.label}>
        {options.label}
      </label>
      <input
        type="text"
        id={options.label}
        {...register?.register(register.name, register.options)}
        className={`${inputClass} ${options.className || ""}`}
      />
    </div>
  );
};

export default Input;
