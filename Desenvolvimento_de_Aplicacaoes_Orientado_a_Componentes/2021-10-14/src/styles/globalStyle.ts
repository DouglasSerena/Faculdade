import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  :root {
    --color-text: 0,0,0;
    --color-text-secondary: 255,255,255;
    --color-background: 255,255,255;
    
    --color-primary: 49, 26, 145;
    --color-primary-light: 103, 69, 194;
    --color-primary-dark: 0, 0, 98;
  
    --color-danger: 244, 67, 54;
    --color-success: 244, 67, 54;
    --color-warning: 255, 152, 0;
  }

  body,html,#root {
    width: 100vw;
    height: 100vh;

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
`;

export default GlobalStyle;
