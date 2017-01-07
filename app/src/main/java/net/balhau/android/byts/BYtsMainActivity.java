package net.balhau.android.byts;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import net.balhau.android.byts.adaptors.PagerAdaptor;

import java.util.Map;

public class BYtsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byts_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout=createTabLayout();
        ViewPager viewPager = createViewePager(tabLayout);
        setTabLayoutListener(tabLayout,viewPager);
    }

    private FloatingActionButton createFloatingActionButton(){
         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fragment);
         fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go fuck yourself", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
         });

        return fab;
    }

    private void setTabLayoutListener(TabLayout tabLayout, final ViewPager pager){
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private TabLayout createTabLayout(){
        String[] tabs = getResources().getStringArray(R.array.menu_tabs);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for(String tab : tabs){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        return tabLayout;
    }

    private ViewPager createViewePager(TabLayout tabLayout){
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        PagerAdaptor pagerAdaptor = new PagerAdaptor(getSupportFragmentManager());
        pager.setAdapter(pagerAdaptor);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_byts_main, menu);
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
}
