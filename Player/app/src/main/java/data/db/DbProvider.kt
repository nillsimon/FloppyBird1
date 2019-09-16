package data.db

import data.MediaSourceData
import io.reactivex.Flowable
import okhttp3.MediaType

interface DbProvider {
    fun getMedia(type: MediaType): Flowable<List<MediaSourceData>>
    fun savedMedia(data: List<MediaSourceData>)
    fun updatePlaintState(id: Int, isPlating:Boolean)
}