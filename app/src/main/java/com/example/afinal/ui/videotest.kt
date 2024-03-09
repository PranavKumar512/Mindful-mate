import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.afinal.R
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoPlayerCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .scale(2.5f)
            ,
        shape = CircleShape,


    ) {
        VideoPlayer(
            mediaItems = listOf(
                VideoPlayerMediaItem.RawResourceMediaItem(
                    resourceId = R.raw.video
                )
            ),
            handleLifecycle = true,
            autoPlay = true,
            usePlayerController = false, // Disable player controller for background playback
            handleAudioFocus = false, // Allow playback regardless of audio focus changes
            volume = 0.5f,  // Set volume (0.0f to 1.0f)
            repeatMode = RepeatMode.ALL, // Set repeat mode
            onCurrentTimeChanged = { // Current time changed callback
                Log.e("CurrentTime", it.toString())
            },
            playerInstance = { // ExoPlayer instance (Experimental)

            },
            modifier = Modifier.fillMaxSize(),
        )
    }
}
