package data.db

import data.MediaSourceData
import io.reactivex.Flowable
import okhttp3.MediaType

class DbProviderImpl(private var db: AppDatabase): DbProvider{

 override fun getMedia(type: MediaType): Flowable<List<MediaSourceData>> {
return db.mediaDao().getMedia(type)
 }

 override fun savedMedia(data: List<MediaSourceData>) {
db.mediaDao().insertMedia(data)
 }

 override fun updatePlaintState(id: Int, isPlating: Boolean) {
db.mediaDao().updateMediaState(id,isPlating) }
}