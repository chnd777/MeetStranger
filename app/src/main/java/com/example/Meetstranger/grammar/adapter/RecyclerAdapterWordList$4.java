package com.example.Meetstranger.grammar.adapter;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.Meetstranger.R;
import com.example.Meetstranger.model.Word;

class RecyclerAdapterWordList$4 implements OnClickListener {
   // $FF: synthetic field
   final com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList this$0;
   // $FF: synthetic field
   final com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.MyViewHolder val$holder;
   // $FF: synthetic field
   final int val$position;

   RecyclerAdapterWordList$4(com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList var1, com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList.MyViewHolder var2, int var3) {
      this.this$0 = var1;
      this.val$holder = var2;
      this.val$position = var3;
   }

   public void onClick(View var1) {



      Word var2 = (Word)this.this$0.wordList.get(this.val$position);
      Dialog var3 = new Dialog(var1.getContext());
      var3.requestWindowFeature(1);
      var3.setContentView(R.layout.grammar_dialouge);
      var3.setCanceledOnTouchOutside(true);
      TextView var5 = (TextView)var3.findViewById(R.id.tv1);
      TextView var6 = (TextView)var3.findViewById(R.id.tv2);
      TextView var7 = (TextView)var3.findViewById(R.id.tv3);
      TextView var8 = (TextView)var3.findViewById(R.id.tv4);
      TextView var9 = (TextView)var3.findViewById(R.id.tv5);
      TextView var10 = (TextView)var3.findViewById(R.id.tv6);
      var8.setOnClickListener(new RecyclerAdapterWordList$4$1(this, var3));
      var9.setOnClickListener(new com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList$4$2(this, var3));
      var10.setOnClickListener(new com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList$4$3(this, var3));
      var3.setOnCancelListener(new RecyclerAdapterWordList$4$4(this));
      var6.setText(var2.getMeaning());
      var7.setText(var2.getExample());
      var5.setText(var2.getWordName());
      var3.show();
      //
   }
}
