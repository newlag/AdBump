package tv.limehd.adbump;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;

public class AdBump extends WebView implements AdBumpInterface {

    Player player;
    AdBumpCallback webViewCallback;
    final static int FAIL_PLAY_MUSIC = 100;
    public AdBump(@NonNull Context context) {
        super(context);
    }

    public AdBump(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialization();
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void initialization() {
        player = new Player(getContext());
        getSettings().setJavaScriptEnabled(true);
        setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void playAndShow() {
        Log.d("TAG","play");
        showWebView();
        try {
            player.playMusic();
            onSuccessPlay();
        } catch (Exception e) {
            onFailurePlay();
        }
    }

    @Override
    public void stopAndHide() {
        setVisibility(View.GONE);
        player.stopMusic();
    }

    @Override
    public void playMusic() {
        try {
            player.playMusic();
            onSuccessPlay();
        } catch (Exception e) {
            onFailurePlay();
        }
    }

    @Override
    public void stopMusic() {
        player.stopMusic();
    }



    @Override
    public void hide() {
        setVisibility(View.GONE);
    }

    @Override
    public void show() {
        showWebView();
    }


    private void showWebView() {
        try {
            setVisibility(View.VISIBLE);
            if (webViewCallback != null) {
                webViewCallback.onSuccessShow();
            }
        } catch (Exception e) {
            if (webViewCallback != null) {
                webViewCallback.onFailureShow();
            }
        }
    }

    @Override
    public void destroyWebView() {
        clearHistory();
        clearCache(true);
        clearView();
        removeAllViews();
        destroy();
    }

    public AdBumpInterface getWebViewInterface() {
        return this;
    }

    @Override
    public void destroy() {
        super.destroy();
        player.destroy();
    }



    @Override
    public void reloadWebView() {
        reload();
    }

    @Override
    public void setMusicFile(int resId) {
        player.setMusicFile(resId);
    }

    @Override
    public void loadHtmlFile(String html) {
        loadUrl(html);
    }

    public void setWebViewCallback(AdBumpCallback listener) {
        webViewCallback = listener;
    }

    private void onFailurePlay() {
        if (webViewCallback != null) {
            webViewCallback.onFailurePlay(AdBump.FAIL_PLAY_MUSIC);
        }
    }

    private void onSuccessPlay() {
        if (webViewCallback != null) {
            webViewCallback.onSuccessPlay();
        }
    }

}
