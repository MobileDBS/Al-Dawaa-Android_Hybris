object Hilt {
    const val hiltVersion = "2.43.2"
    const val javaInjectVersion = "1"
    const val android = "com.google.dagger:hilt-android:$hiltVersion"
    const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    const val javaInject = "javax.inject:javax.inject:$javaInjectVersion"
}

object HiltTest {

    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Hilt.hiltVersion}"
}