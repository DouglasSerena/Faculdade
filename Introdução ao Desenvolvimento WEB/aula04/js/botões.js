var clas = document.querySelector('div#clas')
var esta = document.querySelector('div#esta')
var jogo = document.querySelector('div#jogo')
var noti = document.querySelector('div#noti')
var part = document.querySelector('div#part')

function fehcar() {
  clas.style.display = 'none'
  esta.style.display = 'none'
  jogo.style.display = 'none'
  noti.style.display = 'none'
  part.style.display = 'none'
}

function parti() {
  fehcar()
  if (part.style.display == 'none') {
    part.style.display = 'block'
  }
}
function notic() {
  fehcar()
  if (noti.style.display == 'none') {
    noti.style.display = 'block'
  }
}
function clasi() {
  fehcar()
  if (clas.style.display == 'none') {
    clas.style.display = 'block'
  }
}
function estat() {
  fehcar()
  if (esta.style.display == 'none') {
    esta.style.display = 'block'
  }
}
function jogag() {
  fehcar()
  if (jogo.style.display == 'none') {
    jogo.style.display = 'block'
  }
}