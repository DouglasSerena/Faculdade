import AuthProvider from "./context/Auth";
import ToastsProvider from "./context/Toasts";
import Routes from "./routers";
import GlobalStyle from "./styles/globalStyle";

function App() {
  return (
    <>
      <GlobalStyle />
      <AuthProvider>
        <ToastsProvider>
          <Routes />
        </ToastsProvider>
      </AuthProvider>
    </>
  );
}

export default App;
