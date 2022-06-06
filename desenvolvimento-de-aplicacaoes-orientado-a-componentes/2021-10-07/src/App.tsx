import Footer from "./components/Footer";
import Header from "./components/Header";
import { BrowserRouter, Route } from "./routers";
import GlobalStyle from "./styles/globalStyle";

function App() {
  return (
    <>
      <GlobalStyle />
      <BrowserRouter>
        <Route path="/" component={Header} />
        <Route path="/login" component={Footer} />
      </BrowserRouter>
    </>
  );
}

export default App;
