package capitalcryptoworld.capitalworld.com.hajjapp.Controller;

import capitalcryptoworld.capitalworld.com.hajjapp.ApiInterface.HajjInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fahad Aziz on 16/05/2018.
 */

public class RestManager {
    HajjInterface hajjInterface;
    String BASE_URL = "http://testingservice12.azurewebsites.net/api/";//write ipconfig on command line and write ipv4 address is here
    //String BASE_URL = "http://192.168.0.122:503/";
    public  HajjInterface getServices(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        hajjInterface = retrofit.create(HajjInterface.class);
        return  hajjInterface ;
    }

}
