package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Main activity
 */
public class MainActivity extends AppCompatActivity {

    // Declare the variables so that you will be able to reference it later.
    /**
     * List view for showing cities
     */
    ListView listViewCity;
    /**
     * editText for adding new city
     */
    EditText editTextNewName;
    /**
     * container of editText and button
     */
    LinearLayout llNameField;
    /**
     * adapter for listview
     */
    ArrayAdapter<String> cityAdapter;
    /**
     * contains all city names
     */
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llNameField = findViewById(R.id.field_nameEntry);
        editTextNewName = findViewById(R.id.editText_name);
        listViewCity = findViewById(R.id.city_list);

        dataList = new ArrayList<>();
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        listViewCity.setAdapter(cityAdapter);

        listViewCity.setOnItemClickListener((parent, view, position, id) -> {
            String city = cityAdapter.getItem(position);
            Intent intent = new Intent(this,ShowActivity.class);
            intent.putExtra("city",city);
            startActivity(intent);
        });

        final Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(v -> llNameField.setVisibility(View.VISIBLE));

        final Button confirmButton = findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(v -> {
            String cityName = editTextNewName.getText().toString();
            cityAdapter.add(cityName);
            editTextNewName.getText().clear();
            llNameField.setVisibility(View.INVISIBLE);
        });

        final Button deleteButton = findViewById(R.id.button_clear);
        deleteButton.setOnClickListener(v -> cityAdapter.clear());

    }

}
