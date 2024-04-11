package contolloer;

public interface Controller<T> {
    void create(T t);
    void update(T t);
    void delete(T t);
    void read(T t);
}
