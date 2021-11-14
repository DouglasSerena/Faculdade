import { FC, HTMLAttributes } from "react";
import { classNames } from "../../utils/class-name";

import Input from "./Input";
import Label from "./Label";
import Select from "./Select";
import Textarea from "./Textarea";

interface IDivProps extends HTMLAttributes<HTMLDivElement> {}

const Field: FC<IDivProps> = ({ children, ...rest }) => {
  return (
    <div {...rest} className={classNames(rest.className)}>
      {children}
    </div>
  );
};

export default Object.assign(Field, {
  Input: Input,
  Label: Label,
  Select: Select,
  Textarea: Textarea,
});
