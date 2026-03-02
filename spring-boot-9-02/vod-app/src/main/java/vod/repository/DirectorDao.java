package vod.repository;

import vod.model.Director;

import java.util.List;

public interface DirectorDao {

    List<Director> findAll();

    Director findById(int id);

    Director add(Director d);


}
