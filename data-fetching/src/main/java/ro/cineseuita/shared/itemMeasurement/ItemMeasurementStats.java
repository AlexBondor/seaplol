package ro.cineseuita.shared.itemMeasurement;

import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;

public class ItemMeasurementStats {

    private Long volumeCount = 0L;
    private Long weightCount = 0L;
    private Long singlesCount = 0L;
    private Long boxesCount = 0L;
    private Long servicesCount = 0L;
    private Long timeCount = 0L;
    private Long unclassifiedCount = 0L;
    private ItemMeasurement predominantMeasurementUnit;

    public Long getVolumeCount() {
        return volumeCount;
    }

    public void setVolumeCount(Long volumeCount) {
        this.volumeCount = volumeCount;
    }

    public Long getWeightCount() {
        return weightCount;
    }

    public void setWeightCount(Long weightCount) {
        this.weightCount = weightCount;
    }

    public Long getSinglesCount() {
        return singlesCount;
    }

    public void setSinglesCount(Long singlesCount) {
        this.singlesCount = singlesCount;
    }

    public Long getBoxesCount() {
        return boxesCount;
    }

    public void setBoxesCount(Long boxesCount) {
        this.boxesCount = boxesCount;
    }

    public Long getServicesCount() {
        return servicesCount;
    }

    public void setServicesCount(Long servicesCount) {
        this.servicesCount = servicesCount;
    }

    public Long getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(Long timeCount) {
        this.timeCount = timeCount;
    }

    public Long getUnclassifiedCount() {
        return unclassifiedCount;
    }

    public void setUnclassifiedCount(Long unclassifiedCount) {
        this.unclassifiedCount = unclassifiedCount;
    }

    public ItemMeasurement getPredominantMeasurementUnit() {
        return predominantMeasurementUnit;
    }

    public void setPredominantMeasurementUnit(ItemMeasurement predominantMeasurementUnit) {
        this.predominantMeasurementUnit = predominantMeasurementUnit;
    }

    public void incrementByMeasurementType(ItemMeasurement itemMeasurement, Long count) {
        switch (itemMeasurement) {
            case LITRI:
                volumeCount += count;
                break;
            case GRAME:
                weightCount += count;
                break;
            case BUCATI:
                singlesCount += count;
                break;
            case CUTII:
                boxesCount += count;
                break;
            case TIMP:
                timeCount += count;
                break;
            case SERVICIU:
                servicesCount += count;
                break;
            case UM:
                unclassifiedCount += count;
                break;
        }
    }

    public void feed(DirectAcquisitionItem item) {
        incrementByMeasurementType(item.getItemMeasureClass(), item.getItemQuantity().longValue());
    }

    public void feed(ItemMeasurementStats itemMeasurementStats) {
        this.volumeCount += itemMeasurementStats.getVolumeCount();
        this.weightCount += itemMeasurementStats.getWeightCount();
        this.singlesCount += itemMeasurementStats.getSinglesCount();
        this.boxesCount += itemMeasurementStats.getBoxesCount();
        this.timeCount += itemMeasurementStats.getTimeCount();
        this.servicesCount += itemMeasurementStats.getServicesCount();
        this.unclassifiedCount += itemMeasurementStats.getUnclassifiedCount();
    }
}
