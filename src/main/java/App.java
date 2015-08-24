import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            model.put("definitions", request.session().attribute("definitions"));
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/definitions", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("definitions", Definition.getDefinitions());
            model.put("template", "templates/definitions.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/definitions/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/definition-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/definitions", (request,response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
            String description = request.queryParams("description");
            Definition newDef = new Definition(description);
            word.addDefinition(newDef);
            model.put("word", word);
            model.put("template", "templates/word.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/definitions/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
            model.put("definition", definition);
            model.put("template", "templates/definition.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/words", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("words", Word.getAllWords());
            model.put("template", "templates/words.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/words/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/word-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/words", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            String word = request.queryParams("word");
            Word newWord = new Word(word);
            model.put("word", newWord);
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/words/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
            model.put("template", "templates/word.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/words/:id/definitions/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
            model.put("template", "templates/word-definitions-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
