package ReKritiks.Dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import ReKritiks.Dashboard.databinding.DashboardActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class Dashboard_Activity_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private DashboardActivityMainBinding binding;
    private ViewPager vp_pages;
    private ImageView profileImage;
    private String email;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DashboardActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        edit = sharedPreferences.edit();

        profileImage = findViewById(R.id.profileImage);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent emailIntent = getIntent();
        email = emailIntent.getStringExtra("Email");
        Log.i("Dashboard Email:",email);
        //NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
      /* mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.frag_nav_leaderboard, R.id.logout)
                .setDrawerLayout(drawer)
                .build();*/
 /*       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/
        TabLayout tbl_pages= findViewById(R.id.tbl_pages);
        vp_pages= findViewById(R.id.vp_pages);
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
        if (id == R.id.frag_nav_leaderboard) {
            getSupportFragmentManager().beginTransaction().add(R.id.relative_layout, new Leaderboard_MainActivity()).addToBackStack(null).commit();
        } else if (id == R.id.frag_nav_dashboard) {
            Intent dashboardIntent= new Intent(this,Dashboard_Activity_Main.class);
            startActivity(dashboardIntent);
            finish();
        }
        else if (id == R.id.logout) {
            edit.clear();
            edit.commit();
            Intent logoutIntent= new Intent(this,Initial_MainActivity.class);
            startActivity(logoutIntent);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void profile(View view) {
        Intent profileIntent = new Intent(this, Profile_MainActivity.class);
        profileIntent.putExtra("ProfEmail",email);
        startActivity(profileIntent);
    }

    public void leaderboard(View view)
    {

    }


}