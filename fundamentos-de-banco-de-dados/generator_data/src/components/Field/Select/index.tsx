import {
  FC,
  forwardRef,
  OptionHTMLAttributes,
  SelectHTMLAttributes,
} from "react";
import { classNames } from "../../../utils/class-name";

interface ISelectProps extends SelectHTMLAttributes<HTMLSelectElement> {}

const Select: FC<ISelectProps> = forwardRef(({ children, ...rest }, ref) => {
  return (
    <select
      {...rest}
      ref={ref as any}
      className={classNames("form-select", rest.className)}
    >
      {children}
    </select>
  );
});

interface IOptionGroupProps extends OptionHTMLAttributes<HTMLOptGroupElement> {}

const Group: FC<IOptionGroupProps> = ({ children, ...rest }) => {
  return <optgroup {...rest}>{children}</optgroup>;
};

interface IOptionProps extends OptionHTMLAttributes<HTMLOptionElement> {}

const Option: FC<IOptionProps> = ({ children, ...rest }) => {
  return <option {...rest}>{children}</option>;
};

export default Object.assign(Select, {
  Group: Group,
  Option: Option,
});
