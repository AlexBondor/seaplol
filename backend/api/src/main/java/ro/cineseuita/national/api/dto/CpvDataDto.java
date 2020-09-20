package ro.cineseuita.national.api.dto;

import ro.cineseuita.data.cpv.entity.NationalCpvData;

import java.util.List;

public class CpvDataDto {
    private NationalCpvData details;
    private List<NationalCpvData> children;

    public NationalCpvData getDetails() {
        return details;
    }

    public void setDetails(NationalCpvData details) {
        this.details = details;
    }

    public List<NationalCpvData> getChildren() {
        return children;
    }

    public void setChildren(List<NationalCpvData> children) {
        this.children = children;
    }
}
