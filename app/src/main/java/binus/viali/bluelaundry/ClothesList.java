package binus.viali.bluelaundry;

import android.graphics.Bitmap;

public class ClothesList {

    public Bitmap image;
    public String title, description;
    public int index;

    public ClothesList(Bitmap image, String title, String description, int index) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.index = index;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
