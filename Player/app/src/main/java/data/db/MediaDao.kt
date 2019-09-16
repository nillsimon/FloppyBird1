package data.db

import android.arch.persistence.room.*
import data.MediaSourceData
import io.reactivex.Flowable
import okhttp3.MediaType

@Dao
@TypeConverters(MediaTypeConverters::class)
interface MediaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedia(data: List<MediaSourceData>)

    @Query("select * from media where mediaType = :type")
    fun getMedia(type: MediaType): Flowable<List<MediaSourceData>>

    @Query("select count() from media where mediaType =:type")
    fun selectCountMedia(type: MediaType): Int

    @Query("update media set isPlaying =:isPaying where id =:id")
    fun updatePlayerState(id: Int, isPaying: Boolean)

    @Query("update media set isPlaying = 0")
    fun resetPlayingState()

    @Transaction
    fun updateMediaState(id: Int, isPaying: Boolean) {
    resetPlayingState()
    updatePlayerState(id, isPaying)
}
}