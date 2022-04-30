import { FC, Fragment } from "react";
import { OmitNative, Route, RouteProps } from "react-router";
import { useAuth } from "src/context/Auth";

const RoutePrivate: FC<RouteProps<string> & OmitNative<any, keyof RouteProps>> =
  ({ children, ...rest }) => {
    const { isAdmin } = useAuth();

    if (isAdmin) {
      return <Route {...rest}>{children}</Route>;
    }
    return <Fragment></Fragment>;
  };

export default RoutePrivate;
