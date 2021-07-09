package com.example.Meetstranger.grammar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Meetstranger.R;
import com.example.Meetstranger.grammar.adapter.RecyclerAdapterVocabulary;
import com.example.Meetstranger.model.GridName;

import java.util.ArrayList;
import java.util.List;

public class VocabularyActivity extends AppCompatActivity {

   private List gridNames = new ArrayList();
   private RecyclerAdapterVocabulary recyclerAdapter;
   private RecyclerView recyclerView;

   private ImageButton basicWordButton;
   private final OnClickListener basicWordButtonListener = v->{
      this.openDictionary(1);
   };
   private ImageButton advancedWordButton;
   private final OnClickListener advancedWordButtonListener = v->{
      this.openDictionary(2);
   };
   private ImageButton phrasalVerbButton;
   private final OnClickListener phrasalVerbButtonListener = v->{
      this.openDictionary(3);
   };
   private ImageButton idiomsButton;
   private final OnClickListener idiomsButtonListener = v->{
      this.openDictionary(4);
   };
   private ImageButton appliedGrammarButton;
   private final OnClickListener appliedGrammarButtonListener = v->{
      this.openDictionary(5);
   };
   private ImageButton whatsAppShareButton;
   private final OnClickListener whatsAppShareButtonListener = v->{
      Intent sendIntent = new Intent();
      sendIntent.setAction(Intent.ACTION_SEND);
      sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.share));
      sendIntent.setType("text/plain");
      startActivity(sendIntent);
   };

   private void openDictionary(int var1) {
      Intent var2 = new Intent(this, DictionaryActivity.class);
      var2.putExtra("dictionary_no", var1);
      this.startActivity(var2);
   }

   private static final String complexWord = "Advanced Vocabulary";
   private static final String grammar = "Applied Grammar";
   private static final String idioms = "Popular Idioms";
   private static final String phrasalVerb = "Phrasal Verbs";
   private static final String simpleWord = "Basic Vocabulary";
   private static final String whatsApp = "App Share";
   public void clickGridButton(String var1) {
      switch(var1) {
         case simpleWord:
         this.basicWordButton.performClick();
         return;
         case complexWord:
         this.advancedWordButton.performClick();
         return;
         case phrasalVerb:
         this.phrasalVerbButton.performClick();
         return;
         case idioms:
         this.idiomsButton.performClick();
         return;
         case grammar:
         this.appliedGrammarButton.performClick();
         return;
         case whatsApp:
         this.whatsAppShareButton.performClick();
         return;
      default:
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(R.layout.grammar_grid_vocabulary);

      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      this.recyclerView = (RecyclerView)this.findViewById(R.id.recycler_view); // 2131296465
      this.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
      this.recyclerAdapter = new RecyclerAdapterVocabulary(this.gridNames, this);
      this.recyclerView.setAdapter(this.recyclerAdapter);

      GridName var3 = new GridName();
      var3.setTitle("Basic Vocabulary");
      this.gridNames.add(var3);
      GridName var5 = new GridName();
      var5.setTitle("Advanced Vocabulary");
      this.gridNames.add(var5);
      GridName var7 = new GridName();
      var7.setTitle("Phrasal Verbs");
      this.gridNames.add(var7);
      GridName var9 = new GridName();
      var9.setTitle("Popular Idioms");
      this.gridNames.add(var9);
      GridName var11 = new GridName();
      var11.setTitle("Applied Grammar");
      this.gridNames.add(var11);
      GridName var13 = new GridName();
      var13.setTitle("App Share");
      this.gridNames.add(var13);

      this.basicWordButton = new ImageButton(this);
      this.basicWordButton.setOnClickListener(this.basicWordButtonListener);
      this.advancedWordButton = new ImageButton(this);
      this.advancedWordButton.setOnClickListener(this.advancedWordButtonListener);
      this.phrasalVerbButton = new ImageButton(this);
      this.phrasalVerbButton.setOnClickListener(this.phrasalVerbButtonListener);
      this.idiomsButton = new ImageButton(this);
      this.idiomsButton.setOnClickListener(this.idiomsButtonListener);
      this.appliedGrammarButton = new ImageButton(this);
      this.appliedGrammarButton.setOnClickListener(this.appliedGrammarButtonListener);
      this.whatsAppShareButton = new ImageButton(this);
      this.whatsAppShareButton.setOnClickListener(this.whatsAppShareButtonListener);

   }


}
