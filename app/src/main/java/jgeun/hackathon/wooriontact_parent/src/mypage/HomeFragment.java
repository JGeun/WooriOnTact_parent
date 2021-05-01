package jgeun.hackathon.wooriontact_parent.src.mypage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.child.adapter.InfoAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.adapter.ADAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.adapter.HomeAdapter;
import me.relex.circleindicator.CircleIndicator3;


public class HomeFragment extends Fragment {
    private ViewPager2 buyViewpager;
    private HomeAdapter homeAdapter;
    private CircleIndicator3 buyIndicator;

    private ViewPager2 adViewpager;
    private ADAdapter adAdapter;
    private CircleIndicator3 adIndicator;

    private Context mContext;
    public HomeFragment(Context mContext){
        this.mContext = mContext;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        buyViewpager = view.findViewById(R.id.buy_viewpager);
        homeAdapter = new HomeAdapter((FragmentActivity) view.getContext(), 4);
        buyViewpager.setAdapter(homeAdapter);
//        buyIndicator.setViewPager(buyViewpager);
//        buyIndicator.createIndicators(4,0);
        buyViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //viewpager.setCurrentItem(1000);
        buyViewpager.setOffscreenPageLimit(3);

        buyViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    buyViewpager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                buyIndicator.animatePageSelected(position%4);
            }
        });

        adViewpager = view.findViewById(R.id.ad_viewpager);
        adIndicator = view.findViewById(R.id.ad_indicator);
        ADAdapter adAdapter = new ADAdapter((FragmentActivity) view.getContext(), 4);
        adViewpager.setAdapter(adAdapter);
        adIndicator.setViewPager(adViewpager);
        adIndicator.createIndicators(4,0);
        adViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //viewpager.setCurrentItem(1000);
        adViewpager.setOffscreenPageLimit(3);

        adViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    adViewpager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                adIndicator.animatePageSelected(position%4);
            }
        });
        return view;
    }
}