import java.time.LocalDate;

public class Fig4 {
    public static void main(String[] args) {
        System.out.println("=== Fig 4: Open/Closed Principle ===");

        Order order1 = new Order(120, 5);
        order1.setShipping(new Ground());
        System.out.println("Ground cost: " + order1.getShippingCost());
        System.out.println("Delivery: " + order1.getShippingDate());

        Order order2 = new Order(80, 5);
        order2.setShipping(new Air());
        System.out.println("Air cost: " + order2.getShippingCost());
        System.out.println("Delivery: " + order2.getShippingDate());
    }
}

// ---------- Helper Classes ----------
interface Shipping {
    double getCost(Order order);
    LocalDate getDate(Order order);
}

class Ground implements Shipping {
    public double getCost(Order order) {
        if (order.getTotal() > 100) return 0;
        return Math.max(10, order.getTotalWeight() * 1.5);
    }
    public LocalDate getDate(Order order) { return LocalDate.now().plusDays(5); }
}

class Air implements Shipping {
    public double getCost(Order order) { return Math.max(20, order.getTotalWeight() * 3); }
    public LocalDate getDate(Order order) { return LocalDate.now().plusDays(2); }
}

class Order {
    private double total;
    private double totalWeight;
    private Shipping shipping;

    public Order(double total, double totalWeight) {
        this.total = total;
        this.totalWeight = totalWeight;
    }

    public double getTotal() { return total; }
    public double getTotalWeight() { return totalWeight; }
    public void setShipping(Shipping shipping) { this.shipping = shipping; }
    public double getShippingCost() { return shipping.getCost(this); }
    public LocalDate getShippingDate() { return shipping.getDate(this); }
}
