package ro.cineseuita.cpv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.cpv.entity.CpvCode;
import ro.cineseuita.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.cpv.repository.CpvCodesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static ro.cineseuita.cpv.entity.components.CpvSimpleTreeNode.createRoot;

@Service
public class CpvTreeConstructorService {

    private final CpvCodesRepository cpvCodesRepository;

    @Autowired
    public CpvTreeConstructorService(CpvCodesRepository cpvCodesRepository) {
        this.cpvCodesRepository = cpvCodesRepository;
    }

    public CpvSimpleTreeNode constructCpvCodesTree() {
        List<CpvCode> allCpvCodes = cpvCodesRepository.findAll();
        Map<Long, List<CpvCode>> codesGroupedByTrailingZeros = allCpvCodes.stream().collect(groupingBy(CpvCode::getNumberOfTrailingZeros));

        long maximumTrailingZeros = 6;
        List<CpvCode> firstLevelCodes = codesGroupedByTrailingZeros.get(maximumTrailingZeros);
        CpvSimpleTreeNode root = createRoot(
                firstLevelCodes.stream().map(CpvCode::toCpvSimpleTreeNode
                )
                        .collect(toList()));


        root.getChildren().forEach(cpvSimpleTreeNode -> fillChildren(cpvSimpleTreeNode, codesGroupedByTrailingZeros, maximumTrailingZeros - 1));

        sanityChecks(allCpvCodes, root);
        return root;
    }

    private void fillChildren(CpvSimpleTreeNode currentRoot, Map<Long, List<CpvCode>> groupedCodes, Long currentLevel) {
        if (currentLevel < 0) {
            return;
        }

        List<CpvCode> allCodesLowerInHierarchy = new ArrayList<>();

        for (long l = currentLevel; l >= 0; l--) {
            allCodesLowerInHierarchy.addAll(groupedCodes.get(l));
        }

        List<CpvSimpleTreeNode> childrenNodes = allCodesLowerInHierarchy
                .stream()
                .filter(cpvCode ->
                        cpvCode.isParentOf(currentRoot.getCode())
                )
                .map(CpvCode::toCpvSimpleTreeNode
                )
                .collect(toList());

        currentRoot.setChildren(childrenNodes);

        currentRoot.getChildren().forEach(child -> fillChildren(child, groupedCodes, currentLevel - 1));
    }

    long countNodesInTree(CpvSimpleTreeNode currentRoot) {
        List<CpvSimpleTreeNode> children = currentRoot.getChildren();
        if (currentRoot.isLeaf()) {
            return 0;
        } else {
            long successorsCount = children.stream().mapToLong(this::countNodesInTree).sum();
            return successorsCount + children.size();
        }
    }

    boolean findNodeInTree(CpvSimpleTreeNode currentRoot, CpvSimpleTreeNode toBeFound) {
        if (currentRoot.getCode().equals(toBeFound.getCode())) {
            return true;
        } else {
            if (currentRoot.isLeaf()) {
                return false;
            } else {
                return currentRoot.getChildren().stream().anyMatch(child -> findNodeInTree(child, toBeFound));
            }
        }
    }

    int countNumberOfApparitionsOfNodeInTree(CpvSimpleTreeNode currentRoot, CpvSimpleTreeNode toBeFound) {
        if (currentRoot.getCode().equals(toBeFound.getCode())) {
            return 1;
        } else {
            if (currentRoot.isLeaf()) {
                return 0;
            } else {
                return currentRoot.getChildren().stream().mapToInt(child -> countNumberOfApparitionsOfNodeInTree(child, toBeFound)).sum();
            }
        }
    }

    private void sanityChecks(List<CpvCode> allCpvCodes, CpvSimpleTreeNode root) {
        AtomicInteger multipleCount = new AtomicInteger();

        allCpvCodes.forEach(cpvCode -> {
            int count = countNumberOfApparitionsOfNodeInTree(root, cpvCode.toCpvSimpleTreeNode());
            if (count > 1) {
                System.out.printf("Node %s was found %d times in the tree\n", cpvCode.getCode(), count);
                multipleCount.getAndIncrement();
            }
            if (count == 0) {
                System.out.printf("Node %s was NOT found in the tree\n", cpvCode.getCode());
            }
        });
        long numberOfNodesInTree = countNodesInTree(root);

        System.out.printf("Tree with: %d nodes, number of duplicates:%d\n", numberOfNodesInTree, multipleCount.get());

        if (allCpvCodes.size() != numberOfNodesInTree) {
            throw new RuntimeException("Something went wrong with in processing the CSV codes. There is a difference between number of codes and tree nodes.");
        }
    }
}
