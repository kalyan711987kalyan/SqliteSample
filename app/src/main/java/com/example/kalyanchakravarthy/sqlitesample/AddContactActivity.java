package com.example.kalyanchakravarthy.sqlitesample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kalyanchakravarthy on 22/05/15.
 */
public class AddContactActivity extends Activity {


    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb;
    TextView name;
    TextView phone;
    TextView email;
    TextView street;
    TextView place;
    int id_To_Update = 0;

    protected void onCreate(Bundle savedinstance) {

        super.onCreate(savedinstance);
        setContentView(R.layout.addcontact);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextStreet);
        street = (TextView) findViewById(R.id.editTextEmail);
        place = (TextView) findViewById(R.id.editTextCity);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {


        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        return true;
    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");

            if (mydb.insertContact(name.getText().toString(), phone.getText().toString(), email.getText().toString(), street.getText().toString(), place.getText().toString())) {
                Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(getApplicationContext(), com.example.kalyanchakravarthy.sqlitesample.MainActivity.class);
            startActivity(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
