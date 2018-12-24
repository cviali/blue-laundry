package binus.viali.bluelaundry;

import android.graphics.Bitmap;

public class ClothesDetailList {

    public Bitmap image;
    public String title, desc, desc2;
    public int price, index;

    public ClothesDetailList(int index, Bitmap image, String title, String desc, String desc2, int price) {
        this.index = index;
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.desc2 = desc2;
        this.price = price;
    }
}
