import { FC, OptionHTMLAttributes, SelectHTMLAttributes } from "react";
import { RegisterOptions, UseFormRegister } from "react-hook-form";
import { classNames } from "src/utils/class-names";

interface ISelectProp extends SelectHTMLAttributes<HTMLSelectElement> {
  label?: string;
  scale?: "large" | "small" | "default";
  register?: {
    name: string;
    register: UseFormRegister<any>;
    options?: Partial<RegisterOptions>;
  };
}

const Select: FC<ISelectProp> = ({ register, children, ...options }) => {
  const selectClass = classNames({
    "form-select": true,
    "form-select-lg": options.scale === "large",
    "form-select-sm": options.scale === "small",
  });

  return (
    <select
      {...options}
      className={`${selectClass} ${options.className || ""}`}
    >
      {children}
    </select>
  );
};

interface IOptionProp extends OptionHTMLAttributes<HTMLOptionElement> {}

const Option: FC<IOptionProp> = ({ children, ...options }) => (
  <option {...options}>{children}</option>
);

export default Object.assign(Select, {
  Option,
});
