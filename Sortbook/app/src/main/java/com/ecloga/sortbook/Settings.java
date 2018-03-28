package com.ecloga.sortbook;

import android.accounts.Account;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Settings extends android.support.v4.app.Fragment {

    public Settings() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);

        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/josefin_slab_regular.ttf");

        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        tv1.setTypeface(typeFace);

        TextView tv2 = (TextView) view.findViewById(R.id.tv2);
        tv2.setTypeface(typeFace);

        TextView tv3 = (TextView) view.findViewById(R.id.tv3);
        tv3.setTypeface(typeFace);

        TextView tv4 = (TextView) view.findViewById(R.id.tv4);
        tv4.setTypeface(typeFace);

        TextView tv5 = (TextView) view.findViewById(R.id.tv5);
        tv5.setTypeface(typeFace);

        RelativeLayout rl1 = (RelativeLayout) view.findViewById(R.id.rl1);
        rl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Notifications.class));
            }
        });

        RelativeLayout rl2 = (RelativeLayout) view.findViewById(R.id.rl2);
        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyAccount.class));
            }
        });

        RelativeLayout rl3 = (RelativeLayout) view.findViewById(R.id.rl3);
        rl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Report.class));
            }
        });

        RelativeLayout rl4 = (RelativeLayout) view.findViewById(R.id.rl4);
        rl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Help.class));
            }
        });

        RelativeLayout rl5 = (RelativeLayout) view.findViewById(R.id.rl5);
        rl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AboutUs.class));
            }
        });

        TextView tvSpread = (TextView) view.findViewById(R.id.tvSpread);
        tvSpread.setTypeface(typeFace);

        ImageView ivSpread = (ImageView) view.findViewById(R.id.ivSpread);
        ivSpread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getContext(), v);

                /*
                Do the log out stuff
                 */
            }
        });

        return view;
    }
}
