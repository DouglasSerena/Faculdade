import axios from "axios";
import { authInterceptor } from "./auth.interceptor";

const api = axios.create({
  baseURL: `http://143.244.147.161:8001/index.php`,
});

authInterceptor(api);

export default api;
