package repository;

public interface Service<K, T> {
    public void create(K k);
    public void read(T t);
    public void update();
    public void delete(T t);
}
