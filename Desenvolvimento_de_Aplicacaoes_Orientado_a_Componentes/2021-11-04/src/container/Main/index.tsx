import { FC } from "react";
import Footer from "./Footer";
import Header from "./Header";

const Main: FC = ({ children }) => {
  return (
    <>
      <Header />
      {children}
      <Footer />
    </>
  );
};

export default Main;
