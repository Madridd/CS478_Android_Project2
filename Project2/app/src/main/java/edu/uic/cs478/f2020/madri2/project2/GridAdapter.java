package edu.uic.cs478.f2020.madri2.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    private static final int PADDING = 8;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private Context context;          // This will have to be passed to the ImageView
    private List<Integer> carIcons;   // Adapter must store AdapterView's items (pics)
    private List<String> carNames;    // Adapter must store AdapterView's items (text)
    private LayoutInflater inflater;  // to put in each grid spot


    public GridAdapter(Context c, List<Integer> icons, List<String> names){
        this.context = c;
        this.carIcons = icons;
        this.carNames = names;
    }


    @Override
    public int getCount() {
        return carNames.size();
    }

    @Override
    public Object getItem(int position) {
        return carNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return carIcons.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.item_grid,null);
        }

        ImageView icon = (ImageView) gridView.findViewById(R.id.imageView);
        TextView iconName = (TextView) gridView.findViewById(R.id.textView);

        icon.setImageResource(carIcons.get(position));
        iconName.setText(carNames.get(position));


        return gridView;
    }
}
