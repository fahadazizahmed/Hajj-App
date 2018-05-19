package capitalcryptoworld.capitalworld.com.hajjapp.ApiInterface;

import capitalcryptoworld.capitalworld.com.hajjapp.Model.AuthToken;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.HajjRegisterResponse;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.LoginModel;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.RegisteHajjUser;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.Register;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.RegisterResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Fahad Aziz on 16/05/2018.
 */

public interface HajjInterface {

@POST("TokenAuth/Authenticate")
Call<AuthToken> getToken(@Body LoginModel loginModel);

@POST("services/app/User/CreateOrUpdateUser")
Call<RegisterResponse> sendUser(@Body Register register);
@POST("services/app/HajjRegistrationService/Create")
    Call<HajjRegisterResponse> registerHajjUser(@Header("Authorization") String authorization, @Body RegisteHajjUser registeHajjUser);


}
