package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Context;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.listeners.ActionClickListener;

public class Snackbars {

    public static void showDoneSnackbar(Context context) {
        Activity activity = (Activity) context;

        SnackbarManager.show(
                Snackbar.with(context)
                        .text("Task marked as done")
                        .actionLabel("Undo")
                        .actionColorResource(R.color.primary)
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {
                                /*
                                   Handle UNDO action
                                    */
                            }
                        })
                , activity);
    }

    public static void showAddToFavouritesSnackbar(Context context) {
        Activity activity = (Activity) context;

        SnackbarManager.show(
                Snackbar.with(context)
                        .text("Task added to favourites")
                        .actionLabel("Undo")
                        .actionColorResource(R.color.primary)
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {
                                /*
                                   Handle UNDO action
                                    */
                            }
                        })
                , activity);
    }

    public static void showRemoveFromFavouritesSnackbar(Context context) {
        Activity activity = (Activity) context;

        SnackbarManager.show(
                Snackbar.with(context)
                        .text("Task removed from favourites")
                        .actionLabel("Undo")
                        .actionColorResource(R.color.primary)
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(Snackbar snackbar) {
                                /*
                                   Handle UNDO action
                                    */
                            }
                        })
                , activity);
    }
}
