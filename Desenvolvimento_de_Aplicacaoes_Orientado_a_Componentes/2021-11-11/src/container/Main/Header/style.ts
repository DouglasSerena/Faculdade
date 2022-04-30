import styled from "styled-components";

export const Style = {
  Header: styled.header`
    display: flex;
    align-items: center;
    justify-content: space-between;
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
