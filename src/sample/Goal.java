/* Capstone Project Goal class
By: Monica 
 */

package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Goal {
    // Fields for users goals
    double caloriesGoal;
    double exerciseGoal;
    double sleepGoal;

    // Default Goal object
    Goal() {
        caloriesGoal = 0;
        exerciseGoal = 0;
        sleepGoal = 0;
    }

    // Constructor with parameters for Goal object
    public Goal (double caloriesGoal, double exerciseGoal, double sleepGoal) {
        this.caloriesGoal = caloriesGoal;
        this.exerciseGoal = exerciseGoal;
        this.sleepGoal = sleepGoal;
    }


    // Method to write Goal object into healthPlan text file
    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("healthPlan.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("GOALS" + "\r");
        bufferedWriter.write("Calories Goal: " + caloriesGoal + "\r");
        bufferedWriter.write("Exercise Goal: " + exerciseGoal + "\r");
        bufferedWriter.write("Sleep Goal: " + sleepGoal + "\r");
        bufferedWriter.write("\r");
        bufferedWriter.write("Thank you for using the Health Planner App! Stay Healthy!" + "\r");
        bufferedWriter.write("---------------------------------------------------------" + "\r");
        bufferedWriter.write("\r");
        bufferedWriter.close();
    }

}
