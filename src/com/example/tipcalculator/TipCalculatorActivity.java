package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		final Button btnCalculate10 = (Button) findViewById(R.id.btnCalculate10);
		final Button btnCalculate15 = (Button) findViewById(R.id.btnCalculate15);
		final Button btnCalculate20 = (Button) findViewById(R.id.btnCalculate20);
		
		btnCalculate10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateTip(10);
            }
        });
		
		btnCalculate15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateTip(15);
            }
        });
		
		btnCalculate20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateTip(20);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void calculateTip(int percent){
		EditText textViewResult = (EditText) findViewById(R.id.textViewResult);
		EditText editTextTotalBill = (EditText) findViewById(R.id.editTextTotalBill);
		
		String value = textViewResult.getText().toString();
		float val = Float.parseFloat(value);
		val = (float) percent/100 * val;
		editTextTotalBill.setText(String.valueOf(val));
		
		InputMethodManager imm = (InputMethodManager)getSystemService(
			      Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(textViewResult.getWindowToken(), 0);
	}
}
