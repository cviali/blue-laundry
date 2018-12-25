package binus.viali.bluelaundry;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    public String index, totalPrice;
    public int calcPrice;

    public ImageView image;
    public TextView itemName, desc, desc2, price;
    public Button submit, back;
    public EditText qty;

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
        index = intent.getStringExtra("id");

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

        image = findViewById(R.id.item_image);
        itemName = findViewById(R.id.item_name);
        desc = findViewById(R.id.item_desc);
        desc2 = findViewById(R.id.item_desc2);
        price = findViewById(R.id.text_price);
        qty = findViewById(R.id.input_qty);
        submit = findViewById(R.id.button_submit);

        switch(index){
            case "0":
                image.setImageBitmap(itemList.get(0).image);
                itemName.setText(itemList.get(0).title);
                desc.setText(itemList.get(0).desc);
                desc2.setText(itemList.get(0).desc2);
                price.setText("Rp. " + itemList.get(0).price + " / pcs");
                calcPrice = itemList.get(0).price;
                break;
            case "1":
                image.setImageBitmap(itemList.get(1).image);
                itemName.setText(itemList.get(1).title);
                desc.setText(itemList.get(1).desc);
                desc2.setText(itemList.get(1).desc2);
                price.setText("Rp. " + itemList.get(1).price + " / pcs");
                calcPrice = itemList.get(1).price;
                break;
            case "2":
                image.setImageBitmap(itemList.get(2).image);
                itemName.setText(itemList.get(2).title);
                desc.setText(itemList.get(2).desc);
                desc2.setText(itemList.get(2).desc2);
                price.setText("Rp. " + itemList.get(2).price + " / pcs");
                calcPrice = itemList.get(2).price;
                break;
            case "3":
                image.setImageBitmap(itemList.get(3).image);
                itemName.setText(itemList.get(3).title);
                desc.setText(itemList.get(3).desc);
                desc2.setText(itemList.get(3).desc2);
                price.setText("Rp. " + itemList.get(3).price + " / pcs");
                calcPrice = itemList.get(3).price;
                break;
            case "4":
                image.setImageBitmap(itemList.get(4).image);
                itemName.setText(itemList.get(4).title);
                desc.setText(itemList.get(4).desc);
                desc2.setText(itemList.get(4).desc2);
                price.setText("Rp. " + itemList.get(4).price + " / pcs");
                calcPrice = itemList.get(4).price;
                break;
            case "5":
                image.setImageBitmap(itemList.get(5).image);
                itemName.setText(itemList.get(5).title);
                desc.setText(itemList.get(5).desc);
                desc2.setText(itemList.get(5).desc2);
                price.setText("Rp. " + itemList.get(5).price + " / pcs");
                calcPrice = itemList.get(5).price;
                break;
            case "6":
                image.setImageBitmap(itemList.get(6).image);
                itemName.setText(itemList.get(6).title);
                desc.setText(itemList.get(6).desc);
                desc2.setText(itemList.get(6).desc2);
                price.setText("Rp. " + itemList.get(6).price + " / pcs");
                calcPrice = itemList.get(6).price;
                break;
            case "7":
                image.setImageBitmap(itemList.get(7).image);
                itemName.setText(itemList.get(7).title);
                desc.setText(itemList.get(7).desc);
                desc2.setText(itemList.get(7).desc2);
                price.setText("Rp. " + itemList.get(7).price + " / pcs");
                calcPrice = itemList.get(7).price;
                break;
            case "8":
                image.setImageBitmap(itemList.get(8).image);
                itemName.setText(itemList.get(8).title);
                desc.setText(itemList.get(8).desc);
                desc2.setText(itemList.get(8).desc2);
                price.setText("Rp. " + itemList.get(8).price + " / pcs");
                calcPrice = itemList.get(8).price;
                break;
            case "9":
                image.setImageBitmap(itemList.get(9).image);
                itemName.setText(itemList.get(9).title);
                desc.setText(itemList.get(9).desc);
                desc2.setText(itemList.get(9).desc2);
                price.setText("Rp. " + itemList.get(9).price + " / pcs");
                calcPrice = itemList.get(9).price;
                break;
            case "10":
                image.setImageBitmap(itemList.get(10).image);
                itemName.setText(itemList.get(10).title);
                desc.setText(itemList.get(10).desc);
                desc2.setText(itemList.get(10).desc2);
                price.setText("Rp. " + itemList.get(10).price + " / pcs");
                calcPrice = itemList.get(10).price;
                break;
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClothesDetail.this, String.valueOf(calcPrice * Integer.parseInt(qty.getText().toString())), Toast.LENGTH_SHORT).show();
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
        });

        back = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClothesDetail.super.onBackPressed();
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
