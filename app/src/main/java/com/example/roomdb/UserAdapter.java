package com.example.roomdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Adapter class for the RecyclerView
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList = new ArrayList<>();

    // onCreateViewHolder is called when the RecyclerView needs a new ViewHolder
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the list item layout and create a new UserViewHolder
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_user, parent, false);
        return new UserViewHolder(itemView);
    }

    // onBindViewHolder is called to bind data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // Get the current user from the list
        User currentUser = userList.get(position);

        // Set the user details to the TextViews in the ViewHolder
        holder.textViewName.setText("Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
        holder.textViewEmail.setText("Email: " + currentUser.getEmail());
        holder.textViewPhoneNumber.setText("Phone: " + currentUser.getPhoneNumber());
        holder.textViewAddress.setText("Address: " + currentUser.getAddress());
        holder.textViewCountry.setText("Country:"+ currentUser.getCountry());
    }

    // getItemCount returns the number of items in the list
    @Override
    public int getItemCount() {
        return userList.size();
    }

    // setUserList is a method to update the data in the adapter
    public void setUserList(List<User> userList) {
        this.userList = userList;
        // Notify the adapter that the data set has changed
        notifyDataSetChanged();
    }

    // UserViewHolder is a static inner class that represents each item in the RecyclerView
    static class UserViewHolder extends RecyclerView.ViewHolder {
        // TextViews to display user details
        TextView textViewName;
        TextView textViewEmail;
        TextView textViewPhoneNumber; // Additional TextView for phone number
        TextView textViewAddress;    // Additional TextView for address
        TextView textViewCountry;

        // Constructor for UserViewHolder
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize TextViews using their IDs from the list item layout
            textViewName = itemView.findViewById(R.id.name);
            textViewEmail = itemView.findViewById(R.id.email);
            textViewPhoneNumber = itemView.findViewById(R.id.phoneno);
            textViewAddress = itemView.findViewById(R.id.address);
            textViewCountry = itemView.findViewById(R.id.country);
        }
    }
}
