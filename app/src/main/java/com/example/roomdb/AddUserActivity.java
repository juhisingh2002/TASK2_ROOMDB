package com.example.roomdb;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AddUserActivity extends AppCompatActivity {

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPhoneNumber;
    private EditText editTextAddress;
    private EditText editTextCountry;
    private Button buttonSave;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // Initialize EditTexts and Button
        editTextFirstName = findViewById(R.id.firstnameee);
        editTextLastName = findViewById(R.id.Lastname);
        editTextEmail = findViewById(R.id.useremail);
        editTextPhoneNumber = findViewById(R.id.userphoneno);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextCountry = findViewById(R.id.editTextCountry);
        buttonSave = findViewById(R.id.buttonSave);

        // Set a click listener for the Save button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to save the user data to the database
                saveUserData();
                Intent intent = new Intent(AddUserActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(AddUserActivity.this, "Data inserted into room db", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveUserData() {
        // Retrieve user input from EditTexts

        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String country = editTextCountry.getText().toString().trim();

        // TODO: Add validation if needed

        // Create a new User object with the input data
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setAddress(address);
        newUser.setCountry(country);
        userViewModel.insert(newUser);
        // TODO: Save the user to the Room database using your ViewModel or DatabaseHelper

        // For simplicity, you can print the user details for now
        System.out.println("User Details: " + newUser.toString());
    }
}
