package repository

import data.convertMediaDataEntity
import data.db.DbProvider
import data.file.FileContentProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import model.MediaSourceEntity
import okhttp3.MediaType

class MediaSourceRepositoryImpl (
    private var dbProvider: DbProvider,
    private var networkProvider: NetworkProvider,
    private var fileContentProvider: FileContentProvider
): MediaSourceRepository{
    override fun getMedia(type: MediaType): Flowable<List<MediaSourceEntity>> {
        return dbProvider.getMedia(type)
            .distinctUntilChanged()
            .flatMap { list ->
                when(type) {
                    MediaType.ONLINE -> {
                        if (list.isEmpty()){
                            networkProvider.updateOnLineMediaData()
                                .doOnNext { it.map { it.mediaType = MediaType.ONLINE } }
                                .doOnNext { dbProvider.savedMedia(it)}
                        }else{
                            Flowable.fromArray(list)
                        }
                    }
                    else -> {
                        if (list.isEmpty()) {
                            fileContentProvider.getFiles()
                                .doOnNext { dbProvider.savedMedia(it) }
                        }else {
                            Flowable.fromArray(list)
                        }
                    }
                }
            }
            .map { it.map { convertMediaDataEntity(it) } }
     }

    override fun updatPlayingState(id: Int, isPlying: Boolean): Completable {
            return Completable.fromAction{
                dbProvider.updatePlaintState(id, isPlying)
            }
    }

    override fun updateFileMedia(): Completable {
        return fileContentProvider.getFiles()
            .map { dbProvider.savedMedia(it) }
            .ignoreElements()
    }
}