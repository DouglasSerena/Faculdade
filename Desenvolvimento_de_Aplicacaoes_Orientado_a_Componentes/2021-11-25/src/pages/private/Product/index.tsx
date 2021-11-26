import { useCallback, useEffect, useState } from "react";
import { useHistory, useParams } from "react-router";
import { IProduct } from "src/interfaces/product.interface";
import { handleTry } from "src/utils/handle-try";
import Button from "src/components/bootstrap/Button";
import Card from "src/components/bootstrap/Card";
import Field from "src/components/Field";
import api from "src/api";

function Product() {
  const [products, setProducts] = useState<IProduct[]>([]);
  const { categoryId } = useParams<{ categoryId?: string }>();
  const history = useHistory();

  const handleProducts = async (categoryId?: string) => {
    let url = categoryId ? `/products/category/${categoryId}` : `/products`;

    const [data] = await handleTry(api.get<IProduct[]>(url));
    if (data) {
      setProducts(data.data);
    }
  };

  const onChange = useCallback(
    (category: string) => {
      if (category) {
        history.push(`/product/${category}`);
      } else {
        history.push(`/product`);
      }
    },
    [history]
  );

  useEffect(() => {
    handleProducts(categoryId);
  }, [categoryId]);

  return (
    <main className="container">
      <div className="py-3 d-flex justify-content-between">
        <h3>Produtos</h3>
        <div>
          <Field.Select
            value={categoryId}
            onChange={(event) => onChange(event.target.value)}
          >
            <Field.Select.Option value="">Todos</Field.Select.Option>
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
