package com.example.lotterylistone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LotteryActivity extends AppCompatActivity {

    public static final String EXTRA_LOTTERYID = "lotteryId";

    // GUI controls
    private TextView tvName;
    private TextView tvDescription;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        // Get the lottery from the intent
        int lotteryId = (Integer) getIntent().getExtras().get(EXTRA_LOTTERYID);
        Lottery lottery = Lottery.lotteries[lotteryId];

        // Populate the lottery name
        tvName = findViewById(R.id.tvName);
        tvName.setText(lottery.getName());

        // Populate the lottery short description
        tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setText(lottery.getDescription());

        // Populate the lottery image
        ivPhoto = findViewById(R.id.ivPhoto);
        // Sets a drawable as the content of this ImageView.
        ivPhoto.setImageResource(lottery.getImageResourceId());
        //  Allows you to associate a textual description to the view.
        //  The docs state that it's primarily used to support accessibility,
        ivPhoto.setContentDescription(lottery.getName());
    }
}
