package tv.limehd.adbump;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class Player {

    Context context;
    MediaPlayer mediaPlayer;
    int resId;

    public Player(Context context) {
        this.context = context;
        initPlayer();
    }

    public void playMusic() throws Exception {
        if (resId == 0){
            throw new Exception();
        }
        initPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void stopMusic() {
        initPlayer();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void initPlayer() {
        if (mediaPlayer == null && resId != 0) {
            mediaPlayer = MediaPlayer.create(context, resId);
            mediaPlayer.setLooping(true);
        }
    }

    public void destroy() {
        initPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void setMusicFile(int resId) {
        this.resId = resId;
        initPlayer();
    }
}
