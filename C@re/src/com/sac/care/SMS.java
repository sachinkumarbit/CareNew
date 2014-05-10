package com.sac.care;
import android.telephony.SmsManager;


public class SMS {

        /**
         * @param args
         */
        public static void main(String[] args) {}
        
        public void sendSMS(String phoneNo, String sms){
        	SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, sms, null, null);
        }
        
        
}