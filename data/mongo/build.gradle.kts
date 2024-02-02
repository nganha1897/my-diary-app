plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
    id("com.google.devtools.ksp")
    id("androidx.room")
}

android {
    namespace = "com.ha.mongo"
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

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.coroutines.core)
    implementation(libs.realm.sync)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    implementation(project(":common:util"))
}