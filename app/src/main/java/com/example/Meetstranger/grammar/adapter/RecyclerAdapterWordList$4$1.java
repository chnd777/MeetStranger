package com.example.Meetstranger.grammar.adapter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.Meetstranger.model.Word;

class RecyclerAdapterWordList$4$1 implements OnClickListener {
   // $FF: synthetic field
   final com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList$4 this$1;
   // $FF: synthetic field
   final Dialog val$dialog;

   RecyclerAdapterWordList$4$1(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList$4 var1, Dialog var2) {
      this.this$1 = var1;
      this.val$dialog = var2;
   }

   public void onClick(View var1) {
      this.this$1.this$0.wordListToBeDisplayed.RemoveFromList((Word)this.this$1.this$0.wordList.get(this.this$1.val$position));
      ((Word)this.this$1.this$0.wordList.get(this.this$1.val$position)).setFlag("green");
      int var2 = 0;

      boolean var3;
      while(true) {
         if (var2 >= this.this$1.this$0.wordList.size()) {
            var3 = true;
            break;
         }

         if (!((Word)this.this$1.this$0.wordList.get(var2)).getFlag().equals("green")) {
            var3 = false;
            break;
         }

         ++var2;
      }

      if (var3) {
         this.this$1.this$0.myDictionaryInfo.setLevelColor(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$100(this.this$1.this$0).getLevel_number(), "green");
      } else {
         this.this$1.this$0.myDictionaryInfo.setLevelColor(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$100(this.this$1.this$0).getLevel_number(), "pink");
      }

      com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$200(this.this$1.this$0);
      this.this$1.this$0.notifyDataSetChanged();
      this.val$dialog.dismiss();
   }
}
