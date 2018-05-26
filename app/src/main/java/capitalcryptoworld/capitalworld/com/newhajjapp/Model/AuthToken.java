package capitalcryptoworld.capitalworld.com.newhajjapp.Model;

/**
 * Created by Fahad Aziz on 16/05/2018.
 */

public class AuthToken {
    public MyResult getResult() {
        return result;
    }

    public void setResult(MyResult result) {
        this.result = result;
    }

    MyResult result;

    public class  MyResult{
        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        String accessToken;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        int userId;
    }


}
