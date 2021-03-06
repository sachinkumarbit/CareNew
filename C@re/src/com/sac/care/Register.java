package com.sac.care;

import org.json.JSONArray;
import org.json.JSONException;
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
	
	public void home(View view){
		startActivity(new Intent("android.intent.action.MAIN"));
	}
	
	
	public void info(View view){
		startActivity(new Intent("android.intent.action.INFO"));
	}
	public void logout(View view){
		startActivity(new Intent("android.intent.action.LOGOUT"));
	}

	public void reset(View view){
		startActivity(new Intent("android.intent.action.REGISTER"));
	}
	public void register(View view) throws JSONException{
		EditText EmployeeId=(EditText)findViewById(R.id.EmployeeId);
		EditText EmployeeName=(EditText)findViewById(R.id.EmployeeName);
		EditText EmailId=(EditText)findViewById(R.id.EmailId);
		EditText Mobile=(EditText)findViewById(R.id.Mobile);
		EditText AMobile=(EditText)findViewById(R.id.AMobile);
		EditText Address1=(EditText)findViewById(R.id.Address1);
		EditText Address2=(EditText)findViewById(R.id.Address2);
		Spinner bloodGroup=(Spinner)findViewById(R.id.bloodGroup);
		
		String employeeId = EmployeeId.getText().toString();
		String employeeName = EmployeeName.getText().toString();
		String emailId = EmailId.getText().toString();
		String mobile = Mobile.getText().toString();
		String aMobile = AMobile.getText().toString();
		String address1 = Address1.getText().toString();
		String address2 = Address2.getText().toString();
		address1=address1+address2;
		String blood_group = bloodGroup.getSelectedItem().toString();
		
		if(null==employeeId || "".equals(employeeId) ){
			Toast.makeText(getApplicationContext(), " please enter  a valid employee id...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==employeeName || "".equals(employeeName)){
			Toast.makeText(getApplicationContext(), " please enter  a valid employee name...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==emailId || "".equals(emailId)){
			Toast.makeText(getApplicationContext(), " please enter  a valid email id...",
					   Toast.LENGTH_LONG).show();
				}
		else if(null==mobile || "".equals(mobile)){
			Toast.makeText(getApplicationContext(), " please enter  a valid mobile number...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==aMobile || "".equals(aMobile)){
			Toast.makeText(getApplicationContext(), " please enter  a valid alertnative mobile number...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==address1 || "".equals(address1)){
			Toast.makeText(getApplicationContext(), " please enter  a valid address...",
					   Toast.LENGTH_LONG).show();
		}
		else if(null==blood_group ){
			Toast.makeText(getApplicationContext(), " please enter  a valid blood group...",
					   Toast.LENGTH_LONG).show();
		}else{
			JSONService jsonService= new JSONService();
			System.out.println("json_registration1==== "+ employeeId +" ," + employeeName+" ," + emailId +" ,"+ mobile+" ," + aMobile +" ," + address1 +" ," + blood_group);
			JSONObject json1= jsonService.register(employeeId, employeeName, emailId, mobile, aMobile, address1, blood_group);
			System.out.println("json_registration2==== "  +json1 );
			SMS sms=new SMS();
			sms.sendSMS("8904033448", "hello..");
			System.out.println("json_registration2==== "  +json1 );
			
			if(null != json1 && "true".equals(json1.getString("success"))){
				System.out.println(json1.get("0"));
				String s="";
				for(int i=0;i< (json1.length()-1);i++){
					s=""+i;
					System.out.println(json1.getString(s));
				}
				
			}
			startActivity(new Intent("android.intent.action.SUCCESS"));

		}
			
	}
}
