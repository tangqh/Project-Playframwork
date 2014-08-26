package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.Task;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class TaskController extends Controller {
    
	private static final Form<Task> taskForm = Form.form(Task.class);

    public static Result novo() {    	
    	return ok(views.html.novo.render(taskForm));  	
    }
    
    public static Result gravar() {
    	Form<Task> form = taskForm.bindFromRequest();
    	if (form.hasErrors()) {
    		flash("erro", "Foram identificado problemas no cadastro!");
    		return ok(views.html.novo.render(form));
    	}
    	Task task = form.get();
    	task.save();
    	flash("sucesso", "Registro gravado com sucesso!");
    	return redirect(routes.TaskController.lista());
    }
    
    public static Result lista(){
    	List<Task> tasks = Task.find.findList();
    	return ok(views.html.task.render(tasks));
    }
    
    public static Result taskJson(){
    	List<Task> tasks = Task.find.all();
    	return ok(toJson(tasks));
    }
    
    public static Result detalhar(Long id){
    	Form<Task> detalhaForm = taskForm.fill(Task.find.byId(id));
    	return ok(views.html.alterar.render(id,detalhaForm));
    }
    
    public static Result alterar(Long id){
    	Form<Task> alteraForm = taskForm.fill(Task.find.byId(id)).bindFromRequest();
    	if (alteraForm.hasErrors()) {
    		return badRequest(views.html.alterar.render(id, alteraForm));
    	}
    	alteraForm.get().update(id);
    	flash("sucesso", "Tarefa alterado com sucesso");
    	return redirect(routes.TaskController.lista());
    }
    
    public static Result remover(Long id){ 
    	Task.find.ref(id).delete();
    	flash("sucesso", "Tarefa removida com sucesso!");    	
    	return redirect(routes.TaskController.lista());
    }	

}
