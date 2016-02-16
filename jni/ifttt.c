#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <stdint.h>
#include <assert.h>
#include <pthread.h>
#include <jni.h>
#include <android/log.h>



//#define
#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, "libfingerprint", __VA_ARGS__))
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "libfingerprint", __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, "libfingerprint", __VA_ARGS__))
#define LOGE(...) ((void)__android_log_print(ANDROID_LOG_ERROR, "libfingerprint", __VA_ARGS__))
static const char* const kClassPathName =
		"com/albert/ifttt/jni/main_jni";

/**
 * ��Java�е�Stringת����c�е�char�ַ���
 */
char *Jstring2CStr(JNIEnv *env, jstring jstr) {
    char *rtn = NULL;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String"); //String
    jstring strencode = (*env)->NewStringUTF(env, "GB2312"); // �õ�һ��java�ַ��� "GB2312"
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes",
                                        "(Ljava/lang/String;)[B"); //[ String.getBytes("gb2312");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid,
                                                           strencode); // String .getByte("GB2312");
    jsize alen = (*env)->GetArrayLength(env, barr); // byte����ĳ���
    jbyte *ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1); //""
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba, 0); //
    return rtn;
}


JNIEXPORT jint JNICALL
Java_com_albert_ifttt_jni_mainjni_forkthread(
		JNIEnv* env, jclass thiz, jstring serviceName, jint sdkVersion) {
	 char *name = Jstring2CStr(env, serviceName);
	//fork�ӽ��̣���ִ����ѯ����
	    pid_t pid = fork();
	    __android_log_print(ANDROID_LOG_DEBUG, "NativeInit","fork=%d", pid);
	    if (pid < 0) {
	// forkʧ����
	    } else if (pid == 0) {
	// ����һֱ����һֱ�ж��ļ��Ƿ���ڵķ�ʽȥ�жϣ���������Ч���Եͣ�����ʹ�ü����ķ�ʽ����ѭ����ÿ��һ���ж�һ�Σ�����̫�˷���Դ�ˡ�
	        int check = 1;
	        while (check) {
	            pid_t ppid = getppid();
	            __android_log_print(ANDROID_LOG_DEBUG, "NativeInit","pid=%d", getpid());
	            __android_log_print(ANDROID_LOG_DEBUG, "NativeInit","ppid=%d", ppid);
	            if (ppid == 1) {
	                LOGI("ppid == 1");
	                if (sdkVersion >= 17) {
	                    LOGI("> 17");
	                    int ret = execlp("am", "am", "startservice", "--user", "0",
	                                     "-n", name,
	                                     (char *) NULL);
	                } else {
	                    execlp("am", "am", "startservice", "-n",
	                           name,
	                           (char *) NULL);
	                    LOGI("else");
	                }
	                check = 0;
	            } else {
	            }
	            sleep(1);
	        }
	    } else {
	        LOGI("parent .. pid=%d", pid);
	//������ֱ���˳���ʹ�ӽ��̱�init�����������Ա����ӽ��̽���
	    }

		return 0;


}


