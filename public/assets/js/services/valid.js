import { typeErros } from './constants/TYPESERROR.js';
import { messageError } from './constants/MESSAGEERROR.js';
import { retrieveAddress } from './retrieveAddress.js';
import { ValidPrice } from './validPrice.js';

export function valid(input, showLabel = true) {
    const isValid = input.validity.valid;
    const type = input.dataset.type;

    if (input.dataset.type == 'category') {
        console.log(input);
    }

    const labelError = input.parentNode.querySelector('div');
    const specificValidation = {
        zip: (input) => retrieveAddress(input),
        price: (input) => ValidPrice(input),
    };

    if (specificValidation[type]) {
        specificValidation[type](input);
    }

    if (showLabel) {
        if (!isValid) {
            const message = showMessage(input.validity, input.dataset.type);
            labelError.textContent = message;
            input.classList.add('is-invalid');
        } else {
            input.classList.remove('is-invalid');
            input.classList.add('is-valid');
        }
    }
}

function showMessage(validity, type) {
    let message = false;

    typeErros.forEach((error) => {
        if (validity[error]) {
            message = messageError[type][error];
        }
    });

    return message;
}
