import { Col, Container, Jumbotron, Nav, Navbar, Row } from "react-bootstrap";

function Landing() {
  return (
    <>
      <Navbar expand="lg" variant="light" bg="light">
        <Container>
          <Navbar.Brand href="#">Navbar</Navbar.Brand>

          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <Container className="mt-2">
        <Jumbotron>
          <h1>Hello, world!</h1>
          <p>
            This is a simple hero unit, a simple jumbotron-style component for
            calling extra attention to featured content or information.
          </p>
        </Jumbotron>

        <Row>
          <Col>
            <h2></h2>
          </Col>
          <Col>
            <h2>diawhdouiawghodu</h2>
          </Col>
          <Col>
            <h2>diawhdouiawghodu</h2>
          </Col>
          <Col>
            <h2>diawhdouiawghodu</h2>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default Landing;
