import java.util.Scanner;

public class ShoppingCart {

    private double[] prices;
    private int itemCount;
    private final String cartId;

    public ShoppingCart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String cartId = sc.nextLine();

        System.out.print("Enter maximum number of items: ");
        int maxItems = sc.nextInt();

        ShoppingCart cart = new ShoppingCart(cartId, maxItems);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price: ");
            cart.addItem(sc.nextDouble());
        }

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());

        sc.close();
    }
}