-target 1.6

-libraryjars <java.home>/lib/rt.jar

-repackageclasses ''
-applymapping 'proguard.map'
-printmapping 'build/libs/osclient.map'

-keep,allowobfuscation public class * { public static void main(java.lang.String[]); }
-keepclassmembers public class * { public static void main(java.lang.String[]); }
-adaptresourcefilecontents
