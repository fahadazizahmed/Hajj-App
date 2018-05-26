package capitalcryptoworld.capitalworld.com.newhajjapp.ApiInterface;


import capitalcryptoworld.capitalworld.com.newhajjapp.Model.AccomodationList;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.AuthToken;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.CheckAccmodation;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.ComplainResponse;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.Complaint;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.GetUserType;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.HajjRegisterResponse;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.LoginModel;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.RegisteHajjUser;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.Register;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
@POST("services/app/ComplaintService/Create")
    Call<ComplainResponse>  sendComplain(@Header("Authorization") String authorization, @Body Complaint complaint);

@POST("services/app/AccommodationService/ListAll")
Call<AccomodationList> getAllaccomodation();
@GET("services/app/HajjRegistrationService/GetAccCheck")
Call<CheckAccmodation> checkAccomodation();
@GET("services/app/HajjRegistrationService/GetRoleCheck")
    Call<GetUserType> getUserById(@Query("UserId") int id,@Header("Authorization") String authorization);
}
