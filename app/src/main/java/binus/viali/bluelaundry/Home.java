package binus.viali.bluelaundry;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView greetings;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        greetings = findViewById(R.id.text_greeting);

    String username = getIntent().getStringExtra(Login.EXTRA_USERNAME);

        greetings.setText("Welcome, " + username);

    mDrawerLayout = findViewById(R.id.drawer_layout);
    mToggle = new ActionBarDrawerToggle(Home.this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

    getSupportActionBar().setTitle("Blue Laundry");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){ //mastiin yg dipencet itu tombol hamburger di toolbar
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        displaySelectedScreen(menuItem.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId){
        //Fragment fragment = null;
        switch (itemId){
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(),"Ini Home Mas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_items:
                Toast.makeText(getApplicationContext(),"Ini Items Mas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                Toast.makeText(getApplicationContext(),"Ini About Mas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                Toast.makeText(getApplicationContext(),"Ini Logout Mas", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
