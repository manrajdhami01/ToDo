package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = (findViewById(R.id.etItem));
        btnsave = (findViewById(R.id.btnsave));

        getSupportActionBar().setTitle("Edit Item");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#527A54"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        //When the user is done editing, they click the save button
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent which will contain the results
                Intent intent = new Intent();

                //pass the data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set the result of the intent
                setResult(RESULT_OK, intent);

                //finish activity, close the screen and go back
                finish();
            }
        });
    }
}