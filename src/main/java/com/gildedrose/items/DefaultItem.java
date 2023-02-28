package com.gildedrose.items;

public class DefaultItem extends Item {
   public DefaultItem(String name, int sellIn, int quality) {
      super(name, sellIn, quality);
   }

   private static final int DEFAULT_DECREMENT_SELL_IN_THRESHOLD = 0;

   @Override
   public void update() {
      decreaseSellIn(this);

      if (this.quality > DEFAULT_DECREMENT_SELL_IN_THRESHOLD) {
         decreaseQuality(this);
      }
      if (this.sellIn < MIN_SELL_IN && this.quality > MIN_QUALITY) {
         decreaseQuality(this);
      }
   }
}
