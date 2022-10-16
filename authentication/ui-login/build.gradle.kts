
apply{
    from("$rootDir/android-library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}
dependencies{
/*    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)*/
    "implementation"(project(Modules.authenticationInteractors))
    "implementation"(project(Modules.authenticationDomain))
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.components))


}
