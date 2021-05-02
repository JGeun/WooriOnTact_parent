package jgeun.hackathon.wooriontact_parent.src.card.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.card.CardFragment;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment1;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment2;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment3;

public class CardAdapter extends FragmentStateAdapter {
    private Context context;
    private int mCount;
    public CardAdapter(FragmentActivity fa, int count) {
        super(fa);
        context = fa;
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
            return new CardFragment(index);

    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public int getRealPosition(int position) { return position % mCount; }
}
