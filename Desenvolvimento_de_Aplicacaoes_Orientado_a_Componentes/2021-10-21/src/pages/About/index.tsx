import { useEffect, useState } from "react";
import { IPage } from "../../interfaces/page.interface";
import api from "../../api";
import { handleTry } from "src/utils/handle-try";

function About() {
  const [page, setPage] = useState<IPage | null>(null);

  useEffect(() => {
    (async () => {
      const [data] = await handleTry(api.get<IPage>("/pages/2"));
      if (data) {
        setPage(data.data);
      }
    })();
  }, []);

  return (
    <main className="container">
      <h2>{page?.page}</h2>
      <p dangerouslySetInnerHTML={{ __html: page?.content || "" }}></p>
    </main>
  );
}

export default About;
