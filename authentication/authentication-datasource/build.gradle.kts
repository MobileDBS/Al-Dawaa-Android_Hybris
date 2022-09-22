apply{
    from("$rootDir/library-build.gradle")
}
dependencies{
    "implementation" (Retrofit.retrofit)
    "implementation" (Retrofit.moshiConverter)
    "implementation" (Retrofit.retrofitCoroutines)

    "implementation" (Retrofit.moshi)
    "implementation" (Retrofit.moshiKotlin)
    "implementation" (Retrofit.moshiCodegen)

    "implementation"(project(Modules.authenticationDomain))

    "implementation"(Kotlinx.coroutinesCore)

   // "implementation"(Hilt.android)
   // "kapt"(Hilt.compiler)

}