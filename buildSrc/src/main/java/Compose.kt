object Compose {
    private const val activityComposeVersion = "1.5.1"
    const val activity = "androidx.activity:activity-compose:$activityComposeVersion"
    const val composeVersion = "1.2.1"
    const val kotlinCompilerExtensionVersion = "1.3.1"

    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"

    private const val navigationVersion = "2.5.2"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val composeCompilerVersion = "1.2.1"
    const val composeCompiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"

    private const val hiltNavigationComposeVersion = "1.0.0"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val material_3 = "1.0.0-alpha13"
    const val material3 = "androidx.compose.material3:material3:$material_3"

    private const val flow = "0.17.0"
    const val flowLayout = "com.google.accompanist:accompanist-flowlayout:$flow"

    private const val composeUtilVersion = "1.3.1"
    const val composeUtil = "androidx.compose.ui:ui-util:$composeUtilVersion"


    private const val accompanistPermissionsVersion = "0.23.0"
    const val Permissions = "com.google.accompanist:accompanist-permissions:$accompanistPermissionsVersion"

    private const val accompanistPagerVersion = "0.28.0"
    const val accompanistPager = "com.google.accompanist:accompanist-pager:$accompanistPagerVersion"

    private const val accompanistPagerIndicatorVersion = "0.28.0"
    const val accompanistPagerIndicator = "com.google.accompanist:accompanist-pager-indicators:$accompanistPagerIndicatorVersion"

    private const val accompanistSystemUiControllerVersion = "0.28.0"
    const val accompanistSystemUiController = "com.google.accompanist:accompanist-systemuicontroller:$accompanistSystemUiControllerVersion"



    private const val maps_compose = "2.7.2"
    const val maps ="com.google.maps.android:maps-compose:$maps_compose"

    private const val play_services= "18.1.0"
    const val playServices ="com.google.android.gms:play-services-maps:$play_services"

    private const val places="2.7.0"
    const val googlePlaces="com.google.android.libraries.places:places:$places"

    private const val service_location="21.0.1"
    const val playServicesLocation="com.google.android.gms:play-services-location:$service_location"


}

object ComposeTest {
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
}