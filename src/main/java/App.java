import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
         Integer port;
         if (process.environment().get("PORT") != null) {
             port = Integer.parseInt(process.environment().get("PORT"));
         } else {
             port = 4567;
         }
    
        setPort(port);

    	staticFileLocation("/public");
    	String layout = "templates/layout.vtl";

	    get("/", (request, response) -> {
		  Map<String, Object> model = new HashMap<String, Object>();
		  model.put("template", "templates/index.vtl");
		  return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());


		get("/add_squad_form", (request, response) -> {
		  Map<String, Object> model = new HashMap<String, Object>();
		  model.put("template", "templates/add_squad_form.vtl");
		  return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		post ("/hero", (request, response) -> {
		  Map<String, Object> model = new HashMap<String, Object>();
		  String name = request.queryParams("name");
		  int age = Integer.parseInt(request.queryParams("age"));
		  String power = request.queryParams("power");
		  String weakness = request.queryParams("weakness");
		  Hero myHero = new Hero(name,age,power,weakness);
      	  model.put("template", "templates/success_hero.vtl");
		  return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

        get("/hero", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("hero", Hero.all());
          model.put("template", "templates/hero.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

		get("/add_hero_form", (request, response) -> {
		  Map<String, Object> model = new HashMap<String, Object>();
		  model.put("template", "templates/add_hero_form.vtl");
		  return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/add_squad_form/:id/squad/new", (request, response) -> {
		  Map<String, Object> model = new HashMap<String, Object>();
		  Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
          model.put("hero", hero);
		  model.put("template", "templates/add_squad_form.vtl");
		  return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		post ("/squad", (request, response) -> {
		  Map<String, Object> model = new HashMap<String, Object>();
		  String name = request.queryParams("name");
		  int size = Integer.parseInt(request.queryParams("size"));
		  String cause = request.queryParams("cause");
		  Squad mySquad = new Squad(name,size,cause);
      	  model.put("template", "templates/success_squad.vtl");
		  return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

        get("/squad", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("squads", Squad.all());
          model.put("template", "templates/squad.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

		get("/hero/:id", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
          model.put("hero", hero);
          model.put("template", "templates/hero_details.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}