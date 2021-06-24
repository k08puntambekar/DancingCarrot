package ReKritiks.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import ReKritiks.Dashboard.adapters.Dashboard_FragmentAdapter;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import ReKritiks.Dashboard.databinding.DashboardActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class Dashboard_Activity_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private DashboardActivityMainBinding binding;
    private ViewPager vp_pages;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DashboardActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        profileImage = findViewById(R.id.profileImage);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/
        TabLayout tbl_pages= (TabLayout) findViewById(R.id.tbl_pages);
        vp_pages= (ViewPager) findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new Dashboard_FragmentAdapter(getSupportFragmentManager(), tbl_pages.getTabCount());
        vp_pages.setAdapter(pagerAdapter);


        tbl_pages.setupWithViewPager(vp_pages);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.frag_nav_leaderboard)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.relative_layout, new Leaderboard_MainActivity()).commit();
        } else if (id == R.id.frag_nav_dashboard)
        {
            Intent dashboardIntent= new Intent(this,Dashboard_Activity_Main.class);
            startActivity(dashboardIntent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void profile(View view) {
        Intent profileIntent = new Intent(this, Profile_MainActivity.class);
        startActivity(profileIntent);
    }

    public void leaderboard(View view)
    {

    }

}