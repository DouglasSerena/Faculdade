import { FC, Fragment } from "react";
import { useAuth } from "src/context/Auth";

const Auth: FC = ({ children }) => {
  const { isAdmin } = useAuth();

  if (isAdmin) {
    return <>{children}</>;
  }

  return <Fragment></Fragment>;
};

export default Object.assign({}, { Auth: Auth });
