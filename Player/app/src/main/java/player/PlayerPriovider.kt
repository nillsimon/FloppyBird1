package player

import model.MediaSourceEntity

abstract class PlayerProvider {
     private var listeners = arrayListOf<PlayerStateListener>()
     protected var mediaItem: MediaSourceEntity? = null

     abstract fun onPlay(data: MediaSourceEntity)
     abstract fun onStop()
     abstract fun onDestroy()

     fun callbackState(isPlaying: Boolean){
         listeners.forEach { listener ->
         mediaItem?.also{
             listener.onChangePlayingState(it.copy(isPlaing = isPlaying))
         }
        }
     }
    fun addListener(listener: ExoPlayerProviderEmpl.ExoPlayerListener){
        listeners.add(listener)
    }
    fun removeListener(listener: PlayerStateListener){
        listeners.remove(listener)
    }
}
