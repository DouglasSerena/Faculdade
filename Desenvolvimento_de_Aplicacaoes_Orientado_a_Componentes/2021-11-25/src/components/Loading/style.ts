import styled, { keyframes } from "styled-components";

const rotate = keyframes`
  from {
    transform: rotate(360deg);
  }
  to {
    transform: rotate(0deg);
  }
`;

export const Style = {
  Loading: styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    animation: ${rotate} 2s linear infinite;
  `,
};
