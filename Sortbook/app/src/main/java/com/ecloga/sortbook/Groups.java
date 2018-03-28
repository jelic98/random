package com.ecloga.sortbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kennyc.bottomsheet.BottomSheet;
import com.kennyc.bottomsheet.BottomSheetListener;

public class Groups
        extends android.support.v4.app.Fragment
        implements View.OnClickListener, View.OnLongClickListener {

    public Groups() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.groups, container, false);

        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/josefin_slab_regular.ttf");

        LinearLayout group_1 = (LinearLayout) view.findViewById(R.id.group_1);
        group_1.setOnClickListener(this);
        group_1.setOnLongClickListener(this);

        LinearLayout group_2 = (LinearLayout) view.findViewById(R.id.group_2);
        group_2.setOnClickListener(this);
        group_2.setOnLongClickListener(this);

        LinearLayout group_3 = (LinearLayout) view.findViewById(R.id.group_3);
        group_3.setOnClickListener(this);
        group_3.setOnLongClickListener(this);

        LinearLayout group_4 = (LinearLayout) view.findViewById(R.id.group_4);
        group_4.setOnClickListener(this);
        group_4.setOnLongClickListener(this);

        LinearLayout group_5 = (LinearLayout) view.findViewById(R.id.group_5);
        group_5.setOnClickListener(this);
        group_5.setOnLongClickListener(this);

        LinearLayout group_6 = (LinearLayout) view.findViewById(R.id.group_6);
        group_6.setOnClickListener(this);
        group_6.setOnLongClickListener(this);

        TextView group_1_name = (TextView) view.findViewById(R.id.group_1_name);
        group_1_name.setTypeface(typeFace);
        group_1_name.setText(Preferences.getDefaults("group_1_name", getActivity().getApplicationContext()));

        TextView group_2_name = (TextView) view.findViewById(R.id.group_2_name);
        group_2_name.setTypeface(typeFace);
        group_2_name.setText(Preferences.getDefaults("group_2_name", getActivity().getApplicationContext()));

        TextView group_3_name = (TextView) view.findViewById(R.id.group_3_name);
        group_3_name.setTypeface(typeFace);
        group_3_name.setText(Preferences.getDefaults("group_3_name", getActivity().getApplicationContext()));

        TextView group_4_name = (TextView) view.findViewById(R.id.group_4_name);
        group_4_name.setTypeface(typeFace);
        group_4_name.setText(Preferences.getDefaults("group_4_name", getActivity().getApplicationContext()));

        TextView group_5_name = (TextView) view.findViewById(R.id.group_5_name);
        group_5_name.setTypeface(typeFace);
        group_5_name.setText(Preferences.getDefaults("group_5_name", getActivity().getApplicationContext()));

        TextView group_6_name = (TextView) view.findViewById(R.id.group_6_name);
        group_6_name.setTypeface(typeFace);
        group_6_name.setText(Preferences.getDefaults("group_6_name", getActivity().getApplicationContext()));

        return view;
    }

    @Override
    public void onClick(View v) {
        Animations.RecyclerItemClickAnimation(getActivity().getApplicationContext(), v);

        switch(v.getId()) {
            case R.id.group_1:
                Parameters.intentFrom = "group1";
                break;
            case R.id.group_2:
                Parameters.intentFrom = "group2";
                break;
            case R.id.group_3:
                Parameters.intentFrom = "group3";
                break;
            case R.id.group_4:
                Parameters.intentFrom = "group4";
                break;
            case R.id.group_5:
                Parameters.intentFrom = "group5";
                break;
            case R.id.group_6:
                Parameters.intentFrom = "group6";
                break;
        }

        startActivity(new Intent(getActivity(), Group.class));
    }

    @Override
    public boolean onLongClick(final View v) {
        Animations.RecyclerItemHoldFirstAnimation(getActivity(), v);

        new BottomSheet.Builder(getActivity(), R.menu.group_menu)
                .setBackgroundColor(getResources().getColor(R.color.bottom_sheet))
                .setListener(new BottomSheetListener() {
                    @Override
                    public void onSheetShown() {

                    }

                    @Override
                    public void onSheetItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_rename:
                                Intent intent = new Intent(getActivity(), RenameGroup.class);
                                intent.putExtra("groupId", v.getId());
                                startActivity(intent);
                                break;
                            case R.id.menu_share:
                                break;
                            case R.id.menu_details:
                                startActivity(new Intent(getActivity(), GroupDetails.class));
                                break;
                        }

                        Animations.RecyclerItemHoldSecondAnimation(getActivity(), v);
                    }

                    @Override
                    public void onSheetDismissed() {
                        Animations.RecyclerItemHoldSecondAnimation(getActivity(), v);
                    }
                })
                .show();

        return false;
    }
}
