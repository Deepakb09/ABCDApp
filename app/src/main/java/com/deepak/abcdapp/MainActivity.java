package com.deepak.abcdapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager1, viewPager2;
    MyAdapter myAdapter1;
    MyAdapter2 myAdapter2;

    String[] arr2 = {"APPLE","BALL","CAR","DOG","ELEPHANT"};
    String alpha;
    String imgnm;
    TextView textView3;

    public class MyAdapter extends FragmentPagerAdapter{
        String[] arr1 = {"One","Two","Three","Four","Five"};
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment1 frag1 = new Fragment1();
            Bundle b = new Bundle();
            b.putInt("imgposition", position);
            frag1.setArguments(b);
            return frag1;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arr1[position];
        }
    }

    public class MyAdapter2 extends FragmentPagerAdapter{
        //String[] arr2 = {"APPLE","BALL","CAR","DOG","ELEPHANT"};
        public MyAdapter2(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment2 frag2 = new Fragment2();
            Bundle b = new Bundle();
            b.putInt("imageposition", position);
            frag2.setArguments(b);
            return frag2;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arr2[position];
        }
    }


    public void getAlphaFromFrag(String ch){
        alpha = ch;
    }

    public void setAlphaImageFromFrag(String ch){
        imgnm = ch;
        //textView3.setText(imgnm);
        //Toast.makeText(MainActivity.this, ch, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);
        TabLayout tabLayout1 = (TabLayout) findViewById(R.id.myTab);
        myAdapter1 = new MyAdapter(getSupportFragmentManager());
        viewPager1.setAdapter(myAdapter1);
        tabLayout1.setupWithViewPager(viewPager1);
        textView3 = (TextView) findViewById(R.id.textView3);

        viewPager2 = (ViewPager) findViewById(R.id.viewPager2);
        TabLayout tabLayout2 = (TabLayout) findViewById(R.id.myTab2);
        myAdapter2 = new MyAdapter2(getSupportFragmentManager());
        viewPager2.setAdapter(myAdapter2);
        tabLayout2.setupWithViewPager(viewPager2);

        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int i = viewPager2.getCurrentItem();
                textView3.setText(arr2[i]);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
