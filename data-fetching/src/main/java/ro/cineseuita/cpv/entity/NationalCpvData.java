package ro.cineseuita.cpv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.cpv.entity.components.CpvData;
import ro.cineseuita.cpv.entity.components.CpvDataNode;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Document(collection = "nationalCpvData")
public class NationalCpvData extends CpvData {

    @Id
    private String id;

    private String parentId;

    private List<String> childrenIds = new ArrayList<>();

    public static NationalCpvData formNationalCpvDataFromCpvDataNode(CpvDataNode dataNode) {
        NationalCpvData nationalCpvData = new NationalCpvData();
        nationalCpvData.id = dataNode.getCpvCode();
        nationalCpvData.setCpvCode(dataNode.getCpvCode());
        nationalCpvData.setCpvCodeSimplified(dataNode.getCpvCodeSimplified());
        nationalCpvData.setDescription(dataNode.getDescription());
        nationalCpvData.addToContracts(dataNode.getContracts());
        nationalCpvData.setTotal(dataNode.getTotal());
        nationalCpvData.setNumberOfItems(dataNode.getNumberOfItems());
        nationalCpvData.setItemMeasurementStats(dataNode.getItemMeasurementStats());

        nationalCpvData.setParentId(dataNode.getParent().getCpvCode());
        nationalCpvData.setChildrenIds(dataNode.getChildren().stream().map(CpvData::getCpvCode).collect(toList()));

        return nationalCpvData;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<String> childrenIds) {
        this.childrenIds = childrenIds;
    }
}
