
package com.example.raeven.guidance;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private UserDatabaseHelper _dbHelper = null;
    private SQLiteDatabase _database = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

    public void councilorCheck(View view) {

        EditText studNumberHolder = (EditText)findViewById(R.id.editText_studentNumber);
        int studNumber = Integer.parseInt(studNumberHolder.getText().toString().trim());

        Cursor cursor = _database.rawQuery("SELECT * FROM " +
                UserContract.UserDetails.TABLE_NAME + " WHERE " +
                UserContract.UserDetails.STUDNUMBER_COLUMN + " = " +
                studNumber, null);

        if(cursor.getCount() > 0)
        {
            EditText passwordHolder = (EditText)findViewById(R.id.editText_password);
            String password = passwordHolder.getText().toString();

            cursor.moveToFirst();
            String passwordHold = cursor.getString(cursor.getColumnIndex(UserContract.UserDetails.PASSWORD_COLUMN));

            if (password.equals(passwordHold)){
                int userTypeHolder = cursor.getInt(cursor.getColumnIndex(UserContract.UserDetails.USERTYPE_COLUMN));

                Toast.makeText(getApplicationContext(), passwordHold + " " + password + " " +
                       userTypeHolder , Toast.LENGTH_SHORT).show();

                if (userTypeHolder == 0){
                    Intent intent = new Intent(this, DashboardActivity.class);
                    startActivity(intent);
                    //student
               }

                else if (userTypeHolder == 1){
                    Intent intent = new Intent(this, DashboardActivityAdmin.class);
                    startActivity(intent);
                    //Guidance
                }

                else
                    Toast.makeText(getApplicationContext(), "111 ", Toast.LENGTH_SHORT).show();

            }
            else
                Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerAccount (View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
