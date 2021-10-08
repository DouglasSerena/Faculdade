import { useEffect, useState } from "react";
import Footer from "../../components/Footer";
import Header from "../../components/Header";

function Landing() {
  const [message, setMessage] = useState("");
  const [router, setRouter] = useState("home");

  useEffect(() => {
    setMessage("Bem vindo!!!");
  }, [setMessage]);

  return (
    <>
      <Header onRouter={setRouter} />

      <main>
        <section>
          {message} {router}
        </section>
      </main>

      <Footer />
    </>
  );
}

export default Landing;
