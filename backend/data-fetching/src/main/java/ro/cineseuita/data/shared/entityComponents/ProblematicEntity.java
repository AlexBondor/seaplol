package ro.cineseuita.data.shared.entityComponents;

public class ProblematicEntity<T extends Enum<T>> {
    private ProblemIndicators<T> problems = new ProblemIndicators<>();

    public ProblemIndicators<T> getProblems() {
        return problems;
    }
}
