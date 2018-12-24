package binus.viali.bluelaundry;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Items extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView clothes, others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        clothes = findViewById(R.id.button_clothes);
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Items.this, Clothes.class);
                intent.putExtra("id", "0");
                startActivity(intent);
            }
        });

        others = findViewById(R.id.button_others);
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Items.this, Clothes.class);
                intent.putExtra("id", "1");
                startActivity(intent);
            }
        });
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
            case 1:
                //TODO: create clothes and others activites and custom list views
                intent = new Intent(this, Contact.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, Services.class);
                startActivity(intent);
                break;

        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
