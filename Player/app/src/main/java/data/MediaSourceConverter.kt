package data

import model.MediaSourceEntity
import okhttp3.MediaType
import java.io.File

fun convertMediaDataEntity(data: MediaSourceData): MediaSourceEntity{
    return MediaSourceEntity(
        data.id,
        data.name,
        if(data.mediaType == MediaType.ONLINE) null else File(data.urlPath),
        data.urlPath,
        data.imagePath,
        data.mediaType,
        data.isPlaying

    )

}