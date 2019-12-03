package models.dao;

import models.Comment;

import java.util.List;

public interface CommentDao {

    void add (Comment comment);

    Comment findById(int id);

    List<Comment> getAll();


    void deleteById(int id);
}
