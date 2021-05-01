package jgeun.hackathon.wooriontact_parent.src.child;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.child.adapter.InfoAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.MyPageActivity;
import me.relex.circleindicator.CircleIndicator3;

public class ChildInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager2 viewpager;
    private InfoAdapter myAdapter;
    private CircleIndicator3 mIndicator;

    private LinearLayout registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_info);

        registerButton = findViewById(R.id.info_btn_register);
        registerButton.setOnClickListener(this);

        viewpager = findViewById(R.id.viewpager);
        myAdapter = new InfoAdapter(this, 3);
        viewpager.setAdapter(myAdapter);
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(viewpager);
        mIndicator.createIndicators(3, 0);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //viewpager.setCurrentItem(1000);
        viewpager.setOffscreenPageLimit(3);

        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewpager.setCurrentItem(position);
                    if (position == 2) {
                        registerButton.setVisibility(View.VISIBLE);
                    } else {
                        registerButton.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position % 3);
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.info_btn_register:
                startActivity(new Intent(this, MyPageActivity.class));
                break;
        }
    }

}