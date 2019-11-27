package Main;

import java.io.Serializable;

/**
 * The type Product.
 */
public class Product implements Serializable {

    private int refNo, stock;
    private String name, brand, department, supplier;
    private Double costPrice, salePrice;

    /**
     * Instantiates a new Product.
     */
    public Product(){
        this(0, "Unknown", "Unknown", 0, "Unknown", "Unknown", 0.00, 0.00 );
    }

    /**
     * Instantiates a new Product.
     *
     * @param refNo     the ref no
     * @param name      the name
     * @param brand     the brand
     * @param stock     the stock
     * @param supName   the sup name
     * @param depName   the dep name
     * @param costPrice the cost price
     * @param salePrice the sale price
     */
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

    /**
     * Sets ref no.
     * @param refNo the ref no
     */
    public void setRefNo(int refNo) { this.refNo = refNo;}

    /**
     * Sets name.
     * @param name the name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Sets brand.
     * @param brand the brand
     */
    public void setBrand(String brand) { this.brand = brand; }

    /**
     * Sets stock.
     * @param stock the stock
     */
    public void setStock(int stock) { this.stock = stock; }

    /**
     * Sets cost price.
     * @param costPrice the cost price
     */
    public void setCostPrice(Double costPrice) { this.costPrice = costPrice; }

    /**
     * Sets sale price.
     * @param salePrice the sale price
     */
    public void setSalePrice(Double salePrice) { this.salePrice = salePrice; }

    /**
     * Sets department.
     * @param department the department
     */
    public void setDepartment(String department) { this.department = department; }

    /**
     * Sets supplier.
     * @param supplier the supplier
     */
    public void setSupplier(String supplier) { this.supplier = supplier; }

    /**
     * Gets ref no.
     * @return the ref no
     */
    public int getRefNo() { return refNo; }

    /**
     * Gets name.
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Gets brand.
     * @return the brand
     */
    public String getBrand() { return brand; }

    /**
     * Gets stock.
     * @return the stock
     */
    public int getStock() { return stock; }

    /**
     * Gets cost price.
     * @return the cost price
     */
    public Double getCostPrice() { return costPrice; }

    /**
     * Gets sale price
     * @return the sale price
     */
    public Double getSalePrice() { return salePrice; }

    /**
     * Gets department.
     * @return the department
     */
    public String getDepartment() { return department; }

    /**
     * Gets supplier.
     * @return the supplier
     */
    public String getSupplier() { return supplier; }

    public String toString() {

        return  String.format("%-8d%-18s%-22s%-11d%-15.2f%-15.2f\n",
                getRefNo(), getName(), getBrand(), getStock(), getCostPrice(), getSalePrice());

    }
}
