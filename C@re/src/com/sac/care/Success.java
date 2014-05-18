package com.sac.care;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

public class Success extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
		Toast.makeText(getApplicationContext(), "Thanks for the registration and peolple will get back to you ...", Toast.LENGTH_LONG).show();
		if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
	}

	public void login(View view){
    	startActivity(new Intent("android.intent.action.LOGIN"));
    }
	
	public void home(View view){
		startActivity(new Intent("android.intent.action.MAIN"));
	}
	
	
	public void register(View view){
		startActivity(new Intent("android.intent.action.REGISTER"));
	}
	public void logout(View view){
		startActivity(new Intent("android.intent.action.LOGOUT"));
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	

}
