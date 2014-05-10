package com.sac.care;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

@SuppressLint("NewApi") public class Login extends Activity{

	public SharedPreferences pref;
	public Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		 if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		MenuInflater menuInflater=getMenuInflater();
		menuInflater.inflate(R.menu.login_menu, menu);
				
		return super.onCreateOptionsMenu(menu);
	}
	
	
	public void home(View view){
		startActivity(new Intent("android.intent.action.MAIN"));
	}
	
	public void register(View view){
		startActivity(new Intent("android.intent.action.REGISTER"));
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.menu_logout:
			
			break;
		case R.id.menu_register1:
			
			break;
		case R.id.menu_setting1:
			
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	public void login(View view) throws JSONException{
		EditText userid=(EditText)findViewById(R.id.userid);
		EditText password=(EditText)findViewById(R.id.password);
		JSONService jSONService=new JSONService();
		JSONObject json=jSONService.login(userid.getText().toString(), password.getText().toString());
		System.out.println(json);
		if (null!= json){
			System.out.println("userId=="+ json.getString("userId"));
			if(null!=json.getString("userId")){
				pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
				editor = pref.edit();
				editor.putString("userId", json.getString("userId"));
			}
				
			startActivity(new Intent("android.intent.action.REGISTER"));
		}
		else
			startActivity(new Intent("android.intent.action.LOGIN"));
	}
	

}
