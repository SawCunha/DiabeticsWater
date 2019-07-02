package br.com.riseline.cleiton.esports.diabticswater.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

import br.com.riseline.cleiton.esports.diabticswater.R;
import br.com.riseline.cleiton.esports.diabticswater.Util.SharedDiabtics;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class IntroActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        unbinder = ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

        createIntro();
    }

    private void createIntro() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage(
                getResources().getString(R.string.sou_sisi),getResources().getString(R.string.sobre_sisi),
                getResources().getColor(R.color.colorPrimary), R.drawable.ic_happy, R.drawable.ic_icone_noti);

        PaperOnboardingPage scr2 = new PaperOnboardingPage(
                getResources().getString(R.string.novidades), getResources().getString(R.string.msg_1),
                Color.parseColor("#65B0B4"), R.drawable.ic_teacher, R.drawable.ic_teacher);

        PaperOnboardingPage scr3 = new PaperOnboardingPage(
                getResources().getString(R.string.mais_novidades), getResources().getString(R.string.msg_2),
                Color.parseColor("#9B90BC"), R.drawable.ic_newspaper, R.drawable.ic_newspaper);

        PaperOnboardingPage scr4 = new PaperOnboardingPage(
                getResources().getString(R.string.nao_para_novidade), getResources().getString(R.string.msg_3),
                getResources().getColor(R.color.colorAccent), R.drawable.ic_sun, R.drawable.ic_sun);

        PaperOnboardingPage scr5 = new PaperOnboardingPage(
                getResources().getString(R.string.e_so_isso), getResources().getString(R.string.msg_4),
                getResources().getColor(R.color.colorPrimaryDark), R.drawable.ic_the_end, R.drawable.ic_the_end);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);
        elements.add(scr5);

        PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(elements);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(this::pularEvent);
    }

    @OnClick(R.id.pular)
    public void pularEvent(){
        SharedDiabtics.saveApresentacao(this,true);
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
