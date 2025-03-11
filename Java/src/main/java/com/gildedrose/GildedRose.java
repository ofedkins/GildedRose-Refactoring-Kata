package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                agedBrieItemsLogic(items[i]);
            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                backstagePassesItemsLogic(items[i]);
            } else if (items[i].name.equals("Conjured Mana Cake")) {
                conjuredItemsLogic(items[i]);
            } else if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                normalItemsLogic(items[i]);
            }
        }
    }

    private void agedBrieItemsLogic(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void backstagePassesItemsLogic(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }

    private void conjuredItemsLogic(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                // IDE suggests for below: Can be replaced with 'Math.max()' call
                item.quality = item.quality - 2 > 0 ? item.quality - 2 : 0;
            }
        }
    }

    private void normalItemsLogic(Item item) {
        item.quality = item.quality - 1;
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
