package com.spisoft.countrycodepicker.sampletv;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.spisoft.widget.countrycodepicker.CountryCodeDialog;
import com.spisoft.widget.countrycodepicker.CountryCodePicker;
import com.spisoft.widget.countrycodepicker.CountryUtils;

public class MainActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ImageView im = findViewById(R.id.im);


    final CountryCodePicker countryCodePicker = new CountryCodePicker(MainActivity.this);
    final CountryCodeDialog countryCodeDialog = new CountryCodeDialog(countryCodePicker);
    countryCodeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
      @Override
      public void onDismiss(DialogInterface dialog) {
        countryCodePicker.getSelectedCountryCode();
        im.setImageResource(CountryUtils.getFlagDrawableResId(countryCodePicker.getmSelectedCountry()));
        Toast.makeText(MainActivity.this, countryCodePicker.getSelectedCountryCode(), Toast.LENGTH_SHORT).show();
      }
    });

    im.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        countryCodeDialog.show();
      }
    });

    CountryCodePicker ccp = findViewById(R.id.ccp);
    EditText edtPhone = findViewById(R.id.phone_number_edt);

    ccp.registerPhoneNumberTextView(edtPhone);
  }
}
