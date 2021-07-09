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
import com.example.Meetstranger.grammar.adapter.RecyclerAdapterWordList;

import com.example.Meetstranger.grammar.utils.CommunicatorFragmentInterface;

public class Word_List_fragment extends BaseFragment implements CommunicatorFragmentInterface {
   private ImageButton backButton;
   private Context context;
   int current_level;
   int dictionary_number;
   private TextView levelNumebertextview;
   private RecyclerAdapterWordList mAdapter;
   private RecyclerView recyclerView;
   private TextView txtAdd;
   private View view;

   private void initUI() {
      this.txtAdd = (TextView)this.view.findViewById(R.id.text_view_add);
      this.backButton = (ImageButton)this.view.findViewById(R.id.image_button);
      this.levelNumebertextview = (TextView)this.view.findViewById(R.id.text_view_title);
      TextView var1 = this.levelNumebertextview;
      StringBuilder var2 = new StringBuilder();
      var2.append("Level-");
      var2.append(Integer.toString(1 + this.current_level));
      var1.setText(var2.toString());
      this.txtAdd.setOnClickListener(v->{
         this.setContentFragment(new Insert_Word_fragment(), true);
      });
      this.backButton.setOnClickListener(v->{
         this.getActivity().onBackPressed();
      });
      this.recyclerView = (RecyclerView)this.view.findViewById(R.id.recycler_view);
      this.mAdapter = new RecyclerAdapterWordList(this.current_level, this.dictionary_number, this.context);
      LinearLayoutManager var5 = new LinearLayoutManager(this.getActivity().getApplicationContext());
      this.recyclerView.setLayoutManager(var5);
      this.recyclerView.setItemAnimator(new DefaultItemAnimator());
      this.recyclerView.setAdapter(this.mAdapter);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.context = this.getActivity();
      this.view = var1.inflate(R.layout.grammar_word_list_fragment, var2, false);
      this.current_level = this.getArguments().getInt("level_no", 0);
      this.dictionary_number = this.getArguments().getInt("dictionary_no", 0);
      this.initUI();
      return this.view;
   }

   public void setContentFragment(Fragment var1, boolean var2) {

      if (var1 != null) {
         FragmentManager var3 = this.getFragmentManager();
         Fragment var4 = var3.findFragmentById(R.id.frame_layout); // 2131296386
         if (var4 == null || !var1.getClass().isAssignableFrom(var4.getClass())) {
            Bundle var5 = new Bundle();
            var5.putInt("level_no", this.current_level);
            var5.putInt("dictionary_no", this.dictionary_number);
            var1.setArguments(var5);
            FragmentTransaction var6 = var3.beginTransaction();
            var6.replace(R.id.frame_layout, var1, var1.getClass().getName()); // 2131296386
            if (var2) {
               var6.addToBackStack(var1.getClass().getName());
            }

            var6.commit();
            var3.executePendingTransactions();
         }
      }

   }

}
