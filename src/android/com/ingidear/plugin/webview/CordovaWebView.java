package co.com.netcom.plugin.backgroundtimer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.os.Bundle;
import android.content.Intent;


/**
 * **************************************************************
 * Copyright (c) 2015 - Carlos Arturo Reyes Romero, All rights reserved
 *
 * ****************************************************************
 */
public class CordovaWebView extends CordovaPlugin {

    @Override
    public boolean execute(final String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Log.d("[CordovaWebView]", "Inicio: " + action);
    
        Context context=this.cordova.getActivity().getApplicationContext();
		String url = args.getString(0);
		String nombreApp = args.getString(1);
		String colorApp = args.getString(2);

        if (action.equals("abrirWeb")) {
           
		        Bundle datos = new Bundle();
                Intent activityma = new Intent().setClass(
                        CordovaWebView.this, WebViewActivity.class);

                datos.putSerializable("Url", url);
                datos.putSerializable("NombreApp", nombreApp);
                datos.putSerializable("colorBar", colorApp);
                activityma.putExtras(datos);

                context.startActivity(activityma);
           
          
				PluginResult result = new PluginResult(PluginResult.Status.OK, "ok");
				result.setKeepCallback(false);
				callbackContext.sendPluginResult(result);;
				return true;
			}
	}
			



}