package capitalcryptoworld.capitalworld.com.newhajjapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import capitalcryptoworld.capitalworld.com.newhajjapp.Model.AccomodationList;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.AllAccomodation;
import capitalcryptoworld.capitalworld.com.newhajjapp.R;

public class DetailAccomodationActivity extends AppCompatActivity {
    TextView name,phn,price,available,location;
    SharedPreferences spref;
    static String filename="my personal file";
    public static final String Value = "could not load data";
    Button selectPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_accomodation);
        spref=getSharedPreferences(filename,0);
        final SharedPreferences.Editor editor = spref.edit();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        AllAccomodation allAccomodation = (AllAccomodation) intent.getSerializableExtra("value");
        name = (TextView)findViewById(R.id.tx_name);
        phn = (TextView)findViewById(R.id.tx_contact);
        price = (TextView)findViewById(R.id.tx_price);
        location = (TextView)findViewById(R.id.tx_location);
        available = (TextView)findViewById(R.id.tx_availabe);
        selectPackage = (Button)findViewById(R.id.btn_sign);

        int ids = allAccomodation.getId();

        name.setText(allAccomodation.getName().toString());
        phn.setText(allAccomodation.getContact()+"");
        price.setText(allAccomodation.getPrice());
        available.setText(allAccomodation.getAvailable()+"");
        location.setText(allAccomodation.getLocation());
        editor.putInt("AccomodationId",ids);
        editor.commit();

        spref=getSharedPreferences(filename, Context.MODE_PRIVATE);//this file only aceess your app

        int type=spref.getInt("AccomodationId",23);
        Log.d("show id",type+"");
        selectPackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}
