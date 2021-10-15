import { masked, TConfigMask } from "@douglas-serena/utils";
import {
  FC,
  InputHTMLAttributes,
  MutableRefObject,
  useEffect,
  useRef,
} from "react";
import { classNames } from "../../utils/class-names";

interface IInputProp extends InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  mask?: string;
  floating?: boolean;
  maskConfig?: Partial<TConfigMask>;
  scale?: "large" | "small" | "default";
  register?: MutableRefObject<HTMLInputElement | null>;
}

const InputBlock: FC<IInputProp> = ({
  mask,
  label,
  scale,
  register,
  floating,
  maskConfig,
  ...rest
}) => {
  const inputRef = useRef<HTMLInputElement | null>(null);
  const blockClass = classNames({
    "form-floating": floating,
  });
  const inputClass = classNames({
    "form-control": true,
    "form-control-lg": scale === "large",
    "form-control-sm": scale === "small",
  });

  useEffect(() => {
    if (register) {
      register.current = inputRef.current;
    }
  }, [register, inputRef]);

  useEffect(() => {
    if (mask && inputRef.current) {
      masked(mask, maskConfig).bind(inputRef.current);
    }
  }, [mask, maskConfig, inputRef]);

  return (
    <div className={blockClass}>
      {label && !floating && (
        <label className="form-label" htmlFor={label}>
          {label}
        </label>
      )}
      <input
        id={label}
        type="text"
        ref={inputRef}
        className={inputClass}
        {...rest}
      />
      {label && floating && <label htmlFor={label}>{label}</label>}
    </div>
  );
};

export default InputBlock;
