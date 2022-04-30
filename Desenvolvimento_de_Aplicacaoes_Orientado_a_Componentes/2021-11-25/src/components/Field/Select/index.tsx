import {
  FC,
  forwardRef,
  OptionHTMLAttributes,
  SelectHTMLAttributes,
} from "react";
import { classNames } from "src/utils/class-names";

interface ISelectProp extends SelectHTMLAttributes<HTMLSelectElement> {
  label?: string;
  scale?: "large" | "small" | "default";
}

const Select: FC<ISelectProp> = forwardRef(({ children, ...rest }, forward) => {
  return (
    <select
      {...rest}
      ref={forward as any}
      className={classNames(
        {
          "form-select": true,
          "form-select-lg": rest.scale === "large",
          "form-select-sm": rest.scale === "small",
        },
        rest.className
      )}
    >
      {children}
    </select>
  );
});

interface IOptionProp extends OptionHTMLAttributes<HTMLOptionElement> {}

const Option: FC<IOptionProp> = ({ children, ...options }) => (
  <option {...options}>{children}</option>
);

export default Object.assign(Select, {
  Option,
});
