package capitalcryptoworld.capitalworld.com.hajjapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import capitalcryptoworld.capitalworld.com.hajjapp.Activity.Registration;
import capitalcryptoworld.capitalworld.com.hajjapp.Controller.RestManager;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.OperatorRegister;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.OperatorRegisterResponse;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RestManager restManager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restManager = new RestManager();
                OperatorRegister operatorRegister = new OperatorRegister("Fahad","333","admin",true,true);
                Call<OperatorRegisterResponse> call = restManager.getServices().CreateOperator(operatorRegister);
                call.enqueue(new Callback<OperatorRegisterResponse>() {
                    @Override
                    public void onResponse(Call<OperatorRegisterResponse> call, Response<OperatorRegisterResponse> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Register Sucessfully", Toast.LENGTH_LONG).show();


                        }

                        else{
                            //  Log.d("Error response",response.body().toString());
                            Toast.makeText(MainActivity.this, "Email or username already exist", Toast.LENGTH_LONG).show();

                            //mDialog.dismiss();
                        }



                    }

                    @Override
                    public void onFailure(Call<OperatorRegisterResponse> call, Throwable t) {
                        Log.d("Internet response",t.getMessage());

                        Toast.makeText(MainActivity.this, "There is no internet connection", Toast.LENGTH_LONG).show();


                    }
                });
            }
        });
    }
}
