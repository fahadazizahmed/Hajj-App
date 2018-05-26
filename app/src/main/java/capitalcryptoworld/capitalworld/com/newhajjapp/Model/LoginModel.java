package capitalcryptoworld.capitalworld.com.newhajjapp.Model;

/**
 * Created by Fahad Aziz on 16/05/2018.
 */

public class LoginModel {
    String userNameOrEmailAddress;
    String password;

    public LoginModel(String userNameOrEmailAddress, String password) {
        this.userNameOrEmailAddress = userNameOrEmailAddress;
        this.password = password;
    }
}
