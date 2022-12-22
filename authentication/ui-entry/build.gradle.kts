
apply{
    from("$rootDir/android-library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id("org.jetbrains.kotlin.android")
}
dependencies{
    "implementation"(project(Modules.ui_login))
    "implementation"(project(Modules.authenticationDomain))
    "implementation"(project(Modules.ui_register))
    "implementation"(project(Modules.components))
    "implementation"(SocialMedia.facebooksdk)
    "implementation"(SocialMedia.facebookLogin)
    "implementation"(SocialMedia.facebookcore)
    "implementation"(SocialMedia.googleservice)
    "implementation"(SocialMedia.twitter)
    "implementation"(AndroidX.constraint)
    "implementation"(Localization.localization)


}

