package com.example.Meetstranger.grammar.adapter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.Meetstranger.model.Word;

class RecyclerAdapterWordList$4$2 implements OnClickListener {
   // $FF: synthetic field
   final RecyclerAdapterWordList$4 this$1;
   // $FF: synthetic field
   final Dialog val$dialog;

   RecyclerAdapterWordList$4$2(RecyclerAdapterWordList$4 var1, Dialog var2) {
      this.this$1 = var1;
      this.val$dialog = var2;
   }

   public void onClick(View var1) {
      Toast.makeText(var1.getContext().getApplicationContext(), "Item will be displayed during conversation.", Toast.LENGTH_SHORT).show();
      if (!((Word)this.this$1.this$0.wordList.get(this.this$1.val$position)).getFlag().equals("red")) {
         this.this$1.this$0.wordListToBeDisplayed.AddInList((Word)this.this$1.this$0.wordList.get(this.this$1.val$position));
      }

      ((Word)this.this$1.this$0.wordList.get(this.this$1.val$position)).setFlag("red");
      this.this$1.this$0.myDictionaryInfo.setLevelColor(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$100(this.this$1.this$0).getLevel_number(), "pink");
      com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.access$200(this.this$1.this$0);
      this.this$1.this$0.notifyDataSetChanged();
      this.val$dialog.dismiss();
   }
}
