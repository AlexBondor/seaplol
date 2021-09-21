package ro.cineseuita.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TreeMap {

  private String name;
  private Double value;
  private List<TreeMap> children;

  public TreeMap() {
    children = new ArrayList<>();
  }

  public static List<TreeMap> generateMockTreeMap() {
    List<TreeMap> firstLevelChildren = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      TreeMap firstLevelChild = getBasicTreeMapNoChildren();
      firstLevelChildren.add(firstLevelChild);
      int limit = new Random().nextInt(5) + 5;
      createChildren(firstLevelChild, limit);
    }
    return firstLevelChildren;
  }

  private static void createChildren(TreeMap parent, int limit) {
    for (int i = 0; i < limit; i++) {
      TreeMap child = getBasicTreeMapNoChildren();
      parent.children.add(child);
      if (new Random().nextBoolean()) {
        createChildren(child, --limit);
      }
    }
  }

  private static TreeMap getBasicTreeMapNoChildren() {
    TreeMap treeMap = new TreeMap();
    treeMap.name = "Cool story bruh";
    treeMap.value = Math.random() * 100;
    return treeMap;
  }

  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("name", this.name);
    map.put("value", this.value);
    map.put("hasChildren", !this.children.isEmpty());
    map.put("children", children.isEmpty() ? null : children.stream().map(TreeMap::toMap));
    return map;
  }

}
