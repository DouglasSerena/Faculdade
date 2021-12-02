import styled from "styled-components";

export const Style = {
  Header: styled.header`
    position: fixed;
    top: 0;
    left: 0;

    display: flex;
    align-items: center;
    justify-content: space-between;

    min-height: 56px;

    box-shadow: 0 3px 1px -2px #0003, 0 2px 2px #00000024, 0 1px 5px #0000001f;
    background-color: rgb(var(--color-background));
    z-index: 10;
  `,
  Title: styled.h2`
    display: flex;
    align-items: center;
    justify-content: center;

    margin: 0;
    & > a {
      display: flex;
      align-items: center;
      justify-content: center;

      text-decoration: none;
      color: inherit;
    }
    & > a > i {
      margin-right: 5px;
    }
  `,
};
