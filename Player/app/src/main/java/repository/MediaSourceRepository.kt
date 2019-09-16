package repository

import io.reactivex.Completable
import io.reactivex.Flowable
import model.MediaSourceEntity
import okhttp3.MediaType

interface MediaSourceRepository {
    fun getMedia(type: MediaType):Flowable<List<MediaSourceEntity>>
    fun updatPlayingState(id: Int, isPlying: Boolean):Completable
    fun updateFileMedia(): Completable

}