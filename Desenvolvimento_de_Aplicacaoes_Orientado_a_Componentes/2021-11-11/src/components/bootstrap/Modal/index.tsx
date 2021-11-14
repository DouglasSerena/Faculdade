import { FC, HTMLAttributes, useEffect, useRef } from "react";

interface IPropModal extends HTMLAttributes<HTMLDivElement> {
  open?: boolean;
  onOpen?: (event: Event) => void;
  onClose?: (event: Event) => void;
  onRef?: (modal: bootstrap.Modal) => void;
}

const Modal: FC<IPropModal> = ({
  open,
  onRef,
  onOpen,
  onClose,
  children,
  ...attr
}) => {
  const modalRef = useRef<HTMLDivElement | null>(null);
  let modal: bootstrap.Modal;

  useEffect(() => {
    if (modalRef) {
      modal = new bootstrap.Modal(modalRef.current); // eslint-disable-line react-hooks/exhaustive-deps

      modalRef.current.addEventListener("hide.bs.modal", onClose);
      modalRef.current.addEventListener("show.bs.modal", onOpen);
      if (onRef) {
        onRef(modal);
      }
    }
  }, [modal, onRef, modalRef]);

  useEffect(() => {
    if (modal) {
      open ? modal.show() : modal.hide();
    }
  }, [open, modal]);

  return (
    <div
      {...attr}
      tabIndex={-1}
      ref={modalRef}
      className={`modal fade ${attr.className || ""}`}
    >
      <div className="modal-dialog">
        <div className="modal-content">{children}</div>
      </div>
    </div>
  );
};

const Header: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <header {...attr} className={`modal-header ${attr.className || ""}`}>
    {children}
  </header>
);
const Close: FC<HTMLAttributes<HTMLSpanElement>> = ({ children, ...attr }) => (
  <span {...attr} data-bs-dismiss="modal">
    {children}
  </span>
);
const Title: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <h4 {...attr} className={`modal-title ${attr.className || ""}`}>
    {children}
  </h4>
);
const Body: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <header {...attr} className={`modal-body ${attr.className || ""}`}>
    {children}
  </header>
);
const Footer: FC<HTMLAttributes<HTMLDivElement>> = ({ children, ...attr }) => (
  <footer {...attr} className={`modal-footer ${attr.className || ""}`}>
    {children}
  </footer>
);

export default Object.assign(Modal, {
  Header,
  Title,
  Body,
  Close,
  Footer,
});
