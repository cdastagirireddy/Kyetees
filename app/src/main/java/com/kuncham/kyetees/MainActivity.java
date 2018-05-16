package com.kuncham.kyetees;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment mHomeFragment;
    private MensFragment mMensFragment;
    private WomensFragment mWomensFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BottemNavigation Framework
        mMainFrame = (FrameLayout)findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView)findViewById(R.id.main_nav);

        mHomeFragment = new HomeFragment();
        mMensFragment = new MensFragment();
        mWomensFragment = new WomensFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(mHomeFragment);
                        return true;
                    case R.id.mens :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(mMensFragment);

                        return true;

                    case R.id.womens:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(mWomensFragment);

                        return true;

                    default:
                        return false;
                }
            }
        });


        //DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
