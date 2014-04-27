package com.sac.care;

import com.sac.care.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        

    }
    
    public void login(View view){
    	startActivity(new Intent("android.intent.action.LOGIN"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	super.onCreateOptionsMenu(menu);
    	MenuInflater menuInflater =getMenuInflater();
    	menuInflater.inflate(R.menu.main_menu, menu);
    	return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	super.onOptionsItemSelected(item);
    	switch(item.getItemId()){
    	case R.id.menu_login:
    		
    		break;
    	case R.id.menu_register:
    		
    		break;
    	case R.id.menu_setting:
    		
    		break;
    	
    	}
    	return super.onOptionsItemSelected(item);
    }

}
