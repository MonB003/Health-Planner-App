/* Capstone Project Calories class
By: Monica 
 */

package sample;

import javafx.beans.property.SimpleStringProperty;

public class Calories {
    // FIELDS: male, female, age

    // Male field with getters and setters
    public String getMale() {
        return male.get();
    }

    public SimpleStringProperty maleProperty() {
        return male;
    }

    public void setMale(String male) {
        this.male.set(male);
    }

    SimpleStringProperty male;

    // Female field with getters and setters
    public String getFemale() {
        return female.get();
    }

    public SimpleStringProperty femaleProperty() {
        return female;
    }

    public void setFemale(String female) {
        this.female.set(female);
    }

    SimpleStringProperty female;

    // Age field with getters and setters
    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    SimpleStringProperty age;


    // Calories object constructor
    public Calories (String a, String b, String c) {
        this.age = new SimpleStringProperty(a);
        this.male = new SimpleStringProperty(b);
        this.female = new SimpleStringProperty(c);
    }

    // Calories object constructor with parameters and values
    public Calories (SimpleStringProperty age, SimpleStringProperty male, SimpleStringProperty female) {
        this.age = new SimpleStringProperty("age");
        this.male = new SimpleStringProperty("male");
        this.female = new SimpleStringProperty("female");
    }

    // toString method to display object
    public String toString() {
        return "Age: " + age + ";  Male: " + male + ";  Female: " + female;
    }
}
