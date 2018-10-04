import products.VendingProduct;

import java.util.ArrayList;

public class ProductTray {
    private String trayCode;
    private int capacity;
    private ArrayList<VendingProduct> stock;

    public ProductTray(String trayCode, int capacity) {
        this.trayCode = trayCode;
        this.capacity = capacity;
        this.stock = new ArrayList<>();
    }

    public String getTrayCode() {
        return trayCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addProduct(VendingProduct product){
        if(isNotFull()){
        this.stock.add(product);
        }
    }

    public int countStock() {
        return this.stock.size();
    }

    public boolean isNotFull(){
        return countStock() < this.capacity;
    }
    public VendingProduct dispenseProduct(){
        if(countStock() >= 1) {
        return this.stock.remove(0); }
        return null;
    }
}
