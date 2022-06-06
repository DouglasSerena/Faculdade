import { createGlobalStyle } from "styled-components";
import tinycolor from "tinycolor2";

function hexToRGB(color: string) {
  const rgb = tinycolor(color).toRgbString();
  return rgb.replace(/[rgb()]/gi, "");
}

const GlobalStyle = createGlobalStyle`
  :root {
    --color-text: ${hexToRGB("#000000")};
    --color-background: ${hexToRGB("#FFFFFF")};
    --color-background-secondary: ${hexToRGB("#FFFFFF")};
    
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

  .main {
    min-height: calc(100% - 106px);
    margin-top: 56px;
  }

  .material-icons {
    width: 24px;
    height: 24px;
  }
  
  @media (prefers-color-scheme: dark) {
    :root {
      --color-text: ${hexToRGB("#e8eaed")};
      --color-background: ${hexToRGB("#21252b")};
      --color-background-secondary: ${hexToRGB("#282c34")};
    }

    .form-control,
    .form-select {
      &,
      &:focus {
        color: rgb(var(--color-text));
        background-color: rgb(var(--color-background-secondary));
      }
      &:read-only {
        color: rgb(var(--color-text), 0.6);
        background-color: rgb(var(--color-background-secondary), 0.5);
      }
    }
    .form-select,
    .form-control {
      &:focus {
        border-color: rgb(var(--color-primary));
        box-shadow: 0 0 0 0.25rem rgb(var(--color-primary) / 25%);
      }
    }

    .btn  {
      color: rgb(var(--color-text));
    }

    .btn-dark {
      border: 1px solid #fff!important;
      border-color: rgb(var(--color-background-secondary));
      background: rgb(var(--color-background-secondary));
    }
    .btn-dark:active,
    .btn-dark:focus {
      border-color: rgb(var(--color-primary));
      box-shadow: 0 0 0 0.25rem rgb(var(--color-primary) / 25%);
    }

    .btn-primary {
      border-color: rgb(var(--color-primary));
      background: rgb(var(--color-primary));
    }
    .btn-primary:active,
    .btn-primary:focus {
      border-color: rgb(var(--color-primary));
      background: rgb(var(--color-primary));
      box-shadow: 0 0 0 0.25rem rgb(var(--color-primary) / 25%);
    }

    .card,
    .moda-body,
    .modal-header,
    .modal-footer,
    .modal-content,
    .list-group-item {
      color: rgb(var(--color-text));
      background-color: rgb(var(--color-background-secondary));
    }

    .modal-dialog {
      z-index: 13;
    }
  }
`;

export default GlobalStyle;
