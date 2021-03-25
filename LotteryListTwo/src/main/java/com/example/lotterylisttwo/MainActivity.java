package com.example.lotterylisttwo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private ListView lvTips;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the ListView
        lvTips = findViewById(R.id.lvTips);

        // Initializing a new ArrayList
        final ArrayList<String> tips = new ArrayList<>();
        tips.add("Tip 1");
        tips.add("Tip 2");
        tips.add("Tip 3");
        tips.add("Tip 4");
        tips.add("Tip 5");
        tips.add("Tip 6");
        tips.add("Tip 7");
        tips.add("Tip 8");
        tips.add("Tip 9");
        tips.add("Tip 10");
        /*
        What are possible Adapters in Android?
        BaseAdapter is a very generic adapter that allows you to do pretty much whatever you want.
        However, you have to do a bit more coding yourself to get it working.
        ArrayAdapter is a more complete implementation that works well for data in arrays or ArrayLists.
        Similarly, there is a related CursorAdapter that you should use if your data is in a Cursor (e.g. in a database).
        Both of these extend BaseAdapter.
        */

        // Create an ArrayAdapter from the List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, tips);

        // Populate the ListView with items from ArrayAdapter
        lvTips.setAdapter(arrayAdapter);

        // Set an item click Listener for ListView
        lvTips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                /* Alternative 1: Just show a Toast message
                // Get the selected item text from the ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item text with a Toast message
                Toast.makeText(getApplicationContext(), selectedItem + " selected", Toast.LENGTH_LONG).show();
                */

                // Alternative 2: Delete an item with an AlertDialog
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setMessage("Are you sure you want to delete this item?")
                        .setTitle("Attempt to delete an item")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    tips.remove(position);
                                    arrayAdapter.notifyDataSetChanged();

                                    Toast.makeText(MainActivity.this, "Item deleted!", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Item NOT deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
