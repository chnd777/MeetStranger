package com.example.Meetstranger.grammar.fragment;

import android.view.View;
import android.view.View.OnClickListener;

class Insert_Word_fragment$3 implements OnClickListener {
   // $FF: synthetic field
   final Insert_Word_fragment this$0;

   Insert_Word_fragment$3(Insert_Word_fragment var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      Insert_Word_fragment var2 = this.this$0;
      Insert_Word_fragment.access$300(var2, Insert_Word_fragment.access$000(var2).getText().toString().trim(), Insert_Word_fragment.access$100(this.this$0).getText().toString().trim(), Insert_Word_fragment.access$200(this.this$0).getText().toString().trim());
   }
}
