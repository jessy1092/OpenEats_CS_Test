package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Member;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class MemberController extends Controller {
	@Transactional
	public static Result index(String email) {
		// fake data
		Member member = new Member("test@gmail.com", "Eddie", "Chen");
		member.save();
		
		JsonNode node = Json.toJson(member);		
		return ok(node);
		
      //  return ok(("Hello from Java"));
    }
}
