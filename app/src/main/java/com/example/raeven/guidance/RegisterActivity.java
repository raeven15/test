package com.example.raeven.guidance;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private UserDatabaseHelper _dbHelper = null;
    private SQLiteDatabase _database = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try
        {
            //Creates the db upon
            // instantiation (executes on create)
            _dbHelper = new UserDatabaseHelper(getApplicationContext());
            _database = _dbHelper.getWritableDatabase();
            Toast.makeText(getApplicationContext(), "You good bro", Toast.LENGTH_SHORT).show();

        }

        catch(Exception ex)
        {
            Toast.makeText(getApplicationContext(), "Something went wsssssrong.", Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
            startActivity(new Intent(this, MainActivity.class)); // go back to main screen
        }

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public void register (View view) {
        EditText nameView = (EditText) findViewById(R.id.register_name);
        EditText studNumberView = (EditText) findViewById(R.id.register_studNumber);
        EditText passwordView = (EditText) findViewById(R.id.register_password);
        EditText passwordView2 = (EditText) findViewById(R.id.register_password2);
        EditText addressView = (EditText) findViewById(R.id.register_address);
        EditText contactNumberView = (EditText) findViewById(R.id.register_contactNumber);
        EditText courseView = (EditText) findViewById(R.id.register_Course);


        String password = passwordView.getText().toString();
        String password2 = passwordView2.getText().toString();

            try {
                Cursor cursor = _database.query(UserContract.UserDetails.TABLE_NAME,
                        new String[]{UserContract.UserDetails.STUDNUMBER_COLUMN},
                        UserContract.UserDetails.STUDNUMBER_COLUMN + " = ?",
                        new String[]{studNumberView.getText().toString()},
                        null,
                        null,
                        null);

                if (cursor.getCount() <= 0) {
                    if (_database != null) {
                        if (!password.equals(password2)) {
                            Toast.makeText(getApplicationContext(),
                                    "Password don't match",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                        ContentValues values = new ContentValues();
                        values.put(UserContract.UserDetails.NAME_COLUMN, nameView.getText().toString());
                        values.put(UserContract.UserDetails.STUDNUMBER_COLUMN, Integer.parseInt(studNumberView.getText().toString().trim()));
                        values.put(UserContract.UserDetails.PASSWORD_COLUMN, passwordView.getText().toString());
                        values.put(UserContract.UserDetails.CONTACTNUMBER_COLUMN, contactNumberView.getText().toString());
                        values.put(UserContract.UserDetails.COURSE_COLUMN, courseView.getText().toString());

                        RadioButton radioStudent = (RadioButton) findViewById(R.id.radioButton_Student);

                        if (radioStudent.isChecked()) {
                            values.put(UserContract.UserDetails.USERTYPE_COLUMN, 0);
                        } else {
                            values.put(UserContract.UserDetails.USERTYPE_COLUMN, 1);
                        }

                        _database.insert(UserContract.UserDetails.TABLE_NAME, null, values);
                        Toast.makeText(getApplicationContext(),
                                "User " + nameView.getText().toString() + " created. ",
                                Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "User already exists.",
                            Toast.LENGTH_SHORT).show();
                }
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),
                        "User creation failed.",
                        Toast.LENGTH_SHORT).show();

                ex.printStackTrace();
            }
        }
}


