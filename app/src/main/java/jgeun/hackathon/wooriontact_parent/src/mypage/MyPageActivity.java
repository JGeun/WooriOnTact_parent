package jgeun.hackathon.wooriontact_parent.src.mypage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.util.StatusBarUtil;

public class MyPageActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Context mConText;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private ProfileFragment profileFragment;
    private CardFragment cardFragment = new CardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        sharedPreferences = this.getSharedPreferences("pay", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("이름", "이름");
        profileFragment = new ProfileFragment(name);

        mConText = this;
        setFrag(1);

        bottomNavigationView = findViewById(R.id.child_mypage_bottomNavi);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_creditCard:
                        setFrag(0);
                        break;
                    case R.id.menu_profile:
                        setFrag(1);
                        break;

                }
                return true;
            }
        });
    }

    public void changeStatusColor(int n){
        if(n == 0){
            StatusBarUtil.setStatusBarColor(this, StatusBarUtil.StatusBarColorType.MAIN_COLOR_STATUS_BAR);
        }else{
            StatusBarUtil.setStatusBarColor(this, StatusBarUtil.StatusBarColorType.WHITE_STATUS_BAR);
        }
    }

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        changeStatusColor(n);
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, cardFragment);

                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, profileFragment);
                ft.commit();
                break;
        }
    }
}