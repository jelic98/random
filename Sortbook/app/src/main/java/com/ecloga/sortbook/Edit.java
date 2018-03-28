package com.ecloga.sortbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.android.datetimepicker.date.DatePickerDialog;
import com.android.datetimepicker.time.RadialPickerLayout;
import com.android.datetimepicker.time.TimePickerDialog;
import com.gc.materialdesign.views.ButtonFlat;
import com.rengwuxian.materialedittext.MaterialEditText;
import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Edit extends FragmentActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private static final String TIME_PATTERN = "HH:mm";
    private Calendar calendar;
    private DateFormat dateFormat;
    private SimpleDateFormat timeFormat;
    private String activator, oldTaskDetails;

    String min, hour, day, month, year;

    int fav_counter, priority, iGroup;
    String date;
    String[] months = new String[] {
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        overridePendingTransition(R.anim.popup_open, R.anim.popup_close);

        setWindowSize();

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/josefin_slab_regular.ttf");

        calendar = Calendar.getInstance();
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        timeFormat = new SimpleDateFormat(TIME_PATTERN);

        MaterialEditText etTitle = (MaterialEditText) findViewById(R.id.etTtitle);
        MaterialEditText etDescription = (MaterialEditText) findViewById(R.id.etDescription);

        etTitle.setTypeface(typeFace);
        etDescription.setTypeface(typeFace);

        DiscreteSeekBar discreteSeekBar = (DiscreteSeekBar) findViewById(R.id.rating);
        discreteSeekBar.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i, boolean b) {
                priority = i;
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar discreteSeekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar) {

            }
        });

        final ImageView add_favourites = (ImageView) findViewById(R.id.add_favourites);
        add_favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                fav_counter++;

                if (fav_counter % 2 == 0) {
                    add_favourites.setImageResource(R.drawable.favourites_stroke);
                } else {
                    add_favourites.setImageResource(R.drawable.favourites);
                }
            }
        });

        ImageView choose_group = (ImageView) findViewById(R.id.choose_group);
        choose_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                Intent intent = new Intent(Edit.this, ChangeGroup.class);
                intent.putExtra("activator", "edit");
                startActivityForResult(intent, 1);
            }
        });

        switch(Parameters.intentFrom) {
            case "group1":
                choose_group.setImageResource(R.color.group_red);
                break;
            case "group2":
                choose_group.setImageResource(R.color.group_green);
                break;
            case "group3":
                choose_group.setImageResource(R.color.group_blue);
                break;
            case "group4":
                choose_group.setImageResource(R.color.group_orange);
                break;
            case "group5":
                choose_group.setImageResource(R.color.group_pink);
                break;
            case "group6":
                choose_group.setImageResource(R.color.group_dark);
                break;
        }

        ImageView ivCalendar = (ImageView) findViewById(R.id.calendar);
        ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);



                DatePickerDialog.newInstance(Edit.this, Integer.parseInt(year),
                        Integer.parseInt(month),
                        Integer.parseInt(day)).show(getFragmentManager(), "datePicker");
            }
        });

        ImageView add_reminder = (ImageView) findViewById(R.id.add_reminder);
        add_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animations.RegularClick(getApplicationContext(), v);

                TimePickerDialog.newInstance(Edit.this, Integer.parseInt(hour),
                        Integer.parseInt(min), true).show(getFragmentManager(), "timePicker");
            }
        });

        ButtonFlat btnSave = (ButtonFlat) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialEditText etTitle = (MaterialEditText) findViewById(R.id.etTtitle);
                MaterialEditText etDescription = (MaterialEditText) findViewById(R.id.etDescription);

                String favourite;

                if(fav_counter % 2 != 0) {
                    favourite = "true";
                }else {
                    favourite = "false";
                }

                String description = String.valueOf(etDescription.getText());

                if(description == null || description.isEmpty()) {
                    description = "No description";
                }

                String title = String.valueOf(etTitle.getText());

                boolean titleAlreadyExists = false;

                for(int i = 0; i < Parameters.taskUndone; i++) {
                    String taskDetails = String.valueOf(Parameters.taskDetails.get(i));
                    String currentTaskTitle = taskDetails.substring(0, taskDetails.indexOf("~1~"));

                    if(title.equals(currentTaskTitle)) {
                        titleAlreadyExists = true;
                    }
                }

                String rating = String.valueOf(priority);

                String reminderDate = dateFormat.format(calendar.getTime());
                reminderDate = reminderDate.replace(reminderDate.substring(3, reminderDate.indexOf(" ")), "");
                String reminderTime = timeFormat.format(calendar.getTime());
                String reminder = reminderDate + " @ " + reminderTime;

                String group;

                if(iGroup == 0) {
                    group = "6";
                }else {
                    group = String.valueOf(iGroup);
                }

                DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy @ HH:mm");
                Date mDate = new Date();
                String sDate = dateFormat.format(mDate);
                int month = Integer.parseInt(sDate.substring(0, sDate.indexOf(".")));
                sDate = sDate.substring(sDate.indexOf(".") + 1);
                String day = sDate.substring(0, sDate.indexOf("."));
                sDate = sDate.substring(sDate.indexOf(".") + 1);

                for(int i = 0; i < 12; i++) {
                    if(i == month) {
                        date = months[i-1] + " " + day + ", " + sDate;
                    }
                }

                if(title == null || title.isEmpty()) {
                    etTitle.setError("This field is required");
                }else {
                    if(etTitle.length() > 20) {
                        int delta = etTitle.length() - 20;
                        etTitle.setError("Remove " + delta + " characters");
                    }else if(etDescription.length() > 100) {
                        int delta = etDescription.length() - 100;
                        etDescription.setError("Remove " + delta + " characters");
                    }else {
                        String taskDetails = title + "~1~"
                                + description + "~2~"
                                + favourite + "~3~"
                                + rating + "~4~"
                                + group + "~5~"
                                + date + "~6~"
                                + reminder + "~7~";

                        if(activator.equals("home")) {
                            if (titleAlreadyExists) {
                                etTitle.setError("This title already exists");
                            }else {
                                UpdateTasks.addTask(taskDetails);

                                if(favourite.equals("true")) {
                                    UpdateTasks.addFavTask(taskDetails);
                                }

                                /*
                                    Check from what group is intent coming
                                    PLACE CODE BELOW OUTSIDE OF ACTIVATOR = HOME IF CODE BLOCK
                                 */
                                switch(group) {
                                    case "1":
                                        UpdateTasks.addGroup1Task(taskDetails);
                                        break;
                                    case "2":
                                        UpdateTasks.addGroup2Task(taskDetails);
                                        break;
                                    case "3":
                                        UpdateTasks.addGroup3Task(taskDetails);
                                        break;
                                    case "4":
                                        UpdateTasks.addGroup4Task(taskDetails);
                                        break;
                                    case "5":
                                        UpdateTasks.addGroup5Task(taskDetails);
                                        break;
                                    case "6":
                                        UpdateTasks.addGroup6Task(taskDetails);
                                        break;
                                }

                                Edit.this.finish();
                            }
                        }else if(activator.equals("edit")) {
                            Parameters.taskDetails.set(Parameters.taskDetails.indexOf(oldTaskDetails), taskDetails);

                            Edit.this.finish();
                        }else if(activator.equals("favourites")) {
                            if (titleAlreadyExists) {
                                etTitle.setError("This title already exists");
                            }else {
                                UpdateTasks.addTask(taskDetails);

                                if(favourite.equals("true")) {
                                    UpdateTasks.addFavTask(taskDetails);
                                }

                                Edit.this.finish();
                            }
                        }
                    }
                }
            }
        });

        ButtonFlat btnCancel = (ButtonFlat) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit.this.finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            activator = extras.getString("activator");

            if(activator != null && !activator.isEmpty()) {
                if(activator.equals("edit")) {
                    String taskDetails = extras.getString("details");
                    oldTaskDetails = taskDetails;

                    if(taskDetails != null && !taskDetails.isEmpty()) {
                        String title = taskDetails.substring(0, taskDetails.indexOf("~1~"));
                        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~1~") + 3), "");
                        String description = taskDetails.substring(0, taskDetails.indexOf("~2~"));
                        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~2~") + 3), "");
                        String favourite = taskDetails.substring(0, taskDetails.indexOf("~3~"));
                        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~3~") + 3), "");
                        String rating = taskDetails.substring(0, taskDetails.indexOf("~4~"));
                        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~4~") + 3), "");
                        String group = taskDetails.substring(0, taskDetails.indexOf("~5~"));
                        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~5~") + 3), "");
                        String date = taskDetails.substring(0, taskDetails.indexOf("~6~"));
                        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~6~") + 3), "");
                        String reminder = taskDetails.substring(0, taskDetails.indexOf("~7~"));

                        month = reminder.substring(0, reminder.indexOf(" "));
                        day = reminder.substring(reminder.indexOf(" ") + 1, reminder.indexOf(","));
                        reminder = reminder.replace(" ", "");
                        year = reminder.substring(reminder.indexOf(" ") + 1, reminder.indexOf("@") - 1);
                        reminder = reminder.replace(" @", "");
                        hour = reminder.substring(reminder.indexOf(" ") + 1, reminder.indexOf(":"));
                        min = reminder.substring(reminder.indexOf(":") + 1);

                        switch(month) {
                            case "Jan":
                                month = "1";
                                break;
                            case "Feb":
                                month = "2";
                                break;
                            case "Mar":
                                month = "3";
                                break;
                            case "April":
                                month = "4";
                                break;
                            case "May":
                                month = "5";
                                break;
                            case "Jun":
                                month = "6";
                                break;
                            case "Jul":
                                month = "7";
                                break;
                            case "Aug":
                                month = "8";
                                break;
                            case "Sep":
                                month = "9";
                                break;
                            case "Oct":
                                month = "10";
                                break;
                            case "Nov":
                                month = "11";
                                break;
                            case "Dec":
                                month = "12";
                                break;
                        }

                        etTitle.setText(title);
                        etDescription.setText(description);

                        int priority = Integer.parseInt(rating);
                        discreteSeekBar.setProgress(priority);

                        switch(group) {
                            case "1":
                                choose_group.setImageResource(R.color.group_red);
                                break;
                            case "2":
                                choose_group.setImageResource(R.color.group_green);
                                break;
                            case "3":
                                choose_group.setImageResource(R.color.group_blue);
                                break;
                            case "4":
                                choose_group.setImageResource(R.color.group_orange);
                                break;
                            case "5":
                                choose_group.setImageResource(R.color.group_pink);
                                break;
                            case "6":
                                choose_group.setImageResource(R.color.group_dark);
                                break;
                        }

                        if(favourite.equals("true")) {
                            add_favourites.setImageResource(R.drawable.favourites);
                        }else {
                            add_favourites.setImageResource(R.drawable.favourites_stroke);
                        }
                    }
                }else if(activator.equals("favourites")) {
                    add_favourites.setImageResource(R.drawable.favourites);
                }else {
                    hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
                    min = String.valueOf(calendar.get(Calendar.MINUTE));
                    year = String.valueOf(calendar.get(Calendar.YEAR));
                    month = String.valueOf(calendar.get(Calendar.MONTH));
                    day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

                    switch(month) {
                        case "Jan":
                            month = "1";
                            break;
                        case "Feb":
                            month = "2";
                            break;
                        case "Mar":
                            month = "3";
                            break;
                        case "April":
                            month = "4";
                            break;
                        case "May":
                            month = "5";
                            break;
                        case "Jun":
                            month = "6";
                            break;
                        case "Jul":
                            month = "7";
                            break;
                        case "Aug":
                            month = "8";
                            break;
                        case "Sep":
                            month = "9";
                            break;
                        case "Oct":
                            month = "10";
                            break;
                        case "Nov":
                            month = "11";
                            break;
                        case "Dec":
                            month = "12";
                            break;
                    }
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                String group = data.getStringExtra("group");

                ImageView choose_group = (ImageView) findViewById(R.id.choose_group);

                switch(group) {
                    case "1":
                        choose_group.setImageResource(R.color.group_red);
                        iGroup = 1;
                        break;
                    case "2":
                        choose_group.setImageResource(R.color.group_green);
                        iGroup = 2;
                        break;
                    case "3":
                        choose_group.setImageResource(R.color.group_blue);
                        iGroup = 3;
                        break;
                    case "4":
                        choose_group.setImageResource(R.color.group_orange);
                        iGroup = 4;
                        break;
                    case "5":
                        choose_group.setImageResource(R.color.group_pink);
                        iGroup = 5;
                        break;
                    case "6":
                        choose_group.setImageResource(R.color.group_dark);
                        iGroup = 6;
                        break;
                }
            }
        }
    }

    private void setWindowSize() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        calendar.set(i, i1, i2);
    }

    @Override
    public void onTimeSet(RadialPickerLayout radialPickerLayout, int i, int i1) {
        calendar.set(Calendar.HOUR_OF_DAY, i);
        calendar.set(Calendar.MINUTE, i1);
    }
}
