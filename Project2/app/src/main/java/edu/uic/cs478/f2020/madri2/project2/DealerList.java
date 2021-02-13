package edu.uic.cs478.f2020.madri2.project2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DealerList extends Activity {
    String[] mobileArray = {"Fox Ford Lincoln:\n"+
                            "2501 North Elston Avenue\n" +
                            "Chicago, IL 60647",
                            "Metro Ford Sales & Service,Inc.:\n"+
                            "6455 So Western Avenue\n"+
                            "Chicago, IL 60636",
                            "Zeigler Ford of North Riverside:\n"+
                            "2100 South Harlem Avenue\n"+
                            "North Riverside, IL 60546"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealer_listview);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listtext,R.id.textView, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
