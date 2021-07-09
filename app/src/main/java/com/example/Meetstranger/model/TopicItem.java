package com.example.Meetstranger.model;

public class TopicItem {
   private String RoomName;
   private String Title;
   private int Type;

   public String getRoomName() {
      return this.RoomName;
   }

   public String getTitle() {
      return this.Title;
   }

   public int getType() {
      return this.Type;
   }

   public void setRoomName(String var1) {
      this.RoomName = var1;
   }

   public void setTitle(String var1) {
      this.Title = var1;
   }

   public void setType(int var1) {
      this.Type = var1;
   }
}
