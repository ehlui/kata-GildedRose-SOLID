package com.gildedrose.items;

public class AgedBrie extends Item {
   public AgedBrie(String name, int sellIn, int quality) {
      super(name, sellIn, quality);
   }

   @Override
   public void update() {
      decreaseSellIn(this);

      if (this.quality < MAX_QUALITY) {
         increaseQuality(this);
      }

      if (this.sellIn < MIN_SELL_IN && this.quality < MAX_QUALITY) {
         this.quality += 1;
      }
   }
}
