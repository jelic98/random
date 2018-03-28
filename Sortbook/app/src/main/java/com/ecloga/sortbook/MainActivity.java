package com.ecloga.sortbook;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
    DEBUG OVER WI-FI <<SETUP>>
    cd C:\Users\Lazar\AppData\Local\Android\sdk\platform-tools
    adb devices
    adb usb
    adb tcpip 5555
    adb connect 192.168.0.X
    adb devices
*/

public class MainActivity extends FragmentActivity {

    private SlidingTabLayout mTabs;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setBackgroundColor(getResources().getColor(R.color.transparent_10));
        mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
        mTabs.setCustomTabView(R.layout.custom_tab_view, 0);
        mTabs.setDistributeEvenly(true);

        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accent);
            }
        });

        mTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int[] icons = new int[]{
                    R.drawable.home_tab,
                    R.drawable.favourites_tab,
                    R.drawable.groups_tab,
                    R.drawable.settings_tab
            };

            public void changeTabIconColor(int position) {
                Drawable image = getResources().getDrawable(icons[position]);
                assert image != null;
                image.setColorFilter(getResources().getColor(R.color.accent), PorterDuff.Mode.MULTIPLY);
            }

            public void resetTabIconColor() {
                for(int i = 0; i < 4; i++) {
                    Drawable image = getResources().getDrawable(icons[i]);
                    assert image != null;
                    image.setColorFilter(getResources().getColor(R.color.clouds), PorterDuff.Mode.MULTIPLY);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                resetTabIconColor();
                changeTabIconColor(position);
            }

            @Override
            public void onPageSelected(int position) {
                resetTabIconColor();
                changeTabIconColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabs.setViewPager(mPager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        
        int[] icons = new int[] {
                R.drawable.home_tab,
                R.drawable.favourites_tab,
                R.drawable.groups_tab,
                R.drawable.settings_tab
        };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            if(position == 0) {
                fragment = new Home();
            }else if(position == 1) {
                fragment = new Favourites();
            }else if(position == 2) {
                fragment = new Groups();
            }else if(position == 3) {
                fragment = new Settings();
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Drawable image = getResources().getDrawable(icons[position]);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());

            SpannableString sb = new SpannableString(" ");
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            return sb;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public static class MyFragment extends Fragment {
        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();

            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);

            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.home, container, false);
        }
    }
}
