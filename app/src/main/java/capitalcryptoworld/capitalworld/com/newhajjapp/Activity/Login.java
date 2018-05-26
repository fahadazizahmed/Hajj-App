package capitalcryptoworld.capitalworld.com.hajjapp.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import capitalcryptoworld.capitalworld.com.hajjapp.Controller.RestManager;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.AuthToken;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.LoginModel;
import capitalcryptoworld.capitalworld.com.hajjapp.Model.Register;
import capitalcryptoworld.capitalworld.com.hajjapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText name;
    EditText password;
    TextView signUp;
    RestManager restManager;
    Button login;
    String myName;
    AlertDialog dialogBuilder;
    String myPasword;
    SharedPreferences spref;
    static String filename="my personal file";
    public static final String Value = "could not load data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        configView();
        spref=getSharedPreferences(filename,0);

        restManager = new RestManager();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////////////////
                myName = name.getText().toString();
                myPasword = password.getText().toString();


                if(myName.equals("") && myPasword.equals("")){
                    dialogBuilder = new AlertDialog.Builder(Login.this).create();
                    View customView = getLayoutInflater().inflate(R.layout.activity_password_change_dialogue, null);
                    TextView msgError  = (TextView) customView.findViewById(R.id.tx_msg1);
                    TextView msgError1  = (TextView) customView.findViewById(R.id.tx_msg2);
                    TextView errorDialog = (TextView)customView.findViewById(R.id.error_msg);

                    msgError.setText("Please enter your Usrname and password");

                    dialogBuilder.setView(customView);
                    dialogBuilder.show();
                }


                else  if(myName.equals(""))
                {
                    // Toast.makeText(LoginActivity.this,"Fill the email field",Toast.LENGTH_LONG).show();
                    dialogBuilder = new AlertDialog.Builder(Login.this).create();
                    View customView = getLayoutInflater().inflate(R.layout.activity_password_change_dialogue, null);
                    TextView msgError  = (TextView) customView.findViewById(R.id.tx_msg1);
                    TextView msgError1  = (TextView) customView.findViewById(R.id.tx_msg2);
                    TextView errorDialog = (TextView)customView.findViewById(R.id.error_msg);

                    msgError.setText("Please enter your Usrname");


                    dialogBuilder.setView(customView);
                    dialogBuilder.show();
                }
                else if(myPasword.equals(""))
                {
                    //Toast.makeText(LoginActivity.this,"Fill the password field",Toast.LENGTH_LONG).show();
                    dialogBuilder = new AlertDialog.Builder(Login.this).create();
                    View customView = getLayoutInflater().inflate(R.layout.activity_password_change_dialogue, null);
                    TextView msgError  = (TextView) customView.findViewById(R.id.tx_msg1);
                    TextView msgError1  = (TextView) customView.findViewById(R.id.tx_msg2);
                    TextView errorDialog = (TextView)customView.findViewById(R.id.error_msg);
                    msgError.setText("Please enter your password");
                    dialogBuilder.setView(customView);
                    dialogBuilder.show();

                }
                else {
                    new LoginNow().execute();
                }
            }
        });


    }

    public void cancel(View view){
        dialogBuilder.dismiss();
    }
    public void configView(){
        name = (EditText)findViewById(R.id.et_name);
        password = (EditText)findViewById(R.id.et_pass);
        login = (Button)findViewById(R.id.btn_sign);
        signUp = (TextView)findViewById(R.id.signup);


    }





    public class LoginNow extends AsyncTask<String,Integer,String>
    {
        private ProgressDialog mDialog;
        final SharedPreferences.Editor editor = spref.edit();

        LoginModel loginModel = new LoginModel(myName,myPasword);

        protected  void onPreExecute()
        {

            mDialog = ProgressDialog.show(Login.this,"Please wait...", "Login process ...", true);
        }
        @Override
        protected String doInBackground(String... strings) {
            Call<AuthToken> call = restManager.getServices().getToken(loginModel);
            call.enqueue(new Callback<AuthToken>() {
                @Override
                public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                    if (response.isSuccessful()) {
                        String token = response.body().getResult().getAccessToken();
                        Log.d("MyToken",token);
                        int id=  response.body().getResult().getUserId();
                        editor.putInt("Shared Data", 32);
                        editor.putString("Token",token);
                        editor.putInt("Id",id);
                        editor.commit();
                        mDialog.dismiss();
                        Intent intent = new Intent(Login.this,RegistrationOption.class);
                        startActivity(intent);


                    } else {
                        Toast.makeText(Login.this, "User name or Password is not correct", Toast.LENGTH_LONG).show();
                   mDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<AuthToken> call, Throwable t) {
                    Toast.makeText(Login.this,"Internet connection is not on",Toast.LENGTH_LONG).show();
                    mDialog.dismiss();
                }
            });
            return null;
        }
        protected void onPostExecute(String result) {

        }

    }















}
