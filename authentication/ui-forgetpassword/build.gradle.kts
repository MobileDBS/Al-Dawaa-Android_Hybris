apply{
    from("$rootDir/android-library-build.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")
dependencies{
    "implementation"(project(Modules.components))


}