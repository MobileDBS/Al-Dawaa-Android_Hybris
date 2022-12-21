apply{
    from("$rootDir/android-library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies {
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.ui_filter))

    "implementation"("com.google.accompanist:accompanist-systemuicontroller:0.23.1")
}