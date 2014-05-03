package com.sac.care;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends Activity{

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		 if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	

	public void reset(View view){
		startActivity(new Intent("android.intent.action.REGISTER"));
	}
	public void register(View view){
		EditText EmployeeId=(EditText)findViewById(R.id.EmployeeId);
		EditText EmployeeName=(EditText)findViewById(R.id.EmployeeName);
		EditText EmailId=(EditText)findViewById(R.id.EmailId);
		EditText Mobile=(EditText)findViewById(R.id.Mobile);
		EditText AMobile=(EditText)findViewById(R.id.AMobile);
		EditText Address=(EditText)findViewById(R.id.Address);
		Spinner bloodGroup=(Spinner)findViewById(R.id.bloodGroup);
		
		String employeeId = EmployeeId.getText().toString();
		String employeeName = EmployeeName.getText().toString();
		String emailId = EmailId.getText().toString();
		String mobile = Mobile.getText().toString();
		String aMobile = AMobile.getText().toString();
		String address = Address.getText().toString();
		String blood_group = bloodGroup.getSelectedItem().toString();
		
		if(null==employeeId && "".equals(employeeId) ){
			Toast.makeText(getApplicationContext(), " please enter  a valid employee id...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==employeeName && "".equals(employeeName)){
			Toast.makeText(getApplicationContext(), " please enter  a valid employee name...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==emailId && "".equals(emailId)){
			Toast.makeText(getApplicationContext(), " please enter  a valid email id...",
					   Toast.LENGTH_LONG).show();
				}
		else if(null==mobile && "".equals(mobile)){
			Toast.makeText(getApplicationContext(), " please enter  a valid mobile number...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==aMobile && "".equals(aMobile)){
			Toast.makeText(getApplicationContext(), " please enter  a valid alertnative mobile number...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==address && "".equals(address)){
			Toast.makeText(getApplicationContext(), " please enter  a valid address...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==blood_group ){
			Toast.makeText(getApplicationContext(), " please enter  a valid blood group...",
					   Toast.LENGTH_LONG).show();
		}else{
			JSONService jsonService= new JSONService();
			JSONObject json= jsonService.register(employeeId, employeeName, emailId, mobile, aMobile, address, blood_group  );
			System.out.println("json_registration==== "  +json );
			startActivity(new Intent(""));
		}
			
	}
}
