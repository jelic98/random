package com.ecloga.sortbook;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;
import com.kennyc.bottomsheet.BottomSheet;
import com.kennyc.bottomsheet.BottomSheetListener;

public class RecyclerViewRecyclerAdapter
        extends RecyclerView.Adapter<RecyclerViewRecyclerAdapter.ViewHolder> {

    private Context context;
    private String title, description, favourite, rating, group, date, reminder;

    public RecyclerViewRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();

        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String taskDetails = "";

        switch(Parameters.intentFrom) {
            case "home":
                taskDetails = Parameters.taskDetails.get(position);
                break;
            case "favourites":
                taskDetails = Parameters.favDetails.get(position);
                break;
            case "group1":
                taskDetails = Parameters.group1Details.get(position);
                break;
            case "group2":
                taskDetails = Parameters.group2Details.get(position);
                break;
            case "group3":
                taskDetails = Parameters.group3Details.get(position);
                break;
            case "group4":
                taskDetails = Parameters.group4Details.get(position);
                break;
            case "group5":
                taskDetails = Parameters.group5Details.get(position);
                break;
            case "group6":
                taskDetails = Parameters.group6Details.get(position);
                break;
        }

        title = taskDetails.substring(0, taskDetails.indexOf("~1~"));
        holder.tvTitle.setText(title);

        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~1~") + 3), "");
        description = taskDetails.substring(0, taskDetails.indexOf("~2~"));
        holder.tvDescription.setText(description);

        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~2~") + 3), "");
        favourite = taskDetails.substring(0, taskDetails.indexOf("~3~"));

        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~3~") + 3), "");
        rating = taskDetails.substring(0, taskDetails.indexOf("~4~"));

        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~4~") + 3), "");
        group = taskDetails.substring(0, taskDetails.indexOf("~5~"));

        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~5~") + 3), "");
        date = taskDetails.substring(0, taskDetails.indexOf("~6~"));

        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~6~") + 3), "");
        reminder = taskDetails.substring(0, taskDetails.indexOf("~7~"));

        if(favourite.equals("true")) {
            holder.fav.setImageResource(R.drawable.favourites_stroke);
        }else if(favourite.equals("false")) {
            holder.fav.setImageResource(R.color.transparent);
        }

        int colorId1;
        int colorId2;

        switch(group) {
            case "1":
                colorId1 = R.color.group_red;
                colorId2 = R.color.group_red_dark;
                break;
            case "2":
                colorId1 = R.color.group_green;
                colorId2 = R.color.group_green_dark;
                break;
            case "3":
                colorId1 = R.color.group_blue;
                colorId2 = R.color.group_blue_dark;
                break;
            case "4":
                colorId1 = R.color.group_orange;
                colorId2 = R.color.group_orange_dark;
                break;
            case "5":
                colorId1 = R.color.group_pink;
                colorId2 = R.color.group_pink_dark;
                break;
            case "6":
                colorId1 = R.color.group_dark;
                colorId2 = R.color.group_dark_dark;
                break;
            default:
                colorId1 = R.color.group_dark;
                colorId2 = R.color.group_dark_dark;
                break;
        }

        holder.itemView.setBackgroundColor(context.getResources().getColor(colorId1));
        holder.expandableLayout.setBackgroundColor(context.getResources().getColor(colorId2));
        holder.expandableLayout.setInterpolator(Utils.createInterpolator(Utils.FAST_OUT_SLOW_IN_INTERPOLATOR));

        holder.expandableLayout.setListener(new ExpandableLayoutListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }

            @Override
            public void onOpened() {
            }

            @Override
            public void onClosed() {
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(holder.expandableLayout);

                Animations.RecyclerItemClickAnimation(context, v);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                Animations.RecyclerItemHoldFirstAnimation(context, v);

                new BottomSheet.Builder(context, R.menu.task_menu)
                        .setBackgroundColor(context.getResources().getColor(R.color.bottom_sheet))
                        .setListener(new BottomSheetListener() {
                            @Override
                            public void onSheetShown() {

                            }

                            @Override
                            public void onSheetItemSelected(MenuItem menuItem) {
                                String taskDetails = "";

                                switch(Parameters.intentFrom) {
                                    case "home":
                                        taskDetails = Parameters.taskDetails.get(holder.getLayoutPosition());
                                        break;
                                    case "favourites":
                                        taskDetails = Parameters.favDetails.get(holder.getLayoutPosition());
                                        break;
                                    case "group1":
                                        taskDetails = Parameters.group1Details.get(holder.getLayoutPosition());
                                        break;
                                    case "group2":
                                        taskDetails = Parameters.group2Details.get(holder.getLayoutPosition());
                                        break;
                                    case "group3":
                                        taskDetails = Parameters.group3Details.get(holder.getLayoutPosition());
                                        break;
                                    case "group4":
                                        taskDetails = Parameters.group4Details.get(holder.getLayoutPosition());
                                        break;
                                    case "group5":
                                        taskDetails = Parameters.group5Details.get(holder.getLayoutPosition());
                                        break;
                                    case "group6":
                                        taskDetails = Parameters.group6Details.get(holder.getLayoutPosition());
                                        break;
                                }

                                Intent intent;

                                switch (menuItem.getItemId()) {
                                    case R.id.menu_edit:
                                        intent = new Intent(context, Edit.class);
                                        intent.putExtra("activator", "edit");
                                        intent.putExtra("details", taskDetails);
                                        context.startActivity(intent);

                                        break;
                                    case R.id.menu_archive:
                                        UpdateTasks.removeTask(position);

                                        if(favourite.equals("true")) {
                                            UpdateTasks.removeFavTask(position);
                                        }

                                        Snackbars.showDoneSnackbar(context);
                                        Animations.RecyclerItemArchiveAnimation(context, v);
                                        break;
                                    case R.id.menu_favourite:
                                        if(taskDetails.contains("true")) {
                                            Snackbars.showRemoveFromFavouritesSnackbar(context);
                                            taskDetails = taskDetails.replace("true", "false");
                                        }else {
                                            Snackbars.showAddToFavouritesSnackbar(context);
                                            taskDetails = taskDetails.replace("false", "true");
                                        }

                                        switch(Parameters.intentFrom) {
                                            case "home":
                                                Parameters.taskDetails.set(position, taskDetails);
                                                break;
                                            case "favourites":
                                                Parameters.favDetails.set(position, taskDetails);
                                                break;
                                            case "group1":
                                                Parameters.group1Details.set(position, taskDetails);
                                                break;
                                            case "group2":
                                                Parameters.group2Details.set(position, taskDetails);
                                                break;
                                            case "group3":
                                                Parameters.group3Details.set(position, taskDetails);
                                                break;
                                            case "group4":
                                                Parameters.group4Details.set(position, taskDetails);
                                                break;
                                            case "group5":
                                                Parameters.group5Details.set(position, taskDetails);
                                                break;
                                            case "group6":
                                                Parameters.group6Details.set(position, taskDetails);
                                                break;
                                        }

                                        //FIX: favourite animation not showing
                                        Animations.RecyclerItemFavouriteAnimation(context, v);
                                        break;
                                    case R.id.menu_group:
                                        intent = new Intent(context, ChangeGroup.class);
                                        intent.putExtra("activator", "menu");
                                        context.startActivity(intent);

                                        break;
                                    case R.id.menu_share:
                                        break;
                                    case R.id.menu_details:
                                        String sFavourite = "";
                                        String sGroup = "";

                                        if(favourite.equals("true")) {
                                            sFavourite = "Yes";
                                        }else if(favourite.equals("false")) {
                                            sFavourite = "No";
                                        }

                                        sGroup = Preferences.getDefaults("group_" + group + "_name", context);

                                        intent = new Intent(context, TaskDetails.class);
                                        intent.putExtra("title", title);
                                        intent.putExtra("date", date);
                                        intent.putExtra("group", sGroup);
                                        intent.putExtra("favourite", sFavourite);
                                        intent.putExtra("reminder", reminder);
                                        context.startActivity(intent);

                                        break;
                                }

                                Animations.RecyclerItemHoldSecondAnimation(context, v);
                            }

                            @Override
                            public void onSheetDismissed() {
                                Animations.RecyclerItemHoldSecondAnimation(context, v);
                            }
                        })
                        .show();

                return false;
            }
        });
    }

    private void onClickButton(final ExpandableLayout expandableLayout) {
        expandableLayout.toggle();
    }

    @Override
    public int getItemCount() {
        switch(Parameters.intentFrom) {
            case "home":
                return Parameters.taskUndone;
            case "favourites":
                return Parameters.taskFavourites;
            case "group1":
                return Parameters.taskGroup1;
            case "group2":
                return Parameters.taskGroup2;
            case "group3":
                return Parameters.taskGroup3;
            case "group4":
                return Parameters.taskGroup4;
            case "group5":
                return Parameters.taskGroup5;
            case "group6":
                return Parameters.taskGroup6;
            default:
                return Parameters.taskUndone;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvDescription;
        public ImageView fav;
        public ExpandableRelativeLayout expandableLayout;

        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/josefin_slab_regular.ttf");

        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvTitle.setTypeface(typeFace);

            tvDescription = (TextView) v.findViewById(R.id.tvDescription);
            tvDescription.setTypeface(typeFace);

            fav = (ImageView) v.findViewById(R.id.indicator);

            expandableLayout = (ExpandableRelativeLayout) v.findViewById(R.id.expandableLayout);
        }
    }
}
