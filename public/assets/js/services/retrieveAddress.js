export const retrieveAddress = async (input) => {
    const zip = input.value.replace('-', '');

    if (input.validity.valid) {
        const url = `https://viacep.com.br/ws/${zip}/json/`;

        const data = await fetch(url, {
            method: 'GET',
            mode: 'cors',
            headers: {
                'content-type': 'application/json;charset=utf-8',
            },
        }).then((res) => res.json());
        !data.erro
            ? fillField(data)
            : input.setCustomValidity('Este CEP não é válido');
    }
};

const fillField = (data) => {
    const city = document.getElementById('city');
    const state = document.getElementById('state');
    const ddd = document.getElementById('ddd');

    state.classList.remove('is-invalid');
    city.classList.remove('is-invalid');
    city.classList.add('is-valid');

    ddd.value = `+55${data.ddd}`;
    city.value = data.localidade;
    state.value = data.uf;
};
