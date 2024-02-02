plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    id("androidx.room")
}

android {
    namespace = "com.ha.mydiaryapp"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = "com.ha.mydiaryapp"
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ProjectConfig.extensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    // Navigation
    implementation(libs.navigation.compose)
     // Splash Screen
    implementation(libs.splash.api)
    // Realm
    implementation(libs.realm.sync)
    // Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    // Desugar
    coreLibraryDesugaring(libs.desugar.jdk)
    // Coil
    implementation(libs.coil)
    // Firebase
    implementation(libs.firebase.storage)
    // Hilt
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(project(":common:ui"))
    implementation(project(":common:util"))
    implementation(project(":data:mongo"))
    implementation(project(":data:mongo"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:home"))
    implementation(project(":feature:write"))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime)
    implementation(libs.activity.compose)

//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")

}