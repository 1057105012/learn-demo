
-libraryjars <java.home>/lib/rt.jar

-verbose
-useuniqueclassmembernames
-adaptclassstrings
#-dontpreverify
-target 1.8
-printmapping out.map
-renamesourcefileattribute SourceFile
-keepattributes Exceptions, InnerClasses, Signature, Deprecated, SourceFile, LineNumberTable, *Annotation*, EnclosingMethod
-keepclassmembers enum * { *; }
-keepclasseswithmembers public class * {
   public static void premain(java.lang.String,java.lang.instrument.Instrumentation);
   public static void agentmain(java.lang.String,java.lang.instrument.Instrumentation);
   public static void main(java.lang.String[]);
}



-keeppackagenames
-dontusemixedcaseclassnames

-keep class cn.thirdparty.** {*;}
-keep class Cooker {*;}

-keep class BytebuddyTest { *; }

-dontshrink
-dontoptimize
-ignorewarnings
