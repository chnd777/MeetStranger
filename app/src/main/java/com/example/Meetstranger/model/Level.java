package com.example.Meetstranger.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Level {
   int level_color;
   String level_name;
   int level_no;
   private List wordList;

   public void AddNewWord(Word var1) {
      this.wordList.add(var1);
      this.SortWords();
   }

   public void DeleteWord(Word var1) {
      this.wordList.remove(var1);
      this.SortWords();
   }

   void SortWords() {
      Collections.sort(this.wordList, new Comparator() {
         public int compare(Object var1, Object var2) {
            return ((Word)var1).wordName.toLowerCase().compareTo(((Word)var2).wordName.toLowerCase());
         }
      });
   }

   void fetchDefaultWordList(int var1, int var2) {
      if (var1 == 1) {
         this.wordList = BasicWordDefault.getWordListByLevel(var2);
      } else if (var1 == 2) {
         this.wordList = AdvancedWordDefault.getWordListByLevel(var2);
      } else if (var1 == 3) {
         this.wordList = PhraseDefault.getWordListByLevel(var2);
      } else if (var1 == 4) {
         this.wordList = IdiomsDefault.getWordListByLevel(var2);
      } else if (var1 == 5) {
         this.wordList = GrammarDefault.getWordListByLevel(var2);
      }

      this.SortWords();
   }

   int getLevel_color() {
      return this.level_color;
   }

   public String getLevel_name() {
      return this.level_name;
   }

   public int getLevel_number() {
      return this.level_no;
   }

   public List getWordList() {
      return this.wordList;
   }

   void setLevelColor(int var1) {
      this.level_color = var1;
   }

   public void setLevelName(String var1) {
      this.level_name = var1;
   }

   void setLevelNumber(int var1) {
      this.level_no = var1;
   }

   public void setWordList(List var1) {
      this.wordList = var1;
   }
}
