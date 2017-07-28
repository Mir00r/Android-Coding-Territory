package com.mir00r.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by razza_000 on 24-Jul-17.
 */

public class ServiceCheck extends Service {

    final class CheckThread implements Runnable {

        int serviceId;

        public CheckThread(int serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(this.serviceId);
            }
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        Toast.makeText(ServiceCheck.this, "Service is Starting", Toast.LENGTH_LONG).show();

//        synchronized (this) {
//            try {
//                wait(20000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Thread thread = new Thread(new CheckThread(startId));
        thread.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        //super.onDestroy();
        Toast.makeText(ServiceCheck.this, "Service is Stopping", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
