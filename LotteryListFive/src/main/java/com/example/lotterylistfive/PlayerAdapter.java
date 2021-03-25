package com.example.lotterylistfive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {


    // This context we will use to inflate the Layout
    private Context context;

    // We are storing all the players in a List
    private List<Player> playerList;

    // Getting the context and player List with constructor
    public PlayerAdapter(Context context, List<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflating and returning our ViewHolder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_players, null);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder holder, int position) {
        // Getting the player of the specified position
        Player player = playerList.get(position);

        // Binding the data with the ViewHolder views
        holder.tvName.setText(player.getName());
        holder.tvAge.setText(player.getAge());
        holder.ivPhoto.setImageDrawable(context.getResources().getDrawable(player.getImage()));
    }


    @Override
    public int getItemCount() {
        return playerList.size();
    }


    class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvAge;
        ImageView ivPhoto;

        public PlayerViewHolder(View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
        }
    }
}