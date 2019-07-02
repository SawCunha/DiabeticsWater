package br.com.riseline.cleiton.esports.diabticswater.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.simplymadeapps.quickperiodicjobscheduler.QuickPeriodicJobScheduler;

public class BootCompletedSystem extends BroadcastReceiver {

    /**
     * Trava o recebimento da Intent que realizou o envio.
     *
     * @param context Contexto da Aplicação
     * @param intent  e Intent que realizou o envio
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        QuickPeriodicJobScheduler jobScheduler = new QuickPeriodicJobScheduler(context);
        jobScheduler.start(1, 1800000L); // Run job with jobId=1 every 60 seconds
    }
}
