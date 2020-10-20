package ro.cineseuita.data.shared.entityComponents;

import java.util.HashSet;
import java.util.Set;

public class ProblemIndicators<T extends Enum<T>> {

    private Set<T> problems = new HashSet<>();
    private Long problemsCount = 0L;

    public Set<T> getProblems() {
        return problems;
    }

    public void setProblems(Set<T> problems) {
        this.problems = problems;
    }

    public Long getProblemsCount() {
        return problemsCount;
    }

    public void setProblemsCount(Long problemsCount) {
        this.problemsCount = problemsCount;
    }

    public void addProblem(T problem) {
        if (!problems.contains(problem)) {
            problems.add(problem);
            problemsCount++;
        }
    }
}
