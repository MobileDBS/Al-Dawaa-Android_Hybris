
apply{
    from("$rootDir/android-library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}
dependencies{
    "implementation"(project(Modules.ui_login))
    "implementation"(project(Modules.ui_register))
    "implementation"(project(Modules.components))

}
