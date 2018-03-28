package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.melnykov.fab.FloatingActionButton;

public class Group extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);

        overridePendingTransition(R.anim.activity_open, R.anim.activity_close);

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        TextView tvNoTasks = (TextView) findViewById(R.id.tvNoTasks);
        tvNoTasks.setTypeface(typeFace);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Group.this, Edit.class);
                intent.putExtra("activator", "group");
                startActivity(intent);
            }
        });

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewRecyclerAdapter adapter = new RecyclerViewRecyclerAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == 8) {
                    Parameters.taskDetails.remove(viewHolder.getAdapterPosition());
                    adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                    Snackbars.showDoneSnackbar(Group.this);
                }else if(direction == 4) {
                    String taskDetails = Parameters.taskDetails.get(viewHolder.getAdapterPosition());

                    if(taskDetails.contains("false")) {
                        taskDetails = taskDetails.replace("false", "true");
                        Snackbars.showAddToFavouritesSnackbar(Group.this);
                    }else if(taskDetails.contains("true")) {
                        taskDetails = taskDetails.replace("true", "false");
                        Snackbars.showRemoveFromFavouritesSnackbar(Group.this);
                    }

                    Parameters.taskDetails.set(viewHolder.getAdapterPosition(), taskDetails);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        swipeToDismissTouchHelper.attachToRecyclerView(recyclerView);

        /*
            CHECK IF GROUP HAS MEMBERS
         */
        if(Parameters.taskUndone == 0) {
            recyclerView.setVisibility(View.INVISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
        }else {
            linearLayout.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}
