plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
}

android {
    namespace = "com.ha.ui"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(libs.activity.compose)
    implementation(libs.material3.compose)
    implementation(libs.compose.tooling.preview)
    implementation(libs.realm.sync)
    implementation(libs.coroutines.core)
    implementation(libs.coil)
}