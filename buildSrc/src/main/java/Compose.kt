object Compose {
    private const val activityComposeVersion = "1.5.1"
    const val activity = "androidx.activity:activity-compose:$activityComposeVersion"
    const val composeVersion = "1.2.1"
    const val kotlinCompilerExtensionVersion = "1.3.1"

    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val preview =  "androidx.compose.ui:ui-tooling-preview:$composeVersion"

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
}

object ComposeTest {
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Compose.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
}