package jgeun.hackathon.wooriontact_parent.src.child;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import jgeun.hackathon.wooriontact_parent.R;

public class InfoFragment3 extends Fragment{
    public static SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor;

    private EditText mission1;
    private EditText mission2;
    private EditText mission3;
    private EditText mission4;
    private EditText mission5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_info3, container, false);

        sharedPreferences = getActivity().getSharedPreferences("pay", Context.MODE_PRIVATE);;
        editor = sharedPreferences.edit();

        mission1 = view.findViewById(R.id.info3_mission1);
        mission2 = view.findViewById(R.id.info3_mission2);
        mission3 = view.findViewById(R.id.info3_mission3);
        mission4 = view.findViewById(R.id.info3_mission4);
        mission5 = view.findViewById(R.id.info3_mission5);

        return view;
    }
}
