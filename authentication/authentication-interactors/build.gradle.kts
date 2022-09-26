apply{
    from("$rootDir/library-build.gradle")
}
dependencies{

    "implementation"(Kotlinx.coroutinesAndroid)
    "implementation" (Hilt.javaInject)
    "implementation"(project(Modules.authenticationDomain))
    "implementation"(project(Modules.authenticationDataSource))

}