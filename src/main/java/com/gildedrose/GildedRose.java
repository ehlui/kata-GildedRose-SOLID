package com.gildedrose;

import com.gildedrose.items.Item;

import java.util.List;

class GildedRose {
   // System update does:  At the end of each day our system lowers both values (Quality and SellIn) for every item
   public void updateQuality(List<Item> items) {
      items.forEach(Item::update);
   }

}
