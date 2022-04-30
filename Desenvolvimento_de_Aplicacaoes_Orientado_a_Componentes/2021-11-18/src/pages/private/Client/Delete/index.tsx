import { useCallback } from "react";
import { useHistory, useParams } from "react-router";
import api from "src/api";
import ModalConfirm from "src/components/ModalConfirm";
import { handleTry } from "src/utils/handle-try";

function Delete() {
  const { clientId } = useParams<{ clientId: string }>();
  const history = useHistory();

  const handleDelete = useCallback(async () => {
    const [data] = await handleTry(api.delete(`/clients/${clientId}`));
    if (data) {
      history.push("/client");
    }
  }, [clientId, history]);

  return (
    <ModalConfirm
      onConfirm={handleDelete}
      onCancel={() => history.push("/client")}
    >
      <p>Você tem certeza que quer remover este cliente?</p>
    </ModalConfirm>
  );
}

export default Delete;
