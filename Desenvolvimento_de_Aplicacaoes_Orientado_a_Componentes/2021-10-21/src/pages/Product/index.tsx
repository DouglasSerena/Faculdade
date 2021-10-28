import { useCallback, useEffect, useState } from "react";
import Button from "src/components/bootstrap/Button";
import Card from "src/components/bootstrap/Card";
import Field from "src/components/Field";
import { IProduct } from "src/interfaces/product.interface";
import { handleTry } from "src/utils/handle-try";
import api from "../../api";
import { IPage } from "../../interfaces/page.interface";

function Product() {
  const [page, setPage] = useState<IPage | null>(null);
  const [products, setProducts] = useState<IProduct[]>([]);

  useEffect(() => {
    (async () => {
      const [page] = await handleTry(api.get<IPage>("/pages/3"));
      if (page) {
        setPage(page.data);
      }
      await handleProducts();
    })();
  }, []);

  const onChange = useCallback(
    async (category: string) => handleProducts(category),
    []
  );

  const handleProducts = async (category?: string) => {
    const url = category ? `/products/category/${category}` : `/products`;

    const [products] = await handleTry(api.get<IProduct[]>(url));
    if (products) {
      setProducts(products.data);
    }
  };

  return (
    <main className="container">
      <div className="d-flex justify-content-between">
        <div dangerouslySetInnerHTML={{ __html: page?.content || "" }}></div>
        <div className="pt-3">
          <Field.Select onChange={(event) => onChange(event.target.value)}>
            <Field.Select.Option value="">todos</Field.Select.Option>
            <Field.Select.Option value="1">Teletronio</Field.Select.Option>
            <Field.Select.Option value="2">Saude</Field.Select.Option>
            <Field.Select.Option value="3">Limpeza</Field.Select.Option>
          </Field.Select>
        </div>
      </div>
      <div className="row">
        {products.map((product, index) => (
          <div className="col-md-4 px-2 pb-2" key={index}>
            <Card>
              <Card.Body>
                <Card.Title>{product.name}</Card.Title>
                <Card.Text>{product.description}</Card.Text>
                <div className="text-end">
                  <Button color="primary">R$ {product.price}</Button>
                </div>
              </Card.Body>
            </Card>
          </div>
        ))}
      </div>
    </main>
  );
}

export default Product;
