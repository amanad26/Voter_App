plugins {
    id("com.android.application")
}

android {
    namespace = "com.abm.voterapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.abm.voterapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.karumi:dexter:6.2.3")

    // Lottie Animation
    val lottieVersion = "3.4.0"
    implementation("com.airbnb.android:lottie:$lottieVersion")

    //Retrofit Apis
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    // SDP
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    // Rounded Imageview
    implementation("com.makeramen:roundedimageview:2.3.0")

    // Circle Imageview
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("com.github.leoncydsilva:SearchableSpinner:1.0.1")
    implementation("com.github.dhaval2404:imagepicker:2.1")

}
