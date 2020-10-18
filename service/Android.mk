LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under,src)

LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res

LOCAL_PACKAGE_NAME := VendorSampleService

LOCAL_PRIVATE_PLATFORM_APIS := true

LOCAL_PROGUARD_ENABLED := disabled

LOCAL_CERTIFICATE := platform

LOCAL_PRIVILEGED_MODULE := true

LOCAL_PRODUCT_MODULE := true

LOCAL_REQUIRED_MODULES := vendor.car

LOCAL_JAVA_LIBRARIES := vendor.car \
    framework \
    android.car

LOCAL_STATIC_JAVA_LIBRARIES := \
    android.hardware.automotive.vehicle-V2.0-java

include $(BUILD_PACKAGE)
