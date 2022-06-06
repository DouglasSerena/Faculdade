import { TConfigMask } from "@douglas-serena/utils";
import { FC, forwardRef, TextareaHTMLAttributes } from "react";
import { classNames } from "../../../utils/class-names";

interface ITextareaProp extends TextareaHTMLAttributes<HTMLTextAreaElement> {
  label?: string;
  mask?: string;
  maskConfig?: Partial<TConfigMask>;
  scale?: "large" | "small" | "default";
}

const Textarea: FC<ITextareaProp> = forwardRef(({ ...rest }, forward) => {
  return (
    <div>
      <label className="form-label" htmlFor={rest.label}>
        {rest.label}
      </label>
      <textarea
        id={rest.label}
        {...rest}
        ref={forward as any}
        className={classNames(
          "form-control",
          {
            "form-control-lg": rest.scale === "large",
            "form-control-sm": rest.scale === "small",
          },
          rest.className
        )}
      />
    </div>
  );
});

export default Textarea;
