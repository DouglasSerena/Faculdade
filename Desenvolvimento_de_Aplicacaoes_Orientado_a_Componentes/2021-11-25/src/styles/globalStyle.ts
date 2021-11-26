import { createGlobalStyle } from "styled-components";
import tinycolor from "tinycolor2";

function hexToRGB(color: string) {
  const rgb = tinycolor(color).toRgbString();
  return rgb.replace(/[rgb()]/gi, "");
}

const GlobalStyle = createGlobalStyle`
  :root {
    --color-text: ${hexToRGB("#000000")};
    --color-text-secondary: ${hexToRGB("#FFFFFF")};
    --color-background: ${hexToRGB("#FFFFFF")};
    
    --color-primary: ${hexToRGB("#311A91")};
    --color-primary-light: ${hexToRGB("#6745C2")};
    --color-primary-dark: ${hexToRGB("#000062")};
  
    --color-danger: ${hexToRGB("#F44336")};
    --color-success: ${hexToRGB("#4CAF50 ")};
    --color-warning: ${hexToRGB("#FF9800")};
  }

  body,html,#root {
    width: 100vw;
    height: 100vh;
    overflow-x: hidden;

    font-family: Arial, Helvetica, sans-serif;

    color: rgb(var(--color-text));
    background-color: rgb(var(--color-background));
  }

  * { 
    box-sizing: border-box;
    padding: 0;
    margin: 0;
  }

  header {
    min-height: 56px;
  }

  main {
    min-height: calc(100% - 106px);
  }

  footer {
    min-height: 50px;
  }

  .material-icons {
    width: 24px;
    height: 24px;
  }
`;

export default GlobalStyle;
