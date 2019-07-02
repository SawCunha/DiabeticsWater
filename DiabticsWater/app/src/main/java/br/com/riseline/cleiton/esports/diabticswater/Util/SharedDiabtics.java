package br.com.riseline.cleiton.esports.diabticswater.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedDiabtics {

    private static final String CHAVE = "DIABTICS_WATER_KEY";

    public static void saveApresentacao(Context context, Boolean apresentacao) {
        SharedPreferences sharedPref = context.getSharedPreferences(CHAVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("APRESENTACAO", apresentacao);
        editor.apply();
    }

    public static Boolean getApresentacao(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(CHAVE, Context.MODE_PRIVATE);
        return sharedPref.getBoolean("APRESENTACAO", false);
    }
}
