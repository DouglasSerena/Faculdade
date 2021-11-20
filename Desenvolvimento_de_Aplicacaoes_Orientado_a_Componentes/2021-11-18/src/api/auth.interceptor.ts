import { Axios } from "axios";

export function authInterceptor(axios: Axios) {
  axios.interceptors.request.use(
    (request) => {
      const token = localStorage.getItem("JWT_TOKEN");
      if (token) {
        request.headers.Authorization = `Bearer ${token}`;
      }

      return request;
    },
    (error) => Promise.reject(error)
  );
}
