package com.example.raeven.guidance;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.raeven.guidance.R.id.toolbar;

public class DashboardActivityAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bar_admin);
        ListView listView = (ListView)findViewById(R.id.Listview_Students);
        String [] items = {"Raeven Bauto", "Lance Morales", "Iron Maturan", "Jeffrey Garrido"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.fragment_dashboard_admin, R.id.Listview_Students);
        Toolbar toolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_admin);
        navigationView.setNavigationItemSelectedListener(this);

        DashboardAdminFragment dashboardFragment = new DashboardAdminFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentHolder, dashboardFragment,
                dashboardFragment.getTag()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "I'm at Home", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_assessment) {
            Toast.makeText(this, "I'm at Assessment", Toast.LENGTH_SHORT).show();
            AssessmentFragment assessmentFragment = new AssessmentFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragmentHolder, assessmentFragment,
                    assessmentFragment.getTag()).commit();

        }

        else if (id == R.id.nav_councelors) {
            Toast.makeText(this, "I'm at Councelors Fragment", Toast.LENGTH_SHORT).show();
            CouncelorsFragment councelorsFragment = new CouncelorsFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragmentHolder, councelorsFragment,
                    councelorsFragment.getTag()).commit();

        }

        else if (id == R.id.nav_account) {
            Toast.makeText(this, "I'm at Account", Toast.LENGTH_SHORT).show();
            DashboardFragment dashboardFragment = new DashboardFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragmentHolder, dashboardFragment,
                    dashboardFragment.getTag()).commit();
        }

        else if (id == R.id.nav_logout) {
            Toast.makeText(this, "I'm at Logout", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void checkCredentials(){
//        if ..
//
//        else ..

//        Intent intent = new Intent(this, DashboardActivity.class);
//        startActivity(intent);

        Toast.makeText(this, "I'm at check ", Toast.LENGTH_SHORT).show();


    }


}