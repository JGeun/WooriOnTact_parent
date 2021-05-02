package jgeun.hackathon.wooriontact_parent.src.card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.card.adapter.CardAdapter;
import jgeun.hackathon.wooriontact_parent.src.child.RegisterChildActivity;
import jgeun.hackathon.wooriontact_parent.src.child.adapter.InfoAdapter;
import me.relex.circleindicator.CircleIndicator3;

public class SelectMyCardActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout registerButton;
    private LinearLayout cardButton;

    private ViewPager2 viewpager;
    private CardAdapter cardAdapter;
    private CircleIndicator3 mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_my_card);

        registerButton = findViewById(R.id.select_btn_register);
        registerButton.setOnClickListener(this);

        cardButton = findViewById(R.id.select_cardButton);
        cardButton.setOnClickListener(this);

        viewpager = findViewById(R.id.select_viewpager);
        cardAdapter = new CardAdapter(this, 3);
        viewpager.setAdapter(cardAdapter);
        mIndicator = findViewById(R.id.select_indicator);
        mIndicator.setViewPager(viewpager);
        mIndicator.createIndicators(4, 0);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //viewpager.setCurrentItem(1000);
        viewpager.setOffscreenPageLimit(3);

        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    viewpager.setCurrentItem(position);
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
        switch (v.getId()){
            case R.id.select_btn_register:
                startActivity(new Intent(this, RegisterChildActivity.class));
                break;
            case R.id.select_cardButton:
                Log.d("확인", "클릭");
                cardButton.setVisibility(View.GONE);
               viewpager.setVisibility(View.VISIBLE);
               mIndicator.setVisibility(View.VISIBLE);
                break;
        }
    }
}