package br.com.riseline.cleiton.esports.diabticswater.Activity;

import android.app.Notification;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.simplymadeapps.quickperiodicjobscheduler.QuickPeriodicJobScheduler;

import java.util.Random;

import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationHelper;
import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationOldHelper;
import br.com.riseline.cleiton.esports.diabticswater.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuickPeriodicJobScheduler jobScheduler = new QuickPeriodicJobScheduler(this);
        jobScheduler.start(1, 1800000L); // Run job with jobId=1 every 60 seconds

        notificacaoInicial();
    }

    private void notificacaoInicial(){
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationHelper noti = new NotificationHelper(this);

            Notification.Builder nb = noti.getNotification1("Seja Bem-Vindo", getString(R.string.introducao));
            if (nb != null) {
                noti.notify(new Random().nextInt(), nb);
            }
        }else{
            NotificationOldHelper.notification(this,"Seja Bem-Vindo",getString(R.string.introducao));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
