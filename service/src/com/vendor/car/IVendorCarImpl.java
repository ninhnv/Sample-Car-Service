package com.vendor.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemProperties;
import vendor.car.*;
import android.hardware.automotive.vehicle.V2_0.*;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class IVendorCarImpl extends IVendorCar.Stub {
    private IVehicle mVehicle;

    public IVendorCarImpl() {
        try {
            mVehicle = android.hardware.automotive.vehicle.V2_0.IVehicle.getService();
        } catch (Exception e) {
            Log.e("VendorSampleService", "Failed to get IVehicle service", e);
        }
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    public int getSpeed() {
        final ValueResult Result = new ValueResult();
        VehiclePropValue vehicleProp = new VehiclePropValue();

        vehicleProp.prop = VehicleProperty.PERF_VEHICLE_SPEED;
        vehicleProp.areaId = VehicleArea.GLOBAL;
        vehicleProp.status = VehiclePropertyStatus.AVAILABLE;
        try {
            mVehicle.get(vehicleProp, (status, propValue) -> {
                Log.d("IVendorServiceImpl", String.format("Get Done %f", propValue.value.floatValues.get(0)));
                Result.status = status;
                Result.propValue = propValue;
            });

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return (int) Math.ceil(2.236936 * Result.propValue.value.floatValues.get(0));
    }

    private static class ValueResult {
        int status;
        VehiclePropValue propValue;
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.println("VendorServiceSample");
        switch (args[0]) {
            case "get_speed":
                try {
                    pw.println("Vehicle speed: " + getSpeed());
                } catch (Exception e) {
                    pw.println("Failed to get speed method in Vendor service");
                }
                break;

            case "get_config":
                try {
                    String pixel_config = SystemProperties.get("ro.minui.pixel_format","");
                    String vndk_version = SystemProperties.get("ro.vndk.version","");
                    pw.println("Pixel format: " + pixel_config);
                    pw.println("VNDK version: " + vndk_version);
                } catch (Exception e) {
                    pw.println("Failed to get speed method in Vendor service");
                }
                break;
            default:
                break;
        }
    }
}