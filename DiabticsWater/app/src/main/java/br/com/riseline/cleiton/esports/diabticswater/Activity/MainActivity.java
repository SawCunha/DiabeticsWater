package br.com.riseline.cleiton.esports.diabticswater.Activity;

import android.app.Notification;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.simplymadeapps.quickperiodicjobscheduler.QuickPeriodicJobScheduler;

import java.util.Random;

import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationHelper;
import br.com.riseline.cleiton.esports.diabticswater.Helper.NotificationOldHelper;
import br.com.riseline.cleiton.esports.diabticswater.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.backgroud_color)
    ConstraintLayout backgroundColor;

    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        init();
    }



    private void init() {
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
        unbinder.unbind();
    }
}
