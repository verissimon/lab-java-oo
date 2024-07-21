package dominio;

public class Course extends Content {
    private int workloadHours;

    public Course() {
    }

    public int getWorkloadHours() {
        return workloadHours;
    }

    public void setWorkloadHours(int workloadHours) {
        this.workloadHours = workloadHours;
    }

    @Override
    public double calculateExp() {
        return DEFAULT_EXP * workloadHours;
    }

    @Override
    public String toString() {
        return "Course {" + "\n" +
                "title = " + getTitle() + "\n" +
                "description = " + getDescription() + "\n" +
                "workload = " + workloadHours +
                '}';
    }
}
