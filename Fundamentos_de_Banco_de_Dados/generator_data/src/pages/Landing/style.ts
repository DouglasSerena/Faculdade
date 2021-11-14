import styled from "styled-components";

const classNames = {
  Container: () => ({ className: "container" }),
};

export const Style = {
  Container: styled.div.attrs(classNames.Container)`
    section {
      margin-top: 20px;
      border: 1px solid #3333;
    }
  `,
};
