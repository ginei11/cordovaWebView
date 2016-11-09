package com.ingidear.webview.utilidades;

/**
 * **************************************************************
 * Copyright (c) 2015 - Carlos Arturo Reyes Romero, All rights reserved
 * http://www.netcom.com.co
 * -
 * R reemplazo para cordova plugins
 * -
 * Autor:		Carlos Arturo Reyes Romero
 * email:		carlos.reyes@netcom.com.co
 * Creado:   	31/08/2015 - 5:32 PM
 * Proyecto: 	v3.5
 * ****************************************************************
 */

import android.app.Activity;
import android.content.Context;


public class FakeR {
    private Context context;
    private String packageName;

    public FakeR(Activity activity) {
        context = activity.getApplicationContext();
        packageName = context.getPackageName();
    }

    public FakeR(Context context) {
        this.context = context;
        packageName = context.getPackageName();
    }

    public int getId(String group, String key) {
        return context.getResources().getIdentifier(key, group, packageName);
    }

    public static int getId(Context context, String group, String key) {
        return context.getResources().getIdentifier(key, group, context.getPackageName());
    }
}
