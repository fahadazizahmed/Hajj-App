package capitalcryptoworld.capitalworld.com.hajjapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import capitalcryptoworld.capitalworld.com.hajjapp.R;

public class RegistrationOption extends AppCompatActivity {
LinearLayout registerHajj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_option);
        registerHajj = (LinearLayout)findViewById(R.id.reg_hajj);
        registerHajj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationOption.this,RegistrationDetail.class);
                startActivity(intent);
            }
        });
    }
}
