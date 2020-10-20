package ro.cineseuita.data.essentials.shared;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Set;

public class IndexedCountProblemIndicator<T extends Enum<T>> {

    private Set<T> problems = new HashSet<>();
    @Indexed
    private Long problemsCount = 0L;

    public void setProblems(Set<T> problems) {
        this.problems = problems;
    }

    public Set<T> getProblems() {
        return problems;
    }

    public void setProblemsCount(Long problemsCount) {
        this.problemsCount = problemsCount;
    }

    public Long getProblemsCount() {
        return problemsCount;
    }
}
