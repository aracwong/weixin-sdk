package com.github.aracwong.weixin.framework.annotation;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * 注解解析器
 *
 * @author aracwong
 * @version 1.0.0
 */
@Slf4j
@SupportedAnnotationTypes({"com.github.aracwong.weixin.framework.annotation.WxHandler"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class WxHandlerAnnotationProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (log.isDebugEnabled()) {
            log.debug("==== WxHandlerAnnotationProcessor =====");
        }

        for (TypeElement typeElement : annotations) {
            // 遍历annotations获取annotation类型
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                // 使用roundEnv.getElementsAnnotatedWith获取所有被某一类型注解标注的元素，依次遍历

                String forMsgType = element.getAnnotation(WxHandler.class).forMsgType();
                System.out.println("===========================================");
                log.info("=== WxHandlerAnnotationProcessor process WxHandler with msgType: [{}]", forMsgType);

                // 向当前环境输出warning信息
                processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, "forMsgType = " + forMsgType, element);


            }
        }

        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
