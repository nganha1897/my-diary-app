plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("io.realm.kotlin")
    id("androidx.room")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ha.write"
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

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.activity.compose)
    implementation(libs.material3.compose)
    implementation(libs.navigation.compose)
    implementation(libs.coil)
    implementation(libs.coroutines.core)
    implementation(libs.realm.sync)
    implementation(libs.date.time.picker)
    implementation(libs.date.dialog)
    implementation(libs.time.dialog)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.storage)

    implementation(project(":common:ui"))
    implementation(project(":common:util"))
    implementation(project(":data:mongo"))
}