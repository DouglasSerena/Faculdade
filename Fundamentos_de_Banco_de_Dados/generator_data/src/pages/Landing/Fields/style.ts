import styled from "styled-components";

export const Style = {
  Container: styled.div`
    min-height: 30vh;
    margin: 20px 0;
  `,
  ContainerEmpty: styled.div`
    display: flex;
    align-items: center;
    flex-direction: column;

    & > svg {
      width: 150px;
      height: 150px;
    }
    & > h5 {
      margin-top: 15px;
    }
    & > p {
      width: 400px;
      text-align: center;
      line-height: 20px;
    }
  `,
  List: styled.ul`
    list-style: none;
    padding: 0;
  `,
  ListItem: styled.li`
    display: flex;
    align-items: flex-end;
  `,
};
