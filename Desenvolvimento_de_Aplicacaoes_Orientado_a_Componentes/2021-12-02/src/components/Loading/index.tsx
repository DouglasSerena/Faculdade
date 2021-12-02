import { FC } from "react";
import Icon from "../Icon";
import { Style } from "./style";

const Loading: FC = () => {
  return (
    <Style.Loading>
      <Icon>sync</Icon>
    </Style.Loading>
  );
};

export default Loading;
