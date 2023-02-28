package com.gildedrose;

import com.gildedrose.items.*;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;


class GildedRoseTest {

   @Test
   void when_update_quality() {
      // String itemString = doUpdateQuality("foo", 0, 0);
      //Approvals.verify(itemString);
      CombinationApprovals.verifyAllCombinations(
         this::doUpdateQuality,
         // If we only have an if we can have a greater coverage on its opposite path (example of "Sulfuras, Hand of Ragnaros" name)
         new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
         new Integer[]{-1, 0, 2, 5, 6, 10, 11},
         new Integer[]{0, 1, 49, 50}
      );

   }

   private String doUpdateQuality(String name, int sellIn, int quality) {
      List<Item> items = Collections.singletonList(itemFactory(name, sellIn, quality));

      GildedRose app = new GildedRose();
      app.updateQuality(items);
      //assertEquals("foo", app.items[0].name);

      // Comparing from the txt
      return items.get(0).toString();
   }

   private Item itemFactory(final String name, final int sellIn, final int quality) {
      final String AGED_BRIE = "Aged Brie";
      final String SULFURAS = "Sulfuras, Hand of Ragnaros";
      final String BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

      switch (name) {
         case AGED_BRIE:
            return new AgedBrie(name, sellIn, quality);
         case SULFURAS:
            return new Sulfuras(name, sellIn, quality);
         case BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT:
            return new Backstage(name, sellIn, quality);
         default:
            return new DefaultItem(name, sellIn, quality);
      }
   }

}
