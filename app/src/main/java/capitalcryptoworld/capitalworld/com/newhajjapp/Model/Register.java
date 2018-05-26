package capitalcryptoworld.capitalworld.com.newhajjapp.Model;

/**
 * Created by Fahad Aziz on 16/05/2018.
 */

public class Register
{
    User user;

    public Register(User user, String[] assignedRoleNames) {
        this.user = user;
        this.assignedRoleNames = assignedRoleNames;
    }

    String[] assignedRoleNames;





    public String[] getAssignedRoleNames ()
    {
        return assignedRoleNames;
    }

    public void setAssignedRoleNames (String[] assignedRoleNames)
    {
        this.assignedRoleNames = assignedRoleNames;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [assignedRoleNames = "+assignedRoleNames+", user = "+user+"]";
    }
}