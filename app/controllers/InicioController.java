package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class InicioController extends Controller {

	public static Result index(){
		return ok(views.html.inicio.render());
	}

	public static Result sobre(){
		return TODO;
	}
	
}
