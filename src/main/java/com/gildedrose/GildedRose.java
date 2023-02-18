package com.gildedrose;

class GildedRose {


   private final String AGED_BRIE = "Aged Brie";
   private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
   private final String BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

   // NOTE: The Quality of an item is never more than 50
   private final int MAX_QUALITY = 50;
   private final int MIN_QUALITY = 0;
   private final int MIN_SELL_IN = 0;


   // Once the sell by date has passed, Quality degrades twice as fast (edible items, e.g. age_brie)


   private static final int DEFAULT_DECREMENT_SELL_IN_THRESHOLD = 0;

   //::  Backstage thresholds
   // Quality drops to 0 after the concert
   private static final int BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD = 0;
   // Quality increases by 2 when there are 10 days or less
   private static final int BACKSTAGE_PASSES_INCREASE_QUALITY_BY_TWO_THRESHOLD = 10;
   private static final int BACKSTAGE_PASSES_INCREASE_QUALITY_BY_THREE_THRESHOLD = 5;


   Item[] items;

   public GildedRose(Item[] items) {
      this.items = items;
   }

   // System update does:  At the end of each day our system lowers both values (Quality and SellIn) for every item

   public void updateQuality() {
      for (Item item : items) {
         switch (item.name) {
            case AGED_BRIE:
               decreaseSellIn(item);
               updateAgedBrieItemQuality(item);
               break;
            case BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT:
               //decreaseSellIn(item);
               updateBackstageItemQuality(item);
               break;
            case SULFURAS:
               break;
            default:
               decreaseSellIn(item);
               updateOtherItemQuality(item);
               break;
         }
      }
   }


   public void updateOtherItemQuality(Item item) {
      if (item.quality > DEFAULT_DECREMENT_SELL_IN_THRESHOLD) {
         decreaseQuality(item);
      }
      if (item.sellIn < MIN_SELL_IN && item.quality > MIN_QUALITY) {
         decreaseQuality(item);
      }
   }

   public void updateAgedBrieItemQuality(Item item) {
      if (item.quality < MAX_QUALITY) {
         increaseQuality(item);
      }

      if (item.sellIn < MIN_SELL_IN && item.quality < MAX_QUALITY)
         item.quality += 1;
   }

   public void updateBackstageItemQuality(Item item) {
      increaseQuality(item);

      if (item.sellIn <= BACKSTAGE_PASSES_INCREASE_QUALITY_BY_TWO_THRESHOLD) {
         increaseQuality(item);
      }

      if (item.sellIn <= BACKSTAGE_PASSES_INCREASE_QUALITY_BY_THREE_THRESHOLD) {
         increaseQuality(item);
      }

      decreaseSellIn(item);

      if (item.sellIn < BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_THRESHOLD) {
         item.quality -= item.quality;
      }
   }

   public void updateSulfurasItemQuality(Item item) {
      // do nothing
   }

   private void decreaseSellIn(Item item) {
      item.sellIn -= 1;
   }

   private void increaseQuality(Item item) {
      if (item.quality < MAX_QUALITY) {
         item.quality += 1;
      }
   }

   private void decreaseQuality(Item item) {
      if (item.quality > MIN_QUALITY) {
         item.quality -= 1;
      }
   }

}
