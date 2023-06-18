# Health Planner App
> This is a Capstone project that allows users to record their data and next goal for the following health categories: Calories, Exercise, and Sleep.

<br>

## Table of Contents
- [Technologies](#technologies)
- [How to run the project](#how-to-run-project)
- [How to use the app](#how-to-use-app)
- [References](#references)

<br>

## Technologies
* Frontend: JavaFX
* Backend: Java


<br>


## <a id="how-to-run-project">How to run the project</a>
### Prerequisites:
- Have a Git and GitHub account
- Have [Java JDK](https://adoptopenjdk.net/archive.html) installed 
  - This project uses jdk-11

### Configuration instructions:

You will need to install:
- [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) (executable)
  - This project uses the community version, which is free
- [SceneBuilder](https://gluonhq.com/products/scene-builder/)
  - Under the section *Download Scene Builder for Java 8*, download the appropriate 64-bit installer
  - This project uses the *Windows Installer 64-bit* Platform

Cloning the repository:
- Open Command Prompt
- `cd` into the folder you want the repository stored in
- Type: `git clone https://github.com/MonB003/Health-Planner-App.git`

Using JavaFX in the project:
- In IntelliJ, go to: File > Settings > Languages & Frameworks > JavaFX
  - Under *Path to SceneBuilder*, copy the file location of the SceneBuilder executable on your device
  - Click *Apply*, then *Close*

### Running the project:
1. In IntelliJ, open the Main.java file
   - Main.java file location: *Your Folder Name* /src/sample/Main.java
2. Click the green triangle in the top right corner (when hovered on, it says: Run 'Main')
3. A small popup window will appear, which is the app


<br>


## <a id="how-to-use-app">How to use the app</a>
### Fill out health plan form:
- On the current window, start by filling out your name and age, then click the "Add" button
- Fill out each text field in each section of the Health Plan with valid data. After, click the "Add" button
  - **Note:** the app only lets you fill out the next section once the previous section is complete
- There is a *Details* section on the right side of the window that tells you what to do for the current section
- Once each section's data has been filled and added, you can save the data to the healthPlan text file by clicking the *File* navbar button, then click the "Save" button
- To reset and clear the form: 
  - In the navbar, go to: Edit > Reset

### Guidance section:
- The *Guidance* navbar button has options that provide data to the user
- The Calories recommendations option shows a table of the approximate number of calories people need based on their gender and age
- The Sleep recommendations option shows a table of the approximate number of hours people need to sleep based on their age
- There are options for types of activities based on intensity level, and general exercise tips
- The BMR calculator is a built-in calculator 
  - It calculates your BMR based on gender, weight, age, height
  - Enter your data into each field and click "Calculate" to get your result

### Plan section:
- Food log option
  - Enter the date and food item, and select the meal
  - Click "Log Food", which saves the information you entered
  - You can keep logging food for all meals in that day
  - Once you have logged all your food for the day, click "Save", which writes all that day's data to the foodLog text file
- Shopping list option
  - Enter the item and price and click "Add Item" to add each item to the list
  - Your shopping list will display all your current items and their price
  - To delete an item: click on the item in the shopping list, then click the "Remove Item" button


<br>


## <a id="references">References</a>
### Research:
- [Calories consumed each day](https://www.medicalnewstoday.com/articles/245588#:~:text=According%20to%20the%202015%2D2020,men%20from%202%2C000%20to%203%2C000.)
- [Calories daily intake](https://www.nhs.uk/common-health-questions/food-and-diet/what-should-my-daily-intake-of-calories-be/)
- [Calories recommendations table data](https://www.webmd.com/diet/features/estimated-calorie-requirement)
- [Sleep recommendations table data](https://www.cdc.gov/sleep/about_sleep/how_much_sleep.html)
- [Exercise activities](https://www.nhs.uk/live-well/exercise/)
- [BMR calculation](https://www.verywellfit.com/what-is-bmr-or-basal-metabolic-rate-3495380)
- [Weight loss tips](https://www.healthline.com/nutrition/losing-a-pound-a-day#weight-loss-tips)

### JavaFX:
- [Create new window in JavaFX](https://www.quickprogrammingtips.com/java/how-to-open-a-new-window-in-javafx.html)
- [ChoiceBox dropdown menu](https://jenkov.com/tutorials/javafx/choicebox.html)
- [Button event listener](https://www.geeksforgeeks.org/javafx-button-with-examples/)
- [TreeView and TreeItem objects](https://jenkov.com/tutorials/javafx/treeview.html)
- [File reading and writing](https://www.youtube.com/watch?v=ivRleZ6NWLQ&t=229s)
- [GUI with SceneBuilder](https://www.youtube.com/watch?v=C353UFc3te0&t=156s)
