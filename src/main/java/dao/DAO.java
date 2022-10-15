package dao;

import java.util.List;

public interface DAO<Entity> {

    void create(Entity entity);

    Entity read(int id);

    List<Entity> readAll();

    void update(Entity entity);

    void delete(Entity entity);

}
