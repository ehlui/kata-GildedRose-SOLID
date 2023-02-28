package com.gildedrose.items;

public class Backstage extends Item {
   public Backstage(String name, int sellIn, int quality) {
      super(name, sellIn, quality);
   }

   //::  Backstage thresholds
   // Quality drops to 0 after the concert
   private static final int BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD = 0;
   // Quality increases by 2 when there are 10 days or less
   private static final int BACKSTAGE_PASSES_INCREASE_QUALITY_BY_TWO_THRESHOLD = 10;
   private static final int BACKSTAGE_PASSES_INCREASE_QUALITY_BY_THREE_THRESHOLD = 5;

   @Override
   public void update() {
      increaseQuality();

      if (this.sellIn <= BACKSTAGE_PASSES_INCREASE_QUALITY_BY_TWO_THRESHOLD) {
         increaseQuality();
      }

      if (this.sellIn <= BACKSTAGE_PASSES_INCREASE_QUALITY_BY_THREE_THRESHOLD) {
         increaseQuality();
      }

      decreaseSellIn();

      if (this.sellIn < BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD) {
         this.quality -= this.quality;
      }
   }
}
