package com.example.Meetstranger.grammar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.Meetstranger.R;
import com.example.Meetstranger.model.Level;
import com.example.Meetstranger.model.Word;
import com.example.Meetstranger.model.WordDictionary;
import com.example.Meetstranger.model.WordDictionaryInfo;
import com.example.Meetstranger.util.AppHelper;
import com.example.Meetstranger.util.PersistData;

public class Insert_Word_fragment extends BaseFragment {
   private Context context;
   String currentDictionaryInfoKey;
   String currentDictionaryKey;
   int current_level_no;
   int dictionary_number;
   private EditText edtExample;
   private EditText edtMeaning;
   private EditText edtWordName;
   private WordDictionary myDictionary;
   private WordDictionaryInfo myDictionaryInfo;
   private TextView txtSubmit;
   private View view;

   // $FF: synthetic method
   static EditText access$000(Insert_Word_fragment var0) {
      return var0.edtWordName;
   }

   // $FF: synthetic method
   static EditText access$100(Insert_Word_fragment var0) {
      return var0.edtMeaning;
   }

   // $FF: synthetic method
   static EditText access$200(Insert_Word_fragment var0) {
      return var0.edtExample;
   }

   // $FF: synthetic method
   static void access$300(Insert_Word_fragment var0, String var1, String var2, String var3) {
      var0.adding_to_database(var1, var2, var3);
   }

   private void adding_to_database(String var1, String var2, String var3) {
      Toast.makeText(getActivity(),var1,Toast.LENGTH_SHORT).show();
      if (TextUtils.isEmpty(var1)) {
         Toast.makeText(this.context, "Enter a Word", Toast.LENGTH_SHORT).show();
      } else if (!this.ifWordExist(var1)) {
         Word var4 = new Word();
         var4.setWordName(var1);
         var4.setMeaning(var2);
         var4.setExample(var3);
         Level var5 = this.myDictionary.getLevel(this.current_level_no);
         var5.AddNewWord(var4);
         this.myDictionary.setLevel(this.current_level_no, var5);
         if (this.myDictionaryInfo.getLevelColor(this.current_level_no).equals("green")) {
            this.myDictionaryInfo.setLevelColor(this.current_level_no, "pink");
         }

         this.saveData();
         Toast.makeText(this.context, "Add successful", Toast.LENGTH_SHORT).show();
         this.getActivity().onBackPressed();
      } else {
         Toast.makeText(this.context, "Already exists", Toast.LENGTH_SHORT).show();
      }
   }

   private boolean ifWordExist(String var1) {
      return false;
   }

   private void initUI() {
      this.myDictionary = new WordDictionary();
      this.myDictionaryInfo = new WordDictionaryInfo();
      Gson var1 = new Gson();
      int var2 = this.dictionary_number;
      if (var2 == 1) {
         this.currentDictionaryKey = AppHelper.basicDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.basicDictionaryInfoKey;
      } else if (var2 == 2) {
         this.currentDictionaryKey = AppHelper.advancedDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.advancedDictionaryInfoKey;
      } else if (var2 == 3) {
         this.currentDictionaryKey = AppHelper.phraseDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.phraseDictionaryInfoKey;
      } else if (var2 == 4) {
         this.currentDictionaryKey = AppHelper.idiomsDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.idiomsDictionaryInfoKey;
      } else if (var2 == 5) {
         this.currentDictionaryKey = AppHelper.grammarDictionaryKey;
         this.currentDictionaryInfoKey = AppHelper.grammarDictionaryInfoKey;
      }

      if (!TextUtils.isEmpty(PersistData.getStringData(this.context.getApplicationContext(), this.currentDictionaryKey))) {
         try {
            this.myDictionary = (WordDictionary)var1.fromJson(PersistData.getStringData(this.context.getApplicationContext(), this.currentDictionaryKey), (new TypeToken() {
            }).getType());
         } catch (Exception var8) {
            this.myDictionary.CreateDefaulWordList(this.dictionary_number);
            String var6 = var1.toJson(this.myDictionary);
            PersistData.setStringData(this.context.getApplicationContext(), this.currentDictionaryKey, var6);
         }
      } else {
         this.myDictionary.CreateDefaulWordList(this.dictionary_number);
         String var3 = var1.toJson(this.myDictionary);
         PersistData.setStringData(this.context.getApplicationContext(), this.currentDictionaryKey, var3);
      }

      if (!TextUtils.isEmpty(PersistData.getStringData(this.context.getApplicationContext(), this.currentDictionaryInfoKey))) {
         try {
            this.myDictionaryInfo = (WordDictionaryInfo)var1.fromJson(PersistData.getStringData(this.context.getApplicationContext(), this.currentDictionaryInfoKey), (new TypeToken() {
            }).getType());
         } catch (Exception var7) {
            this.myDictionaryInfo.initialize_first_time();
            String var5 = var1.toJson(this.myDictionaryInfo);
            PersistData.setStringData(this.context.getApplicationContext(), this.currentDictionaryInfoKey, var5);
         }
      } else {
         this.myDictionaryInfo.initialize_first_time();
         String var4 = var1.toJson(this.myDictionaryInfo);
         PersistData.setStringData(this.context.getApplicationContext(), this.currentDictionaryInfoKey, var4);
      }

      this.txtSubmit = (TextView)this.view.findViewById(R.id.tv1_submit); // 2131296568
      this.edtWordName = (EditText)this.view.findViewById(R.id.et1); // 2131296367
      this.edtMeaning = (EditText)this.view.findViewById(R.id.et2); // 2131296366
      this.edtExample = (EditText)this.view.findViewById(R.id.et3); // 2131296365
      this.txtSubmit.setOnClickListener(new com.example.Meetstranger.grammar.fragment.Insert_Word_fragment$3(this));
      this.txtSubmit.setImeOptions(6);
   }

   private void insertDefaultWords() {
   }

   private void saveData() {
      Gson var1 = new Gson();
      String var2 = var1.toJson(this.myDictionary);
      PersistData.setStringData(this.context.getApplicationContext(), this.currentDictionaryKey, var2);
      String var3 = var1.toJson(this.myDictionaryInfo);
      PersistData.setStringData(this.context.getApplicationContext(), this.currentDictionaryInfoKey, var3);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.context = this.getActivity();
      this.view = var1.inflate(R.layout.grammar_insert_word_fragment, var2, false);
      Bundle var4 = this.getArguments();
      this.current_level_no = var4.getInt("level_no", 0);
      this.dictionary_number = var4.getInt("dictionary_no", 0);
      this.initUI();
      return this.view;
   }
}
