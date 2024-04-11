package repository;

public interface Service<K> {
    public void create(K k);
    public void read();
    public void update();
    public void delete();
}
