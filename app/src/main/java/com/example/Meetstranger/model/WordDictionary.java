package com.example.Meetstranger.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordDictionary {
   private List levelList;

   public void AddNewLevel(Level var1) {
      this.levelList.add(var1);
   }

   public void CreateDefaulWordList(int var1) {
      this.levelList = new ArrayList();

      int var6;
      for(int var2 = 0; var2 < 15; var2 = var6) {
         Level var3 = new Level();
         StringBuilder var4 = new StringBuilder();
         var4.append("Level-");
         var6 = var2 + 1;
         var4.append(Integer.toString(var6));
         var3.setLevelName(var4.toString());
         var3.setLevelNumber(var2);
         var3.setLevelColor(0);
         var3.fetchDefaultWordList(var1, var2);
         this.levelList.add(var3);
      }

   }

   public void DeleteLevel(Level var1) {
      this.levelList.remove(var1);
   }

   public Level getLevel(int var1) {
      return (Level)this.levelList.get(var1);
   }

   public Level setLevel(int var1, Level var2) {
      return (Level)this.levelList.set(var1, var2);
   }

   public void sortLevels() {
      Collections.sort(this.levelList, new Comparator() {
         public int compare(Object var1, Object var2) {
            return (new Integer(((Level)var1).level_no)).compareTo(((Level)var2).level_no);
         }
      });
   }
}
