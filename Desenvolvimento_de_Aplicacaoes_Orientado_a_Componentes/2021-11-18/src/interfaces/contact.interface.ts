export enum CONTACT_STATUS {
  OPEN = "0",
  CLOSE = "1",
  ALL = "-1",
}

export interface IContact {
  description: string;
  email: string;
  idContact: number;
  message: string;
  name: string;
  status: CONTACT_STATUS;
}
