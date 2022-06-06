import { FC, useCallback, useState } from "react";
import Button from "src/components/bootstrap/Button";
import Modal from "src/components/bootstrap/Modal";

interface IPropModalConfirm {
  onConfirm?: () => void;
  onCancel?: () => void;
}

const ModalConfirm: FC<IPropModalConfirm> = ({
  onCancel,
  onConfirm,
  children,
}) => {
  const [modal, setModal] = useState<bootstrap.Modal | null>(null);

  const handleConfirm = useCallback(() => {
    onConfirm();
    modal.hide();
  }, [modal, onConfirm]);

  return (
    <Modal open={true} onRef={setModal} onClose={onCancel}>
      <Modal.Header>
        <Modal.Title>Confirmar</Modal.Title>
        <Modal.Close>
          <button className="btn-close"></button>
        </Modal.Close>
      </Modal.Header>
      <Modal.Body>{children}</Modal.Body>
      <Modal.Footer>
        <Modal.Close>
          <Button>Fechar</Button>
        </Modal.Close>
        <Button color="primary" onClick={handleConfirm}>
          Confirmar
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default ModalConfirm;
