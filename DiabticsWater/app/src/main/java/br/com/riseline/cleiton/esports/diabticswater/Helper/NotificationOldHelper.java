package br.com.riseline.cleiton.esports.diabticswater.Helper;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Random;

import br.com.riseline.cleiton.esports.diabticswater.R;

public class NotificationOldHelper {

    public static void notification(Context context, String titulo, String mensagem){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        int color=context.getResources().getColor(R.color.colorPrimary);
        builder.setSmallIcon(R.drawable.ic_logo);
        builder.setColor(color);
        Bitmap mProfilePic= BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_logo);
        builder.setLargeIcon(mProfilePic);
        builder.setStyle(new NotificationCompat.BigTextStyle());
        builder.setContentText(mensagem);
        builder.setContentTitle(titulo);
        Notification notification=builder.build();
        NotificationManagerCompat.from(context).notify(new Random().nextInt(),notification);
    }

}
