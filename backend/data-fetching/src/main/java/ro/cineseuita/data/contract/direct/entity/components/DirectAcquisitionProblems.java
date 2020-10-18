package ro.cineseuita.data.contract.direct.entity.components;

import java.util.Set;

public class DirectAcquisitionProblems {

    private Set<DirectAcquisitionProblem> problems;
    private Long count;

    public Set<DirectAcquisitionProblem> getProblems() {
        return problems;
    }

    public void setProblems(Set<DirectAcquisitionProblem> problems) {
        this.problems = problems;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void addProblem(DirectAcquisitionProblem problem) {
        if (!problems.contains(problem)) {
            problems.add(problem);
            count++;
        }
    }
}
