package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;


class GildedRoseTest {

    @Test
    void when_update_quality() {
        // String itemString = doUpdateQuality("foo", 0, 0);
        //Approvals.verify(itemString);
        CombinationApprovals.verifyAllCombinations(
            this::doUpdateQuality,
            // If we only have an if we can have a greater coverage on its opposite path (example of "Sulfuras, Hand of Ragnaros" name)
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 0, 2, 5,6, 10,11},
            new Integer[]{0, 1, 49, 50}
        );

    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //assertEquals("foo", app.items[0].name);

        // Comparing from the txt
        String itemString = app.items[0].toString();
        return itemString;
    }

}
