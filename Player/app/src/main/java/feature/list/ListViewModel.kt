package feature.list

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import repository.MediaSourceRepository

class ListViewModel(
    private var typeName: String,
    private var repository: MediaSourceRepository,
    private
): ViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onResume(){

    }
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onStart(){

    }


}