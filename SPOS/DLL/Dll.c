#include <jni.h>
#include "Dll.h"

JNIEXPORT jint JNICALL Java_Dll_sum
  (JNIEnv *ds, jobject dtggt, jint a, jint b)
  { return a+b;}
  
JNIEXPORT jint JNICALL Java_Dll_dif
  (JNIEnv *sa, jobject as, jint a, jint b)
  {return a-b;}
  
JNIEXPORT jint JNICALL Java_Dll_mul
  (JNIEnv *as, jobject a1s, jint a, jint b)
  {return a*b;}
  
JNIEXPORT jint JNICALL Java_Dll_div
  (JNIEnv *sa, jobject s1a, jint a, jint b)
  {return a/b;}
  
  
  
  
