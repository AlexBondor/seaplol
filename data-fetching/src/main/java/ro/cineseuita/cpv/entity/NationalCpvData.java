package ro.cineseuita.cpv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.cpv.entity.components.CpvData;
import ro.cineseuita.cpv.entity.components.CpvDataNode;

@Document(collection = "nationalCpvData")
public class NationalCpvData extends CpvData {

    @Id
    private String id;

    public static NationalCpvData formNationalCpvDataFromCpvDataNode(CpvDataNode dataNode) {
        NationalCpvData nationalCpvData = new NationalCpvData();
        nationalCpvData.fillFormFromCpvDataNode(dataNode);
        nationalCpvData.id = dataNode.getCpvCode();
        return nationalCpvData;
    }

}
