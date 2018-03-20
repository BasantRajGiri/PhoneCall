package com.example.giri.phonecall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.buttonPhoneCall);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                //intent.setData(Uri.parse("tel:123456789"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {

                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

    }



    public void createEmail(View view) {


        if (view.getId() == R.id.buttonemail) {
            Intent send = new Intent(Intent.ACTION_SEND);
            send.setData(Uri.parse("mailto:"));

            String to[] = {"basantrajgiri22@gmail.com"};

            send.putExtra(Intent.EXTRA_EMAIL, to);
            send.putExtra(Intent.EXTRA_SUBJECT, "Hello this was send from my Fucking APP");
            send.putExtra(Intent.EXTRA_TEXT, "hey you this is me basanta raj giri which is done" +
                    " for all that i am just learning the android");
            send.setType("message/rfc822");
            startActivity(Intent.createChooser(send, "Send Email"));


        }
        if(view.getId() == R.id.buttonSms){

            Intent sms = new Intent(Intent.ACTION_VIEW);
            sms.setData(Uri.fromParts("sms","01705001486" , null));

                     //OR
           //  Intent smss = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01705001486" , null));

            sms.putExtra("sms_body" , "Hello fucking  ");
            startActivity(sms);
        }
    }

// this is just for checking whether the git hub is working or not
    //jghdfhgfd d d hsd testing testing


}

