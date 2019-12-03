package models.dao;

import models.Bug;

import java.util.List;

public interface BugDao {

    void add (Bug bug);

    Bug findById(int id);

    List<Bug> getAll();


    void deleteById(int id);



}
