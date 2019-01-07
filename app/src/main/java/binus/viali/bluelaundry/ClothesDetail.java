package binus.viali.bluelaundry;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClothesDetail extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<ClothesDetailList> itemList = new ArrayList<>();
    public String totalPrice;
    public int index, calcPrice;

    public ImageView image;
    public TextView itemName, desc, desc2, price;
    public Button submit, back;
    public EditText qty;

    public void seedData(){
        itemList.add(new ClothesDetailList(0, BitmapFactory.decodeResource(getResources(),R.drawable.exclusive_clothes), "Exclusive Clothes", "Suit, Blazer, Blouse, Robe", "Banyak orang tidak tahu merawat pakaian terbaik mereka dengan baik. Kami memiliki banyak cara dan proses untuk menjadikan pakaian terbaikmu utuh setiap saat", 150000));
        itemList.add(new ClothesDetailList(1, BitmapFactory.decodeResource(getResources(),R.drawable.tops), "Tops", "Shirt, T-Shirt", "Menjadikan pakaian atasanmu selalu membuat kamu lebih percaya diri dan tampil indah kapanpun", 8000));
        itemList.add(new ClothesDetailList(2, BitmapFactory.decodeResource(getResources(),R.drawable.bottoms), "Bottoms", "Trouser, Skirt, Denim", "Bawahanmu adalah salah satu bagian terpenting dalam pakaianmu. Jangan jadikan semua itu rusak karena kita tidak peduli, yuk laundry !", 15000));
        itemList.add(new ClothesDetailList(3, BitmapFactory.decodeResource(getResources(),R.drawable.outers), "Outers", "Parka, Jacket, Sweater, Cardigan, Coat", "Jadikan pakaian luaranmu membuatmu untuk selalu nyaman dan ada ketika kamu butuhkan. Jauhi noda bandel yang dapat merusak luaranmu", 30000));
        itemList.add(new ClothesDetailList(4, BitmapFactory.decodeResource(getResources(),R.drawable.accessories), "Accessories", "Hat, Slayer, Scarf, Hijab, Belt, Socks, Underwear, Tie", "Aksesorismu adalah hal pendukung yang menjadikanmu lebih terlihat keren, mau aksesorismu tetap tahan lama? yuk di laundry !", 45000));
        itemList.add(new ClothesDetailList(5, BitmapFactory.decodeResource(getResources(),R.drawable.shoes), "Shoes", "Leather, Canvas, Suede", "Sepatumu akan selalu bersih bagi kami, dari Insole, middlesole, outsole yang mengartikan kami selalu menjaga keutuhan barang dari berbagai sisi", 65000));
        itemList.add(new ClothesDetailList(6, BitmapFactory.decodeResource(getResources(),R.drawable.alpha), "Alpha", "Carpet, Sprai, Blanket, Gordyn, Bed Cover, Bed Sheet", "Paket Alpha adalah Paket yang menyediakan layanan laundry untuk Big Item", 120000));
        itemList.add(new ClothesDetailList(7, BitmapFactory.decodeResource(getResources(),R.drawable.bravo), "Bravo", "Towel, Bag", "Paket Bravo adalah Paket yang menyediakan layanan laundry untuk Medium Item", 100000));
        itemList.add(new ClothesDetailList(8, BitmapFactory.decodeResource(getResources(),R.drawable.charlie), "Charlie", "Prayer Mat, Sarong, Doll, Cotton Fabric", "Paket Charlie adalah Paket yang menyediakan layanan laundry untuk Small Item", 50000));
        itemList.add(new ClothesDetailList(9, BitmapFactory.decodeResource(getResources(),R.drawable.delta), "Delta", "Wallet, Strap, Glasses", "Paket Delta adalah Paket yang menyediakan layanan laundry untuk Very Small Item", 30000));
        itemList.add(new ClothesDetailList(10, BitmapFactory.decodeResource(getResources(),R.drawable.echo), "Echo", "Stoler", "Paket Echo adalah Paket yang menyediakan layanan laundry untuk Rare Item", 200000));
    }

    public void setSelectedData(){
        image.setImageBitmap(itemList.get(index).image);
        itemName.setText(itemList.get(index).title);
        desc.setText(itemList.get(index).desc);
        desc2.setText(itemList.get(index).desc2);
        price.setText("Rp. " + itemList.get(index).price + " / pcs");
        calcPrice = itemList.get(index).price;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Item Detail");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        index = Integer.parseInt(intent.getStringExtra("id"));

        seedData();

        image = findViewById(R.id.item_image);
        itemName = findViewById(R.id.item_name);
        desc = findViewById(R.id.item_desc);
        desc2 = findViewById(R.id.item_desc2);
        price = findViewById(R.id.text_price);
        qty = findViewById(R.id.input_qty);
        submit = findViewById(R.id.button_submit);
        back = findViewById(R.id.button_back);

        setSelectedData();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClothesDetail.super.onBackPressed();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calcQty = qty.getText().toString();
                if(calcQty.equals("") || Integer.parseInt(qty.getText().toString()) == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ClothesDetail.this);
                    builder.setMessage("Quantity must be more than 1").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ClothesDetail.this);
                    builder.setTitle("Subtotal")
                            .setMessage(String.valueOf(calcPrice * Integer.parseInt(qty.getText().toString())))
                            .setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(ClothesDetail.this, Items.class));
                                }
                            }).setNegativeButton("No, thanks", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                }
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
