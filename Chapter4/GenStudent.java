public class GenStudent <T, S extends Comparable<S>>
    implements Comparable<GenStudent<T,S>>
{
    private T id;
    private String name;
    private S score;
    public GenStudent(T id, String name, S score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    
    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public S getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "GenStudent [id=" + id + ", name=" + name + ", score=" + score + "]";
    }

    @Override
    public int compareTo(GenStudent<T, S> o) {
        
        return this.score.compareTo(o.score);
    }
    
}
