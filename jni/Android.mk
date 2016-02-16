LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE:= ifttt

LOCAL_SRC_FILES:=  ifttt.c 

LOCAL_SHARED_LIBRARIES := \
LOCAL_REQUIRED_MODULES := \
    

LOCAL_STATIC_LIBRARIES := \


LOCAL_CFLAGS += -g

LOCAL_LDLIBS :=  -lm -llog -ldl
 



include $(BUILD_SHARED_LIBRARY)
