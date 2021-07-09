package com.example.Meetstranger.grammar.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.Meetstranger.R;
import com.example.Meetstranger.model.Level;
import com.example.Meetstranger.model.Word;
import com.example.Meetstranger.model.WordDictionary;
import com.example.Meetstranger.model.WordDictionaryInfo;
import com.example.Meetstranger.model.WordListToBeDisplayed;
import com.example.Meetstranger.util.AppHelper;
import com.example.Meetstranger.util.PersistData;

import java.util.List;

public class RecyclerAdapterWordList extends RecyclerView.Adapter<RecyclerAdapterWordList.MyViewHolder> {
   private Context contex;
   String currentDictionaryInfoKey;
   String currentDictionaryKey;
   private Level current_level;
   int dictionary_number;
   WordDictionary myDictionary;
   WordDictionaryInfo myDictionaryInfo;
   List wordList;
   WordListToBeDisplayed wordListToBeDisplayed;

   public RecyclerAdapterWordList(int var1, int var2, Context var3) {
      this.contex = var3;
      this.dictionary_number = var2;
      this.myDictionary = new WordDictionary();
      this.myDictionaryInfo = new WordDictionaryInfo();
      this.wordListToBeDisplayed = new WordListToBeDisplayed();
      Gson var4 = new Gson();
      int var5 = this.dictionary_number;
      if (var5 == 1) {
         this.currentDictionaryKey = AppHelper.basicDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.basicDictionaryInfoKey;
      } else if (var5 == 2) {
         this.currentDictionaryKey = AppHelper.advancedDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.advancedDictionaryInfoKey;
      } else if (var5 == 3) {
         this.currentDictionaryKey = AppHelper.phraseDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.phraseDictionaryInfoKey;
      } else if (var5 == 4) {
         this.currentDictionaryKey = AppHelper.idiomsDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.idiomsDictionaryInfoKey;
      } else if (var5 == 5) {
         this.currentDictionaryKey = AppHelper.grammarDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.grammarDictionaryInfoKey;
      }

      if (!TextUtils.isEmpty(PersistData.getStringData(var3.getApplicationContext(), this.currentDictionaryKey))) {
         try {
            this.myDictionary = (WordDictionary)var4.fromJson(PersistData.getStringData(var3.getApplicationContext(), this.currentDictionaryKey), (new TypeToken() {
            }).getType());
         } catch (Exception var14) {
            this.myDictionary.CreateDefaulWordList(this.dictionary_number);
            String var11 = var4.toJson(this.myDictionary);
            PersistData.setStringData(var3.getApplicationContext(), this.currentDictionaryKey, var11);
         }
      } else {
         this.myDictionary.CreateDefaulWordList(this.dictionary_number);
         String var6 = var4.toJson(this.myDictionary);
         PersistData.setStringData(var3.getApplicationContext(), this.currentDictionaryKey, var6);
      }

      if (!TextUtils.isEmpty(PersistData.getStringData(var3.getApplicationContext(), this.currentDictionaryInfoKey))) {
         try {
            this.myDictionaryInfo = (WordDictionaryInfo)var4.fromJson(PersistData.getStringData(var3.getApplicationContext(), this.currentDictionaryInfoKey), (new TypeToken() {
            }).getType());
         } catch (Exception var13) {
            this.myDictionaryInfo.initialize_first_time();
            String var10 = var4.toJson(this.myDictionaryInfo);
            PersistData.setStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey, var10);
         }
      } else {
         this.myDictionaryInfo.initialize_first_time();
         String var7 = var4.toJson(this.myDictionaryInfo);
         PersistData.setStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey, var7);
      }

      if (!TextUtils.isEmpty(PersistData.getStringData(var3.getApplicationContext(), AppHelper.displayKey))) {
         try {
            this.wordListToBeDisplayed = (WordListToBeDisplayed)var4.fromJson(PersistData.getStringData(var3.getApplicationContext(), AppHelper.displayKey), (new TypeToken() {
            }).getType());
         } catch (Exception var12) {
            this.wordListToBeDisplayed.initialize_first_time();
            String var9 = var4.toJson(this.wordListToBeDisplayed);
            PersistData.setStringData(var3.getApplicationContext(), AppHelper.displayKey, var9);
         }
      } else {
         this.wordListToBeDisplayed.initialize_first_time();
         String var8 = var4.toJson(this.wordListToBeDisplayed);
         PersistData.setStringData(var3.getApplicationContext(), AppHelper.displayKey, var8);
      }

      this.wordList = this.myDictionary.getLevel(var1).getWordList();
      this.current_level = this.myDictionary.getLevel(var1);
   }

   // $FF: synthetic method
   static Context access$000(RecyclerAdapterWordList var0) {
      return var0.contex;
   }

   // $FF: synthetic method
   static Level access$100(RecyclerAdapterWordList var0) {
      return var0.current_level;
   }

   // $FF: synthetic method
   static void access$200(RecyclerAdapterWordList var0) {
      var0.saveData();
   }

   private void saveData() {
      this.current_level.setWordList(this.wordList);
      this.myDictionary.setLevel(this.current_level.getLevel_number(), this.current_level);
      Gson var2 = new Gson();
      String var3 = var2.toJson(this.myDictionary);
      PersistData.setStringData(this.contex.getApplicationContext(), this.currentDictionaryKey, var3);
      String var4 = var2.toJson(this.myDictionaryInfo);
      PersistData.setStringData(this.contex.getApplicationContext(), this.currentDictionaryInfoKey, var4);
      String var5 = var2.toJson(this.wordListToBeDisplayed);
      PersistData.setStringData(this.contex.getApplicationContext(), AppHelper.displayKey, var5);
   }

   public int getItemCount() {
      return this.wordList.size();
   }

   public void onBindViewHolder(MyViewHolder holder, int pos) {
      Word word = (Word)this.current_level.getWordList().get(pos);
      holder.textView.setText(word.getWordName());

      /*
      if (word.getFlag().equalsIgnoreCase("green")) {
         holder.textView.setBackgroundColor(this.contex.getResources().getColor(R.color.grammar_used_it)); // 2131099750
      } else if (word.getFlag().equalsIgnoreCase("red")) {
         holder.textView.setBackgroundColor(this.contex.getResources().getColor(R.color.grammar_will_use)); // 2131099705
      } else {
         holder.textView.setBackgroundColor(this.contex.getResources().getColor(R.color.grammar_not_used)); // 2131099863
      }
      */

      holder.itemView.setOnClickListener(new RecyclerAdapterWordList$4(this, holder, pos));
   }

   public MyViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new MyViewHolder(LayoutInflater.from(var1.getContext()).inflate(R.layout.grammar_data_row, var1, false));
   }

   public static class MyViewHolder extends RecyclerView.ViewHolder {
      TextView textView;

      public MyViewHolder(View var1) {
         super(var1);
         this.textView = (TextView)var1.findViewById(R.id.text_view);
      }
   }
}
