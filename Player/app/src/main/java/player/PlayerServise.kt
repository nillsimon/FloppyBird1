package player

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.support.v4.media.app.NotificationCompat
import androidx.annotation.RequiresApi
import com.simon.player.R
import feature.MainActivity
import io.reactivex.subjects.BehaviorSubject
import model.MediaSourceEntity
import org.koin.android.ext.android.inject

const val NOTIFICATION_ID = 10
const val NOTIFICATION_CHANNEL_ID = "101"
class PlayerService: Service(){
    private val binder = PlayerServiceBinder()
    private val player by inject<PlayerProvider>()
    private val idPlayerStateSubject = BehaviorSubject.create<MediaSourceEntity>()
    private lateinit var notificationManager: NotificationManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        notificationManager = getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager
            crateChannel()
        player.addListener(playerListener)

    }
        fun startPlayer(data: MediaSourceEntity) {
            player.onPlay(data)
        }
        fun stopPlayer(){
            player.onStop()

        }
        fun getisPlayingStateSubject()= idPlayerStateSubject

       override fun onDestroy(){
           super.onDestroy()
           player.removeListener(playerListener)
           player.onDestroy()
       }
    private val playerListener = object : PlayerStateListener {
        override fun onChangePlayingState(data: MediaSourceEntity) {
            idPlayerStateSubject.onNext(data)
            if(data.isPlaing) showNotification(data.name)else dismissNotification()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun crateChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "Mеdia", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification(text: String){
        val notification = buildNotification(text)
        notificationManager.notify(NOTIFICATION_ID, notification)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            startForeground(NOTIFICATION_ID, notification)
    }
    private fun dismissNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
            stopForeground(true)
        }
    }
    private fun buildNotification(text: String): android.app.Notification{
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent =PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        return NotificationCompat.Builder(this,NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("MyPlayer")
            .setContentText(text)
            .setContentIntent(pendingIntent)
            .setAutoCannel(false)
            .build()
    }
    override fun onBind(p0: Intent?): IBinder? {
          return binder
        }

    private inner class PlayerServiceBinder: Binder() {
     fun getService(): PlayerService{
         return this@PlayerService
        }
    }
}