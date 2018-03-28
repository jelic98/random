package com.ecloga.sortbook;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.aakira.expandablelayout.ExpandableLayout;

public class Animations {
    public static void RegularClick(Context context, View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.recycler_item_click);
        v.startAnimation(anim);
    }

    public static void RecyclerItemClickAnimation(Context context, View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.recycler_item_click);
        v.startAnimation(anim);
    }

    public static void RecyclerItemHoldFirstAnimation(Context context, View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.recycler_item_hold_first);
        v.startAnimation(anim);
    }

    public static void RecyclerItemHoldSecondAnimation(Context context, View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.recycler_item_hold_second);
        v.startAnimation(anim);
    }

    public static void RecyclerItemArchiveAnimation(Context context, View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.recycler_item_archive);
        v.startAnimation(anim);
    }

    public static void RecyclerItemFavouriteAnimation(Context context, View v) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.recycler_item_favourite);
        v.startAnimation(anim);
    }
}
