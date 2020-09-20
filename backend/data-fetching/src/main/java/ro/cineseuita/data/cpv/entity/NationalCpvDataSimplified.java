package ro.cineseuita.data.cpv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Document(collection = "nationalCpvDataSimplified")
public class NationalCpvDataSimplified {

    @Id
    private String cpvCode;
    private String description;
    private Double total = 0.0;
    @DBRef
    private NationalCpvDataSimplified parent;
    private List<NationalCpvDataSimplified> children;

    public String getCpvCode() {
        return cpvCode;
    }

    public void setCpvCode(String cpvCode) {
        this.cpvCode = cpvCode;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<NationalCpvDataSimplified> getChildren() {
        return children;
    }

    public void setChildren(List<NationalCpvDataSimplified> children) {
        this.children = children;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static NationalCpvDataSimplified fromSimpleNode(CpvSimpleTreeNode rootSimple) {
        NationalCpvDataSimplified simplified = new NationalCpvDataSimplified();
        simplified.setCpvCode(rootSimple.getCode());
        simplified.setDescription(rootSimple.getDescription());
        simplified.children = (rootSimple.getChildren() != null) ? rootSimple.getChildren().stream().map(NationalCpvDataSimplified::fromSimpleNode).collect(toList()) : new ArrayList<>();
        simplified.children.forEach(child -> child.setParent(simplified));
        return simplified;
    }

    public boolean hasChildren() {
        return children != null && children.size() > 0;
    }

    public NationalCpvDataSimplified getParent() {
        return parent;
    }

    public void setParent(NationalCpvDataSimplified parent) {
        this.parent = parent;
    }

    public void feedParent() {
        this.parent.total += this.getTotal();
    }
}
