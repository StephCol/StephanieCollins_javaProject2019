package Main;

public class Supplier {

    private String name, email;

    public Supplier(){
        this("Unknown", "Unknown");
    }

    public Supplier(String name, String email){

        setSupplierName(name);
        setEmail(email);
    }

    public Supplier(String name){
        setSupplierName(name);
    }

    public String getEmail() { return email; }
    public String getSupplierName() { return name; }


    public void setEmail(String email) { this.email = email; }
    public void setSupplierName(String name) { this.name = name; }

    public String toString() { return String.format("Supplier Name: %-20s\nSupplier Email: %-20s\n ",
                 getSupplierName(), getEmail());
    }
}
