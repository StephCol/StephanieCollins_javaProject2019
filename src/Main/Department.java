package Main;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a department in the store eg. Watches, Rings etc.
 * A Department contains product of the relevant type.
 *
 * @author Stephanie Collins
 *
 * Department implements Serializable so Department objects can be saved to a file
 */
public class Department implements Serializable {
    /**
     * The name of the department.
     */
    private String depName;
    /**
     * Each Department contains an ArrayList of products
     */
    private ArrayList<Product> productArray;

    /**
     * Creates a new department using the single argument constructor
     * within, and provides a default value for name
     */
    public Department(){
        this("Unknown");
    }

    /**
     * Creates a new department with the given name,
     * also assigns an ArrayList of products to the Department
     *
     * @param depName The name of the department
     */
    public Department(String depName){
        setDepName(depName);
        productArray = new ArrayList<Product>();
    }

    /**
     * Mutator method to set/change the name of the Department
     *
     * @param depName The name of the department
     */
    public void setDepName(String depName) { this.depName = depName; }

    /**
     * Accessor method Returns the name of the Department
     *
     * @return depName The name of the department
     */
    public String getDepName() { return depName; }


    /**
     * Add product.
     *
     * @param product Adds a product to the ArrayList of products
     */
    public void addProduct(Product product) {
        this.productArray.add(product);
    }

    /**
     * Returns the contents of the products Array for the department object
     * on which it is called
     *
     * @return list of products in the selected department
     */
    public String getProductList() {
        String list = "";
        for (Product p : productArray) {
            list += p.toString() + "\n" ;
        }
        return list;
    }

    /**
     * Returns the name of the Department
     * @return name of selected department
     */
    public String toString(){
        return String.format("%-20s", getDepName());
    }

    /**
     * Returns a boolean value to show if the compared departments are the same
     *
     * @param d the Department
     * @return a boolean value of true or false to compare department names
     */
    public boolean equals(Department d){
        return this.getDepName().equals(d.getDepName());
    }
}
