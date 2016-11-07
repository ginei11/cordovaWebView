
var exec = cordova.require('cordova/exec');
var platform = require('cordova/platform');

 var WebViewNative = function () {
 };


WebViewNative.prototype.iniciarTimer1 = function(successCallback, errorCallback, timer, actividadDestino){
				  cordova.exec(
						successCallback,
						errorCallback,
						"webview",
						"abrirWeb",
						[
						url,
						nombreApp
						]
					);
				  };



var webViewNative = new WebViewNative();
module.exports = webViewNative;
