package data.file

import data.MediaSourceData
import io.reactivex.Flowable

interface FileContentProvider {
    fun getFiles(): Flowable<List<MediaSourceData>>
}