package di

import data.network.Api
import io.reactivex.schedulers.Schedulers
 import okhttp3.OkHttpClient
 import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
 import retrofit2.converter.gson.GsonConverterFactory

fun createOkHttpClient(): OkHttpClient{
    var httpLogging = HttpLoggingInterceptor()
    httpLogging.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(httpLogging)
        .build()

}



fun createWebService(okHttp: OkHttpClient): Api {
    var retrofit = Retrofit.Builder()
        .baseUrl("://api.myjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

        .client(okHttp)
        .build()
    return retrofit.create(Api::class.java)

}
