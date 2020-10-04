package ro.cineseuita.data.shared.itemMeasurement;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.*;

import static java.util.Arrays.asList;

public class ItemMeasurementClassifier {

    private static final LevenshteinDistance LEVENSHTEIN_DISTANCE = LevenshteinDistance.getDefaultInstance();

    private static Set<String> UM_VOLUME = new HashSet<>(asList("litru", "ml", "l", "litri", "19 litri", "500 ml", "1000 ml", "100 ml", "1 x 5 ml", "1 x 200 ml", "4 x 50 ml", "1 x 8 ml", "1 x 50 ml"));

    private static Set<String> UM_WEIGHT = new HashSet<>(asList("kilogram", "kg", "g", " g", "g ", " kg", "kg ", "kg.", "1000 g", " kilogram", " kilogram", "1kg", " 1kg", "1 kg", " 1 kg", "1 kg , litru", "kg/ buc", "kg/buc", "buc/kg", "100g", "500g", "500 g", "250g", "100 g", "100g", "1 x 1 ml", "600 ml", "gram", "kilograme", "100 grame", "200 grame", "25 grame", "grame", "5 grame", "25 kilograme", "10 grame", "50 grame"));

    private static Set<String> UM_SINGLES = new HashSet<>(asList("bucata", "buc", "buc.", "top", "kit", "rola", "mp", "metru patrat", "metru", "perechi", "bc", "mc", "metru cub", "carnet (25 file)", "tona", "km", "fl", "flacon", "flacon x 200 ml", "flacon x 10 ml", "flacon x 1000 ml", "1 flacon 1 litru", "flacon 100 ml", "flacon x 10 comprimate ", "flacon 500 ml", "flacon ", "1 flacon", "(35) flacon 1l", " buc(pachet)", "buc fara tva", "1 buc.", " bc", "fir", "pereche", "tub", "punga", "metru liniar", "bidon", "sac", "plic", "placa", "tb", "cuvant", "participant", "pers", "bloc", "trusa", "imobil", "cursa", "analiza", "pagina", "tableta", "lot", "curs", "fila", "tubx7ml", "legatura", "fiola", "eveniment", "cursant", "mwh", "centimetru patrat", "fl.", "polita", "m2", "ha", "coala", "ghem", "dosar", "test", "tipla", "galetusa 1.5 kg", "galetusa1.5 kg"));

    private static Set<String> UM_BOXES = new HashSet<>(asList("cutie", "pachet", "set", "cut", "pac", "cutia", "100 buc", "cartus  x50 discuri ", "cartus x 50 discuri", "CARTUS  x50 discuri", "100 filme / cutie", "Cutie * 10 Fi *0.5 ml", "1pacx10placi", "pach", "cutii", "comprimate", "Set 2 x 20 L.", "cutie x 10 flacoane", "kit x 100 teste"));

    private static Set<String> UM_SERVICES = new HashSet<>(asList("contract", "lucrare", "lucrarea", "lucrarea/obiectiv", "lucrare/proiect", "deviz/lucrare", "bucata (lucrare)", "pachet/lucrare", "persoana", "valoare contract", "serviciu", "lei", "ron", "per contract", "proiect", "abonament lunar", "abonament", "abonament/luna", "abonament anual", "abonament 12 luni an 2018", "abonament 12 luni an 2019", "abonament pe 12 luni an 2020", "abonament 12 luni", "abonament trimestrial", "abonamente", "serviciu lunar", "serviciu/luna", "serviciu/luna", ""));

    private static Set<String> UM_TIME = new HashSet<>(asList("luna", "u.t.", " u.t.", "u.t. ", "ora", "an", "lunar", "zi", ""));

    public static ItemMeasurement getBucket(String measurement) {
        measurement = measurement.toLowerCase();

        if (metricSatisfied(measurement, UM_VOLUME)) {
            return ItemMeasurement.LITRI;
        } else if (metricSatisfied(measurement, UM_WEIGHT)) {
            return ItemMeasurement.GRAME;
        } else if (metricSatisfied(measurement, UM_SINGLES)) {
            return ItemMeasurement.BUCATI;
        } else if (metricSatisfied(measurement, UM_BOXES)) {
            return ItemMeasurement.CUTII;
        } else if (metricSatisfied(measurement, UM_TIME)) {
            return ItemMeasurement.TIMP;
        } else if (metricSatisfied(measurement, UM_SERVICES)) {
            return ItemMeasurement.SERVICIU;
        } else {
            return ItemMeasurement.UM;
        }

    }

    private static boolean metricSatisfied(String measurement, Set<String> collection) {
        return collection.stream().anyMatch(s -> LEVENSHTEIN_DISTANCE.apply(measurement, s) < Math.min(measurement.length(), 3));
    }

    public static List<String> getSubsetOfExamplesForBucket(ItemMeasurement bucket) {
        if (bucket == ItemMeasurement.LITRI) {
            return new ArrayList<>(UM_VOLUME).subList(0, 8);
        } else if (bucket == ItemMeasurement.GRAME) {
            return new ArrayList<>(UM_WEIGHT).subList(0, 8);
        } else if (bucket == ItemMeasurement.BUCATI) {
            return new ArrayList<>(UM_SINGLES).subList(0, 8);
        } else if (bucket == ItemMeasurement.CUTII) {
            return new ArrayList<>(UM_BOXES).subList(0, 8);
        } else if (bucket == ItemMeasurement.TIMP) {
            return new ArrayList<>(UM_TIME).subList(0, 8);
        } else if (bucket == ItemMeasurement.SERVICIU) {
            return new ArrayList<>(UM_SERVICES).subList(0, 8);
        }
        return Collections.singletonList("Nu s-a putut determina tipul unității de măsură...");
    }

}
