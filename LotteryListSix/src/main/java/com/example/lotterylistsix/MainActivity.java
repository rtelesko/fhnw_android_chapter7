package com.example.lotterylistsix;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // GUI control
    ListView lvPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing list view with the custom adapter
        ArrayList<Player> playerList = new ArrayList<>();
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(this, R.layout.list_item, playerList);
        lvPlayer = findViewById(R.id.lvPlayer);
        lvPlayer.setAdapter(itemArrayAdapter);

        // Populating list items
        playerList.add(new Player("John"));
        playerList.add(new Player("Ben"));
        playerList.add(new Player("Eve"));
        playerList.add(new Player("Donald"));
        playerList.add(new Player("Joe"));
        playerList.add(new Player("Martin"));
        playerList.add(new Player("Victor"));
        playerList.add(new Player("Tom"));
        playerList.add(new Player("Jack"));
        playerList.add(new Player("Erik"));
        playerList.add(new Player("Adam"));
        playerList.add(new Player("David"));
        playerList.add(new Player("Paul"));
        playerList.add(new Player("Timothy"));

        // Set up list item onclick listener
        setUpListItemClickListener();
    }

    private void setUpListItemClickListener() {
        lvPlayer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Player " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}