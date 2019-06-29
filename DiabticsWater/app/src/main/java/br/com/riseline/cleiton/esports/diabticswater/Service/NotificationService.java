package br.com.riseline.cleiton.esports.diabticswater.Service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationHelper;
import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationOldHelper;
import br.com.riseline.cleiton.esports.diabticswater.Util.Mensagens;

public class NotificationService {

    public static void notification(Context context) {
        Log.e("TESTE","JOB FIRED");
        int valueM = aleatorio(Mensagens.mensagem_aleatorias.size());
        int valueT = aleatorio(Mensagens.titulos_aleatorios.size());
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationHelper noti = new NotificationHelper(context);

            Notification.Builder nb = noti.getNotification1(Mensagens.titulos_aleatorios.get(valueT),String.format(Mensagens.mensagem_aleatorias.get(valueM),getDateString()) );
            if (nb != null) {
                noti.notify(new Random().nextInt(), nb);
            }
        }else{
            NotificationOldHelper.notification(context,Mensagens.titulos_aleatorios.get(valueT),String.format(Mensagens.mensagem_aleatorias.get(valueM),getDateString()));
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

}
