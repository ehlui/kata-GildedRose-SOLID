package com.gildedrose;

class GildedRose {
    Item[] items;

    private final String ITEM_NAME_EQ_AGED_BRIE = "Aged Brie";
    private final String NAME_EQ_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String NAME_EQ_SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final int ITEM_QUALITY_GREATER_THAN_0 = 0;
    private final int ITEM_QUALITY_LOWER_THAN_50 = 50;
    private final int ITEM_SELL_IN_LOWER_THAN_11 = 11;
    private final int ITEM_SELL_IN_LOWER_THAN_6 = 6;
    private final int ITEM_SELL_IN_LOWER_THAN_0 = 0;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(ITEM_NAME_EQ_AGED_BRIE)
                && !items[i].name.equals(NAME_EQ_BACKSTAGE_PASSES)) {
                if (items[i].quality > ITEM_QUALITY_GREATER_THAN_0) {
                    if (!items[i].name.equals(NAME_EQ_SULFURAS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < ITEM_QUALITY_LOWER_THAN_50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(NAME_EQ_BACKSTAGE_PASSES)) {
                        if (items[i].sellIn < ITEM_SELL_IN_LOWER_THAN_11) {
                            if (items[i].quality < ITEM_QUALITY_LOWER_THAN_50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < ITEM_SELL_IN_LOWER_THAN_6) {
                            if (items[i].quality < ITEM_QUALITY_LOWER_THAN_50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(NAME_EQ_SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < ITEM_SELL_IN_LOWER_THAN_0) {
                if (!items[i].name.equals(ITEM_NAME_EQ_AGED_BRIE)) {
                    if (!items[i].name.equals(NAME_EQ_BACKSTAGE_PASSES)) {
                        if (items[i].quality > ITEM_QUALITY_GREATER_THAN_0) {
                            if (!items[i].name.equals(NAME_EQ_SULFURAS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < ITEM_QUALITY_LOWER_THAN_50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
