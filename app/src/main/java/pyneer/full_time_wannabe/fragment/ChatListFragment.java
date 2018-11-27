package pyneer.full_time_wannabe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.RadarChart;

import pyneer.full_time_wannabe.R;

/**
 * Created by ddjdd on 2018-11-27.
 */

public class ChatListFragment extends Fragment {
    ViewGroup rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (rootView != null) return rootView;
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }
}
