package models.dao;

import models.Bug;
import models.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oBugDao implements BugDao {

    @Override
    public void add(Bug bug) {
        String sql="INSERT INTO bugs (content,category,user_id) VALUES (:content,:category,:user_id)";
        try(Connection con= DB.sql2o.open()){
            int id =(int) con.createQuery(sql,true)
                    .bind(bug)
                    .executeUpdate()
                    .getKey();
            bug.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

   @Override
    public List<Bug> getAll() {
        try(Connection con= DB.sql2o.open()){
            return con.createQuery("SELECT * FROM bugs")
                    .executeAndFetch(Bug.class);
        }
    }

    @Override
    public Bug findById(int id) {
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM bugs WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Bug.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM bugs WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
