package com.gildedrose.items;

public abstract class Item {

   protected final int MAX_QUALITY = 50;
   protected final int MIN_QUALITY = 0;
   protected final int MIN_SELL_IN = 0;

   public String name;

   //  number of days we have to sell the item
   public int sellIn;

   // how valuable the item is
   public int quality;

   public Item(String name, int sellIn, int quality) {
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
   }

   @Override
   public String toString() {
      return this.name + ", " + this.sellIn + ", " + this.quality;
   }

   public abstract void update();

   protected void decreaseSellIn(Item item) {
      item.sellIn -= 1;
   }

   protected void increaseQuality(Item item) {
      if (item.quality < MAX_QUALITY) {
         item.quality += 1;
      }
   }

   protected void decreaseQuality(Item item) {
      if (item.quality > MIN_QUALITY) {
         item.quality -= 1;
      }
   }
}
