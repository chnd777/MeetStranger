package com.example.Meetstranger.model;

public class Word {
   int color = 0;
   String example;
   String flag = "white";
   String meaning;
   String wordName;

   static Word getNewWord(String var0, String var1, String var2) {
      Word var3 = new Word();
      var3.setWordName(var0);
      var3.setMeaning(var1);
      var3.setExample(var2);
      return var3;
   }

   public int getColor() {
      return this.color;
   }

   public String getExample() {
      return this.example;
   }

   public String getFlag() {
      return this.flag;
   }

   public String getMeaning() {
      return this.meaning;
   }

   public String getWordName() {
      return this.wordName;
   }

   public void setColor(int var1) {
      this.color = var1;
   }

   public void setExample(String var1) {
      this.example = var1;
   }

   public void setFlag(String var1) {
      this.flag = var1;
   }

   public void setMeaning(String var1) {
      this.meaning = var1;
   }

   public void setWordName(String var1) {
      this.wordName = var1;
   }
}
