package player

import model.MediaSourceEntity

interface PlayerStateListener {
    fun onChangePlayingState(data: MediaSourceEntity)
}