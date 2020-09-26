import { retrieveAddress } from './retrieveAddress.js';

const API_USER = (id) => `http://localhost/pw2/admin/client/${id}`;

export async function update() {
  const params = window.location.pathname.split('/');
  if (params.includes('update')) {
    const id = params[params.length - 1];
    const name = document.getElementById('name');
    const email = document.getElementById('email');
    const phone = document.getElementById('phone');
    const street = document.getElementById('street');

    const user = await fetch(API_USER(id)).then((res) => res.json());
    console.log(user);
    name.value = user.name;
    email.value = user.email;
    phone.value = user.phone.substring(5);
    const address = user.address.split(',');
    street.value = address[0];
  }
}
