import { FC, LabelHTMLAttributes } from "react";
import { classNames } from "../../../utils/class-name";

interface ILabelProps extends LabelHTMLAttributes<HTMLLabelElement> {}

const Label: FC<ILabelProps> = ({ children, ...rest }) => {
  return (
    <label {...rest} className={classNames("form-label", rest.className)}>
      {children}
    </label>
  );
};

export default Label;
