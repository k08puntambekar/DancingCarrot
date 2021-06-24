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
import ReKritiks.Dashboard.adapters.Leaderboard_Contact;
import ReKritiks.Dashboard.adapters.Leaderboard_RecyclerViewAdapter;

public class Leaderboard_FragmentContact extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private List<Leaderboard_Contact> lstLeaderboardContact;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstLeaderboardContact = new ArrayList<>();
        lstLeaderboardContact.add(new Leaderboard_Contact("Aditya Dahapute",2000));
        lstLeaderboardContact.add(new Leaderboard_Contact("Kaushik Puntambekar",1760));
        lstLeaderboardContact.add(new Leaderboard_Contact("Vibhav Abhyankar",1650));
        lstLeaderboardContact.add(new Leaderboard_Contact("Rutvik Thanage ",1625));
        lstLeaderboardContact.add(new Leaderboard_Contact("Siddharth Vincent",1500));
        lstLeaderboardContact.add(new Leaderboard_Contact("Amit shahade",1498));
        lstLeaderboardContact.add(new Leaderboard_Contact("Pranay naidu",1400));
        lstLeaderboardContact.add(new Leaderboard_Contact("jai bihani",1360));
        lstLeaderboardContact.add(new Leaderboard_Contact("Elon Musk",1200));
        lstLeaderboardContact.add(new Leaderboard_Contact("aditya dahapute",900));

    }

    public Leaderboard_FragmentContact() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.leaderboard_contact_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.contact_recyclerview);
        Leaderboard_RecyclerViewAdapter leaderboardRecyclerViewAdapter = new Leaderboard_RecyclerViewAdapter(getContext(), lstLeaderboardContact);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(leaderboardRecyclerViewAdapter);
        return v;
    }
}
