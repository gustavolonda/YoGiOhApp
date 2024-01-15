plugins {
    id("com.android.application")
}

android {
    namespace = "com.fisagrp.yugiohapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fisagrp.yugiohapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "CARD_INFO", "\"cardinfo.php\"")
        buildConfigField("String", "NAME_DATA_BASE", "\"card_database\"")
    }
    flavorDimensions += "api"

    productFlavors {

        create("dev") {
            resValue("string","app_name","YuGiOh-DEV")
            buildConfigField("String", "URL_BASE", "\"https://db.ygoprodeck.com/api/v7/\"")


            applicationIdSuffix =".dev"

        }

        create("pro") {
            resValue ("string","app_name","YuGiOh")
            buildConfigField("String", "URL_BASE", "\"https://db.ygoprodeck.com/api/v7/\"")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}


dependencies {
    //Retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.4")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    //rxjava2
    implementation("io.reactivex.rxjava2:rxjava:2.0.1")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.2")

    //picasso
    implementation("com.squareup.picasso:picasso:2.8")

    // Room
    val roomVersion = "2.1.0"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    implementation("androidx.appcompat:appcompat:1.6.0-alpha04")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}