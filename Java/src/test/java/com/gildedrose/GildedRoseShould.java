package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseShould {


    @Test
    void decrease_sellIn_and_maintains_quality_when_item_name_is_not_Sulfuras_and_quality_is_0() {
        Item[] items = {new Item("NOT Sulfuras, Hand of Ragnaros", 10, 0)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void decrease_sellIn_and_decrease_quality_when_item_name_is_not_Sulfuras_and_positive_quality() {
        Item[] items = {new Item("NOT Sulfuras, Hand of Ragnaros", 10, 10)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(9, gildedRose.items[0].quality);
    }

    @Test
    void decrease_sellIn_and_increase_quality_when_item_name_is_AgedBrie_and_quality_is_40() {
        Item[] items = {new Item("Aged Brie", 10, 40)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(41, gildedRose.items[0].quality);
    }

    @Test
    void when_item_is_Backstage_and_sellIn_is_less_than_6_and_quality_is_less_than_48_then_should_increase_in_3_quality_and_decrease_sellIn_in_1() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals(4, gildedRose.items[0].sellIn);
        assertEquals(50, gildedRose.items[0].quality);
    }

}
