package com.example.Meetstranger.grammar.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.Meetstranger.R;
import com.example.Meetstranger.grammar.ListActivity;
import com.example.Meetstranger.model.WordDictionaryInfo;
import com.example.Meetstranger.util.AppHelper;
import com.example.Meetstranger.util.PersistData;

import java.lang.reflect.Type;

public class RecyclerAdapterWordLevel extends RecyclerView.Adapter<RecyclerAdapterWordLevel.MyViewHolder> {
   private Context contex;
   String currentDictionaryInfoKey;
   int dictionary_number;
   WordDictionaryInfo myDictionaryInfo;
   final int total_level = 15;

   public RecyclerAdapterWordLevel(int var1, Context var2) {
      this.contex = var2;
      this.dictionary_number = var1;
      this.myDictionaryInfo = new WordDictionaryInfo();
      Gson var3 = new Gson();
      int var4 = this.dictionary_number;
      if (var4 == 1) {
         this.currentDictionaryInfoKey = AppHelper.basicDictionaryInfoKey;
      } else if (var4 == 2) {
         this.currentDictionaryInfoKey = AppHelper.advancedDictionaryInfoKey;
      } else if (var4 == 3) {
         this.currentDictionaryInfoKey = AppHelper.phraseDictionaryInfoKey;
      } else if (var4 == 4) {
         this.currentDictionaryInfoKey = AppHelper.idiomsDictionaryInfoKey;
      } else if (var4 == 5) {
         this.currentDictionaryInfoKey = AppHelper.grammarDictionaryInfoKey;
      }

      if (!TextUtils.isEmpty(PersistData.getStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey))) {
         try {
            this.myDictionaryInfo = (WordDictionaryInfo)var3.fromJson(PersistData.getStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey), (new TypeToken() {
            }).getType());
         } catch (Exception var7) {
            this.myDictionaryInfo.initialize_first_time();
            String var6 = var3.toJson(this.myDictionaryInfo);
            PersistData.setStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey, var6);
         }
      } else {
         this.myDictionaryInfo.initialize_first_time();
         String var5 = var3.toJson(this.myDictionaryInfo);
         PersistData.setStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey, var5);
      }
   }

   public int getItemCount() {
      return 15;
   }

   public void onBindViewHolder(MyViewHolder var1, int var2) {
      TextView var3 = var1.textView;
      StringBuilder var4 = new StringBuilder();
      var4.append("Level-");
      var4.append(Integer.toString(var2 + 1));
      var3.setText(var4.toString());

      var1.itemView.setOnClickListener(v->{
         Intent intent = new Intent(contex.getApplicationContext(), ListActivity.class);
         intent.putExtra("level_no", var2);
         intent.putExtra("dictionary_no", this.dictionary_number);
         contex.startActivity(intent);
      });
   }

   public MyViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new MyViewHolder(LayoutInflater.from(var1.getContext()).inflate(R.layout.grammar_data_row, var1, false));
   }

   public void updateLevelInfo() {
      Gson var1 = new Gson();

      if (!TextUtils.isEmpty(PersistData.getStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey))) {
         Type collectionType = new TypeToken<WordDictionaryInfo>(){}.getType();
         this.myDictionaryInfo = (WordDictionaryInfo)var1.fromJson(PersistData.getStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey),collectionType);
      }

   }

   public static class MyViewHolder extends RecyclerView.ViewHolder {
      TextView textView;

      public MyViewHolder(View var1) {
         super(var1);
         this.textView = (TextView)var1.findViewById(R.id.text_view);
      }
   }
}
