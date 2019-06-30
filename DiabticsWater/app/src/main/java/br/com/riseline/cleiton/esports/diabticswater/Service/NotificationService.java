package br.com.riseline.cleiton.esports.diabticswater.Service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationHelper;
import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationOldHelper;
import br.com.riseline.cleiton.esports.diabticswater.R;

public class NotificationService {

    public static void notification(Context context) {
        Log.e("TESTE","JOB FIRED");
        int valueM = aleatorio(getMessageSize(context));
        int valueT = aleatorio(getTituloSize(context));
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationHelper noti = new NotificationHelper(context);

            Notification.Builder nb = noti.getNotification1(getTitulo(context, valueT),String.format(getMessage(context,valueM),getDateString()) );
            if (nb != null) {
                noti.notify(new Random().nextInt(), nb);
            }
        }else{
            NotificationOldHelper.notification(context,getTitulo(context, valueT),String.format(getMessage(context,valueM),getDateString()));
        }
    }

    private static int aleatorio(int max){
        Random r = new Random();
        int low = 0;
        return r.nextInt(max-low) + low;
    }

    private static String getDateString() {
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        @SuppressLint("SimpleDateFormat") DateFormat fmt = new SimpleDateFormat("HH:mm");
        return fmt.format(date);
    }

    private static Integer getMessageSize(Context context){
       return context.getResources().getStringArray(R.array.mensagem_aleatorias).length;
    }

    private static String getMessage(Context context, Integer index){
        String[] myResArray = context.getResources().getStringArray(R.array.mensagem_aleatorias);
        return Arrays.asList(myResArray).get(index);
    }

    private static Integer getTituloSize(Context context){
        return context.getResources().getStringArray(R.array.titulos_aleatorios).length;
    }

    private static String getTitulo(Context context, Integer index){
        String[] myResArray = context.getResources().getStringArray(R.array.titulos_aleatorios);
        return Arrays.asList(myResArray).get(index);
    }

}
