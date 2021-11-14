import { FC, useCallback } from "react";
import {
  Control,
  FieldValues,
  useFieldArray,
  UseFormRegister,
} from "react-hook-form";
import Field from "../../../components/Field";
import { DATATYPE } from "../../../constants/datatype";
import { Style } from "./style";
import { MdAdd, MdDelete } from "react-icons/md";
import NodData from "./NoData";

interface IFieldsProps {
  register: UseFormRegister<FieldValues>;
  control: Control<FieldValues, object>;
}

const Fields: FC<IFieldsProps> = ({ register, control }) => {
  const { fields, append, remove } = useFieldArray({
    name: "fields",
    control: control,
  });

  const handleAppend = useCallback(() => {
    append({ name: "", data: "", type: "string" });
  }, [append]);

  const handleRemove = useCallback(
    (index) => {
      remove(index);
    },
    [remove]
  );

  return (
    <Style.Container>
      {fields.length === 0 ? (
        <Style.ContainerEmpty>
          <NodData />
          <h5>Opps!!</h5>
          <p>
            Para conseguir gerar um insert valido você deve adicionar uma coluna
          </p>

          <button
            onClick={() => handleAppend()}
            type="button"
            className="btn btn-outline-primary"
          >
            <MdAdd size={20} /> coluna
          </button>
        </Style.ContainerEmpty>
      ) : (
        <>
          <Style.List>
            {fields.map((field, index) => (
              <Style.ListItem key={index}>
                <Field className="w-100">
                  <Field.Label>Name</Field.Label>
                  <Field.Input
                    {...register(`fields.${index}.name`, { required: true })}
                  />
                </Field>

                <Field className="w-100 mx-2">
                  <Field.Label>Data</Field.Label>
                  <Field.Select
                    {...register(`fields.${index}.data`, { required: true })}
                  >
                    <Field.Select.Option value="foreignKey">
                      Foreign key
                    </Field.Select.Option>
                    {DATATYPE.map(({ group, values }, index) => (
                      <Field.Select.Group key={index} label={group}>
                        {values.map((value, index) => (
                          <Field.Select.Option
                            key={index}
                            value={`${group}.${value}`}
                          >
                            {value}
                          </Field.Select.Option>
                        ))}
                      </Field.Select.Group>
                    ))}
                  </Field.Select>
                </Field>

                <Field className="w-100 mx-2">
                  <Field.Label>Type</Field.Label>
                  <Field.Select
                    {...register(`fields.${index}.type`, { required: true })}
                  >
                    <Field.Select.Option defaultValue="string">
                      string
                    </Field.Select.Option>
                    <Field.Select.Option defaultValue="number">
                      number
                    </Field.Select.Option>
                    <Field.Select.Option defaultValue="boolean">
                      boolean
                    </Field.Select.Option>
                  </Field.Select>
                </Field>

                <button
                  type="button"
                  className="btn btn-outline-danger"
                  onClick={() => handleRemove(index)}
                >
                  <MdDelete size={20} />
                </button>
              </Style.ListItem>
            ))}
          </Style.List>

          <div className="d-flex justify-content-end">
            <button
              type="button"
              onClick={() => handleAppend()}
              className="btn btn-outline-primary"
            >
              <MdAdd size={20} /> coluna
            </button>
          </div>
        </>
      )}
    </Style.Container>
  );
};

export default Fields;
