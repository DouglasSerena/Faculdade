const result = document.querySelector("#result");

const inputsLabel = document.querySelectorAll(".input-label");

inputsLabel.forEach(inputsLabel => {
    let input = inputsLabel.querySelector("input");
    let label = inputsLabel.querySelector("label");

    input.addEventListener("focus", () => {
        if (input.value == "")
            label.classList.toggle("up");
    })
    input.addEventListener("blur", () => {
        if (input.value == "")
            label.classList.toggle("up");
    })

})

function removeAllClass() {
    let labels = document.querySelectorAll("label")
    labels.forEach(label => {
        label.classList.remove("up");
    })
}

function calcImc() {
    let name = document.querySelector("#name");
    let sex = document.getElementsByName("sex");
    let weight = document.querySelector("#weight");
    let height = document.querySelector("#height");
    let values = [];

    if (valid(name, weight, height)) {
        alert("Preencha os campos");
        return false;
    }

    values.push(name.value);

    if(sex[0].checked == true)
        values.push("Masculino");
    else
        values.push("Feminino");

    values.push(parseNumber(height.value));

    values.push(parseNumber(weight.value));

    let imc = (weight.value/(height.value*height.value)).toFixed(2)
    values.push(imc);


    if(imc <= 18.5)
        values.push('Abaixo do peso ideal');
    else if(imc <= 25)
        values.push('Peso ideal');
    else if(imc <= 30)
        values.push('Acima do peso ideal');
    else
        values.push('Obesidade');

    let tr = document.createElement("tr");
    values.forEach(value => {
        let td = document.createElement("td");
        td.textContent = value;
        tr.append(td);
    });

    result.append(tr);

    
    removeAllClass()
    name.value = "";
    sex[0].checked = true;
    weight.value = "";
    height.value = "";

    return false;
}

function parseNumber(number) {
    return Number(number.replace(",","."));
}

function valid(name, weight, height) {
    let falid = 0;

    if (name.value == "")
        falid++;

    if (weight.value == "")
        falid++;

    if (height.value == "")
        falid++;

    if (falid > 0)
        return true;
    return false;
}

