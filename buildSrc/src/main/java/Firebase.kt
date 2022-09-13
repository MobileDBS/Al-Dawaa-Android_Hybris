object Firebase {
    private const val messagingVersion = "23.0.8"
    private const val analyticsVersion = "21.1.1"
    private const val bomVersion = "30.4.1"
    private const val coreVersion = "21.1.1"
    private const val databaseVersion = "20.0.6"

    const val firebaseMessagingKtx = "com.google.firebase:firebase-messaging-ktx:$messagingVersion"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:$messagingVersion" //can't find the latest

    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:$analyticsVersion"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"

    const val firebaseBom = "com.google.firebase:firebase-bom:$bomVersion"

    const val firebaseCore = "com.google.firebase:firebase-core:$coreVersion"

    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val crashlyticsPlugin = "com.google.firebase.crashlytics"

    const val firebaseDatabasektx = "com.google.firebase:firebase-database-ktx:$databaseVersion"


}
/*

implementation 'com.google.firebase:firebase-analytics:20.1.0'
implementation platform('com.google.firebase:firebase-bom:26.4.0')

implementation 'com.google.firebase:firebase-core:20.1.0'
implementation 'com.google.firebase:firebase-crashlytics-ktx'
implementation 'com.google.firebase:firebase-analytics-ktx'
//Real time DB
implementation 'com.google.firebase:firebase-database-ktx:20.0.3'
* */