apply{
    from("$rootDir/android-library-build.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")
//apply(plugin = "com.android.application")
/*plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}*/
dependencies{
    "implementation"(Compose.maps)
    "implementation"(Compose.playServices)
   // "implementation"(Compose.Permissions)
    "implementation"(Compose.googlePlaces)
   // "implementation"(Compose.playServicesLocation)
    //Slider
    "implementation"(Compose.accompanistPager)
    "implementation"(Compose.accompanistPagerIndicator)
    "implementation"(Compose.composeUtil)


}