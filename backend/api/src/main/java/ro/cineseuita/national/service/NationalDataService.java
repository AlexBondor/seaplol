package ro.cineseuita.national.service;//package ro.cineseuita.national.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.data.cpv.entity.components.CpvData;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.data.cpv.repository.NationalCpvDataRepository;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurementStats;
import ro.cineseuita.national.api.dto.CpvDataDto;

import java.util.List;

@Service
public class NationalDataService {

    private final NationalCpvDataRepository nationalCpvDataRepository;

    @Autowired
    public NationalDataService(NationalCpvDataRepository nationalCpvDataRepository) {
        this.nationalCpvDataRepository = nationalCpvDataRepository;
    }

    public CpvDataDto getNationalCpvData() {
        CpvDataDto cpvDataDto = new CpvDataDto();

        List<NationalCpvData> children = nationalCpvDataRepository.findByParentId(CpvSimpleTreeNode.ROOT);

        cpvDataDto.setChildren(children);
        cpvDataDto.setDetails(aggregateDetailsForAll(children));

        return cpvDataDto;
    }

    public CpvDataDto getCpvChildrenOf(String cpvCode) {
        CpvDataDto cpvDataDto = new CpvDataDto();

        NationalCpvData root = nationalCpvDataRepository.findById(cpvCode).get();
        List<NationalCpvData> children = nationalCpvDataRepository.findAllByIdIn(root.getChildrenIds());

        cpvDataDto.setDetails(root);
        cpvDataDto.setChildren(children);
        return cpvDataDto;
    }

    private NationalCpvData aggregateDetailsForAll(List<NationalCpvData> children) {
        NationalCpvData aggregatedDetails = new NationalCpvData();
        aggregatedDetails.setDescription("Total cheltuieli țară");

        aggregatedDetails.setTotal(children.stream().mapToDouble(CpvData::getTotal).sum());
        aggregatedDetails.setNumberOfItems(children.stream().mapToLong(CpvData::getNumberOfItems).sum());

        ItemMeasurementStats overallStats = new ItemMeasurementStats();
        children.forEach(child -> {
            ItemMeasurementStats childItemMeasurementStats = child.getItemMeasurementStats();
            overallStats.feed(childItemMeasurementStats);
        });

        overallStats.computeAverage();

        aggregatedDetails.setItemMeasurementStats(overallStats);
        return aggregatedDetails;
    }
}
