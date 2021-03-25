package com.example.lotterylistthree;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private ListView lvTips;
    private TextView tvSelection;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the ListView and TextView
        lvTips = findViewById(R.id.lvTips);
        tvSelection = findViewById(R.id.tvSelection);

        // Generating some example data
        final String[] tips = new String[5];
        tips[0] = "5  15  18  4  11  30";
        tips[1] = "31  32  8  15  22  19";
        tips[2] = "20  10  30  8  12  42";
        tips[3] = "1  2  3  4  28  42";
        tips[4] = "17  12  13  33  8  41";

        // Create an ArrayAdapter from the List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Tip 1", "Tip 2", "Tip 3", "Tip 4", "Tip 5"});

        // Populate the ListView with items from ArrayAdapter
        lvTips.setAdapter(arrayAdapter);

        // Set an item click Listener for ListView
        lvTips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected tip from the ListView
                String selectedTip = tips[position];
                // Display the selected tip in the TextView
                tvSelection.setText("Selected tip: " + selectedTip);
            }
        });
    }
}
