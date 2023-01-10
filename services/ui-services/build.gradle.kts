apply{
    from("$rootDir/android-library-build.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")

/*plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id("org.jetbrains.kotlin.android")
}*/
dependencies{

    "implementation"(project(Modules.components))
    "implementation"(Camera.camerax)
    "implementation"(Camera.cameraview)
    "implementation"(Camera.cameraxlife)
    "implementation"(Compose.permissions)
    "implementation"(project(Modules.servicesDomain))

}
