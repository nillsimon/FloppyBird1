package data.network

import data.MediaSourceData
import io.reactivex.Flowable
import retrofit2.http.GET

interface Api {
    @GET("")
    fun getOnlineMediaFromServer(): Flowable<MediaSourceData>
}