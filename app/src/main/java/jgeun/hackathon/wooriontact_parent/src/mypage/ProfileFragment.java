package jgeun.hackathon.wooriontact_parent.src.mypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.mypage.adapter.HomeAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.data.InfoData;

public class ProfileFragment extends Fragment {
    private String name;
    public ProfileFragment(String name){
        this.name = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);



        TextView nameText =  view.findViewById(R.id.home_tv_name);
        nameText.setText(name);
        ArrayList<InfoData> missonList = new ArrayList<>();
        missonList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", true));
        missonList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", true));
        missonList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", false));
        missonList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", true));

        RecyclerView missionView=view.findViewById(R.id.home_rv_mission);
        missionView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        missionView.setAdapter(new HomeAdapter(missonList));

        ArrayList<InfoData> creditList = new ArrayList<>();
        creditList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", true));
        creditList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", true));
        creditList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", false));
        creditList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", true));
        creditList.add(new InfoData("일주일 동안 100,000원 이하 사용하기", false));
        RecyclerView creditView=view.findViewById(R.id.home_rv_credit);
        creditView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        creditView.setAdapter(new HomeAdapter(creditList));
        return view;
    }
}
