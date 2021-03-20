package com.example.nntn;


import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
import java.util.Locale;

public class sms extends AppCompatActivity {

    Button buttonSend;
    EditText textPhoneNo;
    EditText textSMS;
    static jumun jm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
        textSMS = (EditText) findViewById(R.id.editTextSMS);

        //버튼 클릭이벤트
        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //입력한 값을 가져와 변수에 담는다
                String phoneNo = textPhoneNo.getText().toString();
                String sms = textSMS.getText().toString();

                try {
                    //전송
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms,null,null);
                    Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }

                

        });


        }
    public void get_btn(View view) {
        String shot = "아메리카노(ice) : " +"\n" + jm.ms.mshotnum + "잔" +" "+ (jm.ms.PRICE_SHOT * jm.ms.mshotnum) + "원";
        String ameice = "아메리카노(hot) : " +"\n"+ jm.ms.mshotnum2 + "잔" +" "+ (jm.ms.PRICE_COFFEE * jm.ms.mshotnum2) + "원";
        String hap = "수량 : " + (jm.ms.mshotnum + jm.ms.mshotnum2) + "잔";
        String formattedPrice = "합계 / "
                + NumberFormat.getCurrencyInstance(Locale.KOREA).format((jm.ms.PRICE_SHOT * jm.ms.mshotnum) + (jm.ms.PRICE_COFFEE * jm.ms.mshotnum2));
if (jm.ms.mshotnum > 0) {
    String message = shot + "\n"
            + ameice + "\n" +"\n"
            + hap + "\n"
            + formattedPrice + "\n";

    displayMessage(message);
}
else {
    String message = ameice + "\n"
            + shot + "\n"+"\n"
            + hap + "\n"
            + formattedPrice + "\n";

    displayMessage(message);
}
    }
    public void displayMessage(String message) {
        textSMS.setText(message);
    }
    public void back_btn(View view) {

        super.onBackPressed();

    }
}