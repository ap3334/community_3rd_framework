package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Container {

    private static final ArticleController articleController;
    private static final HomeController homeController;

    static {
        articleController = new ArticleController();
        homeController = new HomeController();
    }

    public static ArticleController getArticleController() {
        return articleController;
    }

    public static List<String> getControllerNames() {

        List<String> controllerNames = new ArrayList<>();

        Reflections reflector = new Reflections("com.ll.exam");
        Set<Class<?>> controllerSet = reflector.getTypesAnnotatedWith(Controller.class);

        for (Class<?> controller : controllerSet) {
            String key = controller.getSimpleName();
            String[] temp = key.split("Controller");
            controllerNames.add(temp[0].toLowerCase());
        }

        return controllerNames;
    }
}
