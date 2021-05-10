const args = {
    allowNegative: false,
    negativeSignAfter: false,
    prefix: 'R$ ',
    fixed: true,
    fractionDigits: 2,
    decimalSeparator: ',',
    thousandsSeparator: '.',
    cursor: 'end'
};

const input = SimpleMaskMoney.setMask('#value', args);
const kwh = document.querySelector("#kwh");
const form = document.querySelector("form");
const result = document.querySelector("#result");

form.addEventListener("submit", event => {
    event.preventDefault();

    let reais = SimpleMaskMoney.formatToNumber(input.value);
    let value = kwh.value.substring(0, kwh.value.length - 4)
    let addition = 0;

    if (value > 100) addition = 0.25;
    if (value > 200) addition = 0.5;

    value = (reais*value)+(reais*value)*addition;


    value = value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });

    result.textContent  =  value;
});

function blockChar(event) {
    if (event.charCode < 48 || event.charCode > 57) {
        return false;
    }
}

kwh.addEventListener("focus", () => {
    value = kwh.value;
    kwh.value = value.substring(0, value.length - 4);
});

kwh.addEventListener("blur", () => {
    value = kwh.value;
    kwh.value = value + " kwh";
});
