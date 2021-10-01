import styled from "styled-components";

export const Container = styled.div`
  position: absolute;
  inset: 50% auto auto 50%;
  transform: translate(-50%, -50%);

  width: 100%;
  max-width: 350px;
  padding: 20px 40px;

  border-radius: 5px;
  box-shadow: 0 3px 1px -2px rgb(0 0 0 / 20%), 0 2px 2px 0 rgb(0 0 0 / 14%),
    0 1px 5px 0 rgb(0 0 0 / 12%);

  & > .title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
  }
  & > form > button {
    width: 100%;
  }

  /* TMP */

  & > .info-temp {
    position: absolute;
    inset: auto 0 110% 0;

    display: flex;
    flex-direction: column;

    padding: 20px 40px;

    box-shadow: 0 3px 1px -2px rgb(0 0 0 / 20%), 0 2px 2px 0 rgb(0 0 0 / 14%),
      0 1px 5px 0 rgb(0 0 0 / 12%);
  }
  & > .info-temp > .title {
    font-size: 16px;
    font-weight: bold;

    text-transform: uppercase;

    margin-bottom: 10px;
  }
  & > .info-temp > span > b {
    text-transform: uppercase;
  }
`;
