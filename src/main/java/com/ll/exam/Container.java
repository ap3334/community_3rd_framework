package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.Service;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Container {

    private static Map<Class, Object> objects;

    static {
        objects = new HashMap<>();

        scanComponents();
    }

    private static void scanComponents() {
        scanServices();
        scanControllers();
    }

    private static void scanServices() {
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Service.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    private static void scanControllers() {
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    public static <T> T getObj(Class<T> cls) {
        return (T) objects.get(cls);
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


}
