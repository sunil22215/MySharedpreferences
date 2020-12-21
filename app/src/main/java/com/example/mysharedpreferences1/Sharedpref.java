package com.example.mysharedpreferences1;

import android.content.Context;
import android.content.SharedPreferences;

public class Sharedpref {
    public static String name;
    public static String password;
    private static SharedPreferences sharedPreferences;

    private Sharedpref() {
    }

    public static void init(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), context.MODE_PRIVATE);

        }
    }


    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public static String read(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }


}





