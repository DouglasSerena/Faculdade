var clas = document.querySelector('iframe#clas')
var esta = document.querySelector('iframe#esta')
var jogo = document.querySelector('iframe#jogo')
var noti = document.querySelector('iframe#noti')
var part = document.querySelector('iframe#part')

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