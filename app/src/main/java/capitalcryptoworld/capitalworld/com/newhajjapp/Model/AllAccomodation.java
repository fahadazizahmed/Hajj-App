package capitalcryptoworld.capitalworld.com.newhajjapp.Model;

import java.io.Serializable;

/**
 * Created by Fahad Aziz on 24/05/2018.
 */
@org.parceler.Parcel
public class AllAccomodation implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    String location;
    int id;
    Boolean isAvailable;
    String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    int contact;














}