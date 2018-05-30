package controllers;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.StudentEntity;
import models.StudentModel;
import play.db.jpa.JPABase;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import service.StudentService;

@With(SecurityController.class)

public class StudentController extends Controller {

	public static void create() {
		String body = params.get("body");
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(body);
		Gson gson = new Gson();
		StudentModel studentModel = gson.fromJson(body, StudentModel.class);
		StudentService studentService = new StudentService();
		studentService.insert(studentModel);
		renderJSON("{\"success\":\"true\"}");
	}

	public static void findById(int eid) {
		StudentEntity studentEntity = StudentEntity.find("id=?", Long.valueOf(String.valueOf(eid))).first();
		String jsonResponse = new Gson().toJson(studentEntity);
		renderJSON(jsonResponse);
	}

	public static void updateById(int eid) {
		String body = params.get("body");
		Gson gson = new Gson();
		StudentModel studentModel = gson.fromJson(body, StudentModel.class);
		studentModel.setSid(eid);
		StudentService studentService = new StudentService();
		StudentEntity studentEntity = studentService.update(studentModel);
		String jsonResponse = new Gson().toJson(studentEntity);
		renderJSON(jsonResponse);
	}

	public static void deleteById(int eid) {
		StudentEntity studentEntity = StudentEntity.find("id=?", Long.valueOf(String.valueOf(eid))).first();
		studentEntity._delete();
		String jsonResponse = new Gson().toJson(studentEntity);
		renderJSON(jsonResponse);
	}

	public static void findByIdAndName(String eid, String ename) {
		StudentEntity studentEntity = StudentEntity.find("id=? and studentName=?", Long.valueOf(eid), ename).first();
		StudentModel studentModel = new StudentModel(studentEntity.getStudentName(), studentEntity.getStudentCity(),
				Integer.valueOf(String.valueOf(studentEntity.id)));
		String jsonResponse = new Gson().toJson(studentModel);
		renderJSON(jsonResponse);
	}

	public static void findAllStudents() {
		List<StudentEntity> posts = StudentEntity.all().fetch();
		String jsonResponse = new Gson().toJson(posts);
		renderJSON(jsonResponse);
	}
}
