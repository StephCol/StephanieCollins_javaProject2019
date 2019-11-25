package Main;

import java.util.ArrayList;

public class Department extends Product {

    private String depName;
    private ArrayList<Product> productArray;

    public Department(){
        this("Unknown");
    }

    public Department(String depName){
        setDepName(depName);
        productArray = new ArrayList<Product>();
    }

    public void setDepName(String depName) { this.depName = depName; }
    public String getDepName() { return depName; }


    public String getProductList() {
        String list = "";
        for (Product p : productArray) {
            list += p.toString() + "\n" ;
        }
        return list;
    }



    public void addProduct(Product product) {
        this.productArray.add(product);
    }


    public String toString(){
        return String.format("%-20s", getName());
    }


   public boolean equals(Department d){
        if(this.getDepName().equals(d.getDepName()))
            return true;
        else
            return false;
    }




}

