package co.com.netcom.plugin.backgroundtimer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;



/**
 * **************************************************************
 * Copyright (c) 2015 - Carlos Arturo Reyes Romero, All rights reserved
 *
 * ****************************************************************
 */
public class CordovaWebView extends CordovaPlugin {

    public static CallbackContext callbackContext = null;
    @Override
    public boolean execute(final String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Log.d("[CordovaWebView]", "Inicio: " + action);
        this.callbackContext = callbackContext;
        Context context=this.cordova.getActivity().getApplicationContext();


        if (action.equals("abrirWeb")) {
           
            mPreferencias.setSetBoot2(false);
            cordova.getActivity().stopService(new Intent(cordova.getActivity(), ServicioTimer2.class));
            ServicioTimer2.waitTimer2.cancel();
            PluginResult result = new PluginResult(PluginResult.Status.OK, "ok");
            result.setKeepCallback(false);
            BackGroundTimer.callbackContext.sendPluginResult(result);;
            return true;
			}
	}
			



}