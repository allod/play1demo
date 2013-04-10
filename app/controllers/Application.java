package controllers;

import models.Profile;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void service() {
        List<Profile> profiles = Profile.findAll();
        render(profiles);
    }

}