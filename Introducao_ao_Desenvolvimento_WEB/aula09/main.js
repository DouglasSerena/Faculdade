const form = document.querySelector("form");
const year = document.querySelector("#year");
const result = document.querySelector("#result");
var years = document.querySelector("#years")
var random = (max, min) => Math.floor( Math.random() * ( max - min ) + min );
var values;



form.addEventListener("input", event => {
    event.preventDefault();
    
    values = year.value.split(/\D/g);
});

function share() {
    let max = 0;
    let min = values[0];
    values.forEach( e => {
        let value = Number(e)

        if ( max < value && value <= 150) max = value;
        if ( min > value) min = value;
        
        let li = document.createElement("li");
        li.innerHTML += `<span></span>${value}`;
        li.style.animationDuration = random(8, 2)+ "s";
        li.style.left = random(100, 0) + "%";
        li.style.animationTimingFunction = `
        cubic-bezier(
            ${Math.random()},
            ${Math.random()},
            ${Math.random()},
            ${Math.random()}
        )`;
        years.append(li);
    });
    result.innerHTML = `Maior Idade <span>${max}</span><br/>Menor Idade <span>${min}</span>`;
}

// setInterval(() => {
//     let li = document.querySelector("#years li:nth-child(1)")
//     li.remove();
// }, 1000);
