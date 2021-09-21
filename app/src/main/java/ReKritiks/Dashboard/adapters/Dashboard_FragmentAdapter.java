package ReKritiks.Dashboard.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ReKritiks.Dashboard.fragments.Dashboard_All_Apps_Tab_Fragment;
import ReKritiks.Dashboard.fragments.Dashboard_Games_Tab_Fragment;
import ReKritiks.Dashboard.fragments.Dashboard_Music_Tab_Fragment;
import ReKritiks.Dashboard.fragments.Dashboard_App_Tab_Fragment;
import org.jetbrains.annotations.NotNull;

public class Dashboard_FragmentAdapter extends FragmentPagerAdapter {


    public Dashboard_FragmentAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Dashboard_All_Apps_Tab_Fragment();

            case 1:
                return new Dashboard_Games_Tab_Fragment();
            case 2:
                return new Dashboard_Music_Tab_Fragment();
            case 3:
                return new Dashboard_App_Tab_Fragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            //
            //Your tab titles
            //
            case 0:return "All Apps";
/*            case 1:return "Games";
            case 2: return "Music";
            case 3:return "Apps";*/
            default:return null;
        }
    }
}