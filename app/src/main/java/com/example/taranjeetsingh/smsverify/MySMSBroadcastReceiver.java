package com.example.taranjeetsingh.smsverify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

/**
 * Created by Taranjeet Singh on 06-Jan-19.
 */
public class MySMSBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            Status status = (Status) extras.get(SmsRetriever.EXTRA_STATUS);

            switch (status.getStatusCode()) {
                case CommonStatusCodes.SUCCESS:
                {// Get SMS message contents
                    final String message = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            Toast.makeText(context, "Success:: " + message, Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Extract one-time code from the message and complete verification
                    // by sending the code back to your server.
                    Log.e("TAG:: ", "Success Error");
                    break;}
                case CommonStatusCodes.TIMEOUT:
                {// Waiting for SMS timed out (5 minutes)
                    // Handle the error ..
                    Log.e("TAG:: ", "Timeout Error");

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            Toast.makeText(context, "Failure:: ", Toast.LENGTH_SHORT).show();
                        }
                    });

                    break;}
            }
        }
    }
}
