package sample;

public class Grocery {
    String item;
    double price;

    Grocery() {
        item = "";
        price = 0;
    }

    Grocery (String item, double price) {
        this.item = item;
        this.price = price;
    }

    public String toString() {
        return "ITEM: " + item + ";  PRICE: $" + price;
    }
}
