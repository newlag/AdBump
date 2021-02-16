package tv.limehd.adbumpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tv.limehd.adbump.AdBump;
import tv.limehd.adbump.AdBumpInterface;

public class MainActivity extends AppCompatActivity {

    AdBump adBump;
    AdBumpInterface adBumpInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adBump = findViewById(R.id.adBump);
        adBumpInterface = adBump.getWebViewInterface();
        adBumpInterface.loadHtmlFile("file:///android_asset/test.html");
        adBumpInterface.setMusicFile(R.raw.music);
        adBumpInterface.playAndShow();
    }
}