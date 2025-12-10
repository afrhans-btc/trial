public class IdGenerator<T> {
    private int counter = 1;

    public String generateId(T prefix) {
        return prefix.toString() + "-" + counter++;
    }
    
}
