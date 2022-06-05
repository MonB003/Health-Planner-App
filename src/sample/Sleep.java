/* Capstone Project Sleep class
By: Monica Bacatan
 */

package sample;

import javafx.beans.property.SimpleStringProperty;

public class Sleep {
    // FIELDS: age, hours

    // Sleep object constructor
    public Sleep(String s, String s1) {
        this.age = new SimpleStringProperty(s);
        this.hours = new SimpleStringProperty(s1);
    }

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

    // Hours field with getters and setters
    public String getHours() {
        return hours.get();
    }

    public SimpleStringProperty hoursProperty() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours.set(hours);
    }

    SimpleStringProperty hours;


    // Sleep object constructor with parameters
    public Sleep(SimpleStringProperty age, SimpleStringProperty hours) {
        this.age = new SimpleStringProperty("age");
        this.hours = new SimpleStringProperty("hours");
    }


    // toString method displays object
    public String toString() {
        return "Age: " + age + ";  Hours: " + hours;
    }


}
