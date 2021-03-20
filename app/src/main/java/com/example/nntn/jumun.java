package com.example.nntn;

import java.io.File;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.Hashtable;
import java.util.Locale;

import com.google.zxing.EncodeHintType;
import com.google.zxing.integration.android.IntentIntegrator;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class jumun extends AppCompatActivity {
    private static final String TAG = jumun.class.getSimpleName();
    public TextView mjumun;
    static Menu_select ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumun);
        mjumun = (TextView) findViewById(R.id.ljumun);
    }
public void ejumun_btn(View v) {
    if (ms.mshotnum > 0) {
        String shot = "아메리카노(ice) : " +"\n"+ ms.mshotnum + "잔" +" "+ (ms.PRICE_SHOT * ms.mshotnum) + "원";
        String ameice = "아메리카노(hot) : " +"\n"+ ms.mshotnum2 + "잔" +" "+ (ms.PRICE_COFFEE * ms.mshotnum2) + "원"+"\n"+"\n";
        String hap = "수량 : " + (ms.mshotnum + ms.mshotnum2) + "잔";
        String formattedPrice = "합계 / "
                + NumberFormat.getCurrencyInstance(Locale.KOREA).format((ms.PRICE_SHOT * ms.mshotnum) + (ms.PRICE_COFFEE * ms.mshotnum2));

        String message = shot + "\n"
                + ameice + "\n"
                + hap + "\n"
                + formattedPrice + "\n";

        displayMessage(message);
        }
    else{

        String ameice = "아메리카노(hot) : " +"\n"+ ms.mshotnum2 + "잔" +" "+ (ms.PRICE_COFFEE * ms.mshotnum2) + "원";
        String shot = "아메리카노(ice) : " +"\n"+ ms.mshotnum + "잔" +" "+ (ms.PRICE_SHOT * ms.mshotnum) + "원"+"\n"+"\n";
        String hap = "수량 : " + (ms.mshotnum + ms.mshotnum2) + "잔";
        String formattedPrice = "합계 / "
                + NumberFormat.getCurrencyInstance(Locale.KOREA).format((ms.PRICE_SHOT * ms.mshotnum) + (ms.PRICE_COFFEE * ms.mshotnum2));

        String message = ameice + "\n"
                + shot + "\n"
                + hap + "\n"
                + formattedPrice + "\n";

        displayMessage(message);
    }
    }
    public void displayMessage(String message) {
        mjumun.setText(message);
    }
    public void main_btn(View view) {
        super.onBackPressed();
    }
    public void mkcode_btn(View v){
        ImageView iv;
         

            iv = (ImageView)findViewById(R.id.qrcode);


            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try{
                Hashtable hints = new Hashtable();
                hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
                BitMatrix bitMatrix = (BitMatrix) multiFormatWriter.encode((String)mjumun.getText(), BarcodeFormat.QR_CODE,200,200,hints);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                iv.setImageBitmap(bitmap);
            }catch (Exception e){}
        }
    public void trans_btn(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    }



