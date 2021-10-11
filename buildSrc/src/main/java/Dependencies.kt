object AndroidLibs {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.viewmodel}"
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.viewmodel}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object MaterialLibs {
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
}

object ComposeLibs {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val compose = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialIcons = "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val constraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object DaggerLibs {
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object PagingLibs {
    const val runtime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val compose = "androidx.paging:paging-compose:${Versions.pagingCompose}"
}

object SquareLibs {
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.jUnit}"
}