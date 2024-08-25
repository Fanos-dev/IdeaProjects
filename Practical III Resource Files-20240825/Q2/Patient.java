public class Patient implements Comparable<Patient> {
    private String name;
    private int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return name + "(priority:" + priority + ")";
    }

    public int compareTo(Patient o) {
        return this.priority - o.priority;
    }
}