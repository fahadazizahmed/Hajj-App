package capitalcryptoworld.capitalworld.com.newhajjapp.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;


import capitalcryptoworld.capitalworld.com.newhajjapp.Controller.RestManager;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.HajjRegisterResponse;
import capitalcryptoworld.capitalworld.com.newhajjapp.Model.RegisteHajjUser;
import capitalcryptoworld.capitalworld.com.newhajjapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationDetail extends AppCompatActivity {
    EditText province,dateOfBirth,gender,phone,address,cnicPicture,passportPicture;
    Button registerHajj;
    String userProvince,userdateOfBirht,userGender,userPhone,userAddress,ImageDecode,ImageDecodes,passPic,cnicPic;
    RestManager restManager;
    SharedPreferences spref;
    static String filename="my personal file";
    public static final String Value = "could not load data";
    RegisteHajjUser registeHajjUser;
    String  token,concateStringWithToken,authHeader;
    ImageView imageViewDate,imageViewCnic,imageViewPassport;
     DatePicker datePicker;
     Calendar calendar;
     int year, month, day;
    private static int IMG_RESULT = 1;
    private static int IMG_RESULT1 = 2;

    int compressionRatio = 2;
    Bitmap photo;
    Bitmap photos;
    byte[] imgByte;
    RadioButton radioButton1;
    RadioButton radioButton2;

    File finalFile;
    private Uri fileUri;
    String selectedGender;
    String date;
    SharedPreferences.Editor editor;




    RadioGroup radioGroup;



















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_detail);
        configVar();
        restManager = new RestManager();
        //Select Date

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        imageViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(999);

            }
        });
        ///////////

        //Select Cnic Image
        imageViewCnic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMG_RESULT);
            }
        });
// Select Passport image
        imageViewPassport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMG_RESULT1);
            }
        });







        ////////












        registerHajj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValue();

                spref=getSharedPreferences(filename, Context.MODE_PRIVATE);//this file only aceess your app
                editor = spref.edit();
                token = spref.getString("Token", Value);
                Log.d("new Token",token);
                new HajjUserRegister().execute();
            }
        });
    }

    void configVar() {
        province = (EditText)findViewById(R.id.et_province);
        dateOfBirth = (EditText)findViewById(R.id.et_dob);
        phone = (EditText)findViewById(R.id.et_phnNumber);
        address = (EditText)findViewById(R.id.et_address);
        cnicPicture = (EditText)findViewById(R.id.et_cnic);
        passportPicture = (EditText)findViewById(R.id.et_passPicture);

        registerHajj = (Button)findViewById(R.id.btn_registerHajj);

        imageViewDate = (ImageView)findViewById(R.id.img_date);
        imageViewCnic = (ImageView)findViewById(R.id.img_cnic);
        imageViewPassport = (ImageView)findViewById(R.id.img_passport);

        radioGroup=(RadioGroup) findViewById(R.id.radio_group);


        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        if(radioButtonID == R.id.rd_male){
            radioButton1 = (RadioButton) radioGroup.findViewById(R.id.rd_male);
             selectedGender = (String) radioButton1.getText();
        }
        else if(radioButtonID == R.id.rd_female){
            radioButton2 = (RadioButton) radioGroup.findViewById(R.id.rd_female);
             selectedGender = (String) radioButton2.getText();
        }





















    }
    void getValue(){
       userProvince =  province.getText().toString();
        userdateOfBirht= dateOfBirth.getText().toString();

         userPhone = phone.getText().toString();
        userAddress = address.getText().toString();
        passPic = passImageToString();
        cnicPic = imageToString();


    }



  //////////

    public class HajjUserRegister extends AsyncTask<String,Integer,String>
    {


        private ProgressDialog mDialog;






        protected  void onPreExecute()
        {

            concateStringWithToken = "Bearer";
            authHeader = concateStringWithToken+" "+token;
            registeHajjUser = new RegisteHajjUser(selectedGender,userAddress,userPhone,userProvince,cnicPic,passPic);

            mDialog = ProgressDialog.show(RegistrationDetail.this,"Please wait...", "Registration is in process ...", true);
        }
        @Override
        protected String doInBackground(String... strings) {
            Log.d("Body",registeHajjUser+"");
            Log.d("MyNewctoek",token);
            Call<HajjRegisterResponse> call = restManager.getServices().registerHajjUser(authHeader,registeHajjUser);
            call.enqueue(new Callback<HajjRegisterResponse>() {
                @Override
                public void onResponse(Call<HajjRegisterResponse> call, Response<HajjRegisterResponse> response) {
                   if(response.isSuccessful()){
                       HajjRegisterResponse hajjRegisterResponse = response.body();
                       Log.d("sucess respnse",hajjRegisterResponse.isSuccess()+"");
                        Toast.makeText(RegistrationDetail.this, "Register for hajj Sucessfully", Toast.LENGTH_LONG).show();
                        editor.putInt("key",5);
                        editor.commit();
                        mDialog.dismiss();

                    }


                    else{

                        Toast.makeText(RegistrationDetail.this, "User Already Exist", Toast.LENGTH_LONG).show();

                        mDialog.dismiss();
                    }



                }

                @Override
                public void onFailure(Call<HajjRegisterResponse> call, Throwable t) {
                    Log.d("Internet response",t.getMessage());

                    Toast.makeText(RegistrationDetail.this, "There is no internet connection", Toast.LENGTH_LONG).show();
                    mDialog.dismiss();


                }
            });


            return null;
        }
        protected void onPostExecute(String result) {

        }

    }






    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
         date = day+"/"+month+"/"+year;
        Log.d("todya date",date);

        dateOfBirth.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));




    }



    ///////////

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                    && null != data) {
                //  photo = (Bitmap) data.getExtras().get("data");


                Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecode = cursor.getString(columnIndex);//this is the path of the  image

                cursor.close();


                //imageView.setImageBitmap(BitmapFactory
                //  .decodeFile(ImageDecode));
                photo = BitmapFactory.decodeFile(ImageDecode);

                cnicPicture.setText(ImageDecode);
                Uri tempUri = getImageUri(RegistrationDetail.this, photo);
                finalFile = new File(getRealPathFromURI(tempUri));

            }

            else if (requestCode == IMG_RESULT1 && resultCode == RESULT_OK
                    && null != data) {

                //  photo = (Bitmap) data.getExtras().get("data");


               Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecodes = cursor.getString(columnIndex);//this is the path of the  image


                passportPicture.setText(ImageDecodes);
                cursor.close();


                //imageView.setImageBitmap(BitmapFactory
                //  .decodeFile(ImageDecode));
                photos = BitmapFactory.decodeFile(ImageDecodes);



                Uri tempUri = getImageUri(RegistrationDetail.this, photos);
                finalFile = new File(getRealPathFromURI(tempUri));

            }





















        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }

    }





























/////////////


    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.PNG, compressionRatio, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    private String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imgByte = byteArrayOutputStream.toByteArray();//this is the real image you
        Log.d("im",imgByte+"");
        return Base64.encodeToString(imgByte,Base64.DEFAULT);

    }

    private String passImageToString(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        photos.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imgByte = byteArrayOutputStream.toByteArray();//this is the real image you
        Log.d("im",imgByte+"");
        return Base64.encodeToString(imgByte,Base64.DEFAULT);

    }






















}
