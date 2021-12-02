import styled from "styled-components";

export const Style = {
  Container: styled.div`
    @media (min-width: 720px) {
      & > button {
        display: none;
      }
    }
  `,
  Button: styled.button`
    display: flex;
    align-items: center;
    justify-content: center;

    padding: 6px 16px;
    border-radius: 20px;
    color: rgb(var(--color-text));
    border: 1px solid rgba(var(--color-primary), 0.6);
    background-color: transparent;
    transition: 50ms;

    & > i {
      margin-right: 5px;
    }
    &:active {
      background-color: rgba(var(--color-primary), 0.2);
    }
    &:hover {
      border: 1px solid rgba(var(--color-primary), 1);
    }
  `,
  Toggle: styled.button`
    display: flex;
    align-items: center;
    justify-content: center;

    width: 32px;
    height: 32px;
    border-radius: 4px;
    color: rgb(var(--color-text));
    border: 1px solid transparent;
    background-color: transparent;
    transition: 50ms;
    &:hover {
      border-color: rgba(0, 0, 0, 0.2);
    }
  `,
  Nav: styled.nav<{ open: boolean }>`
    display: flex;
    align-items: center;

    & > a {
      width: 100%;
      color: rgba(var(--color-text), 0.5);
      text-align: center;
      text-decoration: none;
      font-weight: bold;
      position: relative;
      margin-bottom: 5px;

      white-space: nowrap;
      text-transform: uppercase;
      transition: 50ms;
      &:hover,
      &.-active {
        color: rgb(var(--color-text));
      }
    }
    @media (min-width: 720px) {
      & > a {
        &:not(:last-child) {
          margin-right: 15px;
        }
      }
      & > button {
        display: none;
      }
    }

    @media (max-width: 720px) {
      align-items: flex-end;
      flex-direction: column;
      padding: 12px;

      z-index: 2;
      position: fixed;
      top: -3px;
      left: 0;

      width: 100%;

      background: rgb(var(--color-background-secondary));
      box-shadow: 0 2px 4px -1px #0003, 0 4px 5px #00000024,
        0 1px 10px #0000001f;

      transition: 250ms;
      clip-path: ${({ open }) =>
        open
          ? "polygon(0 1%, 100% 0, 100% 120%, 0% 120%)"
          : "polygon(0 1%, 100% 0, 100% 0, 0 0)"};
      & > a {
        color: rgba(var(--color-text), 0.5);
        &:hover,
        &.-active {
          color: rgb(var(--color-text));
        }
      }
      & > a > button {
        width: 100%;
        margin-top: 10px;
      }
    }
  `,
};
