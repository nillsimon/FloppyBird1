package repository

import data.MediaSourceData
import data.network.Api
import io.reactivex.Flowable

class NetworkProviderImpl(private var api: Api) : NetworkProvider{
    override fun updateOnLineMediaData(): Flowable<List<MediaSourceData>> {
        return api.getOnlineMediaFromServer()
     }
}