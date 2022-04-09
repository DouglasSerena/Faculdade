import {
  decrement,
  increment,
} from "../../redux/features/counter/counterReducer";
import { useMyDispatch, useMySelector } from "../../redux/hooks";

function Landing() {
  const count = useMySelector((state) => state.counter.value);
  const dispatch = useMyDispatch();

  return (
    <div>
      <div>
        <button
          aria-label="Increment value"
          onClick={() => dispatch(increment())}
        >
          Increment
        </button>
        <span>{count}</span>
        <button
          aria-label="Decrement value"
          onClick={() => dispatch(decrement())}
        >
          Decrement
        </button>
      </div>
    </div>
  );
}

export default Landing;
