
cordova plugin add https://github.com/ginei11/cordovaWebView


/**
* @success funcion de retorno satisfactorio
* @fail funcion de retorno fail
* @url url a abrir
* @fail nombre a mostrar
* @color color a mostrar en la app bar
*/
webViewNative.open(success, fail, url, nombreApp, color);


Ejemplo:

var success  = function() { alert('se abrio la web');  }
var fail = function() { alert('fallo abrir la web'); }

webViewNative.open(success, fail, "https://github.com/", "webAppName", "#ffffc900");



