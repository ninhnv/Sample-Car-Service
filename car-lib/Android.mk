#LOCAL_PATH := $(call my-dir)
# Build the library
#include $(CLEAR_VARS)
#LOCAL_MODULE_TAGS := optional
#LOCAL_MODULE := vendor.car
#LOCAL_SRC_FILES := $(call all-java-files-under,.)
#LOCAL_SRC_FILES += src/vendor/car/IVendorCar.aidl
#include $(BUILD_JAVA_LIBRARY)

# Copy vendor_car.xml to /system/etc/permissions/
#include $(CLEAR_VARS)
#LOCAL_MODULE_TAGS := optional
#LOCAL_MODULE := vendor_car.xml
#LOCAL_MODULE_CLASS := ETC
#LOCAL_MODULE_PATH := $(TARGET_OUT_ETC)/permissions
#LOCAL_SRC_FILES := $(LOCAL_MODULE)
#include $(BUILD_PREBUILT)
