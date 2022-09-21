
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")

}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools


    defaultConfig {
        applicationId = Android.appId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    /*    vectorDrawables {
            useSupportLibrary true
        }*/
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
     /*   release {

            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }*/
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
       // useIR = true
    }
    buildFeatures {
        compose  = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.kotlinCompilerExtensionVersion
        //kotlinCompilerVersion '1.7.10'
    }
    packagingOptions {
        resources {
            exclude("/META-INF/AL2.0,LGPL2.1")
        }
    }
}

dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycleVmKtx)

    //Coil image loading
    implementation(Coil.coil)
    implementation(Coil.coilGif)


    implementation(Compose.activity)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.tooling)
    implementation(Compose.navigation)
    implementation(Compose.hiltNavigation)
    implementation(Compose.preview)

    implementation(Google.material)

    implementation (Retrofit.retrofit)
    implementation (Retrofit.moshiConverter)
    implementation (Retrofit.retrofitCoroutines)

    implementation (Retrofit.moshi)
    implementation (Retrofit.moshiKotlin)
    implementation (Retrofit.moshiCodegen)



    implementation(Hilt.android)
    kapt(Hilt.compiler)
    //  debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"

}