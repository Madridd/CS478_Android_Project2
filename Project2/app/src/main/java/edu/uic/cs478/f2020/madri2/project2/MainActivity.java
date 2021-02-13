package edu.uic.cs478.f2020.madri2.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    protected static final String EXTRA_RES_ID = "POS";

    private ArrayList<Integer> carPics = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6));

    private ArrayList<String> carNames = new ArrayList<String>(
            Arrays.asList("BroncoSport", "EcoSport", "Bronco", "Edge", "Escape", "Explore"));

    private ArrayList<String> websites = new ArrayList<String>(
            Arrays.asList("https://www.ford.com/suvs/bronco-sport/2021/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs-crossovers/ecosport/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs/bronco/2021/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs-crossovers/edge/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs-crossovers/escape/?gnav=header-all-vehicles",
                    "https://www.ford.com/suvs/explorer/?gnav=header-all-vehicles"));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        // Create a new gridAdapter and set it as the Adapter for this GridView
        gridview.setAdapter(new GridAdapter(this, carPics, carNames));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int)id);
                intent.putExtra("website", position);

                // Start the ImageViewActivity
                startActivity(intent);
            }
        });//end of click listener

        //for the context menu when you long click on grid spot
        registerForContextMenu(gridview);

    }//end of onCreate


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grid_item_menu,menu);
    }//end onCreateContextMenu

    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.option_1:
                //picture
                Intent intent = new Intent(MainActivity.this,ImageViewActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int)info.id);
                intent.putExtra("website", info.position);

                // Start the ImageViewActivity
                startActivity(intent);
                return true;
            case R.id.option_2:
                //webpage
                Uri uri = Uri.parse(websites.get(info.position));
                Intent webintent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webintent);
                return true;
            case R.id.option_3:
                //show dealers
                Intent intent3 = new Intent(MainActivity.this,DealerList.class);
                // Start the ImageViewActivity
                startActivity(intent3);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
}//end onContextItemSelected



}//end of MainActivity
