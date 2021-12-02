import { masked, TConfigMask } from "@douglas-serena/utils";
import { FC, forwardRef, InputHTMLAttributes, useEffect, useRef } from "react";
import { classNames } from "../../../utils/class-names";

interface IInputProp extends InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  mask?: string;
  maskConfig?: Partial<TConfigMask>;
  scale?: "large" | "small" | "default";
}

const Input: FC<IInputProp> = forwardRef(({ ...rest }, forward) => {
  const ref = useRef(null);

  useEffect(() => {
    if (ref.current && rest.mask) {
      masked(rest.mask, rest.maskConfig).bind(ref.current);
    }
  }, [ref, rest]);

  return (
    <div>
      <label className="form-label" htmlFor={rest.label}>
        {rest.label}
      </label>
      <input
        type="text"
        id={rest.label}
        {...rest}
        ref={(_) => {
          ref.current = _;
          (forward as any)(_);
        }}
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

export default Input;
