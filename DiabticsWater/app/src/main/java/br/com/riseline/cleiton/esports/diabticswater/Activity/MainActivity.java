package br.com.riseline.cleiton.esports.diabticswater.Activity;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
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

    @BindView(R.id.meowBottomNavigation)
    MeowBottomNavigation meowBottomNavigation;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initTab();
        init();
    }

    private void initTab() {
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_settings));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_info));

        //meowBottomNavigation.setOnShowListener();
    }

    /*private void managerFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContainerForFragment, fragment, tag);
        fragmentTransaction.commit();
    }*/

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
