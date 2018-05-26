package capitalcryptoworld.capitalworld.com.newhajjapp.Model;

/**
 * Created by Fahad Aziz on 25/05/2018.
 */

public class GetUserType {
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    String result;
    boolean success;
}
