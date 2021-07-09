package com.example.Meetstranger.model;

import android.util.SparseArray;

public class WordDictionaryInfo {
   private SparseArray level_color;

   public String getLevelColor(int var1) {
      return (String)this.level_color.get(var1);
   }

   public void initialize_first_time() {
      this.level_color = new SparseArray();

      for(int var1 = 0; var1 < 15; ++var1) {
         this.level_color.put(var1, "white");
      }

   }

   public void setLevelColor(int var1, String var2) {
      this.level_color.put(var1, var2);
   }
}
