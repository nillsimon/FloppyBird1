package player

import android.net.Uri
import android.os.Looper.prepare
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import model.MediaSourceEntity
import okhttp3.MediaType
import org.koin.dsl.context.Context

class ExoPlayerProviderEmpl(private val context: Context): PlayerProvider() {
    private val listener = ExoPlayerListener()
    private val player = ExoPlayerFactory.newSimpleInstance(context, DefaultTrackSelector()).apply{
        addListener(listener)
    }
    override fun onPlay(data: MediaSourceEntity) {
        mediaItem = data
        val source = prepareSource(data)
        player.applay{
            prepare(source)
            playWhenReady = true
        }
     }
    private fun prepareSource(data: MediaSourceEntity): ExtractorMediaSource {
        val uri = when(data){
           MediaType.ONLINE -> Uri.parse(data.urlPass)
            MediaType.FILE -> Uri.fromFile(data.file)
        }
        val dataSource = DefaultDataSourceFactory(context, Util.getUserAgent(context,"MyPlayer"))
            return ExtractorMediaSource.Factory(dataSource)
                .createMediaSource(uri)
    }

    override fun onStop() {
        player.stop()
     }

    override fun onDestroy() {
        player.removeListener(listener)
        player.relise
     }
    private inner class ExoPlayerListener: Player.EventListener {
        override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                 when(playbackState){
                     Player.STATE_IDLE ->callbackState(false)
                     Player.STATE_BUFFERING -> callbackState(true)
                     Player.STATE_ENDED -> callbackState(false)
                     Player.STATE_READY -> callbackState(true)
                }
            }
        }
}
