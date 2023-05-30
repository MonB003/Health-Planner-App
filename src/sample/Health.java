/* Capstone Project Health class
By: Monica 
 */

package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Health {
    // Fields for health log
    String name;
    int age;
    int calories;
    String exercise;
    double exerciseHours;
    double sleepHours;

    Date date = new Date();
    // Change date format: day of week, month day, year  hours:minutes:seconds am/pm
    SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMM dd, yyyy  hh:mm:ss aa");
    String newDate = dateFormat.format(date);


    // Default constructor for Health object
    Health() {
        name = "";
        age = 0;
        calories = 0;
        exercise = "";
        exerciseHours = 0;
        sleepHours = 0;
    }

    // Constructor with parameters for Health object
    public Health (String name, int age, int calories, String exercise, double exerciseHours, double sleepHours) {
        this.name = name;
        this.age = age;
        this.calories = calories;
        this.exercise = exercise;
        this.exerciseHours = exerciseHours;
        this.sleepHours = sleepHours;
    }


    // Method to write Health object into healthPlan text file
    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("healthPlan.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("HEALTH PLAN" + "\r");
        bufferedWriter.write("Date: " + newDate + "\r");
        bufferedWriter.write("\r");
        bufferedWriter.write("Personal Info:" + "\r");
        bufferedWriter.write("  Name: " + name + "\r");
        bufferedWriter.write("  Age: " + age + "\r");
        bufferedWriter.write("Calories Log:" + "\r");
        bufferedWriter.write("  Number of Calories: " + calories + "\r");
        bufferedWriter.write("Exercise Log:" + "\r");
        bufferedWriter.write("  Exercise Activity: " + exercise + "\r");
        bufferedWriter.write("  Number of Hours Exercising: " + exerciseHours + "\r");
        bufferedWriter.write("Sleep Log:" + "\r");
        bufferedWriter.write("  Number of Hours Slept: " + sleepHours + "\r");
        bufferedWriter.write("\r");
        bufferedWriter.close();
    }

}
