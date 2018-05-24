package capitalcryptoworld.capitalworld.com.hajjapp.Model;

public class OperatorRegister {

    public OperatorRegister(String name, String mobile, String designation, Boolean isDeleted, Boolean isAvailable) {
        this.name = name;
        this.mobile = mobile;
        this.designation = designation;
        this.isDeleted = isDeleted;
        this.isAvailable = isAvailable;

    }

    String  name;
    String mobile;
    String designation;
    Boolean isDeleted;
    Boolean isAvailable;



}
