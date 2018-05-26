package capitalcryptoworld.capitalworld.com.newhajjapp.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import capitalcryptoworld.capitalworld.com.newhajjapp.R;


public class RegistrationOption extends AppCompatActivity {
LinearLayout registerHajj;
LinearLayout accomodationPackage;
    SharedPreferences spref;
    static String filename="my personal file";
    public static final String Value = "could not load data";
    TextView textView;
    LinearLayout complainCervice;
    AlertDialog dialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_option);
        textView = (TextView)findViewById(R.id.acc_text);
        complainCervice = (LinearLayout)findViewById(R.id.btn_complain);
        registerHajj = (LinearLayout)findViewById(R.id.reg_hajj);
       // complainCervice.setEnabled(false);
       // accomodationPackage.setEnabled(false);



        spref=getSharedPreferences(filename, Context.MODE_PRIVATE);
       int accid= spref.getInt("Accomodation_Id",43);
       int key = spref.getInt("key",10);
       if(key == 5){

           if(accid == 0){



               accomodationPackage = (LinearLayout)findViewById(R.id.accomd_detail);
               accomodationPackage.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(RegistrationOption.this,ListAccomodation.class);
                       startActivity(intent);
                   }
               });




           }
           else{
               textView.setText("Get Accomodation Detail");

           }

           complainCervice.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(RegistrationOption.this,ComplaintForm.class);
                   startActivity(intent);
               }
           });


           registerHajj.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   dialogBuilder = new AlertDialog.Builder(RegistrationOption.this).create();
                   View customView = getLayoutInflater().inflate(R.layout.activity_password_change_dialogue, null);
                   TextView msgError  = (TextView) customView.findViewById(R.id.tx_msg1);
                   TextView msgError1  = (TextView) customView.findViewById(R.id.tx_msg2);
                   TextView errorDialog = (TextView)customView.findViewById(R.id.error_msg);
                   msgError.setText("You Already Register for Hajj");
                   dialogBuilder.setView(customView);
                   dialogBuilder.show();

               }
           });






       }
       else {

           registerHajj.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(RegistrationOption.this,RegistrationDetail.class);
                   startActivity(intent);
               }
           });



           accomodationPackage = (LinearLayout)findViewById(R.id.accomd_detail);
           accomodationPackage.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   dialogBuilder = new AlertDialog.Builder(RegistrationOption.this).create();
                   View customView = getLayoutInflater().inflate(R.layout.activity_password_change_dialogue, null);
                   TextView msgError  = (TextView) customView.findViewById(R.id.tx_msg1);
                   TextView msgError1  = (TextView) customView.findViewById(R.id.tx_msg2);
                   TextView errorDialog = (TextView)customView.findViewById(R.id.error_msg);
                   msgError.setText("Please Register for Hajj before");
                   dialogBuilder.setView(customView);
                   dialogBuilder.show();

               }
           });







        complainCervice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder = new AlertDialog.Builder(RegistrationOption.this).create();
                View customView = getLayoutInflater().inflate(R.layout.activity_password_change_dialogue, null);
                TextView msgError  = (TextView) customView.findViewById(R.id.tx_msg1);
                TextView msgError1  = (TextView) customView.findViewById(R.id.tx_msg2);
                TextView errorDialog = (TextView)customView.findViewById(R.id.error_msg);
                msgError.setText("You are not register for hajj");
                dialogBuilder.setView(customView);
                dialogBuilder.show();

            }
        });













    }
       Log.d("Ac+id",accid+"");



    }
    public void cancel(View view){
        dialogBuilder.dismiss();
    }
}
