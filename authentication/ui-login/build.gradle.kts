
apply{
    from("$rootDir/android-library-build.gradle")
}
dependencies{
/*    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)*/
    "implementation"(project(Modules.authenticationInteractors))
    "implementation"(project(Modules.authenticationDomain))
    "implementation"(project(Modules.core))
}
