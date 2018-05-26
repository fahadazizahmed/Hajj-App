package capitalcryptoworld.capitalworld.com.newhajjapp.Model;

/**
 * Created by Fahad Aziz on 22/05/2018.
 */

public class Complaint {


        String title;
            String description;

    public Complaint(String title, String description, String priority, boolean isDeleted) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isDeleted = isDeleted;
    }

    String priority;
            boolean isDeleted;

}
