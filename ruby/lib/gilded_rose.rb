class GildedRose

  # def initialize(items)
  #   @items = items
  # end

  def self.update_quality(items)
    items.map do |item|
      if item.name != "Aged Brie" and item.name != "Backstage passes to a TAFKAL80ETC concert"
          
            update_normal_quality(item) if !sulfuras?(item)

      else

        if item.quality < 50
          item.quality = item.quality + 1
          if item.name.downcase.match /backstage/
            if item.sell_in < 11
              if item.quality < 50
                item.quality = item.quality + 1
              end
            end
            if item.sell_in < 6
              if item.quality < 50
                item.quality = item.quality + 1
              end
            end
          end
        end
        
      end
      if !sulfuras?(item)
        item.sell_in = item.sell_in - 1
      end
      if item.sell_in < 0
        if item.name != "Aged Brie"
          if !item.name.downcase.match /backstage/
            if item.quality > 0
              if !sulfuras?(item)
                update_normal_quality(item)
              end
            end
          else
            item.quality = 0
          end
        else
          if item.quality < 50
            item.quality = item.quality + 1
          end
        end
      end
    end
    items
  end

  def self.update_normal_quality(item)
    item.quality -= 1 unless item.quality.zero?
  end

  def self.sulfuras?(item)
    !item.name.downcase.match( /sulfuras/).nil?
  end
end

class Item
  attr_accessor :name, :sell_in, :quality

  def initialize(name, sell_in, quality)
    @name = name
    @sell_in = sell_in
    @quality = quality
  end

  def to_s()
    "#{@name}, #{@sell_in}, #{@quality}"
  end
end
