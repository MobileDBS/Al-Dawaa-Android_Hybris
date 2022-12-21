apply{
    from("$rootDir/library-build.gradle")
}
dependencies{

    "implementation"(Kotlinx.coroutinesAndroid)
    "implementation" (Hilt.javaInject)
    "implementation" (Retrofit.retrofit)
}