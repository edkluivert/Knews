object AndroidX  {

        const val coreKtx: String = "androidx.core:core-ktx:${Version.coreKtx}"
        const val navigationFragmentKtx: String =
            "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navigationUiKtx: String =
            "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
        const val multiDex: String = "androidx.multidex:multidex:${Version.multidex}"
        const val activity: String = "androidx.activity:activity:${Version.activity}"
        const val lifeCycleCommon: String =
            "androidx.lifecycle:lifecycle-common-java8:${Version.lifeCycle}"
        const val viewModel: String =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifeCycle}"
    }

    object Glide {

        const val glide : String = "com.github.bumptech.glide:glide:${Version.glideVersion}"
    }



    object Intuit {
        const val sdp : String = "com.intuit.sdp:sdp-android:${Version.intuitVersion}"
        const val ssp : String = "com.intuit.ssp:ssp-android:${Version.intuitVersion}"

    }

    object DataStore {
        const val dataStoreJavaLite : String = "com.google.protobuf:protobuf-javalite:${Version.dataStoreJavaLite}"
        const val protoDataStore : String = "androidx.datastore:datastore-core:${Version.protoDataStore}"



    }

    object Paging{

        const val runtime : String =  "androidx.paging:paging-runtime:${Version.pagingVersion}"
        const val common : String = "androidx.paging:paging-common:${Version.pagingVersion}"


    }

    object PrettyTime{
        const val prettyTime = "org.ocpsoft.prettytime:prettytime:${Version.prettyTimeVersion}"
    }


    object View  {

        const val appCompat: String = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val fragment: String = "androidx.fragment:fragment-ktx:${Version.fragment}"
        const val cardView: String = "androidx.cardview:cardview:${Version.cardView}"
        const val materialComponent: String = "com.google.android.material:material:${Version.materialComponent}"
        const val shimmerLayout: String = "com.facebook.shimmer:shimmer:${Version.shimmerLayout}"
        const val constraintLayout: String = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val recyclerView: String = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        private val swipe_refresh_layout = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipe_refresh_layout}"

    }

    object FlowBinding {

        const val android: String = "io.github.reactivecircus.flowbinding:flowbinding-android:${Version.flowBindingVersion}"
        const val lifecycle: String =
            "io.github.reactivecircus.flowbinding:flowbinding-lifecycle:${Version.flowBindingVersion}"
    }

    object Network {

        private const val okhttp: String = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
        private const val loggingInterceptor: String =
            "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        private const val retrofit: String = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        private const val retrofitMoshi: String =
            "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
        const val moshi: String = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"

       const val googleGson = "com.google.code.gson:gson:${Version.google_gson_version}"
        const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit_gson_converter_version}"

    }

    object DI {

        const val javaxInject: String = "javax.inject:javax.inject:${Version.javaxInject}"
        const val daggerHiltAndroid: String =
            "com.google.dagger:hilt-android:${Version.daggerHiltAndroid}"
        const val hiltViewModel: String =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hiltViewModel}"
        const val hiltTesting: String =
            "com.google.dagger:hilt-android-testing:${Version.daggerHiltAndroid}"
    }

     object LiveData{

      const val lifecyleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle_version}"
      const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle_version}"
       const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle_version}"
        const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Version.lifecycle_version}"
     }

    object Coroutines  {


        const val core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"


    }

    object Cache {

        const val room: String = "androidx.room:room-ktx:${Version.room}"
    }

    object TestI {

        const val junit: String = "junit:junit:${Version.junit}"
        const val runner: String = "androidx.test:runner:${Version.runner}"
        const val fragmentTesting: String = "androidx.fragment:fragment-testing:${Version.fragment}"
        const val androidXTest: String = "androidx.test.ext:junit:${Version.testExt}"
        const val espresso: String = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val espressoContrib: String = "androidx.test.espresso:espresso-contrib:${Version.espresso}"
        const val rules: String = "androidx.test:rules:${Version.rules}"
        const val archCoreTest: String = "android.arch.core:core-testing:${Version.archCoreTest}"
        const val truth: String = "com.google.truth:truth:${Version.truth}"
        const val mockWebServer: String = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
        const val coroutinesTest: String = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
        const val robolectric: String = "org.robolectric:robolectric:${Version.robolectric}"
    }

