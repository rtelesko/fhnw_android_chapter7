package com.example.lotterylistfive;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/* Project Source: https://www.simplifiedcoding.net/android-recyclerview-cardview-tutorial/
with some adaptions
 */

public class MainActivity extends AppCompatActivity {

    // A List to store all the players
    List<Player> playerList;

    // The RecyclerView
    RecyclerView rvPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the RecyclerView from xml
        rvPlayers = findViewById(R.id.rvPlayers);
        rvPlayers.setHasFixedSize(true);
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));

        // Initializing the PlayerList
        playerList = new ArrayList<>();

        // Adding some Players
        playerList.add(new Player("Anthony Joshua", "31 years old", R.drawable.joshua));
        playerList.add(new Player("Wladimir Klitschko", "44 years old", R.drawable.klitschko));
        playerList.add(new Player("Deontay Wilder", "35 years old", R.drawable.wilder));

        // Creating RecyclerView adapter
        PlayerAdapter adapter = new PlayerAdapter(this, playerList);

        // Setting Adapter to RecyclerView
        rvPlayers.setAdapter(adapter);
    }

}