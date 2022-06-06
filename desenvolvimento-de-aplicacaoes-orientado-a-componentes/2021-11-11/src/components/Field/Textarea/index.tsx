import { TConfigMask } from "@douglas-serena/utils";
import { FC, TextareaHTMLAttributes } from "react";
import { RegisterOptions, UseFormRegister } from "react-hook-form";
import { classNames } from "../../../utils/class-names";

interface ITextareaProp extends TextareaHTMLAttributes<HTMLTextAreaElement> {
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

const Textarea: FC<ITextareaProp> = ({ register, ...rest }) => {
  const textareaClass = classNames({
    "form-control": true,
    "form-control-lg": rest.scale === "large",
    "form-control-sm": rest.scale === "small",
  });

  return (
    <div>
      <label className="form-label" htmlFor={rest.label}>
        {rest.label}
      </label>
      <textarea
        id={rest.label}
        className={`${textareaClass} ${rest.className || ""}`}
        {...register?.register(register.name, register.options)}
        {...rest}
      />
    </div>
  );
};

export default Textarea;
