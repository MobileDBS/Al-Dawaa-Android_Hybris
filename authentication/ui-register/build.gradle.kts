apply{
    from("$rootDir/android-library-build.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")
dependencies{
/*    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)*/
    "implementation"(project(Modules.components))


}