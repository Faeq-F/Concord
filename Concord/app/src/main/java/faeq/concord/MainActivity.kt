package faeq.concord

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
  
  private var playing:Boolean = false
  private lateinit var mediaPlayer: MediaPlayer
  private lateinit var playPauseButton:Button
  
  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity);
    playPauseButton = findViewById<View>(R.id.PlayPause) as Button
    mediaPlayer = MediaPlayer.create(this, R.raw.zealandardor)
    
  }
  
  override fun finish() {
    mediaPlayer.stop()
    mediaPlayer.release()
    super.finish()
  }
  
  fun playPause(view : View) {
    if (playing){
      mediaPlayer.pause()
      playPauseButton.text = "Play"
    } else{
      mediaPlayer.start()
      playPauseButton.text = "Pause"
    }
    playing = !playing
  }
}