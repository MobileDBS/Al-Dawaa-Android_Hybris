apply{
    from("$rootDir/library-build.gradle")
}
dependencies{

    "implementation"(Kotlinx.coroutinesAndroid)
    "implementation" (Hilt.javaInject)
    "implementation" (Retrofit.retrofit)

    "implementation"(project(Modules.categoriesDomain))
    "implementation"(project(Modules.categoriesDataSource))
    "implementation"(project(Modules.core))

}