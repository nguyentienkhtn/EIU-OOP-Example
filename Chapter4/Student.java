public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private double score;
    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
    }
    @Override
    public int compareTo(Student o) {
        return (int)((this.score - o.score)*100);
    }

    

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        return this.id.equals(((Student)o).id);
    }

    
    
    
}
