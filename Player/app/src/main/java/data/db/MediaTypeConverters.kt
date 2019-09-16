package data.db

import android.arch.persistence.room.TypeConverter
import okhttp3.MediaType

class MediaTypeConverters{

    @TypeConverter
    fun mediaTypeToInt(data: MediaType): Int  {
        return when(data){
            MediaType.ONLINE -> 0
        else -> 1
        }
    }

    @TypeConverter
    fun mediaTypeFromInt(data: Int): MediaType{
        return when(data){
            0 -> MediaType.ONLONE
            else -> MediaType.FILE
        }
    }
}
