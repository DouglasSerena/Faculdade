import { Debounce } from "@douglas-serena/utils";
import { FC, InputHTMLAttributes, useState } from "react";
import { useForm } from "react-hook-form";
import api from "src/api";
import Icon from "src/components/Icon";
import Loading from "src/components/Loading";
import { classNames } from "src/utils/class-names";
import { handleTry } from "src/utils/handle-try";

interface ISearchProp extends InputHTMLAttributes<HTMLInputElement> {
  path?: string;
  onSearch: (data: any) => any;
}

const Search: FC<ISearchProp> = ({ path, onSearch, ...rest }) => {
  const { register, getValues, handleSubmit } = useForm();
  const [loading, setLoading] = useState(false);
  const debounce = new Debounce();

  const onSubmit = async ({ search }: any = getValues()) => {
    const [data, error] = await handleTry(
      api.get(path.replace("{value}", search))
    );
    if (!error) {
      onSearch(data.data);
    }
    setLoading(false);
  };

  const onInput = () => {
    setLoading(true);
    debounce.run(() => onSubmit());
  };

  return (
    <form className="input-group" onSubmit={handleSubmit(onSubmit)}>
      <input
        type="text"
        placeholder="Pesquisar"
        {...rest}
        {...register("search")}
        onInput={onInput}
        className={classNames("form-control", rest.className)}
      />
      <button
        type="submit"
        disabled={loading}
        className="btn btn-dark d-flex align-items-center input-group-append"
      >
        {loading ? <Loading /> : <Icon>search</Icon>}
      </button>
    </form>
  );
};

export default Search;
