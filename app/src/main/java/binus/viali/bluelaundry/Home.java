package binus.viali.bluelaundry;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView greetings;
    public static String greetingName;
    private ViewPager viewPager, viewPager2;
    private ViewPagerAdapter viewPagerAdapter, viewPagerAdapter2;
    private Handler handler, handler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        greetingName = getIntent().getStringExtra(Login.EXTRA_USERNAME);
        greetings = findViewById(R.id.text_greeting);
        greetings.setText("Hello " + greetingName);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(Home.this);
        viewPager.setAdapter(viewPagerAdapter);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int index = viewPager.getCurrentItem();
                if(index == 5){
                    index = 0;
                }else{
                    index++;
                }
                viewPager.setCurrentItem(index);
                handler.postDelayed(this, 3000);
            }
        }, 3000);

        viewPager2 = findViewById(R.id.view_pager2);
        viewPagerAdapter2 = new ViewPagerAdapter(Home.this);
        viewPager2.setAdapter(viewPagerAdapter2);

        handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                int index = viewPager2.getCurrentItem();
                if(index == 0){
                    index = 5;
                }else{
                    index--;
                }
                viewPager2.setCurrentItem(index);
                handler2.postDelayed(this, 3000);
            }
        }, 3000);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId){
        Intent intent;
        switch (itemId){
            case R.id.nav_home:
                intent = new Intent(this, Home.class);
                startActivity(intent);
                break;
            case R.id.nav_items:
                intent = new Intent(this, Items.class);
                startActivity(intent);
                break;
            case R.id.nav_about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}