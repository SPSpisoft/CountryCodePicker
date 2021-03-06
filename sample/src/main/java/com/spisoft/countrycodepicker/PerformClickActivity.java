package com.spisoft.countrycodepicker;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.spisoft.widget.countrycodepicker.CountryCodePicker;

public class PerformClickActivity extends AppCompatActivity {


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_perform_click);

    final CountryCodePicker ccp = findViewById(R.id.ccp);
    Button btnPerformClick = findViewById(R.id.perform_click_btn);
    btnPerformClick.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ccp.performClick();
      }
    });
  }
}
