package com.example.Meetstranger.grammar;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import com.example.Meetstranger.R;
import com.example.Meetstranger.grammar.fragment.Word_List_fragment;

import com.example.Meetstranger.grammar.utils.CommunicatorFragmentInterface;
import com.example.Meetstranger.util.PersistentUser;

public class ListActivity extends AppCompatActivity implements CommunicatorFragmentInterface {
   private Context context;
   private int dictionary_number = 0;
   private int level_number = 0;

   // facebook ads
   private AdView adView;
   private AdListener adListener;
   private int adscount = 0;
   private int maxadscount = 0;

   @Override
   protected void onDestroy() {
      if (adView != null) {
         adView.destroy();
      }
      super.onDestroy();
   }
   //

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(R.layout.grammar_dictionary_main);

      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      // facebook ads
      adscount = PersistentUser.getAdsCount(this.getApplicationContext());
      maxadscount = getResources().getInteger(R.integer.maxadscount);

      adView = new AdView(this, getResources().getString(R.string.fb_banner_ad3), AdSize.BANNER_HEIGHT_50);
      LinearLayout adContainer = (LinearLayout) findViewById(R.id.linear_layout_bottom);
      adContainer.addView(adView);
      adListener = new AdListener() {
         @Override
         public void onError(Ad ad, AdError adError) {
         }

         @Override
         public void onAdLoaded(Ad ad) {
         }

         @Override
         public void onAdClicked(Ad ad) {
            adscount++;
            PersistentUser.setAdsCount(ListActivity.this,adscount);
         }

         @Override
         public void onLoggingImpression(Ad ad) {
         }
      };
      if(adscount<=maxadscount){
         adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
      }
      //

      this.level_number = this.getIntent().getIntExtra("level_no", 0);
      this.dictionary_number = this.getIntent().getIntExtra("dictionary_no", 0);
      this.context = this;

      this.setContentFragment(new Word_List_fragment(), false);
   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      int id = item.getItemId();
      if(id==android.R.id.home){
         this.finish();
         return true;
      }
      return false;
   }

   public void setContentFragment(Fragment var1, boolean var2) {

      if (var1 != null) {
         FragmentManager var3 = this.getSupportFragmentManager();
         Fragment var4 = var3.findFragmentById(R.id.frame_layout);
         Bundle var5 = new Bundle();
         var5.putInt("level_no", this.level_number);
         var5.putInt("dictionary_no", this.dictionary_number);
         var1.setArguments(var5);
         if (var4 == null || !var1.getClass().isAssignableFrom(var4.getClass())) {
            FragmentTransaction var6 = var3.beginTransaction();
            var6.replace(R.id.frame_layout, var1, var1.getClass().getName());
            if (var2) {
               var6.addToBackStack(var1.getClass().getName());
            }

            var6.commit();
            var3.executePendingTransactions();
         }
      }

   }

}
