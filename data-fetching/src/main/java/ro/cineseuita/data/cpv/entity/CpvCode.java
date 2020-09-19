package ro.cineseuita.data.cpv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;

@Document(collection = "cpvCodes")
public class CpvCode {

    @Id
    private String _id;
    private String code;
    private String codeSimplified;
    private String description;
    private String parent;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCodeSimplified() {
        return codeSimplified;
    }

    public void setCodeSimplified(String codeSimplified) {
        this.codeSimplified = codeSimplified;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public long getNumberOfTrailingZeros() {
        return codeSimplified.substring(2).chars().filter(ch -> ch == '0').count();
    }

    public CpvSimpleTreeNode toCpvSimpleTreeNode() {
        return new CpvSimpleTreeNode(code, codeSimplified, description, parent);
    }

    public boolean isParentOf(String code) {
        return parent.equals(code);
    }
}
