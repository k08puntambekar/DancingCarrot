package ReKritiks.Dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import ReKritiks.Dashboard.adapters.Leaderboard_ViewpagerAdapter;
import ReKritiks.Dashboard.fragments.Leaderboard_FragmentCall;
import ReKritiks.Dashboard.fragments.Leaderboard_FragmentContact;

public class Leaderboard_MainActivity extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Leaderboard_ViewpagerAdapter adapter;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.leaderboard_activity_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //super.onCreate(savedInstanceState);
        View v = getView();


        tabLayout = (TabLayout) v.findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager_id);
        adapter = new Leaderboard_ViewpagerAdapter(getActivity().getSupportFragmentManager());


        adapter.AddFragment(new Leaderboard_FragmentCall(), "monthly");
        adapter.AddFragment(new Leaderboard_FragmentContact(), "yearly");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}