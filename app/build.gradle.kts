plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "dk.vixo.githubandroid"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }

        getByName("release") {
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(AndroidLibs.kotlin)
    implementation(AndroidLibs.appCompat)
    implementation(AndroidLibs.core)
    implementation(AndroidLibs.fragment)
    implementation(AndroidLibs.viewmodel)
    implementation(AndroidLibs.lifecycleExt)

    implementation(AndroidLibs.constraintLayout)

    implementation(MaterialLibs.materialDesign)

    implementation(DaggerLibs.dagger)
    implementation(DaggerLibs.android)
    implementation(DaggerLibs.support)
    annotationProcessor(DaggerLibs.processor)
    kapt(DaggerLibs.processor)
    kapt(DaggerLibs.compiler)

    implementation(SquareLibs.okhttp)
    implementation(SquareLibs.retrofit)
    implementation(SquareLibs.interceptor)
    implementation(SquareLibs.converter)

    implementation(ComposeLibs.compose)
    implementation(ComposeLibs.ui)
    implementation(ComposeLibs.material)
    implementation(ComposeLibs.materialIcons)
    implementation(ComposeLibs.constraint)
    implementation(ComposeLibs.coil)

    implementation(PagingLibs.runtime)
    implementation(PagingLibs.compose)

    testImplementation(TestLibs.junit)
}