package com.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class DropDown extends AppCompatActivity {

    String[] items = {"Important", "Not Important", "Maybe?", "N-word"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down);
        autoCompleteTextView = findViewById(R.id.auto_complete);

        // Use a standard layout for dropdown items
        adapterItems = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Show a toast with the selected item
                Toast.makeText(DropDown.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
