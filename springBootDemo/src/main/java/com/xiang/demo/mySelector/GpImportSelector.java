package com.xiang.demo.mySelector;

import com.xiang.demo.DemoApplication;
import com.xiang.demo.component.FirstClass;
import com.xiang.demo.component.SecondClass;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class GpImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{FirstClass.class.getName(), SecondClass.class.getName()};
    }
}
