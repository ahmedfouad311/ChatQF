package com.example.chatqf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chatqf.Fragment.FragmentAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity_Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__chat);

        final FloatingActionButton floatingActionButton;
        floatingActionButton = findViewById(R.id.floatingActionButton);

        final int arr [] = new int[]{R.drawable.ic_chat_selec,R.drawable.ic_status_selec,R.drawable.ic_calls_selec};
        final int arr2 [] = new int[]{R.drawable.ic_chat,R.drawable.ic_status,R.drawable.ic_calls};
        final int arr3 [] = new int[]{R.drawable.ic_message,R.drawable.ic_camera,R.drawable.ic_call};

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setTitle("ChatQF");
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white)); // making the text ChatQF and the back button in white

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Chat").setIcon(R.drawable.ic_chat_selec));
        tabLayout.addTab(tabLayout.newTab().setText("Status").setIcon(R.drawable.ic_status));
        tabLayout.addTab(tabLayout.newTab().setText("Call").setIcon(R.drawable.ic_calls));

        final ViewPager viewPager = findViewById(R.id.viewpager);

        FragmentAdapter adapter = new FragmentAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter); // linking the Fragment adapter with the viewpager

        // when click on the tabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.setIcon(arr[tab.getPosition()]);
                floatingActionButton.setImageDrawable(ContextCompat.getDrawable(MainActivity_Chat.this,arr3[tab.getPosition()]));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(arr2[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // when swap the viewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
            return true;
        }

        else if(id == R.id.setting) {
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
            return true;
        }

        else if(id == R.id.about) {
            Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
