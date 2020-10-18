package com.vendor.car;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;

public class VendorCarService extends Application {
    private static final String REMOTE_SERVICE_NAME = "vendor_car_service";
    private IVendorCarImpl serviceImpl;

    public void onCreate() {
        super.onCreate();
        this.serviceImpl = new IVendorCarImpl();
        try {
            ServiceManager.addService(REMOTE_SERVICE_NAME, this.serviceImpl);
        } catch (Exception ex) {
            Log.e("VendorCarService", "Could not add service to ServiceManager");
        }
    }

    public void onTerminate() {
        super.onTerminate();
    }
}