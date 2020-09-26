import { typeInputs } from './TYPESINPUTS.js';
import {
    VALUE_MISSING,
    TYPE_MISMATCH,
    PATTERN_MISMATCH,
    CUSTOM_ERROR,
    TOO_SHORT,
} from './TYPESERROR.js';

export const messageError = {
    [typeInputs.NAME]: {
        [VALUE_MISSING]: 'Nome precisa ser preenchido.',
    },
    [typeInputs.EMAIL]: {
        [VALUE_MISSING]: 'Email precisa ser preenchido.',
        [TYPE_MISMATCH]: 'Este não é um e-mail válido.',
    },
    [typeInputs.PASSWORD]: {
        [VALUE_MISSING]: 'Senha precisa ser preenchido.',
        [TOO_SHORT]: 'Senha deve possuir no minimo 9 caracteres.',
    },
    [typeInputs.PHONE]: {
        [VALUE_MISSING]: 'Telefone precisa ser preenchido.',
        [PATTERN_MISMATCH]: 'Formado invalido, informe somente números.',
        [TOO_SHORT]: 'Telefone tem que ter 9 números.',
    },
    [typeInputs.ZIP]: {
        [VALUE_MISSING]: 'Cep precisa ser preenchido.',
        [PATTERN_MISMATCH]: 'Formato de cep invalido.',
        [CUSTOM_ERROR]: 'Este não é um CEP válido.',
    },
    [typeInputs.STREET]: {
        [VALUE_MISSING]: 'Rua / Número precisa ser preenchido.',
    },
    [typeInputs.STATE]: {
        [VALUE_MISSING]: 'Estado precisa ser selecionado.',
    },
    [typeInputs.CITY]: {
        [VALUE_MISSING]: 'Cidade precisa ser preenchido.',
    },
    [typeInputs.DESCRIPTION]: {
        [VALUE_MISSING]: 'A descrição deve ser preenchida.',
    },
    [typeInputs.PRICE]: {
        [CUSTOM_ERROR]: 'O valor do produto deve ser superior a R$ 0.',
    },
    [typeInputs.CATEGORY]: {
        [VALUE_MISSING]: 'Selecione uma categoria.',
    },
};
