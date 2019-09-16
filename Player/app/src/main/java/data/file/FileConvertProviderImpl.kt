package data.file

import android.os.Environment
import data.MediaSourceData
import io.reactivex.Flowable
import okhttp3.MediaType
import java.io.File

class FileConvertProviderImpl: FileContentProvider {
    override fun getFiles(): Flowable<List<MediaSourceData>> {
        return  Flowable.fromCallable {
            var files = mutableListOf<MediaSourceData>()
            if (isExternalStorageReadble()){
                var filesFolder = getPublicStorageDir()
                filesFolder.listFiles()?.filter { !it.isDirectory }?.forEach { file ->
                    var data = MediaSourceData(
                        0,
                        file.name,
                        file.absolutePath,
                        "",
                        MediaType.FILE,
                        false
                    )
                    files.add(data)
                }
            }
                    files
        }
    }
    private fun getPublicStorageDir(): File {
        var file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        if (!file.exists()) {
            file.mkdir()
        }
        return file
    }
    private fun isExternalStorageReadble(): Boolean{
        return Environment.getExternalStorageState()in setOf(
            Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY
        )
    }
}