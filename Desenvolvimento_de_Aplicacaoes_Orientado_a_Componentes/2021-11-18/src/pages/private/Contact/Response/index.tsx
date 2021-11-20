import { useCallback, useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { useHistory, useParams } from "react-router";
import api from "src/api";
import Button from "src/components/bootstrap/Button";
import Modal from "src/components/bootstrap/Modal";
import Field from "src/components/Field";
import { CONTACT_STATUS, IContact } from "src/interfaces/contact.interface";
import { handleTry } from "src/utils/handle-try";

function Response() {
  const [contact, setContact] = useState<IContact | null>(null);
  const [modal, setModal] = useState<bootstrap.Modal | null>(null);

  const { handleSubmit, register } = useForm();
  const { contactId } = useParams<{ contactId: string }>();
  const history = useHistory();

  const handleResponse = useCallback(
    async ({ description }) => {
      const [response] = await handleTry(
        api.put(`/contacts/${contactId}`, {
          ...contact,
          description,
          status: CONTACT_STATUS.CLOSE,
        } as IContact)
      );
      if (response) {
        modal.hide();
        history.push("/contact/list");
      }
    },
    [contact, contactId, history, modal]
  );

  const handleContact = useCallback(async () => {
    const [response] = await handleTry(api.get(`/contacts/${contactId}`));
    if (response) {
      setContact(response.data as IContact);
    }
  }, [contactId]);

  useEffect(() => {
    handleContact();
  }, [handleContact]);

  return (
    <Modal
      onRef={setModal}
      open={true}
      onClose={() => history.push("/contact/list")}
    >
      <form onSubmit={handleSubmit(handleResponse)}>
        <Modal.Header>
          <Modal.Title>Responder</Modal.Title>
          <Modal.Close>
            <button className="btn-close"></button>
          </Modal.Close>
        </Modal.Header>
        <Modal.Body>
          <Field.Textarea
            rows={10}
            label="Resposta"
            {...register("description")}
          />
        </Modal.Body>
        <Modal.Footer>
          <Modal.Close>
            <Button>Fechar</Button>
          </Modal.Close>
          <Button type="submit" color="primary">
            Responder
          </Button>
        </Modal.Footer>
      </form>
    </Modal>
  );
}

export default Response;
