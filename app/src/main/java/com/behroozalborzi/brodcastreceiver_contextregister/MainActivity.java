package com.behroozalborzi.brodcastreceiver_contextregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewBroadCastConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewBroadCastConnect = findViewById(R.id.tv_main_broadCast_connection);
        checkInternetConnection();
        registerReceiver(broadcastReceiver,new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));



    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkInternetConnection();
        }
    } ;
    public void checkInternetConnection(){
        if (NetworkUtil.isNetworkConnected(this)){
            textViewBroadCastConnect.setText("Connection To Internet");
        }else {
            textViewBroadCastConnect.setText("Not Connection To Internet");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}