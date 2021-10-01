import styled, { css } from "styled-components";

interface ButtonProp {
  color: string;
}

export const Button = styled.button<ButtonProp>`
  padding: 0 16px;
  min-width: 64px;
  line-height: 36px;

  border: none;
  border-radius: 5px;
  box-shadow: 0 3px 1px -2px rgb(0 0 0 / 20%), 0 2px 2px 0 rgb(0 0 0 / 14%),
    0 1px 5px 0 rgb(0 0 0 / 12%);

  font-size: 14px;
  font-weight: 500;

  cursor: pointer;
  transition: 150ms;
  &:active {
    box-shadow: 0 5px 5px -3px rgb(0 0 0 / 20%), 0 8px 10px 1px rgb(0 0 0 / 14%),
      0 3px 14px 2px rgb(0 0 0 / 12%);
  }

  ${({ color }) => {
    switch (color) {
      case "primary":
        return css`
          background-color: rgb(var(--color-primary));
          color: rgb(var(--color-text-secondary));
        `;
      case "danger":
        return css`
          background-color: rgb(var(--color-danger));
          color: rgb(var(--color-text-secondary));
        `;
      case "warning":
        return css`
          background-color: rgb(var(--color-warning));
          color: rgb(var(--color-text-secondary));
        `;
      default:
        return css`
          background-color: rgb(var(--color-text), 0.2);
        `;
    }
  }};
`;
