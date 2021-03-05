const add = document.querySelector("#add");
const clear = document.querySelector("#clear");
const result = document.querySelector("#result");
const content = document.querySelector("#userContent");
const title = document.querySelector("#title");

clear.addEventListener("click", () => {
    title.value = "";
    content.value = "";
});

add.addEventListener('click', () => {
    const layout = buildLayout(title.value, content.value);
    result.innerHTML += layout;

    removeLayout();
});

removeLayout();
function removeLayout() {
    const removeNot = document.querySelectorAll("#removeNot");
    removeNot.forEach(remove => {
        remove.addEventListener('click', event => {
            confirm("Você que mesmo deletar ?") ? remove.parentNode.remove() : false
        })
    })
}
