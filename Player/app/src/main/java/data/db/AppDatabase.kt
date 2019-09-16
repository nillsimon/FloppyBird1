package data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import data.MediaSourceData
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.context.Context

@Database(
    version = 1,
    entities = [
    MediaSourceData::class
], exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null

        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.androidApplication(), AppDatabase::class.java, "app.db").build()
            }
            return instance!!
        }
    }
    abstract fun mediaDao(): MediaDao
}
