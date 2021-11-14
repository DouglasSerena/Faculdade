import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
  body, #root {
    height: 100vh;
    width: 100vw;
    overflow-x: hidden;
  }
  * {
    box-sizing: border-box;
  }

  .btn {
    display: flex;
    align-items: center;
    justify-content: center;

    min-height: 38px;
    min-width: 38px;
  }
`;
