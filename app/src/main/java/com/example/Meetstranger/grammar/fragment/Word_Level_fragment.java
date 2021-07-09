package com.example.Meetstranger.grammar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Meetstranger.R;
import com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordLevel;

import com.example.Meetstranger.grammar.utils.CommunicatorFragmentInterface;

public class Word_Level_fragment extends BaseFragment implements CommunicatorFragmentInterface {
   private ImageButton backButton;
   private Context context;
   private TextView dictionaryNametextview;
   private int dictionary_number;
   private RecyclerAdapterWordLevel mAdapter;
   private RecyclerView recyclerView;
   private View view;

   private void initUI() {
      this.recyclerView = this.view.findViewById(R.id.recycler_view);
      this.backButton = this.view.findViewById(R.id.image_button);
      this.backButton.setOnClickListener(v->{
         this.getActivity().onBackPressed();
      });
      this.mAdapter = new RecyclerAdapterWordLevel(this.dictionary_number, this.context);
      LinearLayoutManager var1 = new LinearLayoutManager(this.getActivity().getApplicationContext());
      this.recyclerView.setLayoutManager(var1);
      this.recyclerView.setItemAnimator(new DefaultItemAnimator());
      this.recyclerView.setAdapter(this.mAdapter);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.context = this.getActivity();
      this.dictionary_number = this.getArguments().getInt("dictionary_no", 0);
      this.view = var1.inflate(R.layout.grammar_word_level_fragment, var2, false);
      this.dictionaryNametextview = (TextView)this.view.findViewById(R.id.text_view);
      switch(this.dictionary_number) {
      case 1:
         this.dictionaryNametextview.setText("Basic Vocabulary");
         break;
      case 2:
         this.dictionaryNametextview.setText("Advanced Vocabulary");
         break;
      case 3:
         this.dictionaryNametextview.setText("Phrasal Verbs");
         break;
      case 4:
         this.dictionaryNametextview.setText("Idioms");
         break;
      case 5:
         this.dictionaryNametextview.setText("Applied Grammar");
      }

      this.initUI();
      return this.view;
   }

   public void onResume() {
      super.onResume();
      this.mAdapter.updateLevelInfo();
      this.mAdapter.notifyDataSetChanged();
   }

   public void setContentFragment(Fragment var1, boolean var2) {

      if (var1 != null) {
         FragmentManager var3 = this.getFragmentManager();
         Fragment var4 = var3.findFragmentById(R.id.frame_layout);
         if (var4 == null || !var1.getClass().isAssignableFrom(var4.getClass())) {
            Bundle var5 = new Bundle();
            var5.putInt("dictionary_no", this.dictionary_number);
            var1.setArguments(var5);
            FragmentTransaction var6 = var3.beginTransaction();
            var6.replace(R.id.frame_layout, var1, var1.getClass().getName());
            if (var2) {
               var6.addToBackStack(var1.getClass().getName());
            }

            var6.commit();
            var3.executePendingTransactions();
         }
      }

   }

}
