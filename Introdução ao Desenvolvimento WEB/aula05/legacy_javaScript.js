var resPostar = document.getElementById("postar")
var resPostarFrente = document.getElementById("postar-frente")
var res = document.getElementById("res")
var numPoste = 3

function abrir() {
    resPostarFrente.style.display = "none"
    resPostar.style.display = "inline-block"
}
function cancelar() {
    resPostarFrente.style.display = "inline-block"
    resPostar.style.display = "none"
}
function postar() {
    var txtArea = document.getElementById("txt-area")
    if (txtArea.value.length == 0) {
        alert("[ERRO] A algum erro no campo de postagem, verifique se esta preenchido.")
    }else {
        numPoste += 1
        res.innerHTML += `<article><h2>Post #${numPoste}</h2><p>${txtArea.value}</p></article>`
    }
}