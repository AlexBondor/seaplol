package ro.cineseuita.data.essentials.shared;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Set;

public class ProblematicEssentialEntity<T extends Enum<T>> {

    private Set<T> problems;
    @Indexed
    private Long problemsCount;

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
