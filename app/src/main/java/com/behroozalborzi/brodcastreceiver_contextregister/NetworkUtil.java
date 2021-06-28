package com.behroozalborzi.brodcastreceiver_contextregister;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Behrooz on 6/28/2021.
 * https://behroozalborzi.ir
 * Android Developer
 * Thank you ... :)
 */
public class NetworkUtil {

        public static boolean isNetworkConnected(Context context) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
        }
}
