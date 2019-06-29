package br.com.riseline.cleiton.esports.diabticswater;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

import com.simplymadeapps.quickperiodicjobscheduler.PeriodicJob;
import com.simplymadeapps.quickperiodicjobscheduler.QuickJobFinishedCallback;
import com.simplymadeapps.quickperiodicjobscheduler.QuickPeriodicJob;
import com.simplymadeapps.quickperiodicjobscheduler.QuickPeriodicJobCollection;

import br.com.riseline.cleiton.esports.diabticswater.Service.NotificationService;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initJobs();
        atribuiInfor();
    }

    private void atribuiInfor(){
        //if(Build.MANUFACTURER.contentEquals("samsung"))
            new Intent().setComponent(new ComponentName("com.samsung.android.lool",
                "com.samsung.android.sm.ui.battery.BatteryActivity"));

        if(Build.MANUFACTURER.contentEquals("huawei"))
            new Intent().setComponent(new ComponentName("com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.process.ProtectActivity"));

        if(Build.MANUFACTURER.contentEquals("huawei"))
            getPackageManager().getLaunchIntentForPackage("com.huawei.systemmanager");

        if(Build.MANUFACTURER.contentEquals("xiaomi")) {
            new Intent("miui.intent.action.POWER_HIDE_MODE_APP_LIST").addCategory(Intent.CATEGORY_DEFAULT);
            new Intent("miui.intent.action.OP_AUTO_START").addCategory(Intent.CATEGORY_DEFAULT);
            new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings"));
        }

        if(Build.MANUFACTURER.contentEquals("asus"))
            getPackageManager().getLaunchIntentForPackage("com.asus.mobilemanager");

        if(Build.MANUFACTURER.contentEquals("oppo"))
            getPackageManager().getLaunchIntentForPackage("com.color.safecenter");

        if(Build.MANUFACTURER.contentEquals("vivo"))
            new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));

        if(Build.MANUFACTURER.contentEquals("Letv"))
            new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));

        if(Build.MANUFACTURER.contentEquals("Honor"))
            new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));

        if(Build.MANUFACTURER.contentEquals("oneplus"))
            new Intent().setComponent(new ComponentName("com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListAct‌​ivity"));
    }

    public void initJobs() {
        int jobId = 1;
        QuickPeriodicJob job = new QuickPeriodicJob(jobId, new PeriodicJob() {
            @Override
            public void execute(QuickJobFinishedCallback callback) {
                NotificationService.notification(getApplicationContext());
                callback.jobFinished();
            }
        });

        QuickPeriodicJobCollection.addJob(job);
    }
}
