package vendor.car;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.Slog;
import java.util.HashSet;
import java.util.Set;

public class VendorCarExampleManager {
    private static final String REMOTE_SERVICE_NAME = "vendor_car_service";
    private final IVendorCar service;

    public static VendorCarExampleManager getInstance() {
        return new VendorCarExampleManager();
    }

    public int add(int a,int b) {
        try {
            return service.add(a,b);
        }catch(Exception ec){}
        return 0;
    }

    public int sub(int a,int b) {
        try {
            return service.sub(a,b);
        }catch(Exception ec){}
        return 0;
    }

    private VendorCarExampleManager() {
        this.service = IVendorCar.Stub.asInterface(
                ServiceManager.getService(REMOTE_SERVICE_NAME));
        if (this.service == null) {
            throw new IllegalStateException("Failed to find ISampService by name [" + REMOTE_SERVICE_NAME + "]");
        }
    }
}