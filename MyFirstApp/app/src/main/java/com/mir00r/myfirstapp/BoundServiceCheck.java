package com.mir00r.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class BoundServiceCheck extends Service {

    private final IBinder iBinder = new LocalBinder();
    private final Random nGenerator = new Random();


    public class LocalBinder extends Binder {
        BoundServiceCheck getService () {
            return BoundServiceCheck.this;
        }
    }

    public BoundServiceCheck() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return iBinder;
    }

    public int getRandomNum() {
        return nGenerator.nextInt(200);
    }
}
