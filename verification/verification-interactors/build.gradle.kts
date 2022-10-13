apply{
    from("$rootDir/library-build.gradle")
}
dependencies{

    "implementation"(Kotlinx.coroutinesAndroid)
    "implementation" (Hilt.javaInject)
    "implementation" (Retrofit.retrofit)

    "implementation"(project(Modules.verificationDomain))
    "implementation"(project(Modules.verificationDataSource))
    "implementation"(project(Modules.core))

}