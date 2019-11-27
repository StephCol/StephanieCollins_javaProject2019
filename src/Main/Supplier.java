package Main;

import java.io.Serializable;

/**
 * The type Supplier.
 */
public class Supplier implements Serializable {

    private String name, email;

    /**
     * Instantiates a new Supplier.
     */
    public Supplier(){
        this("Unknown", "Unknown");
    }

    /**
     * Instantiates a new Supplier.
     *
     * @param name  the name
     * @param email the email
     */
    public Supplier(String name, String email){

        setSupplierName(name);
        setEmail(email);
    }

    /**
     * Instantiates a new Supplier.
     *
     * @param name the name
     */
    public Supplier(String name){
        setSupplierName(name);
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() { return email; }

    /**
     * Gets supplier name.
     *
     * @return the supplier name
     */
    public String getSupplierName() { return name; }
    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Sets supplier name.
     *
     * @param name the name
     */
    public void setSupplierName(String name) { this.name = name; }

    public String toString() { return String.format("%-40s%-20s\n ",
                 getSupplierName(), getEmail());
    }
}
