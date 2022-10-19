
apply{
    from("$rootDir/android-library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}
dependencies{
/*    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)*/
    "implementation"(project(Modules.categoriesInteractors))
    "implementation"(project(Modules.categoriesDataSource))
    "implementation"(project(Modules.categoriesDomain))
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.components))


}
