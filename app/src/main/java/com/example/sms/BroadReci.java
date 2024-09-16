package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class BroadReci extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        Object[]smsObj= (Object[]) bundle.get("pdus");
        for(Object obj:smsObj){
            SmsMessage message=SmsMessage.createFromPdu((byte[])obj);
            String mob=message.getDisplayOriginatingAddress();
            String mess= message.getDisplayMessageBody();
            Log.d("SMS_BODY","MOB no"+mob+"MSG"+mess);
            SmsManager smsMana=SmsManager.getDefault();
            smsMana.sendTextMessage("+916260582151",null,"Helloooooooooooooooooo",null,null);
        }

    }
}
