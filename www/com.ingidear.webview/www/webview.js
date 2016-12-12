
var exec = cordova.require('cordova/exec');
var platform = require('cordova/platform');

 var WebViewNative = function () {
 };


WebViewNative.prototype.open = function(successCallback, errorCallback, url, nombreApp, colorApp,colorText){
				  cordova.exec(
						successCallback,
						errorCallback,
						"webview",
						"abrirWeb",
						[
						url,
						nombreApp,
						colorApp,
						colorText
						]
					);
				  };



var webViewNative = new WebViewNative();
module.exports = webViewNative;
