import { TConfigMask } from "@douglas-serena/utils";
import { FC, InputHTMLAttributes } from "react";
import { RegisterOptions, UseFormRegister } from "react-hook-form";
import { classNames } from "../../../utils/class-names";

interface ITextareaProp extends InputHTMLAttributes<HTMLTextAreaElement> {
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

const Textarea: FC<ITextareaProp> = ({ register, ...options }) => {
  const textareaClass = classNames({
    "form-control": true,
    "form-control-lg": options.scale === "large",
    "form-control-sm": options.scale === "small",
  });

  return (
    <div>
      <label className="form-label" htmlFor={options.label}>
        {options.label}
      </label>
      <textarea
        id={options.label}
        {...register?.register(register.name, register.options)}
        className={`${textareaClass} ${options.className || ""}`}
      />
    </div>
  );
};

export default Textarea;
