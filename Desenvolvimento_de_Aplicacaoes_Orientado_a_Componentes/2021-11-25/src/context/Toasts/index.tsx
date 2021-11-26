import { createContext, FC, useContext, useRef, useState } from "react";
import { classNames } from "src/utils/class-names";

interface IRouterContext {
  open(
    message: string,
    type?: "danger" | "success" | "warning" | "primary"
  ): void;
}

const ToastsContext = createContext<IRouterContext>({} as IRouterContext);

const ToastsProvider: FC<{}> = ({ children }) => {
  const toastRef = useRef(null);
  const [toast, setToast] = useState<any>(null);

  function open(
    message: string,
    type: "danger" | "success" | "warning" | "primary" = "primary"
  ) {
    setToast({ message, type });
    bootstrap.Toast.getOrCreateInstance(toastRef.current).show();
  }

  return (
    <ToastsContext.Provider value={{ open }}>
      {toast && (
        <div
          className="position-fixed bottom-0 end-0 p-3"
          style={{ zIndex: 11 }}
        >
          <div
            role="alert"
            ref={toastRef}
            className={classNames("toast align-items-center", {
              "bg-primary text-white": toast.type === "primary",
              "bg-danger text-white": toast.type === "danger",
              "bg-success text-white": toast.type === "success",
              "bg-warning text-white": toast.type === "warning",
            })}
          >
            <div className="d-flex">
              <div className="toast-body">{toast.message}</div>
              <button
                type="button"
                className="btn-close me-2 m-auto"
                data-bs-dismiss="toast"
              ></button>
            </div>
          </div>
        </div>
      )}
      {children}
    </ToastsContext.Provider>
  );
};

export const useToasts = () => {
  return useContext(ToastsContext);
};
export default ToastsProvider;
