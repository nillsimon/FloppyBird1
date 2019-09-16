package data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import data.db.MediaTypeConverters
import okhttp3.MediaType

@Entity(tableName = "media")
@TypeConverters(MediaTypeConverters::class)
data class MediaSourceData(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("urlPath")
    @Expose
    var urlPath: String,

    @SerializedName("imagePath")
    @Expose
    var imagePath: String,

    var mediaType: MediaType,

    var isPlaying: Boolean
)