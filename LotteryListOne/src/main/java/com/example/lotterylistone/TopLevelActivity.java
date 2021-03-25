package com.example.lotterylistone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class TopLevelActivity extends AppCompatActivity {

    // GUI controls
    private ListView lvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        // Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    /*
                    AdapterView: The AdapterView where the click happened.
                    View: The view within the AdapterView that was clicked (this will be a view provided by the adapter)
                    position: The position of the view in the list
                    id: The row id of the item that was clicked
                    A position starts from 0, top to bottom of the ListView, whereas to get a proper row id it is important that the cursor,
                    which was passed to the adapter, contains a column called '_id' representing unique id for each row in the table.
                    If you are using an ArrayAdapter, position and id become the same.
                     */
                    public void onItemClick(AdapterView<?> lvOptions,
                                            View itemView,
                                            int position,
                                            long id) {
                        if (position == 0) {
                            Intent intent = new Intent(TopLevelActivity.this,
                                    LotteryCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        // Add the listener to the list view
        lvOptions = findViewById(R.id.lvOptions);
        lvOptions.setOnItemClickListener(itemClickListener);
    }
}

