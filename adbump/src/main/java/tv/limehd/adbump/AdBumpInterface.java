package tv.limehd.adbump;

public interface AdBumpInterface {

    void playAndShow();

    void stopAndHide();

    void playMusic();

    void stopMusic();

    void hide();

    void show();

    void destroyWebView();

    void reloadWebView();

    void setMusicFile (int resId);

    void loadHtmlFile(String html);

}
