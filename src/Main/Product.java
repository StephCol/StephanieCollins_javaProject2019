package Main;

public class Product {

    private int refNo, stock;
    private String name, brand, department, supplier;
    private Double costPrice, salePrice;

    public Product(){
        this(0, "Unknown", "Unknown", 0, "Unknown", "Unknown", 0.00, 0.00 );
    }

    public Product(int refNo, String name, String brand, int stock, String supName, String depName, Double costPrice, Double salePrice){
        setRefNo(refNo);
        setName(name);
        setBrand(brand);
        setStock(stock);
        setCostPrice(costPrice);
        setSalePrice(salePrice);
        setSupplier(supName);
        setDepartment(depName);
    }

    public void setRefNo(int refNo) { this.refNo = refNo;}
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setStock(int stock) { this.stock = stock; }
    public void setCostPrice(Double costPrice) { this.costPrice = costPrice; }
    public void setSalePrice(Double salePrice) { this.salePrice = salePrice; }
    public void setDepartment(String department) { this.department = department; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public int getRefNo() { return refNo; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public int getStock() { return stock; }
    public Double getCostPrice() { return costPrice; }
    public Double getSalePrice() { return salePrice; }
    public String getDepartment() { return department; }
    public String getSupplier() { return supplier; }

    public String toString() {

        return  String.format("%-8d%-20s%-22s%-13d%-17.2f%-15.2f\n",
                getRefNo(), getName(), getBrand(), getStock(), getCostPrice(), getSalePrice());

    }
}
