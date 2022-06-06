import { createContext, FC, useContext, useEffect, useState } from "react";
import { decode } from "jsonwebtoken";
import { IAuth } from "./auth.type";

interface IRouterContext {
  login: (token: string) => void;
  logout: () => void;
  token: string | null;
  logged: boolean;
  isAdmin: boolean;
  auth: IAuth;
}

const AuthContext = createContext<IRouterContext>({} as IRouterContext);

const AuthProvider: FC<{}> = ({ children }) => {
  const [token, setToken] = useState<string | null>(null);
  const [auth, setAuth] = useState<IAuth | null>(null);

  useEffect(() => {
    const jwt = localStorage.getItem("JWT_TOKEN");
    if (jwt) {
      login(jwt);
    }
  }, [token, setToken]);

  function login(token: string) {
    if (token) {
      // api.login(token);

      setToken(token);
      setAuth(decode(token) as IAuth);
      localStorage.setItem("JWT_TOKEN", token);
    }
  }

  function logout() {
    // api.logout();

    setAuth(null);
    setToken(null);
    localStorage.removeItem("JWT_TOKEN");
  }

  return (
    <AuthContext.Provider
      value={{
        token,
        login,
        logout,
        auth: auth,
        logged: !!token,
        isAdmin: auth?.admin === "1",
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  return useContext(AuthContext);
};
export default AuthProvider;
