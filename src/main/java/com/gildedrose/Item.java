package com.gildedrose;

public class Item implements RelevantNames {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    private final int MAX_QUALITY_VALUE = 50;


    public void updateQuality() {
        switch (this.name) {
            case NAME_AGED_BRIE:

                if (this.quality < 50) {
                    this.quality += 1;
                }

                this.sellIn = this.sellIn - 1;

                if (this.sellIn < 0 && this.quality < 50)
                    this.quality += 1;
                break;

            case NAME_BACKSTAGE_PASSES:
                if (this.quality < 50) {
                    this.quality += 1;
                }

                if (this.sellIn < 11 && this.quality < 50) {
                    this.quality += 1;
                }
                if (this.sellIn < 6 && this.quality < 50) {
                    this.quality += 1;
                }

                this.sellIn = this.sellIn - 1;

                if (this.sellIn < 0) {
                    this.quality -= this.quality;
                }
                break;

            case NAME_SULFURAS:
                // do nothing :(
                break;
            default:
                if (this.quality > 0) {
                    this.quality -= 1;
                }

                this.sellIn -= 1;

                if (this.sellIn < 0 && this.quality > 0) {
                    this.quality -= 1;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
