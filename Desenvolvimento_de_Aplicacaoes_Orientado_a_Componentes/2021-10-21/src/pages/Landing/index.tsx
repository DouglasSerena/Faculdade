import { useEffect, useState } from "react";
import { handleTry } from "src/utils/handle-try";
import api from "../../api";
import { IPage } from "../../interfaces/page.interface";

function Landing() {
  const [page, setPage] = useState<IPage | null>(null);

  useEffect(() => {
    (async () => {
      const [data] = await handleTry(api.get<IPage>("/pages/1"));
      if (data) {
        setPage(data.data);
      }
    })();
  }, []);

  return (
    <main className="container">
      <p dangerouslySetInnerHTML={{ __html: page?.content || "" }}></p>
    </main>
  );
}

export default Landing;
