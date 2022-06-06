import AuthProvider from "./context/Auth";
import Routes from "./routers";
import GlobalStyle from "./styles/globalStyle";

function App() {
  return (
    <>
      <GlobalStyle />
      <AuthProvider>
        <Routes />
      </AuthProvider>
    </>
  );
}

export default App;
