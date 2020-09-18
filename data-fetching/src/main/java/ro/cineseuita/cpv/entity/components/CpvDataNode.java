package ro.cineseuita.cpv.entity.components;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CpvDataNode extends CpvData {

    private CpvDataNode parent;
    private List<CpvDataNode> children;

    public CpvDataNode getParent() {
        return parent;
    }

    public void setParent(CpvDataNode parent) {
        this.parent = parent;
    }

    public List<CpvDataNode> getChildren() {
        return children;
    }

    public void setChildren(List<CpvDataNode> children) {
        this.children = children;
    }

    public static CpvDataNode fromSimpleNode(CpvSimpleTreeNode simpleNode) {
        CpvDataNode cpvDataNode = new CpvDataNode();
        cpvDataNode.setCpvCode(simpleNode.getCode());
        cpvDataNode.setCpvCodeSimplified(simpleNode.getCodeSimplified());
        cpvDataNode.setDescription(simpleNode.getDescription());
        cpvDataNode.children = (simpleNode.getChildren() != null) ? simpleNode.getChildren().stream().map(CpvDataNode::fromSimpleNode).collect(toList()) : new ArrayList<>();
        cpvDataNode.children.forEach(child -> child.setParent(cpvDataNode));
        return cpvDataNode;
    }

    public boolean hasChildren() {
        return children != null && children.size() > 0;
    }

    public boolean hasOnlyOneChild() {
        return children != null && children.size() == 1;
    }

    public void feedParent() {
        this.parent.feed(this);
    }
}
