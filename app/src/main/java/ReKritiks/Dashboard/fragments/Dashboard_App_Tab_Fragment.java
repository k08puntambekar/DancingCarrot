package ReKritiks.Dashboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ReKritiks.Dashboard.R;

public class Dashboard_App_Tab_Fragment extends Fragment {


    public Dashboard_App_Tab_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dashboard_app_tab_fragment, container, false);
    }

}