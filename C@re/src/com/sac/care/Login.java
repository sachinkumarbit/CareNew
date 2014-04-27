package com.sac.care;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.menu_logout:
			
			break;
		case R.id.menu_register:
			
			break;
		case R.id.menu_setting:
			
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	public void login(View view){
		EditText userid=(EditText)findViewById(R.id.userid);
		EditText password=(EditText)findViewById(R.id.password);
		JSONService jSONService=new JSONService();
		JSONObject json=jSONService.login(userid.getText().toString(), password.getText().toString());
		System.out.println(json);
		
	}
	

}