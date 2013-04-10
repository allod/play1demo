package controllers;

import models.Profile;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.List;

public class Profiles extends Controller {
    public static void create() {
        render();
    }

    public static void list() {
        List<Profile> profiles = Profile.findAll();
        render(profiles);
    }

    public static void view(Long id) {
        Profile profile = Profile.findById(id);
        notFoundIfNull(profile);
        render(profile);
    }

    public static void save(@Valid Profile profile) {
        if(Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            create();
        }

        profile.save();
        list();
    }
}

