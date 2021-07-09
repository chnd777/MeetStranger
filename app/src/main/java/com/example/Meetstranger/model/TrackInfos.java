package com.example.Meetstranger.model;

public class TrackInfos {
   private String albumName = "";
   private String id = "";
   private boolean selected = false;
   private String songDuration = "";
   private String songSize = "";
   private String trackArist = "";
   private String trackId = "";
   private String trackName = "";
   private String trackPath = "";

   public TrackInfos() {
   }

   public TrackInfos(String var1, String var2, String var3, String var4, String var5) {
      this.id = var1;
      this.trackId = var2;
      this.trackName = var3;
      this.trackArist = var4;
      this.trackPath = var5;
      this.selected = this.selected;
   }

   public String getAlbumName() {
      return this.albumName;
   }

   public String getId() {
      return this.id;
   }

   public String getSongDuration() {
      return this.songDuration;
   }

   public String getSongSize() {
      return this.songSize;
   }

   public String getTrackArist() {
      return this.trackArist;
   }

   public String getTrackId() {
      return this.trackId;
   }

   public String getTrackName() {
      return this.trackName;
   }

   public String getTrackPath() {
      return this.trackPath;
   }

   public boolean isSelected() {
      return this.selected;
   }

   public void setAlbumName(String var1) {
      this.albumName = var1;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setSelected(boolean var1) {
      this.selected = var1;
   }

   public void setSongDuration(String var1) {
      this.songDuration = var1;
   }

   public void setSongSize(String var1) {
      this.songSize = var1;
   }

   public void setTrackArist(String var1) {
      this.trackArist = var1;
   }

   public void setTrackId(String var1) {
      this.trackId = var1;
   }

   public void setTrackName(String var1) {
      this.trackName = var1;
   }

   public void setTrackPath(String var1) {
      this.trackPath = var1;
   }
}
