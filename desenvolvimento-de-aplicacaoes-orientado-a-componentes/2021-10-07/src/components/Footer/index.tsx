import { Link } from "../../routers";
import { FooterContainer } from "./style";

function Footer() {
  return (
    <FooterContainer className="bg-secondary text-white">
      <Link to="/">home</Link>
      <h3 className="m-0">footer</h3>
    </FooterContainer>
  );
}

export default Footer;
