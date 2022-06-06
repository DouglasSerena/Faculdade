import { useCallback } from "react";
import { useHistory, useParams } from "react-router";
import api from "src/api";
import ModalConfirm from "src/components/ModalConfirm";
import { useToasts } from "src/context/Toasts";
import { handleTry } from "src/utils/handle-try";

function ClientDelete() {
  const { open } = useToasts();
  const { clientId } = useParams<{ clientId: string }>();
  const history = useHistory();

  const handleDelete = useCallback(async () => {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const [_, error] = await handleTry(api.delete(`/clients/${clientId}`));
    if (!error) {
      history.push("/client");
      open("Cliente deletado", "success");
    }
  }, [clientId, history, open]);

  return (
    <ModalConfirm
      onConfirm={handleDelete}
      onCancel={() => history.push("/client")}
    >
      <p>Você tem certeza que quer remover este cliente?</p>
    </ModalConfirm>
  );
}

export default ClientDelete;
