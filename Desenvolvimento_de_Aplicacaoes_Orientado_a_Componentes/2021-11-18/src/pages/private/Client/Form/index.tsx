import { masked } from "@douglas-serena/utils";
import { useCallback, useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { useHistory, useParams } from "react-router";
import api from "src/api";
import Button from "src/components/bootstrap/Button";
import Modal from "src/components/bootstrap/Modal";
import Field from "src/components/Field";
import { IClient } from "src/interfaces/client.interface";
import { handleTry } from "src/utils/handle-try";

function Form() {
  const [modal, setModal] = useState<bootstrap.Modal | null>(null);
  const { clientId } = useParams<{ clientId: string }>();
  const { handleSubmit, register, reset } = useForm({
    shouldUnregister: true,
  });
  const history = useHistory();

  const handleClient = useCallback(async () => {
    const [data] = await handleTry(api.get<IClient>(`/clients/${clientId}`));
    if (data) {
      reset(data.data);
    }
  }, [clientId, reset]);

  const onSubmit = async (data: IClient) => {
    const url = clientId ? `/clients/${clientId}` : `/clients`;

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const [_, error] = await handleTry(
      api.request({
        method: clientId ? "PUT" : "POST",
        data: data,
        url,
      })
    );
    if (!error) {
      modal.hide();
    }
  };

  useEffect(() => {
    if (clientId) {
      handleClient();
    }
  }, [clientId, handleClient]);

  return (
    <Modal open={true} onRef={setModal} onClose={() => history.push("/client")}>
      <Modal.Header>
        <Modal.Title>{clientId ? "Atualizar" : "Criar"} cliente</Modal.Title>
      </Modal.Header>

      <form onSubmit={handleSubmit(onSubmit)}>
        <Modal.Body>
          {clientId && (
            <Field.Input
              label="Codigo: "
              readOnly={true}
              defaultValue={clientId}
              {...register("clientId")}
            />
          )}
          <Field.Input label="Nome: " {...register("name")} />
          <Field.Input label="Email: " type="email" {...register("email")} />
          <Field.Input
            type="tel"
            mask="TEL_FULL"
            label="Telefone: "
            {...register("phone")}
          />
          <Field.Textarea
            rows={3}
            label="Endereço: "
            {...register("address")}
          />
        </Modal.Body>

        <Modal.Footer>
          <Modal.Close>
            <Button>Fechar</Button>
          </Modal.Close>
          <Button color="primary">{clientId ? "Atualizar" : "Criar"}</Button>
        </Modal.Footer>
      </form>
    </Modal>
  );
}

export default Form;
