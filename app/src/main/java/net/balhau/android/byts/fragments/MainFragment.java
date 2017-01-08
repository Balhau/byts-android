package net.balhau.android.byts.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.balhau.android.byts.R;
import net.balhau.android.byts.adaptors.PagerAdaptor;

/**
 * Created by vitorfernandes on 1/7/17.
 */

public class MainFragment extends Fragment {
    public MainFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_byts_main,container,false);
        TabLayout tableLayout = createTabLayout(viewRoot);
        ViewPager viewPager = createViewPager(viewRoot,tableLayout);
        setTabLayoutListener(tableLayout,viewPager);
        return viewRoot;
    }

    private TabLayout createTabLayout(View view){
        String[] tabs = getResources().getStringArray(R.array.menu_tabs);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        for(String tab : tabs){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        return tabLayout;
    }

    private ViewPager createViewPager(View view,TabLayout tabLayout){
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        PagerAdaptor pagerAdaptor = new PagerAdaptor(getFragmentManager());
        pager.setAdapter(pagerAdaptor);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return pager;
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
}
