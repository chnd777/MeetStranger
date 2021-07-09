package com.example.Meetstranger.model;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordListToBeDisplayed {
   private Word defaultWord;
   private SparseArray level_color;
   private List wordList;

   public void AddInList(Word var1) {
      for(int var2 = 0; var2 < this.wordList.size(); ++var2) {
         if (((Word)this.wordList.get(var2)).getWordName().equals(var1.getWordName()) && ((Word)this.wordList.get(var2)).getMeaning().equals(var1.getMeaning()) && ((Word)this.wordList.get(var2)).getExample().equals(var1.getExample())) {
            return;
         }
      }

      this.wordList.add(var1);
   }

   public void RemoveFromList(Word var1) {
      for(int var2 = 0; var2 < this.wordList.size(); ++var2) {
         if (((Word)this.wordList.get(var2)).getWordName().equals(var1.getWordName()) && ((Word)this.wordList.get(var2)).getMeaning().equals(var1.getMeaning()) && ((Word)this.wordList.get(var2)).getExample().equals(var1.getExample())) {
            List var3 = this.wordList;
            var3.remove(var3.get(var2));
            return;
         }
      }

   }

   public Word getAWordFromList() {
      if (this.wordList.size() > 1) {
         int var1 = 1 + (new Random()).nextInt(this.wordList.size() - 1);
         return (Word)this.wordList.get(var1);
      } else {
         return this.defaultWord;
      }
   }

   public void initialize_first_time() {
      this.wordList = new ArrayList();
      this.defaultWord = new Word();
      this.defaultWord.setWordName("In A Call");
      this.defaultWord.setMeaning("");
      this.defaultWord.setExample("");
      this.wordList.add(this.defaultWord);
   }
}
