package ReKritiks.Dashboard.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class Leaderboard_ViewpagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<String>();

    public Leaderboard_ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) lstTitles.get(position);
    }
    public void AddFragment(Fragment fragment, String title)
    {
        lstFragment.add(fragment);
        lstTitles.add(title);
    }

}
