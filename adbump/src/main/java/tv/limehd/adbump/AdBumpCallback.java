package tv.limehd.adbump;

public interface AdBumpCallback {

    void onSuccessPlay();

    void onFailurePlay(int resultCode);

    void onSuccessShow();

    void onFailureShow();
}
