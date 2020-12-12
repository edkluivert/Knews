object AnnotationProcessor {
    const val moshi: String = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"

    const val daggerHiltAndroid: String =
        "com.google.dagger:hilt-android-compiler:${Version.daggerHiltAndroid}"
    const val jetpackHiltCompiler: String =
        "androidx.hilt:hilt-compiler:${Version.hiltViewModel}"


    const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle_version}"

    const val room: String = "androidx.room:room-compiler:${Version.room}"

    const val glide : String = "com.github.bumptech.glide:compiler:${Version.glideVersion}"
}