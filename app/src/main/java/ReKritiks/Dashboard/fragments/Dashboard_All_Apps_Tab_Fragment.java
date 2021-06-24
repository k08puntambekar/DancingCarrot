package ReKritiks.Dashboard.fragments;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ReKritiks.Dashboard.R;
import ReKritiks.Dashboard.adapters.*;
import java.util.List;

public class Dashboard_All_Apps_Tab_Fragment extends Fragment {

    private RecyclerView recyclerViewAllApplications;
    private RecyclerView.LayoutManager layoutManager;
    private Dashboard_AllApplicationsAdapter allApplicationsAdapter;

    public Dashboard_All_Apps_Tab_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dashboard_allapps_tab_fragment, container, false);
        recyclerViewAllApplications = view.findViewById(R.id.recyclerViewAllApplications);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewAllApplications.setLayoutManager(layoutManager);

        allApplicationsAdapter = new Dashboard_AllApplicationsAdapter(getActivity(), GetAllInstalledApkInfo(), getActivity().getPackageManager());
        recyclerViewAllApplications.setAdapter(allApplicationsAdapter);

        return view;
    }

    public List<ResolveInfo> GetAllInstalledApkInfo(){

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = getActivity().getPackageManager().queryIntentActivities( mainIntent, 0);
        return pkgAppsList;

    }

}