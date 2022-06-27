package org.bd.java_exercise.annotation.processor;

import com.google.auto.service.AutoService;
import org.bd.java_exercise.annotation.Getter;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 注解处理器<p>
 * 依赖Google的auto-service和Square的JavaPoet
 * {@link Getter}
 */
@AutoService(GetterProcessor.class)
public class GetterProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // 获取所有被注解的元素
        Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(Getter.class);

        for (Element element : elementSet) {
            // 注解作用域为字段，因此直接转型
            VariableElement variableElement = (VariableElement) element;

            // 获取此元素所封装的元素
            TypeElement typeElement = (TypeElement) variableElement.getEnclosingElement();
        }

        // TODO
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(Getter.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    // TODO: in progress
}
