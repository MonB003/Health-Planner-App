/* Capstone Project Controller class
By: Monica Bacatan
 */

package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller {
    // VARIABLES

    // Text fields for personal info
    public TextField textName;
    public TextField textAge;
    public Button btnAddInfo;

    // Text fields for calories log
    public TextField textNumOfCalories;
    public TextField textCalorieGoal;
    public Button btnAddCalories;

    // Text fields for exercise log
    public TextField textActivity;
    public TextField textExerciseHours;
    public TextField textExerciseGoal;
    public Button btnAddExercise;

    // Text fields for sleep log
    public TextField textSleepHours;
    public TextField textSleepGoal;
    public Button btnAddSleep;

    // Labels for description guide on right side of the app
    public Label lblDescription;
    public Label lblDescription2;
    public Label lblDescription3;

    // Menu Items for other functions
    public MenuItem menuSave;
    public MenuItem menuReset;
    public MenuItem menuAbtHealthPlan;

    // Labels for app description
    public Label lblAboutApp;
    public Label lblAboutApp2;
    public Label lblAboutApp3;
    public Label lblAboutApp4;
    public Label lblAboutApp5;
    public Label lblAboutApp6;

    // Anchor pane for layout of the 3 sections in the app
    public AnchorPane anchorPaneLeft;
    public AnchorPane anchorPaneMiddle;
    public AnchorPane anchorPaneRight;

    // Labels for each health category
    public Label lblName;
    public Label lblAge;
    public Label lblMealLog;
    public Label lblCaloriesNum;
    public Label lblCalorieGoal;
    public Label lblExerciseLog;
    public Label lblActivity;
    public Label lblExerciseHours;
    public Label lblExerciseGoal;
    public Label lblSleepLog;
    public Label lblSleepHours;
    public Label lblSleepGoal;

    // Scroll pane to scroll on the middle section
    public ScrollPane scrollPane;

    // Titles of each section
    public Label titleHealthPlan;
    public Label titleYourInfo;
    public Label titleDetails;

    // Warning labels
    public Label lblNameWarning;
    public Label lblAgeWarning;
    public Label lblCaloriesWarning;
    public Label lblActivityWarning;
    public Label lblExerciseWarning;
    public Label lblSleepWarning;

    // Other controls
    public ProgressBar progressBar;
    public Button btnClose;
    public MenuItem menuClose;
    public Label lblProgress;
    public SplitPane splitPane;

    // Variables store user input
    String userName;
    int userAge;
    int userCalorieAmt;
    String userExercise;
    double userExerciseHours;
    double userSleepHours;
    int userCalorieGoal;
    double userExerciseGoal;
    double userSleepGoal;



    // METHODS

    // Method to add personal info
    public void addInfo(ActionEvent actionEvent) {
        // Save user input for name
        userName = textName.getText();

        // Clear warning labels
        lblNameWarning.setText("");
        lblAgeWarning.setText("");

        // If statement if text field is empty
        if (userName.equals("")) {
            // Label shows warning statement
            lblNameWarning.setText("Please enter a name.");

            // Keep previous fields disabled
            textName.setDisable(false);
            textAge.setDisable(false);
            btnAddInfo.setDisable(false);

            // Clear text field
            textName.clear();

            // Keep description guide the same
            lblDescription.setText("Fill in your personal" + "\r" + "info to start the" + "\r" + "health planner!");
            lblDescription2.setText("");
            lblDescription3.setText("");

            // Keep the progress at 0
            progressBar.setProgress(0.0F);
        } else {   // Else statement if text field has proper input
            // Disable text fields and button
            textName.setDisable(true);
            textAge.setDisable(true);
            btnAddInfo.setDisable(true);

            // Enable food category
            textNumOfCalories.setDisable(false);
            textCalorieGoal.setDisable(false);
            btnAddCalories.setDisable(false);

            // Change description to meal
            lblDescription.setText("Fill in the Meal Log with the total" + "\r" + "number of calories you ate and" + "\r" + "your next goal");
            lblDescription2.setText("");
            lblDescription3.setText("");

            // Clear warning labels
            lblNameWarning.setText("");
            lblAgeWarning.setText("");

            // Progress moves to 25% complete
            progressBar.setProgress(0.25F);
        }

        // For loop checks if input for name contains a number
        for (char c : userName.toCharArray()) {
            // If statement checks if each character is a number
            if (Character.isDigit(c)) {
                // Warn statement tells user to enter a name
                lblNameWarning.setText("Please enter a name.");

                // Keep text fields disabled
                textName.setDisable(false);
                textAge.setDisable(false);
                btnAddInfo.setDisable(false);

                // Clear name
                textName.clear();

                // Keep description guide the same
                lblDescription.setText("Fill in your personal" + "\r" + "info to start the" + "\r" + "health planner!");
                lblDescription2.setText("");
                lblDescription3.setText("");

                // Disable food category
                textNumOfCalories.setDisable(true);
                textCalorieGoal.setDisable(true);
                btnAddCalories.setDisable(true);

                // Keep progress at 0
                progressBar.setProgress(0.0F);
            }
        }

        // Try and catch to check if user doesn't input a number into age text field
        try {
            int checkAge = Integer.parseInt(textAge.getText());
        } catch (Exception e) {
            lblAgeWarning.setText("Please enter a number.");

            // Keep text fields disabled
            textName.setDisable(false);
            textAge.setDisable(false);
            btnAddInfo.setDisable(false);

            // Clear age text field
            textAge.clear();

            // Keep description guide the same
            lblDescription.setText("Fill in your personal" + "\r" + "info to start the" + "\r" + "health planner!");
            lblDescription2.setText("");
            lblDescription3.setText("");

            // Disable food category
            textNumOfCalories.setDisable(true);
            textCalorieGoal.setDisable(true);
            btnAddCalories.setDisable(true);

            // Keep progress at 0
            progressBar.setProgress(0.0F);
        }
    }


    // Method to add calorie log and calorie goal
    public void addCalories(ActionEvent actionEvent) {
        // Clear warning statement
        lblCaloriesWarning.setText("");

        // Disable text fields and button
        textNumOfCalories.setDisable(true);
        textCalorieGoal.setDisable(true);
        btnAddCalories.setDisable(true);

        // Enable exercise category
        textActivity.setDisable(false);
        textExerciseHours.setDisable(false);
        textExerciseGoal.setDisable(false);
        btnAddExercise.setDisable(false);

        // Change description guide to exercise category
        lblDescription.setText("Fill in the Exercise Log with the" + "\r" + "activity you did, the number of" + "\r" + "hours you exercised and your" + "\r" + "next goal");

        // Progress moves to 50% complete
        progressBar.setProgress(0.50F);

        // Try and catch to check user input for number of calories
        try {
            int userCalories = Integer.parseInt(textNumOfCalories.getText());
        } catch (Exception e) {
            // Warning tells user to enter a number
            lblCaloriesWarning.setText("Please enter a number.");

            // Clear calories text field
            textNumOfCalories.clear();

            // Keep description guide the same
            lblDescription.setText("Fill in the Meal Log with the total" + "\r" + "number of calories you ate and" + "\r" + "your next goal");

            // Keep food category enabled
            textNumOfCalories.setDisable(false);
            textCalorieGoal.setDisable(false);
            btnAddCalories.setDisable(false);

            // Disable exercise category
            textActivity.setDisable(true);
            textExerciseHours.setDisable(true);
            textExerciseGoal.setDisable(true);
            btnAddExercise.setDisable(true);

            // Progress stays at 25%
            progressBar.setProgress(0.25F);
        }

        // Try and catch to check user input for calories goal
        try {
            int userCaloriesGoal = Integer.parseInt(textCalorieGoal.getText());
        } catch (Exception e) {
            // Warning tells user to input a number
            lblCaloriesWarning.setText("Please enter a number.");

            // Clear calorie goal text field
            textCalorieGoal.clear();

            // Keep description guide the same
            lblDescription.setText("Fill in the Meal Log with the total" + "\r" + "number of calories you ate and" + "\r" + "your next goal");

            // Keep food category enabled
            textNumOfCalories.setDisable(false);
            textCalorieGoal.setDisable(false);
            btnAddCalories.setDisable(false);

            // Disable exercise category
            textActivity.setDisable(true);
            textExerciseHours.setDisable(true);
            textExerciseGoal.setDisable(true);
            btnAddExercise.setDisable(true);

            // Progress stays at 25%
            progressBar.setProgress(0.25F);
        }
    }


    // Method to add exercise log and exercise goal
    public void addExercise(ActionEvent actionEvent) {
        // Save user input for activity type
        userExercise = textActivity.getText();
        // Clear warning label
        lblActivityWarning.setText("");

        // If and else check user input for type of activity to make sure it's a word
        if (userExercise.equals("")) {
            // Warning tells user to enter a word
            lblActivityWarning.setText("Please enter a word.");

            // Clear activity text field
            textActivity.clear();

            // Keep exercise category enabled
            textActivity.setDisable(false);
            textExerciseHours.setDisable(false);
            textExerciseGoal.setDisable(false);
            btnAddExercise.setDisable(false);

            // Disable sleep category
            textSleepHours.setDisable(true);
            textSleepGoal.setDisable(true);
            btnAddSleep.setDisable(true);

            // Keep description guide the same
            lblDescription.setText("Fill in the Exercise Log with the" + "\r" + "activity you did, the number of" + "\r" + "hours you exercised and your" + "\r" + "next goal");

            // Progress stays at 50%
            progressBar.setProgress(0.50F);
        }
        else {  // Else statement if input is proper
            // Disable text fields and button
            textActivity.setDisable(true);
            textExerciseHours.setDisable(true);
            textExerciseGoal.setDisable(true);
            btnAddExercise.setDisable(true);

            // Enable sleep category
            textSleepHours.setDisable(false);
            textSleepGoal.setDisable(false);
            btnAddSleep.setDisable(false);

            // Clear warning labels
            lblActivityWarning.setText("");
            lblExerciseWarning.setText("");

            // Keep description guide the same
            lblDescription.setText("Fill in the Sleep Log with the total" + "\r" + "hours of sleep you got and" + "\r" + "your next goal");

            // Progress moves to 75%
            progressBar.setProgress(0.75F);
        }

        // For loop checks if input for activity contains a number
        for (char c : userExercise.toCharArray()) {
            // If statement checks if each character is a number
            if (Character.isDigit(c)) {
                // Warning tells user to enter a word
                lblActivityWarning.setText("Please enter a word.");

                // CLear activity text field
                textActivity.clear();

                // Keep exercise category enabled
                textActivity.setDisable(false);
                textExerciseHours.setDisable(false);
                textExerciseGoal.setDisable(false);
                btnAddExercise.setDisable(false);

                // Disable sleep category
                textSleepHours.setDisable(true);
                textSleepGoal.setDisable(true);
                btnAddSleep.setDisable(true);

                // Keep description guide the same
                lblDescription.setText("Fill in the Exercise Log with the" + "\r" + "activity you did, the number of" + "\r" + "hours you exercised and your" + "\r" + "next goal");

                // Progress stays at 50%
                progressBar.setProgress(0.50F);
            }
        }

        // Try and catch to check user input for exercise hours
        try {
            double checkExerciseHours = Double.parseDouble(textExerciseHours.getText());
        } catch (Exception e) {
            // Warning tells user to enter a number
            lblExerciseWarning.setText("Please enter a number.");

            // Clear exercise text field
            textExerciseHours.clear();

            // Keep exercise category enabled
            textActivity.setDisable(false);
            textExerciseHours.setDisable(false);
            textExerciseGoal.setDisable(false);
            btnAddExercise.setDisable(false);

            // Disable sleep category
            textSleepHours.setDisable(true);
            textSleepGoal.setDisable(true);
            btnAddSleep.setDisable(true);

            // Keep description guide the same
            lblDescription.setText("Fill in the Exercise Log with the" + "\r" + "activity you did, the number of" + "\r" + "hours you exercised and your" + "\r" + "next goal");

            // Progress stays at 50%
            progressBar.setProgress(0.50F);
        }

        // Try and catch to check user input for exercise goal
        try {
            double checkExerciseGoal = Double.parseDouble(textExerciseGoal.getText());
        } catch (Exception e) {
            // Warning tells user to enter a number
            lblExerciseWarning.setText("Please enter a number.");

            // Clear exercise goal text field
            textExerciseGoal.clear();

            // Keep exercise category enabled
            textActivity.setDisable(false);
            textExerciseHours.setDisable(false);
            textExerciseGoal.setDisable(false);
            btnAddExercise.setDisable(false);

            // Disable sleep category
            textSleepHours.setDisable(true);
            textSleepGoal.setDisable(true);
            btnAddSleep.setDisable(true);

            // Keep description guide the same
            lblDescription.setText("Fill in the Exercise Log with the" + "\r" + "activity you did, the number of" + "\r" + "hours you exercised and your" + "\r" + "next goal");

            // Progress stays at 50%
            progressBar.setProgress(0.50F);
        }
    }


    // Method to add sleep log and sleep goal
    public void addSleep(ActionEvent actionEvent) {
        // Clear warning label
        lblSleepWarning.setText("");

        // Disable text fields and button
        textSleepHours.setDisable(true);
        textSleepGoal.setDisable(true);
        btnAddSleep.setDisable(true);

        // Change description guide to save or reset the info
        lblDescription.setText("Save or reset your info by" + "\r" + "clicking on File in the" + "\r" + "top left corner of the screen!");

        // Disable save menu button
        menuSave.setDisable(false);

        // Progress is complete
        progressBar.setProgress(1.0F);

        // Try and catch to check user input for sleep hours
        try {
            double checkSleepHrs = Double.parseDouble(textSleepHours.getText());

        } catch (Exception e) {
            // Warning tells user to enter a number
            lblSleepWarning.setText("Please enter a number.");

            // Keep text fields and button enabled
            textSleepHours.setDisable(false);
            textSleepGoal.setDisable(false);
            btnAddSleep.setDisable(false);
            menuSave.setDisable(true);

            // Clear sleep text field
            textSleepHours.clear();

            // Keep description guide the same
            lblDescription.setText("Fill in the Sleep Log with the total" + "\r" + "hours of sleep you got and" + "\r" + "your next goal");

            // Progress stays at 75%
            progressBar.setProgress(0.75F);
        }

        // Try and catch to check user input for sleep goal
        try {
            double checkSleepGoal = Double.parseDouble(textSleepGoal.getText());

        } catch (Exception e) {
            // Warning tells user to enter a number
            lblSleepWarning.setText("Please enter a number.");

            // Keep text fields and button enabled
            textSleepHours.setDisable(false);
            textSleepGoal.setDisable(false);
            btnAddSleep.setDisable(false);
            menuSave.setDisable(true);

            // Clear sleep goal text field
            textSleepGoal.clear();

            // Keep description guide the same
            lblDescription.setText("Fill in the Sleep Log with the total" + "\r" + "hours of sleep you got and" + "\r" + "your next goal");

            // Progress stays at 75%
            progressBar.setProgress(0.75F);
        }

    }


    // Method to save everything on healthPlan text file
    public void saveAll(ActionEvent actionEvent) throws IOException {
        // Save user input for each text field
        userName = textName.getText();
        userAge = Integer.parseInt(textAge.getText());
        userCalorieAmt = Integer.parseInt(textNumOfCalories.getText());
        userCalorieGoal = Integer.parseInt(textCalorieGoal.getText());
        userExercise = textActivity.getText();
        userExerciseHours = Double.parseDouble(textExerciseHours.getText());
        userExerciseGoal = Double.parseDouble(textExerciseGoal.getText());
        userSleepHours = Double.parseDouble(textSleepHours.getText());
        userSleepGoal = Double.parseDouble(textSleepGoal.getText());

        // Create Health object to store user input for log
        Health userHealth = new Health(userName, userAge, userCalorieAmt, userExercise, userExerciseHours, userSleepHours);

        // Create Goal object to store user input for goals
        Goal userGoal = new Goal(userCalorieGoal, userExerciseGoal, userSleepGoal);

        // Write Health and Goal objects to healthPlan text file
        userHealth.writeToFile();
        userGoal.writeToFile();

        // Disable menu item for saving
        menuSave.setDisable(true);
    }


    // Method to close the program
    public void handleCloseButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }


    // Method to reset everything
    public void resetAll(ActionEvent actionEvent) {
        // Clear text fields
        textName.clear();
        textAge.clear();
        textNumOfCalories.clear();
        textActivity.clear();
        textExerciseHours.clear();
        textSleepHours.clear();
        textCalorieGoal.clear();
        textExerciseGoal.clear();
        textSleepGoal.clear();

        // Enable text fields for personal info
        textName.setDisable(false);
        textAge.setDisable(false);

        // Disable the rest of the text fields
        textNumOfCalories.setDisable(true);
        textCalorieGoal.setDisable(true);
        textActivity.setDisable(true);
        textExerciseHours.setDisable(true);
        textExerciseGoal.setDisable(true);
        textSleepHours.setDisable(true);
        textSleepGoal.setDisable(true);

        // Enable personal info button
        btnAddInfo.setDisable(false);

        // Disable the rest of the buttons
        btnAddCalories.setDisable(true);
        btnAddExercise.setDisable(true);
        btnAddSleep.setDisable(true);

        // Change description guide to beginning statement
        lblDescription.setText("Fill in your personal" + "\r" + "info to start the" + "\r" + "health planner!");
        lblDescription2.setText("");
        lblDescription3.setText("");

        // Progress resets to 0
        progressBar.setProgress(0.0F);
    }


    // Method to open new window with calorie recommendations
    public void recommendCalories(ActionEvent actionEvent) {
        // Create new window
        Stage stage3 = new Stage();
        stage3.setTitle("Calories Recommendations");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);

        // Create a TableView
        TableView <Calories> tableView = new TableView<>();

        // Set size
        tableView.setMaxSize(282, 225);

        // Create columns with names for TableView
        TableColumn<Calories, String> calories = new TableColumn<>("Calories");
        TableColumn<Calories, String> male = new TableColumn<>("Male");
        TableColumn<Calories, String> female = new TableColumn<>("Female");
        TableColumn<Calories, String> age = new TableColumn<>("Age");
        calories.setCellValueFactory(new PropertyValueFactory<>("Calories"));
        male.setCellValueFactory(new PropertyValueFactory<>("Male"));
        female.setCellValueFactory(new PropertyValueFactory<>("Female"));
        age.setCellValueFactory(new PropertyValueFactory<>("Age"));

        // Add columns to the TableView
        tableView.getColumns().add(calories);
        calories.getColumns().add(age);
        calories.getColumns().add(male);
        calories.getColumns().add(female);

        // Add ObservableList data to the TableView
        final ObservableList<Calories> caloriesData = FXCollections.observableArrayList(
                new Calories("2-3", "1000-1400 calories", "1000-1400 calories"),
                new Calories("4-8", "1400-2000 calories", "1200-1800 calories"),
                new Calories("9-13", "1800-2600 calories", "1600-2200 calories"),
                new Calories("14-18", "2200-3200 calories", "1800-2400 calories"),
                new Calories("19-30", "2400-3000 calories", "2000-2400 calories"),
                new Calories("31-50", "2200-3000 calories", "1800-2200 calories"),
                new Calories("51+", "2000-2800 calories", "1600-2200 calories")
        );

        // Add ObservableList data to the TableView
        tableView.setItems(caloriesData);

        // Create ok button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setAlignment(Pos.BOTTOM_CENTER);
        btnOk.setFont(Font.font(java.awt.Font.SANS_SERIF));

        // Method when ok button is pressed
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            // Method to close this window
            @Override
            public void handle(ActionEvent event) {
                // Close this window
                stage3.close();
            }
        });

        // Label to cite info
        Label lblCaloriesCite = new Label();
        lblCaloriesCite.setText("SOURCE: Zelman, Kathleen M. \"Estimated Calorie Requirements.\" " + "\r"
                + "\t" + "\t" + "WebMD, 18 Aug. 2008,");

        // Hyperlink to store source link
        Hyperlink caloriesHyperlink = new Hyperlink("www.webmd.com/diet/features/estimated-calorie-requirement");
        // Method when hyperlink is pressed
        caloriesHyperlink.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                // Try statement opens website if it can be browsed
                try {
                    // Browse website and open it in a tab
                    Desktop.getDesktop().browse(new URI("www.webmd.com/diet/features/estimated-calorie-requirement"));
                } catch (IOException | URISyntaxException exception) {
                    exception.printStackTrace();
                    System.out.println("Can't Browse");
                }
            }
        });

        // Add TableView and button to the window
        box.getChildren().add(tableView);
        box.getChildren().add(btnOk);
        box.getChildren().add(lblCaloriesCite);
        box.getChildren().add(caloriesHyperlink);

        // Set up layout and size for the new window
        Scene scene3 = new Scene(box, 700, 420);
        stage3.setScene(scene3);
        stage3.show();
    }


    // Method to open new window with sleep recommendations
    public void recommendSleep(ActionEvent actionEvent) {
        // Create new window
        Stage stage3 = new Stage();
        stage3.setTitle("Sleep Recommendations");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen and spacing
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);

        // Create a TableView
        TableView <Sleep> tableView = new TableView<>();

        // Set size
        tableView.setMaxSize(144, 225);

        // Create an ObservableList to store table data
        final ObservableList<Sleep> data = FXCollections.observableArrayList(
                new Sleep("1-2", "11-14 hours"),
                new Sleep("3-5", "10-13 hours"),
                new Sleep("6-12", "9-12 hours"),
                new Sleep("13-18", "8-10 hours"),
                new Sleep("19-60", "7+ hours"),
                new Sleep("61-64", "7-9 hours"),
                new Sleep("65+", "7-8 hours")
        );

        // Create columns with names for table
        TableColumn<Sleep, String> sleep = new TableColumn<>("Sleep");
        sleep.setCellValueFactory(new PropertyValueFactory<>("Sleep"));
        TableColumn<Sleep, String> age = new TableColumn<>("Age");
        age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        TableColumn<Sleep, String> hours = new TableColumn<>("Hours");
        hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));

        // Add columns to the TableView
        tableView.getColumns().add(sleep);
        sleep.getColumns().add(age);
        sleep.getColumns().add(hours);

        // Set column size
        age.setPrefWidth(60);

        // Add ObservableList data to the TableView
        tableView.setItems(data);

        // Create ok button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setAlignment(Pos.BOTTOM_CENTER);
        btnOk.setFont(Font.font(java.awt.Font.SANS_SERIF));

        // Method when ok button is pressed
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            // Method to close this window
            @Override
            public void handle(ActionEvent event) {
                // Close this window
                stage3.close();
            }
        });

        // Label to cite info
        Label lblSleepCite = new Label();
        lblSleepCite.setText("SOURCE: \"CDC - How Much Sleep Do I Need? - Sleep and Sleep Disorders.\" \r" +
                "\t" + "\t" + "Centers for Disease Control and Prevention, 2 Mar. 2017,");

        // Hyperlink to store source link
        Hyperlink sleepHyperlink = new Hyperlink("www.cdc.gov/sleep/about_sleep/how_much_sleep.html");
        // Method when hyperlink is pressed
        sleepHyperlink.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                // Try statement opens website if it can be browsed
                try {
                    // Browse website and open it in a tab
                    Desktop.getDesktop().browse(new URI("www.cdc.gov/sleep/about_sleep/how_much_sleep.html"));
                } catch (IOException | URISyntaxException exception) {
                    exception.printStackTrace();
                    System.out.println("Can't Browse");
                }
            }
        });

        // Add TableView and button to the window
        box.getChildren().add(tableView);
        box.getChildren().add(btnOk);
        box.getChildren().add(lblSleepCite);
        box.getChildren().add(sleepHyperlink);

        // Set up layout and size for the new window
        Scene scene3 = new Scene(box, 700, 420);
        stage3.setScene(scene3);
        stage3.show();
    }


    // Method to display types of activities
    public void exerciseTypes(ActionEvent actionEvent) {
        // Create new window
        Stage stage3 = new Stage();
        stage3.setTitle("Types of Activities");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen
        box.setAlignment(Pos.CENTER);

        // Create main TreeItem and keep it expanded to see the items inside it
        TreeItem<String> activityTypes = new TreeItem<String>("Types of Activities");
        activityTypes.setExpanded(true);

        // Create TreeItems for moderate activities
        TreeItem<String> mediumActivities = new TreeItem<>("Medium Intensity Activities");
        TreeItem<String> briskWalking = new TreeItem<>("Brisk Walking");
        TreeItem<String> waterAerobics = new TreeItem<>("Water Aerobics");
        TreeItem<String> bikeRiding = new TreeItem<>("Bike Riding");
        TreeItem<String> dancing = new TreeItem<>("Dancing");
        TreeItem<String> hiking = new TreeItem<>("Hiking");
        TreeItem<String> rollerblading = new TreeItem<>("Rollerblading");

        // Adding elements to medium intensity activities tree item
        activityTypes.getChildren().add(mediumActivities);
        mediumActivities.getChildren().add(briskWalking);
        mediumActivities.getChildren().add(waterAerobics);
        mediumActivities.getChildren().add(bikeRiding);
        mediumActivities.getChildren().add(dancing);
        mediumActivities.getChildren().add(hiking);
        mediumActivities.getChildren().add(rollerblading);

        // Create TreeItems for high intensity activities
        TreeItem<String> intenseActivities = new TreeItem<>("High Intensity Activities");
        TreeItem<String> running = new TreeItem<>("Running");
        TreeItem<String> swimmingFast = new TreeItem<>("Swimming Fast");
        TreeItem<String> walkingSteps = new TreeItem<>("Walking Up Steps");
        TreeItem<String> sports = new TreeItem<>("Sports");
        TreeItem<String> skippingRope = new TreeItem<>("Skipping Rope");
        TreeItem<String> aerobics = new TreeItem<>("Aerobics");
        TreeItem<String> gymnastics = new TreeItem<>("Gymnastics");
        TreeItem<String> martialArts = new TreeItem<>("Martial Arts");

        // Adding elements to high intensity activities tree item
        activityTypes.getChildren().add(intenseActivities);
        intenseActivities.getChildren().add(running);
        intenseActivities.getChildren().add(swimmingFast);
        intenseActivities.getChildren().add(walkingSteps);
        intenseActivities.getChildren().add(sports);
        intenseActivities.getChildren().add(skippingRope);
        intenseActivities.getChildren().add(aerobics);
        intenseActivities.getChildren().add(gymnastics);
        intenseActivities.getChildren().add(martialArts);

        // Create TreeItems for muscle strengthening activities
        TreeItem<String> muscleStrengthening = new TreeItem<>("Muscle Strengthening Activities");
        TreeItem<String> yoga = new TreeItem<>("Yoga");
        TreeItem<String> pilates = new TreeItem<>("Pilates");
        TreeItem<String> taiChi = new TreeItem<>("Tai Chi");
        TreeItem<String> liftingWeights = new TreeItem<>("Lifting Weights");
        TreeItem<String> pushUps = new TreeItem<>("Push Ups");
        TreeItem<String> sitUps = new TreeItem<>("Sit Ups");
        TreeItem<String> heavyGardening = new TreeItem<>("Heavy Gardening");

        // Adding elements to muscle strengthening activities tree item
        activityTypes.getChildren().add(muscleStrengthening);
        muscleStrengthening.getChildren().add(yoga);
        muscleStrengthening.getChildren().add(pilates);
        muscleStrengthening.getChildren().add(taiChi);
        muscleStrengthening.getChildren().add(liftingWeights);
        muscleStrengthening.getChildren().add(pushUps);
        muscleStrengthening.getChildren().add(sitUps);
        muscleStrengthening.getChildren().add(heavyGardening);

        // Create a TreeView and add all activity types
        TreeView<String> treeView = new TreeView<>(activityTypes);

        // Add TreeView to the window
        box.getChildren().add(treeView);

        // Set up layout and size for the new window
        Scene scene3 = new Scene(box, 700, 420);
        stage3.setScene(scene3);
        stage3.show();
    }


    // Method to display exercise tips
    public void exerciseTips(ActionEvent actionEvent) {
        // Create new window
        Stage stage3 = new Stage();
        stage3.setTitle("Exercise Tips");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen
        box.setAlignment(Pos.CENTER);

        // Create a TreeItem for exercise tips and keep it expanded to see items inside it
        TreeItem<String> exerciseTips = new TreeItem<String>("Exercise Tips");
        exerciseTips.setExpanded(true);

        // Create TreeItems for each tip
        TreeItem<String> tip1 = new TreeItem<>("Drink more water");
        TreeItem<String> tip2 = new TreeItem<>("Reduce intake of processed foods");
        TreeItem<String> tip3 = new TreeItem<>("Consume more protein");
        TreeItem<String> tip4 = new TreeItem<>("Eat more fibre-rich food");
        TreeItem<String> tip5 = new TreeItem<>("Eat regular meals");
        TreeItem<String> tip6 = new TreeItem<>("Include more fruits & vegetables into meals");
        TreeItem<String> tip7 = new TreeItem<>("Exercise regularly");
        TreeItem<String> tip8 = new TreeItem<>("Check labels on food products");
        TreeItem<String> tip9 = new TreeItem<>("Eat smaller portion meals");
        TreeItem<String> tip10 = new TreeItem<>("Eat slowly & rest between meals");
        TreeItem<String> tip11 = new TreeItem<>("Make a shopping list");
        TreeItem<String> tip12 = new TreeItem<>("Get enough sleep");

        // Adding elements to exercise tips tree item
        exerciseTips.getChildren().add(tip1);
        exerciseTips.getChildren().add(tip2);
        exerciseTips.getChildren().add(tip3);
        exerciseTips.getChildren().add(tip4);
        exerciseTips.getChildren().add(tip5);
        exerciseTips.getChildren().add(tip6);
        exerciseTips.getChildren().add(tip7);
        exerciseTips.getChildren().add(tip8);
        exerciseTips.getChildren().add(tip9);
        exerciseTips.getChildren().add(tip10);
        exerciseTips.getChildren().add(tip11);
        exerciseTips.getChildren().add(tip12);

        // Create a TreeView and add exercise tips tree item
        TreeView<String> treeView = new TreeView<>(exerciseTips);

        // Add TreeView to the window
        box.getChildren().add(treeView);

        // Set up layout and size for the new window
        Scene scene3 = new Scene(box, 700, 420);
        stage3.setScene(scene3);
        stage3.show();
    }


    // Method to calculate BMR (basal metabolic rate)
    public void calculateBMR(ActionEvent actionEvent) {
        // Create new window
        Stage stage3 = new Stage();
        stage3.setTitle("BMR Calculator");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);

        // Create labels and text fields for gender, weight, age, and height
        Label lblGender = new Label("Gender (select one)");
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        Label lblWeight = new Label("Weight (kg)");
        TextField textWeight = new TextField();
        textWeight.setMaxWidth(100);
        textWeight.setPromptText("Weight");
        Label lblBMRAge = new Label("Age (years)");
        TextField textBMRAge = new TextField();
        textBMRAge.setMaxWidth(100);
        textBMRAge.setPromptText("Age");
        Label lblHeight = new Label("Height (cm)");
        TextField textHeight = new TextField();
        textHeight.setMaxWidth(100);
        textHeight.setPromptText("Height");

        // Create warning label
        Label lblBMRWarning = new Label();

        // Round BMR number to 2 decimal places
        Label lblBMR = new Label("");
        DecimalFormat df = new DecimalFormat("0.00");

        // Method when male radio button is selected
        male.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // If statement that deselects female radio button when male radio button is pressed
               if (male.isSelected()) {
                   female.setSelected(false);
               }
            }
        });

        // Method when female radio button is selected
        female.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // If statement that deselects male radio button when female radio button is pressed
                if (female.isSelected()) {
                    male.setSelected(false);
                }
            }
        });

        // Create calculate button
        Button btnCalculate = new Button("Calculate");
        // Method when calculate button is pressed
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            // Method to calculate BMR
            @Override
            public void handle(ActionEvent event) {
                // Try statement checks if weight text field is a number
                try {
                    double userWeight = Double.parseDouble(textWeight.getText());
                } catch (Exception e) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please enter a number.");
                    lblBMRWarning.setTextFill(Color.RED);

                    // Clear weight text field
                    textWeight.clear();
                }

                // Try statement checks if age text field is a number
                try {
                    double userAge = Double.parseDouble(textBMRAge.getText());
                } catch (Exception e) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please enter a number.");
                    lblBMRWarning.setTextFill(Color.RED);

                    // Clear age text field
                    textBMRAge.clear();
                }

                // Try statement checks if height text field is a number
                try {
                    double userHeight = Double.parseDouble(textHeight.getText());
                } catch (Exception e) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please enter a number.");
                    lblBMRWarning.setTextFill(Color.RED);

                    // Clear height text field
                    textHeight.clear();
                }

                // If else statements check if each text field is empty
                if (textWeight.getText().isEmpty()) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please enter a number.");
                    lblBMRWarning.setTextFill(Color.RED);

                    // Clear weight text field
                    textWeight.clear();
                }
                else if (textBMRAge.getText().isEmpty()) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please enter a number.");
                    lblBMRWarning.setTextFill(Color.RED);

                    // Clear age text field
                    textBMRAge.clear();
                }
                else if (textHeight.getText().isEmpty()) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please enter a number.");
                    lblBMRWarning.setTextFill(Color.RED);

                    // Clear height text field
                    textHeight.clear();
                }
                else if (!male.isSelected() && !female.isSelected()) {
                    // Red warning label tells user to input a number
                    lblBMRWarning.setText("Please select a gender.");
                    lblBMRWarning.setTextFill(Color.RED);
                }
                // Else statement, when all text fields are filled, it will calculate BMR
                else {
                    // Get user input
                    int weight = Integer.parseInt(textWeight.getText());
                    int age = Integer.parseInt(textBMRAge.getText());
                    int height = Integer.parseInt(textHeight.getText());
                    double BMR = 0;

                    // Calculation for male
                    if (male.isSelected()) {
                        BMR = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
                    }
                    // Calculation for female
                    if (female.isSelected()) {
                        BMR = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                    }

                    // Round BMR to 2 decimal places and display number in the label
                    String roundBMR = df.format(BMR);
                    lblBMR.setText("Your BMR = " + roundBMR);

                    // Clear warning label and text fields
                    lblBMRWarning.setText("");
                    textWeight.clear();
                    textBMRAge.clear();
                    textHeight.clear();
                }
            }
        });

        // Add radio buttons, labels, text fields, and buttons to the new window
        box.getChildren().add(lblGender);
        box.getChildren().add(male);
        box.getChildren().add(female);
        box.getChildren().add(lblWeight);
        box.getChildren().add(textWeight);
        box.getChildren().add(lblBMRAge);
        box.getChildren().add(textBMRAge);
        box.getChildren().add(lblHeight);
        box.getChildren().add(textHeight);
        box.getChildren().add(btnCalculate);
        box.getChildren().add(lblBMRWarning);
        box.getChildren().add(lblBMR);

        // Set up layout and size for the new window
        Scene scene3 = new Scene(box, 700, 420);
        stage3.setScene(scene3);
        stage3.show();
    }


    public ChoiceBox<String> mealChoiceBox = new ChoiceBox<>();
    public String mealChoice;
    // Method to set up choice box in food log
    public void initialize() {
        // Set up meal choice box
        mealChoiceBox.getItems().addAll("Breakfast", "Lunch", "Dinner", "Snack");
        mealChoiceBox.setValue("Breakfast");
        // mealChoice variable stores the option that the user selects for the ice cream flavour
        mealChoice = mealChoiceBox.getValue();

        // Method for when user selects an option for meal choice box
        mealChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // User's choice becomes the value of mealChoice
                mealChoice = newValue;
            }
        });
    }


    // Create queue LinkedLists for each meal of the day, this is used in food log method
    Queue<String> breakfast = new LinkedList<>();
    Queue<String> lunch = new LinkedList<>();
    Queue<String> dinner = new LinkedList<>();
    Queue<String> snack = new LinkedList<>();

    // Create date picker for food log method
    DatePicker dateFoodLog = new DatePicker();
    String newDateLog;

    // Method to log food
    public void logFood(ActionEvent actionEvent) {
        // Create new window
        Stage stage4 = new Stage();
        stage4.setTitle("Food Log");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen and spacing
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);

        // Set up date picker so user can select the date
        Label lblDate = new Label("Date");
        dateFoodLog.setPromptText("Select Date");

        // Create labels and text fields for meal and food item
        Label lblMeal = new Label("Meal");
        Label lblFoodItem = new Label("Food");
        TextField textFoodItem = new TextField();
        textFoodItem.setMaxWidth(100);
        textFoodItem.setPromptText("Food Item");

        // Create buttons to log food and save when done
        Button btnLogFood = new Button();
        btnLogFood.setText("Log Food");
        btnLogFood.setAlignment(Pos.BOTTOM_CENTER);
        Button btnDone = new Button();
        btnDone.setText("Save");
        btnDone.setAlignment(Pos.BOTTOM_CENTER);
        Label lblLogWarning = new Label();

        // Add none to original LinkedLists for when there's nothing inputted into the list when it's saved
        breakfast.add("None");
        lunch.add("None");
        dinner.add("None");
        snack.add("None");

        // Method when log food button is pressed
        btnLogFood.setOnAction(new EventHandler<ActionEvent>() {
            // Method to add to LinkedList
            @Override
            public void handle(ActionEvent event) {
                // If statement checks if text field is empty
                if (textFoodItem.getText().isEmpty()) {
                    // Red warning label tells user to fill out all fields
                    lblLogWarning.setText("Please fill out all fields.");
                    lblLogWarning.setTextFill(Color.RED);
                }
                else if (dateFoodLog.getEditor().getText().isEmpty()) {
                    // Red warning label tells user to fill out all fields
                    lblLogWarning.setText("Please fill out all fields.");
                    lblLogWarning.setTextFill(Color.RED);
                }
                else {  // Else statement if input is proper
                    // Switch statement checks user input to see which meal/case it is
                    // NOTE: Methods are the same for each case, but are specific to that meal's LinkedList
                    switch (mealChoice) {
                        case "Lunch":
                            // Remove "none" item from LinkedList because user is adding to the list
                            // NOTE: Poll() method removes first item from LinkedList. Since each case can be run multiple times, it would remove the first item each time
                            lunch.remove("None");

                            // Add user's food item to the list
                            lunch.add(textFoodItem.getText());
                            break;
                        case "Dinner":
                            dinner.remove("None");
                            dinner.add(textFoodItem.getText());
                            break;
                        case "Snack":
                            snack.remove("None");
                            snack.add(textFoodItem.getText());
                            break;
                        default:
                            breakfast.remove("None");
                            breakfast.add(textFoodItem.getText());
                            break;
                    }

                    // Clear text field and warning label
                    textFoodItem.clear();
                    lblLogWarning.setText("");

                    // Get date and change format
                    LocalDate dateLog = dateFoodLog.getValue();
                    newDateLog = dateLog.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy"));
                    dateFoodLog.setDisable(true);
                }
            }
        });

        // Method when done button is pressed
        btnDone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Try statement to write food log to the text file
                try {
                    writeFoodLogFile();
                } catch (IOException exception) {
                    exception.printStackTrace();
                    System.out.println("Does not work");
                }

                // Clear and enable Date Picker for the next time user uses food log
                dateFoodLog.getEditor().clear();
                dateFoodLog.setDisable(false);

                // While loops check each linked list and remove each item until it's empty
                while (!breakfast.isEmpty()) {
                    breakfast.poll();
                }
                while (!lunch.isEmpty()) {
                    lunch.poll();
                }
                while (!dinner.isEmpty()) {
                    dinner.poll();
                }
                while (!snack.isEmpty()) {
                    snack.poll();
                }

                // Close the window
                stage4.close();
            }
        });

        // Add labels, text fields and button to the window
        box.getChildren().add(lblDate);
        box.getChildren().add(dateFoodLog);
        box.getChildren().add(lblMeal);
        box.getChildren().add(mealChoiceBox);
        box.getChildren().add(lblFoodItem);
        box.getChildren().add(textFoodItem);
        box.getChildren().add(lblLogWarning);
        box.getChildren().add(btnLogFood);
        box.getChildren().add(btnDone);

        // Set up layout and size for the new window
        Scene scene4 = new Scene(box, 700, 420);
        stage4.setScene(scene4);
        stage4.show();
    }


    // Method to write the food log to the foodLog.txt file
    public void writeFoodLogFile() throws IOException {
        // Create FileWriter and BufferedWriter
        FileWriter fileWriter = new FileWriter("foodLog.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Write LinkedLists to the text file
        bufferedWriter.write("FOOD LOG" + "\r");
        bufferedWriter.write("DATE: " + newDateLog + "\r");
        bufferedWriter.write("Breakfast: " + Arrays.toString(breakfast.toArray()) + "\r");
        bufferedWriter.write("Lunch: " + Arrays.toString(lunch.toArray()) + "\r");
        bufferedWriter.write("Dinner: " + Arrays.toString(dinner.toArray()) + "\r");
        bufferedWriter.write("Snack: " + Arrays.toString(snack.toArray()) + "\r");
        bufferedWriter.write("\r");
        bufferedWriter.close();
    }


    // Create text field for grocery price
    public TextField textPrice = new TextField();
    // Create grocery warning label
    public Label lblGroceryWarning = new Label("");
    // Create ListView to store items in shopping list
    public ListView <Grocery> shoppingList = new ListView<>();

    // Method for Shopping List menu item
    public void shoppingList(ActionEvent actionEvent) {
        // Create new window
        Stage stage4 = new Stage();
        stage4.setTitle("Shopping List");

        // Create vertical box for the new window that will pop up
        VBox box = new VBox();

        // Center box on the screen and spacing
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);

        // Create labels, text fields, and buttons for items and prices
        Label lblItem = new Label("Item");
        TextField textItem = new TextField();
        textItem.setPromptText("Item");
        textItem.setMaxWidth(100);
        Label lblPrice = new Label("Price");
        textPrice.setPromptText("$");
        textPrice.setMaxWidth(100);
        Button btnAddItem = new Button("Add Item");
        Label lblList = new Label("Your Shopping List");

        // Set size of ListView
        shoppingList.setMaxSize(300, 480);

        // Method when add item button is pressed
        btnAddItem.setOnAction(new EventHandler<ActionEvent>() {
            // Method to add item to shopping ListView
            @Override
            public void handle(ActionEvent event) {
                // Try statement checks if price input is a number
                try {
                    double userPrice = Double.parseDouble(textPrice.getText());
                } catch (Exception e) {
                    // Red warning label tells user to input a number
                    lblGroceryWarning.setText("Please enter a number.");
                    lblGroceryWarning.setTextFill(Color.RED);

                    // Clear price text field
                    textPrice.clear();
                }

                // If statement checks if item text field is empty
                if (textItem.getText().isEmpty()) {
                    // Warning statement tells user to fill out all fields
                    lblGroceryWarning.setText("Please fill out all fields.");
                    lblGroceryWarning.setTextFill(Color.RED);
                }
                // Else if statement checks if price text field is empty
                else if (textPrice.getText().isEmpty()){
                    // Warning statement tells user to input a number
                    lblGroceryWarning.setText("Please enter a number.");
                    lblGroceryWarning.setTextFill(Color.RED);
                }
                // Else statement if input is proper
                else {
                    // Save user input
                    String item = textItem.getText();
                    double groceryPrice = Double.parseDouble(textPrice.getText());

                    // Create a grocery object and add it to the grocery ListView
                    Grocery grocery = new Grocery(item, groceryPrice);
                    shoppingList.getItems().add(grocery);

                    // Clear text fields and label
                    textItem.clear();
                    textPrice.clear();
                    lblGroceryWarning.setText("");
                }
            }
        });

        // Create button to remove an item
        Button btnRemoveItem = new Button("Remove Item");
        btnRemoveItem.setDisable(true);

        // Method when ListView item is pressed
        shoppingList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Enable button to remove an item
                btnRemoveItem.setDisable(false);
                // Method when remove item button is pressed
                btnRemoveItem.setOnAction(new EventHandler<ActionEvent>() {
                    // Method to remove item
                    @Override
                    public void handle(ActionEvent event) {
                        // Select a grocery from the ListView
                        Grocery grocery;
                        grocery = shoppingList.getSelectionModel().getSelectedItem();
                        shoppingList.getSelectionModel().select(grocery);

                        // Remove grocery
                        shoppingList.getItems().remove(grocery);
                        btnRemoveItem.setDisable(true);
                    }
                });
            }
        });

        // Add labels, text fields, ListView, and buttons to the window
        box.getChildren().add(lblItem);
        box.getChildren().add(textItem);
        box.getChildren().add(lblPrice);
        box.getChildren().add(textPrice);
        box.getChildren().add(btnAddItem);
        box.getChildren().add(lblGroceryWarning);
        box.getChildren().add(lblList);
        box.getChildren().add(shoppingList);
        box.getChildren().add(btnRemoveItem);

        // Set up layout and size for the new window
        Scene scene4 = new Scene(box, 700, 420);
        stage4.setScene(scene4);
        stage4.show();
    }


    // Method for About Health Planner menu item
    public void healthPlanDescription(ActionEvent actionEvent) {
        // Create new window
        Stage stage5 = new Stage();
        stage5.setTitle("About Health Planner App");

        // Create vertical box for the second window that will pop up
        VBox box = new VBox();

        // Center box on the screen and spacing
        box.setAlignment(Pos.CENTER);
        box.setSpacing(8);

        // Label gives a description about Health Planner app
        Label lblAboutHealthPlanner = new Label("The Health Planner App is an app made to help you keep track" + "\r"
                + "of the different elements of your health. This app allows you to fill" + "\r"
                + "in your information and save it on a file so you can keep track of" + "\r"
                + "your health. There is a menu bar in the top left corner with buttons" + "\r"
                + "for guidance and planning. Under the guidance category, there" + "\r"
                + "are calories and sleep recommendations, in addition to a list of" + "\r"
                + "activities and exercise tips. There is a BMR calculator, which" + "\r"
                + "calculates the amount of calories you need while resting, after" + "\r"
                + "you fill in certain information. In the planning category, there is a" + "\r"
                + "food log and a shopping list function, which lets you fill in items" + "\r"
                + "and their prices, then creates a list for you. This app is also a" + "\r"
                + "great way to help you stay organized!" + "\r");
        lblAboutHealthPlanner.setAlignment(Pos.CENTER);
        lblAboutHealthPlanner.setFont(Font.font(java.awt.Font.SANS_SERIF));

        // Ok button closes the second window when clicked
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setAlignment(Pos.BOTTOM_CENTER);
        btnOk.setFont(Font.font(java.awt.Font.SANS_SERIF));

        // Method when ok button is pressed
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            // Method to close this window
            @Override
            public void handle(ActionEvent event) {
                // Close this window
                stage5.close();
            }
        });

        // Add the app description label and ok button to the second window
        box.getChildren().add(lblAboutHealthPlanner);
        box.getChildren().add(btnOk);

        // Set up layout and size for the second window
        Scene scene5 = new Scene(box, 700, 420);
        stage5.setScene(scene5);
        stage5.show();
    }

}
