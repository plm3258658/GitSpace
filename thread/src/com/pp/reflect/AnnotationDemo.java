package com.pp.reflect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationDemo {
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation{
        String name() default "pp";
        int age() default 10;
    }
    @SuppressWarnings("serial")
    @MyAnnotation
    @Deprecated
    class annotation implements Serializable {
    }

    public static void main(String[] args) {
        Annotation[] ant=annotation.class.getAnnotations();
        for(Annotation s:ant){
            System.out.println(s);
        }
        MyAnnotation ant1=annotation.class.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(ant1.name());
        System.out.println(ant1.age());
    }
}
