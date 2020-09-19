package ro.cineseuita.national.service;//package ro.cineseuita.national.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.data.cpv.entity.components.CpvDataNode;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.data.cpv.repository.NationalCpvDataRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class NationalDataService {

    private final NationalCpvDataRepository nationalCpvDataRepository;

    @Autowired
    public NationalDataService(NationalCpvDataRepository nationalCpvDataRepository) {
        this.nationalCpvDataRepository = nationalCpvDataRepository;
    }

    public List<CpvDataNode> getNationalCpvData() {
        List<NationalCpvData> rootNodesSimple = nationalCpvDataRepository.findByParentId(CpvSimpleTreeNode.ROOT);

        List<CpvDataNode> nodesWithChildrenData = new ArrayList<>();
        rootNodesSimple.forEach(rootNode ->
                {
                    CpvDataNode nodeWithChildren = new CpvDataNode();
                    nodeWithChildren.fillFromCpvData(rootNode);

                    List<CpvDataNode> childrenDataNodes = loadChildrenForNode(rootNode);
                    nodeWithChildren.setChildren(childrenDataNodes);

                    nodesWithChildrenData.add(nodeWithChildren);

                }
        );

        return nodesWithChildrenData;
    }

    public List<CpvDataNode> getCpvChildrenOf(String cpvCode) {
        NationalCpvData root = nationalCpvDataRepository.findById(cpvCode).get();
        return loadChildrenForNode(root);
    }

    private List<CpvDataNode> loadChildrenForNode(NationalCpvData rootNode) {
        List<NationalCpvData> children = nationalCpvDataRepository.findAllByIdIn(rootNode.getChildrenIds());
        List<CpvDataNode> childrenDataNodes = children.stream().map(child -> {
            CpvDataNode cpvDataNode = new CpvDataNode();
            cpvDataNode.fillFromCpvData(child);
            return cpvDataNode;
        }).collect(toList());
        return childrenDataNodes;
    }
}
