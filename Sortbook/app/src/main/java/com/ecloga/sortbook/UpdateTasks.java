package com.ecloga.sortbook;

import java.util.ArrayList;

public class UpdateTasks {
    public static void addTask(String taskDetails) {
        Parameters.taskDetails.add(taskDetails);
        Parameters.taskUndone++;
    }

    public static void addFavTask(String taskDetails) {
        Parameters.favDetails.add(taskDetails);
        Parameters.taskFavourites++;
    }

    public static void addGroup1Task(String taskDetails) {
        Parameters.group1Details.add(taskDetails);
        Parameters.taskGroup1++;
    }

    public static void addGroup2Task(String taskDetails) {
        Parameters.group2Details.add(taskDetails);
        Parameters.taskGroup2++;
    }

    public static void addGroup3Task(String taskDetails) {
        Parameters.group3Details.add(taskDetails);
        Parameters.taskGroup3++;
    }

    public static void addGroup4Task(String taskDetails) {
        Parameters.group4Details.add(taskDetails);
        Parameters.taskGroup4++;
    }

    public static void addGroup5Task(String taskDetails) {
        Parameters.group5Details.add(taskDetails);
        Parameters.taskGroup5++;
    }

    public static void addGroup6Task(String taskDetails) {
        Parameters.group6Details.add(taskDetails);
        Parameters.taskGroup6++;
    }

    public static void removeTask(int position) {
        Parameters.taskDone++;
        Parameters.taskUndone--;
        Parameters.taskDetails.remove(position);
    }

    public static void removeFavTask(int position) {
        Parameters.taskFavourites--;
        Parameters.favDetails.remove(position);
    }

    public static void removeGroup1Task(int position) {
        Parameters.taskGroup1--;
        Parameters.group1Details.remove(position);
    }

    public static void removeGroup2Task(int position) {
        Parameters.taskGroup2--;
        Parameters.group2Details.remove(position);
    }

    public static void removeGroup3Task(int position) {
        Parameters.taskGroup3--;
        Parameters.group3Details.remove(position);
    }

    public static void removeGroup4Task(int position) {
        Parameters.taskGroup4--;
        Parameters.group4Details.remove(position);
    }

    public static void removeGroup5Task(int position) {
        Parameters.taskGroup5--;
        Parameters.group5Details.remove(position);
    }

    public static void removeGroup6Task(int position) {
        Parameters.taskGroup6--;
        Parameters.group6Details.remove(position);
    }

    public static int getTaskRating(String taskDetails) {
        taskDetails = taskDetails.replace(taskDetails.substring(0, taskDetails.indexOf("~3~") + 3), "");
        taskDetails = taskDetails.replace(taskDetails.substring(taskDetails.indexOf("~4~")), "");
        return Integer.parseInt(taskDetails);
    }

    public static void resortArrayList(ArrayList<String> arrayList) {
        /*
            Replace Parameters.taskDetails with arrayList
         */
        for(int i = 0; i < Parameters.taskDetails.size() - 1; i++) {
            for(int j = i + 1; i < Parameters.taskDetails.size(); j++) {
                String currentTaskDetails = Parameters.taskDetails.get(i);
                int currentTaskRating = getTaskRating(currentTaskDetails);
                String nextTaskDetails = Parameters.taskDetails.get(j);
                int nextTaskRating = getTaskRating(nextTaskDetails);

                if(nextTaskRating > currentTaskRating) {
                    String s = currentTaskDetails;
                    currentTaskDetails = nextTaskDetails;
                    nextTaskDetails = s;

                    Parameters.taskDetails.set(i, nextTaskDetails);
                    Parameters.taskDetails.set(j, currentTaskDetails);
                }
            }
        }
    }
}
