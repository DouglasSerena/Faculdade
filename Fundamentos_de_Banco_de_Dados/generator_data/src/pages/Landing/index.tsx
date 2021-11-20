import { Style } from "./style";
import { useForm } from "react-hook-form";
import Fields from "./Fields";
import faker from "faker/locale/pt_BR";
import Editor from "@monaco-editor/react";
import { useState } from "react";
import { MdDriveFileRenameOutline } from "react-icons/md";
import dayjs from "dayjs";

export default function Landing() {
  const {
    control,
    register,
    getValues,
    formState: { isValid },
  } = useForm({ mode: "all" });
  const [SQL, setSQL] = useState<string>(
    `INSERT INTO clients (name) VALUES ('carlos')`
  );

  const handleGenerator = () => {
    let { keys, datas } = getValues("fields").reduce(
      (props: any, field: any) => {
        props.keys.push(`${field.name}`);
        props.datas.push({ data: `{{${field.data}}}`, type: field.type });
        return props;
      },
      { keys: [], datas: [] } as {
        keys: string[];
        datas: { data: string; type: string }[];
      }
    );

    let values = Array.from({ length: 100 }).map((_) => {
      const values = datas
        .map(({ data, type }: any) => {
          let value: string;
          if (data === "{{foreignKey}}") {
            value = `${faker.datatype.number(100)}`;
            if (value === "0") {
              value = "1";
            }
          } else if (data === "{{datatype.datetime}}") {
            value = dayjs(faker.datatype.datetime()).format(
              "YYYY-MM-DD HH:mm:ss"
            );
          } else {
            value = faker.fake(data);
          }

          if (type === "string") {
            return `'${value.replace("'", "'")}'`;
          }

          return value;
        })
        .join(", ");

      return `(${values})`;
    });

    setSQL(
      `INSERT INTO {{TABLE}} (${keys.join(",")})\n\tVALUES\n\t\t${values.join(
        ",\n\t\t"
      )};`
    );
  };

  return (
    <Style.Container>
      <Fields register={register} control={control} />

      <div className="d-flex mt-3">
        <button
          type="button"
          disabled={!isValid}
          className="btn btn-outline-success w-100 mx-1"
          onClick={() => handleGenerator()}
        >
          <MdDriveFileRenameOutline size={20} /> Gerar insert
        </button>
      </div>

      <Editor value={SQL} height="50vh" defaultLanguage="sql" />
    </Style.Container>
  );
}
