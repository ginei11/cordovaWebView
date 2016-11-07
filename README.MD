/**
*@autor Carlos Reyes
* @success funcion de retorno satisfactorio
* @fail funcion de retorno fail
* @url url a abrir
* @fail nombre a mostrar
*/
webViewNative.open(success, fail, url, nombreApp);



Ejemplos:

var success  = function() { alert('se abrio la web');  }
var fail = function() { alert('fallo abrir la web'); }

webViewNative.open(success, failt, "https://github.com/", "webAppName");



