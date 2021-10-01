import styled from "styled-components";

export const Container = styled.div`
  position: relative;
  padding: 5px 0;
  margin: 8px 0;

  border: 1px solid rgb(var(--color-text), 0.2);
  border-radius: 5px;

  &:hover {
    border-color: rgb(var(--color-text), 0.7);
  }
  &:focus-within::after {
    content: "";
    position: absolute;
    inset: -1px;

    border: 2px solid rgb(var(--color-primary));
    border-radius: 5px;
  }
`;
export const Label = styled.label`
  position: absolute;
  inset: -6px auto auto 10px;
  font-size: 14px;
  padding: 0 2px;

  font-size: 10px;

  background-color: rgb(var(--color-background));
  transition: 150ms;

  z-index: 1;
  pointer-events: none;
  touch-action: none;
`;
export const Input = styled.input`
  width: 100%;
  padding: 5px 10px;

  border: none;

  outline: 0;
`;
