export const ValidPrice = (input) => {
    const price = input.formatToNumber();

    if (price === 0) {
        input.setCustomValidity('O valor do produto deve ser superior a R$ 0');
        return;
    }

    input.setCustomValidity('');
    return;
};
