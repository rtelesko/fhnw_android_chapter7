package com.example.lotterylistsix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemArrayAdapter extends ArrayAdapter<Player> {

    private int listItemLayout;

    public ItemArrayAdapter(Context context, int layoutId, ArrayList<Player> playerList) {
        super(context, layoutId, playerList);
        listItemLayout = layoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data player for this position
        Player player = getItem(position);

        /*
        Check if an existing view is being reused, otherwise inflate the view.
        setTag() and getTag() methods: We can use setTag() and getTag() methods
        to set and get custom objects as per our requirement. The setTag() method takes an
        argument of type Object, and getTag() returns an Object.
        */
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(listItemLayout, parent, false);
            viewHolder.item = convertView.findViewById(R.id.tvPlayer);
            convertView.setTag(viewHolder); // view lookup cache stored in tag
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.item.setText(player.getName());

        // Return the completed view to render on screen
        return convertView;
    }

    // The ViewHolder, only one item for simplicity and demonstration purposes,
    // you can put all the views inside a row of the list into this ViewHolder.
    private static class ViewHolder {
        TextView item;
    }
}