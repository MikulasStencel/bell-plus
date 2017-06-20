package bell.plus;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openPlayStoreLink("com.epicqueststudios.fractalwallpapergenerator", "");
        //setContentView(R.layout.activity_main);
    }

    public void openPlayStoreLink(String urlPackage, String utmCampaignUrlParam) {
      //  Log.d("Bell Plus", "Opening google play store package: " + urlPackage);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id="+ urlPackage + utmCampaignUrlParam));
            startActivity(intent);
        } catch (Exception e) { //google play app is not installed
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id="+ urlPackage + utmCampaignUrlParam));
            startActivity(intent);
        }
        finally {
            onBackPressed();
        }
    }
 }
