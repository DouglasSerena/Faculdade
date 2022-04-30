function includeHTML() {
  var z, i, elmnt, file, xhttp;
  /*percorrer uma coleção de todos os elementos HTML:*/
  z = document.getElementsByTagName("*");
  for (i = 0; i < z.length; i++) {
    elmnt = z[i];
    /*procure elementos com um certo atributo:*/
    file = elmnt.getAttribute("w3-include-html");
    if (file) {
      /*faça uma solicitação HTTP usando o valor do atributo como o nome do arquivo:*/
      xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
          if (this.status == 200) {elmnt.innerHTML = this.responseText;}
          if (this.status == 404) {elmnt.innerHTML = "Page not found.";}
          /*remova o atributo e chame esta função mais uma vez:*/
          elmnt.removeAttribute("w3-include-html");
          includeHTML();
        }
      }      
      xhttp.open("GET", file, true);
      xhttp.send();
      /*saia da função:*/
      return;
    }
  }
};