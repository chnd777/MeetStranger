package com.example.Meetstranger.grammar.adapter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.Meetstranger.model.Word;

class RecyclerAdapterWordList$4$3 implements OnClickListener {
   // $FF: synthetic field
   final RecyclerAdapterWordList$4 this$1;
   // $FF: synthetic field
   final Dialog val$dialog;

   RecyclerAdapterWordList$4$3(RecyclerAdapterWordList$4 var1, Dialog var2) {
      this.this$1 = var1;
      this.val$dialog = var2;
   }

   public void onClick(View var1) {
      this.this$1.this$0.wordListToBeDisplayed.RemoveFromList((Word)this.this$1.this$0.wordList.get(this.this$1.val$position));
      this.this$1.this$0.wordList.remove(this.this$1.val$position);
      int var3 = 0;

      boolean var4;
      while(true) {
         if (var3 >= this.this$1.this$0.wordList.size()) {
            var4 = true;
            break;
         }

         if (!((Word)this.this$1.this$0.wordList.get(var3)).getFlag().equals("green")) {
            var4 = false;
            break;
         }

         ++var3;
      }

      int var5 = 0;

      boolean var6;
      while(true) {
         if (var5 >= this.this$1.this$0.wordList.size()) {
            var6 = true;
            break;
         }

         if (!((Word)this.this$1.this$0.wordList.get(var5)).getFlag().equals("white")) {
            var6 = false;
            break;
         }

         ++var5;
      }

      if (var4) {
         this.this$1.this$0.myDictionaryInfo.setLevelColor(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$100(this.this$1.this$0).getLevel_number(), "green");
      } else if (var6) {
         this.this$1.this$0.myDictionaryInfo.setLevelColor(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$100(this.this$1.this$0).getLevel_number(), "white");
      } else {
         this.this$1.this$0.myDictionaryInfo.setLevelColor(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$100(this.this$1.this$0).getLevel_number(), "pink");
      }

      com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$200(this.this$1.this$0);
      this.this$1.this$0.notifyDataSetChanged();
      this.val$dialog.dismiss();
   }
}
