package com.example.Meetstranger.grammar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Meetstranger.R;
import com.example.Meetstranger.model.GridName;

import java.util.List;

public class RecyclerAdapterVocabulary extends RecyclerView.Adapter<RecyclerAdapterVocabulary.MyViewHolder> {
   List itemList;
   Context myContext;
   private TextView textView;

   public RecyclerAdapterVocabulary(List var1, Context var2) {
      this.itemList = var1;
      this.myContext = var2;
   }

   public int getItemCount() {
      return this.itemList.size();
   }

   public void onBindViewHolder(MyViewHolder var1, int var2) {
      GridName var3 = (GridName)this.itemList.get(var2);
      var1.textView.setText(var3.getTitle());

      var1.textView.setOnClickListener(new com.example.Meetstranger.grammar.adapter.RecyclerAdapterVocabulary$1(this, var2));
   }

   public MyViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new MyViewHolder(LayoutInflater.from(var1.getContext()).inflate(R.layout.grammar_item_row, var1, false));
   }

   public static class MyViewHolder extends RecyclerView.ViewHolder {
      TextView textView;

      public MyViewHolder(View var1) {
         super(var1);
         this.textView = (TextView)var1.findViewById(R.id.text_view);
      }
   }
}
