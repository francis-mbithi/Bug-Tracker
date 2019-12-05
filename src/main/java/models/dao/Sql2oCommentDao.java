package models.dao;

import models.Comment;
import models.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCommentDao implements CommentDao {

    @Override
    public void add(Comment comment) {
        String sql="INSERT INTO comments (username,content,upvote,downvote,bug_id) VALUES (:username,:content,:upvote,:downvote,:bug_id)";
        try(Connection con= DB.sql2o.open()){
            int id =(int) con.createQuery(sql,true)
                    .bind(comment)
                    .executeUpdate()
                    .getKey();
            comment.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Comment> getAll() {
        try(Connection con= DB.sql2o.open()){
            return con.createQuery("SELECT * FROM comments")
                    .executeAndFetch(Comment.class);
        }
    }

    @Override
    public Comment findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM comments WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Comment.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM comments WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
