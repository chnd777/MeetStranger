package com.example.Meetstranger.grammar;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.example.Meetstranger.R;
import com.example.Meetstranger.grammar.fragment.Word_Level_fragment;

import java.util.Random;

import com.example.Meetstranger.grammar.utils.CommunicatorFragmentInterface;

public class DictionaryActivity extends AppCompatActivity implements CommunicatorFragmentInterface {
   private AdRequest adRequest1;
   private AdView admobAdView;
   private Context context;
   private int dictionary_number;
   private com.facebook.ads.AdView facebookAdView;
   private boolean isAddContainerSet = false;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(R.layout.grammar_dictionary_main);

      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      this.dictionary_number = 1 + (new Random()).nextInt(5);
      this.dictionary_number = this.getIntent().getIntExtra("dictionary_no", 0);
      this.context = this;

      this.setContentFragment(new Word_Level_fragment(), false);
   }

   public void setContentFragment(Fragment var1, boolean var2) {
      
      if (var1 != null) {
         FragmentManager var3 = this.getSupportFragmentManager();
         Fragment var4 = var3.findFragmentById(R.id.frame_layout);
         if (var4 == null || !var1.getClass().isAssignableFrom(var4.getClass())) {
            Bundle var5 = new Bundle();
            var5.putInt("dictionary_no", this.dictionary_number);
            var1.setArguments(var5);
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
