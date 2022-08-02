package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Container {

    private static final ArticleController articleController;
    private static final HomeController homeController;

    static {
        try {
            articleController = (ArticleController) ArticleController.class.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            homeController = (HomeController) HomeController.class.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArticleController getArticleController() {
        return articleController;
    }

    public static List<String> getControllerNames() {

        List<String> controllerNames = new ArrayList<>();

        Reflections reflector = new Reflections("com.ll.exam");
        Set<Class<?>> controllerSet = reflector.getTypesAnnotatedWith(Controller.class);

        for (Class<?> controller : controllerSet) {
            String name = controller.getSimpleName();
            name = name.replace("Controller", "");

            name = Ut.Str.deCapitalize(name);

            controllerNames.add(name);
        }

        return controllerNames;
    }

    public static HomeController getArticleHomeController() {
        return homeController;
    }
}
