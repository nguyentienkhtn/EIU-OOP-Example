public abstract class Student {
    private String id;
    private String name;
    private double score;
    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
    }
    
    public abstract void diHoc(); //header
}
