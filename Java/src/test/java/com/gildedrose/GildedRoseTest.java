package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Disabled
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    // 'Conjured Mana Cake'
    @Test
    void testConjuredItemAtTheEndOfDay() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityDecreaseX2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // '+5 Dexterity Vest' or 'Elixir of the Mongoose'
    // useful with IDE run test with coverage
    @Test
    void testNormalItemAtTheEndOfDay() {
        Item[] items = new Item[] { new Item("Normal", 1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    // useful with IDE run test with coverage
    @Test
    void testNormalItemQualityDecreaseX2() {
        Item[] items = new Item[] { new Item("Normal", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    // useful with IDE run test with coverage
    @Test
    void testNormalItemQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Normal", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    // 'Aged Brie'
    @Test
    void testAgedBrieItemAtTheEndOfDay() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void testAgedBrieItemQualityIncreaseX2() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void testAgedBrieItemNeverAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    // 'Sulfuras, Hand of Ragnaros'
    @Test
    void testSulfurasItemAtTheEndOfDay() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testSulfurasItemAtTheEndOfDayWhenSellInNegativeValue() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    // 'Backstage passes to a TAFKAL80ETC concert'
    @Test
    void testBackstagePassesItemAtTheEndOfDayWhenSellInMoreThan10Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testBackstagePassesItemAtTheEndOfDayWhenSellIn10DaysOrLessButAbove5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void testBackstagePassesItemAtTheEndOfDayWhenSellIn5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void testBackstagePassesItemAtTheEndOfDayWhenSellInChangeToNegative() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstagePassesItemAtTheEndOfDayWhenSellInNotNegativeAndQuality50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

}
