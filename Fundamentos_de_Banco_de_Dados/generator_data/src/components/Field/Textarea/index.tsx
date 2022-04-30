import { FC, forwardRef, TextareaHTMLAttributes } from "react";
import { classNames } from "../../../utils/class-name";

interface ITextareaProps extends TextareaHTMLAttributes<HTMLTextAreaElement> {}

const Textarea: FC<ITextareaProps> = forwardRef(
  ({ children, ...rest }, ref) => {
    return (
      <textarea
        {...rest}
        ref={ref as any}
        className={classNames("form-control", rest.className)}
      >
        {children}
      </textarea>
    );
  }
);

export default Textarea;
