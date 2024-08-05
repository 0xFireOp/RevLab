#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_fr_fireop_revlab_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    const char* tagStr = "LAB_CPP";
    const char* messageStr = "Message from C++";

    // convert Cpp String to Java String
    jstring tag = env->NewStringUTF(tagStr);
    jstring message = env->NewStringUTF(messageStr);

    // call log.d()
    jclass logClass = env->FindClass("android/util/Log");
    jmethodID logMethod = env->GetStaticMethodID(logClass, "v", "(Ljava/lang/String;Ljava/lang/String;)I");
    env->CallStaticIntMethod(logClass, logMethod, tag, message);


    return env->NewStringUTF(hello.c_str());
}
