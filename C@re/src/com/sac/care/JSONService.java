package com.sac.care;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class JSONService {
	public JSONObject login(String userid, String password){
		JSONObject json;
		
		List<NameValuePair> data= new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("userId",userid ));
		data.add(new BasicNameValuePair("password", password));
		
		JSONParser jsonParser= new JSONParser();
		json=jsonParser.getJSONFromUrl("http://sachinkumar.site90.com/login.php", data);
		return json;
			
	}

}
