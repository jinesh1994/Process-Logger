#include <jni.h>
#include <stdio.h>
#include <unistd.h>
#include "JNIDemoJava.h"

JNIEXPORT double JNICALL Java_jnidemojava_Main_nativePrint (JNIEnv *env, jobject obj)
{
    //printf("\nNo of clock ticks per second is %llu\n",sysconf(_SC_CLK_TCK));
    return sysconf(_SC_CLK_TCK);

}
