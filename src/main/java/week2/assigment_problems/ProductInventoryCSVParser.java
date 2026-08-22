package week2.assigment_problems;

public class ProductInventoryCSVParser {

    public static void parseRecord(String record) {

        String[] data = record.split(",");

        if (data.length != 3) {
            System.out.println("Invalid record.");
            return;
        }

        String id = data[0];
        String productName = data[1];
        String quantity = data[2];

        try {
            int productId = Integer.parseInt(id);
            int productQuantity = Integer.parseInt(quantity);

            System.out.println(
                "ID: " + productId +
                " | Product: " + productName +
                " | Quantity: " + productQuantity
            );

        } catch (NumberFormatException e) {
            System.out.println("Invalid record.");
        }
    }

    public static void main(String[] args) {

        String record = "101,Keyboard,25";

        parseRecord(record);
    }
}