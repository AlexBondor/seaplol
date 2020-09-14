package ro.cineseuita.cpv.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CpvCodeParentExceptions {

    private static final Map<String, String> parentExceptionsMap;

    static {
        Map<String, String> specials = new HashMap<>();
        specials.put("30192121-5", "30192100-2");
        specials.put("30192122-2", "30192100-2");
        specials.put("30192123-9", "30192100-2");
        specials.put("30192124-6", "30192100-2");
        specials.put("30192125-3", "30192100-2");
        specials.put("30192126-0", "30192100-2");
        specials.put("30192127-7", "30192100-2");

        specials.put("34511100-3", "34510000-5");

        specials.put("35611100-1", "35610000-3");
        specials.put("35611200-2", "35610000-3");
        specials.put("35611300-3", "35610000-3");
        specials.put("35611400-4", "35610000-3");
        specials.put("35611500-5", "35610000-3");
        specials.put("35611600-6", "35610000-3");
        specials.put("35611700-7", "35610000-3");
        specials.put("35611800-8", "35610000-3");
        specials.put("35612100-8", "35610000-3");
        specials.put("35612200-9", "35610000-3");
        specials.put("35612300-0", "35610000-3");
        specials.put("35612400-1", "35610000-3");
        specials.put("35612500-2", "35610000-3");

        specials.put("35811100-3", "35810000-5");
        specials.put("35811200-4", "35810000-5");
        specials.put("35811300-5", "35810000-5");

        specials.put("38527100-6", "35810000-5");
        specials.put("38527200-7", "35810000-5");
        specials.put("38527300-8", "35810000-5");
        specials.put("38527400-9", "35810000-5");

        specials.put("39254000-7", "39200000-4");

        specials.put("39254100-8", "39254000-7");

        specials.put("39254110-1", "39254100-8");
        specials.put("39254120-4", "39254100-8");

        specials.put("39254130-7", "39254100-8");

        specials.put("42924200-1", "42920000-1");
        specials.put("42924300-2", "42920000-1");
        specials.put("42924700-6", "42920000-1");

        specials.put("42924310-5", "42924300-2");

        specials.put("42924710-9", "42924700-6");
        specials.put("42924720-2", "42924700-6");
        specials.put("42924730-5", "42924700-6");
        specials.put("42924740-8", "42924700-6");
        specials.put("42924790-3", "42924700-6");

        specials.put("44115310-5", "44115000-9");

        specials.put("44613110-4", "44613000-0");

        specials.put("60112000-6", "60100000-9");

        parentExceptionsMap = Collections.unmodifiableMap(specials);
    }

    public static String getSpecialParent(String code) {
        return parentExceptionsMap.getOrDefault(code, null);
    }

    public static Boolean hasSpecialParent(String code) {
        return parentExceptionsMap.containsKey(code);
    }

}
