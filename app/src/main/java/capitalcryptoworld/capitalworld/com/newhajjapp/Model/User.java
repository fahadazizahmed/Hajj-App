package capitalcryptoworld.capitalworld.com.hajjapp.Model;

/**
 * Created by Fahad Aziz on 17/05/2018.
 */

public class User
{


    String name;
    String surname;
    boolean isActive;

    public User(String name, String surname, String userName, String emailAddress, String phoneNumber, String password,boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isActive = isActive;
    }

    String userName;

    String emailAddress;
    String phoneNumber;





    String password;

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getEmailAddress ()
    {
        return emailAddress;
    }

    public void setEmailAddress (String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getSurname ()
    {
        return surname;
    }

    public void setSurname (String surname)
    {
        this.surname = surname;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [phoneNumber = "+phoneNumber+", name = "+name+", emailAddress = "+emailAddress+", userName = "+userName+", surname = "+surname+", password = "+password+"]";
    }
}


