package products;

public abstract class VendingProduct {
    private String name;
    private double price;

    public VendingProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

