package binus.viali.bluelaundry;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ClothesAdapter extends BaseAdapter {

    List<ClothesList> clothesLists;
    Context context;

    public ClothesAdapter(List<ClothesList> clothesLists, Context context) {
        this.clothesLists = clothesLists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clothesLists.size();
    }

    @Override
    public Object getItem(int position) {
        return clothesLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.clothes_list, null);
        ImageView image = view.findViewById(R.id.list_image);
        TextView title = view.findViewById(R.id.list_title);
        TextView desc = view.findViewById(R.id.list_desc);

        image.setImageBitmap(clothesLists.get(position).getImage());
        title.setText(clothesLists.get(position).getTitle());
        desc.setText(clothesLists.get(position).getDescription());
        view.setTag(clothesLists.get(position).getIndex());
        return view;
    }
}
