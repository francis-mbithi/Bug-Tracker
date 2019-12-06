import models.Bug;
import models.Comment;
import models.dao.*;
import models.dao.Sql2oBugDao;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oBugDao bugDao = new Sql2oBugDao();
        Sql2oCommentDao commentDao = new Sql2oCommentDao();

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/bugs", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Bug> bugs = bugDao.getAll();
            model.put("bugs", bugs);
            return new ModelAndView(model, "bugs.hbs");
        }, new HandlebarsTemplateEngine());

        //post a bug
        post("/bugs/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String content = request.queryParams("content");
            String category = request.queryParams("category");
            try {
                Bug bug = new Bug (content, category);
                bugDao.add(bug);
            }catch (IllegalArgumentException exception){
                System.out.println("Please fill in all input fields.");
            }
            response .redirect("/bugs");
            return null;
        });new HandlebarsTemplateEngine();

        get("/bug/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-bug.hbs");
        }, new HandlebarsTemplateEngine());

        //get bug by id
        get("/bugs/:id", (request, response) -> {
          Map<String, Object> model = new HashMap<>();
          int id = parseInt(request.params(":id"));
          Bug bug = bugDao.findById(id);
            List<Comment> comments = commentDao.findById(id);
            model.put("comments", comments);
          model.put("bug", bug);
          return new ModelAndView(model, "bug_details.hbs");
        }, new HandlebarsTemplateEngine());
        // post a Comment
        post("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String username = request.queryParams("username");
            String content = request.queryParams("content");
            int bug_id = Integer.parseInt(request.queryParams("bug_id"));
            Timestamp timestamp = new Timestamp(new Date().getTime());
            try {
                Comment comment = new Comment (username, content,0,0,bug_id);
                commentDao.add(comment);
            }catch (IllegalArgumentException exception){
                System.out.println("Please fill in all input fields.");
            }
            response.redirect("/success");
            return null;
        });new HandlebarsTemplateEngine();

        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        });

        get("/bugs/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            bugDao.findById(parseInt(request.params(":id"))).deleteById();
            response.redirect("/bugs");
            return null;

        }, new HandlebarsTemplateEngine());
    }

}
