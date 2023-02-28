package com.gildedrose;

import com.gildedrose.items.Item;

import java.util.Arrays;

class GildedRose {
   // System update does:  At the end of each day our system lowers both values (Quality and SellIn) for every item
   public void updateQuality(Item[] items) {
      Arrays.stream(items).forEach(Item::update);
   }

}
