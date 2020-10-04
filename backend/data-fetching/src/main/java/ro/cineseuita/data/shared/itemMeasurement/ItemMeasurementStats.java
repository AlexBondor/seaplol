package ro.cineseuita.data.shared.itemMeasurement;

import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemMeasurementStats {

    private Map<ItemMeasurement, CostCountAverage> itemMeasurementCostCount;
    private ItemMeasurement predominantMeasurementUnit;

    public ItemMeasurementStats() {
        itemMeasurementCostCount = Arrays.stream(ItemMeasurement.values()).collect(Collectors.toMap(itemMeasurement -> itemMeasurement, itemMeasurement -> new CostCountAverage()));
    }

    public ItemMeasurement getPredominantMeasurementUnit() {
        return predominantMeasurementUnit;
    }

    public Map<ItemMeasurement, CostCountAverage> getItemMeasurementCostCount() {
        return this.itemMeasurementCostCount;
    }

    public void feed(DirectAcquisitionItem item) {
        ItemMeasurement itemMeasurement = item.getItemMeasureClass();
        long quantity = item.getItemQuantity().longValue();
        itemMeasurementCostCount.get(itemMeasurement).incrementCount(quantity);
        itemMeasurementCostCount.get(itemMeasurement).incrementCost(item.getItemClosingPrice() * quantity);
    }

    public void feed(ItemMeasurementStats itemMeasurementStats) {
        Map<ItemMeasurement, CostCountAverage> otherCostCountMap = itemMeasurementStats.getItemMeasurementCostCount();
        otherCostCountMap.forEach((otherItemMeasurement, otherCostCountAverage) ->
        {
            CostCountAverage thisCostCountAverage = this.itemMeasurementCostCount.get(otherItemMeasurement);
            thisCostCountAverage.add(otherCostCountAverage);
        });
    }

    public void computeAverage() {
        this.predominantMeasurementUnit = computePredominantMeasurementUnit();
        itemMeasurementCostCount.values().forEach(CostCountAverage::computeAverage);
    }

    public Double getAverage() {
        return this.itemMeasurementCostCount.get(predominantMeasurementUnit).getAverage();
    }

    public CostCountAverage getByItemMeasurement(ItemMeasurement itemMeasurement) {
        return itemMeasurementCostCount.get(itemMeasurement);
    }

    private ItemMeasurement computePredominantMeasurementUnit() {
        Map.Entry<ItemMeasurement, CostCountAverage> max = Collections.max(itemMeasurementCostCount.entrySet(),
                Comparator.comparing(entry -> entry.getValue().getCost()));
        return max.getKey();
    }
}
