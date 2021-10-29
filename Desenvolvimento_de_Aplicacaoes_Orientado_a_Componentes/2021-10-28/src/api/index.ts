import axios from "axios";

const api = axios.create({
  headers: {},
  baseURL: `http://143.244.147.161:8001/index.php`,
});

export default api;
