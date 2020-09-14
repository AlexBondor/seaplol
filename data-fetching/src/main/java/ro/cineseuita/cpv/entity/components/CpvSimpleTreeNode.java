package ro.cineseuita.cpv.entity.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CpvSimpleTreeNode {

    public static final String ROOT = "SEAP";

    private String code;
    private String codeSimplified;
    private String description;
    private String parent;
    private List<CpvSimpleTreeNode> children;

    public CpvSimpleTreeNode() {

    }

    public CpvSimpleTreeNode(String code, String codeSimplified, String description, String parent) {
        this.code = code;
        this.codeSimplified = codeSimplified;
        this.description = description;
        this.parent = parent;
    }

    public static CpvSimpleTreeNode createRoot(List<CpvSimpleTreeNode> children) {
        CpvSimpleTreeNode root = new CpvSimpleTreeNode(ROOT, ROOT, ROOT, null);
        root.setChildren(children);
        return root;
    }

    public String getCode() {
        return code;
    }

    public String getCodeSimplified() {
        return codeSimplified;
    }

    public String getParent() {
        return parent;
    }

    public String getDescription() {
        return description;
    }

    public List<CpvSimpleTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<CpvSimpleTreeNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return children == null || children.size() == 0;
    }
}
