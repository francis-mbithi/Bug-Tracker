import models.Bug;
import models.dao.Sql2oBugDao;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oBugDao bugDao = new Sql2oBugDao();

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
        get("/bug/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "add-bug.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
