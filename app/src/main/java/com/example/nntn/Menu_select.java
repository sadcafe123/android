package com.example.nntn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import java.text.NumberFormat;
import java.util.Locale;
import com.google.zxing.integration.android.IntentIntegrator;
import android.widget.Button;
import android.widget.TextView;

public class Menu_select extends AppCompatActivity {
    public static int mshotnum = R.id.shotnum; //샷 수량
    public static int mshotnum2 = R.id.shotnum2; //아아 수량
    public static TextView shotnumview;
    public static TextView shotnumview2;
    public static int PRICE_SHOT = 1500;
    public static int PRICE_COFFEE = 1800;
    public static TextView mPriceTextView;
    public static TextView mPriceTextView2;
    public static TextView msumprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select);

        shotnumview = (TextView) findViewById(R.id.shotnum);
        shotnumview2 = (TextView) findViewById(R.id.shotnum2);
        mPriceTextView = (TextView) findViewById(R.id.pricetextview); //샷 가격
        mPriceTextView2 = (TextView) findViewById(R.id.pricetextview2); //아아 가격
        msumprice = (TextView) findViewById(R.id.HAPNUM); // 합계 가격
    }
    public void ju_btn(View view) {
        Intent intent = new Intent(this, jumun.class);
        startActivity(intent);
    }
    public void back_btn(View view) {

        super.onBackPressed();

    }

    public void chu_btn(View view) {

        super.onBackPressed();

    }



    public void plu_btn(View v) {
        mshotnum++;
        if (mshotnum > 50) {
            mshotnum = 0;

        }
        display(mshotnum);
        displayPrice(PRICE_SHOT * mshotnum);

    }

    public void mi_btn(View v) {
        mshotnum--;
        if (mshotnum < 0) {
            mshotnum = 0;

        }
        display(mshotnum);
        displayPrice(PRICE_SHOT * mshotnum);

    }

    public void plu_btn2(View v) {
        mshotnum2++;
        if (mshotnum2 > 50) {
            mshotnum2 = 0;

        }
        display2(mshotnum2);
        displayPrice2(PRICE_COFFEE * mshotnum2);

    }

    public void mi_btn2(View v) {
        mshotnum2--;
        if (mshotnum2 < 0) {
            mshotnum2 = 0;

        }
        display2(mshotnum2);
        displayPrice2(PRICE_COFFEE * mshotnum2);

    }
    //완료 누르면 합계 보여줌
    public void finish_btn(View view) {
        displayHap((PRICE_SHOT * mshotnum)+(PRICE_COFFEE * mshotnum2));
    }




    private void display(int number) { shotnumview.setText(""+number); }

    private void display2(int number) {
        shotnumview2.setText(""+number);
    }

    private void displayPrice(int number) { mPriceTextView.setText(NumberFormat.getCurrencyInstance(Locale.KOREA).format(number)); } //샷 가격 표시
    private void displayPrice2(int number) { mPriceTextView2.setText(NumberFormat.getCurrencyInstance(Locale.KOREA).format(number)); } //아아 가격 표시
    private void displayHap(int number) { msumprice.setText(NumberFormat.getCurrencyInstance(Locale.KOREA).format(number)); } //총 합계

}