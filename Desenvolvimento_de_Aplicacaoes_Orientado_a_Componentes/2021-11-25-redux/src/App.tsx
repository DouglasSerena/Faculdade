import Landing from "./views/Landing";
import { Provider as ReduxProvider } from "react-redux";
import { store } from "./redux/store";

function App() {
  return (
    <ReduxProvider store={store}>
      <Landing />
    </ReduxProvider>
  );
}

export default App;
