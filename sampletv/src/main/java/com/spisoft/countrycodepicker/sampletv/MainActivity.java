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
    im.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final CountryCodePicker bb = new CountryCodePicker(MainActivity.this);
        CountryCodeDialog mm = new CountryCodeDialog(bb);
        mm.show();
        mm.setOnDismissListener(new DialogInterface.OnDismissListener() {
          @Override
          public void onDismiss(DialogInterface dialog) {
            bb.getSelectedCountryCode();
            im.setImageResource(CountryUtils.getFlagDrawableResId(bb.getmSelectedCountry()));
            Toast.makeText(MainActivity.this, bb.getSelectedCountryCode(), Toast.LENGTH_SHORT).show();
          }
        });
      }
    });

    CountryCodePicker ccp = findViewById(R.id.ccp);
    EditText edtPhone = findViewById(R.id.phone_number_edt);

    ccp.registerPhoneNumberTextView(edtPhone);
  }
}
