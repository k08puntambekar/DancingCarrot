package ReKritiks.Dashboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ReKritiks.Dashboard.R;
import ReKritiks.Dashboard.adapters.Leaderboard_RecyclerViewAdaptercall;

public class Leaderboard_FragmentCall extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private List<ReKritiks.Dashboard.adapters.Leaderboard_Call> lstContact;

    public Leaderboard_FragmentCall() {

    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Aditya Dahapute",2000));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Kaushik Puntambekar",1760));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Vibhav Abhyankar",1650));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Rutvik Thanage ",1625));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Siddharth Vincent",1500));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Amit shahade",1498));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Pranay naidu",1400));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("jai bihani",1360));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("Elon Musk",1200));
        lstContact.add(new ReKritiks.Dashboard.adapters.Leaderboard_Call("aditya dahapute",900));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.leaderboard_call_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.call_recyclerview);
        Leaderboard_RecyclerViewAdaptercall leaderboardRecyclerViewAdaptercall = new Leaderboard_RecyclerViewAdaptercall(getContext(),lstContact);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(leaderboardRecyclerViewAdaptercall);
        return v;

    }
}
