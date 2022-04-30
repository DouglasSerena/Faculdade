import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import type { RootState, AppDispatch } from "./store";

export const useMyDispatch = () => useDispatch<AppDispatch>();
export const useMySelector: TypedUseSelectorHook<RootState> = useSelector;
