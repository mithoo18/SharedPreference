package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        age =  findViewById(R.id.edit2);
    }

    // Fetch the stored data in onResume()
    // Because this is what will be called
    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        String s1 = sh.getString("name","");
        int a = sh.getInt("age",0);
        name.setText(s1);
        age.setText(String.valueOf(a));
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("name",name.getText().toString());
        myEdit.putInt("age",Integer.parseInt(age.getText().toString()));
        myEdit.apply();
    }
}
