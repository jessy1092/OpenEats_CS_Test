package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import views.html.*;

public class MainController extends Controller {
	@SecureSocial.SecuredAction
    public static Result index() {
       // return ok(views.html.index.render("Hello from Java"));
		Identity user = (Identity) ctx().args.get(SecureSocial.USER_KEY);
        return ok(index.render(user)); 
    }
    
}
