package binus.viali.bluelaundry;

import android.content.Intent;
import android.graphics.BitmapFactory;
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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Clothes extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    ClothesAdapter adapter;
    List<ClothesList> listClothes;
    ImageView headerImage;
    TextView headerText;
    public String index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listClothes = new ArrayList<>();
        setContentView(R.layout.activity_clothes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        headerText = findViewById(R.id.text_items);
        headerImage = findViewById(R.id.image_logo);

        Intent intent = getIntent();
        index = intent.getStringExtra("id");
        listView = findViewById(R.id.list_clothes);
        if(index.equals("0")){
            Toast.makeText(Clothes.this, index, Toast.LENGTH_SHORT).show();
            headerText.setText("Clothes");
            headerImage.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.clothes));listView = findViewById(R.id.list_clothes);
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.exclusive_clothes), "Exclusive Clothes", "Suit, Blazer, Blouse, Robe", 0));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.tops), "Tops", "Shirt, T-Shirt", 1));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.bottoms), "Bottoms", "Trousers, Denim, Skirt", 2));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.outers), "Outers", "Jacket, Sweater, Parka, Cardigan, Coat", 3));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.accessories), "Accessories", "Tie, Hat, Belt, Slayer, Socks, Hijab, Scarf, Underwear", 4));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.shoes), "Shoes", "Leather, Suede, Canvas", 5));
        }else{
            Toast.makeText(Clothes.this, index, Toast.LENGTH_SHORT).show();
            headerText.setText("Others");
            headerImage.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.others));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.alpha), "Alpha", "Carpet, Sprai, Blanket, Bed Cover, Bed Sheet, Gordyn", 6));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.bravo), "Bravo", "Towel, Bag", 7));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.charlie), "Charlie", "Prayer Mat, Sarong, Doll, Cotton Fabric", 8));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.delta), "Delta", "Wallet, Strap, Glasses", 9));
            listClothes.add(new ClothesList(BitmapFactory.decodeResource(getResources(),R.drawable.echo), "Echo", "Stroller", 10));
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        adapter = new ClothesAdapter(listClothes,Clothes.this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String index = view.getTag().toString();
                Intent intent = new Intent(Clothes.this, ClothesDetail.class);
                intent.putExtra("id", index);
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
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
