package dm.diana.codegen;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.SetMultimap;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.logging.Logger;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;

import dm.diana.annotation.InjectExtra;

/**
 * Created by luotao on 15/12/14.
 */
public class InjectExtraProcessingStep implements BasicAnnotationProcessor.ProcessingStep {
  @Override
  public Set<? extends Class<? extends Annotation>> annotations() {
    return ImmutableSet.<Class<? extends Annotation>>of(InjectExtra.class);
  }

  @Override
  public Set<Element> process(SetMultimap<Class<? extends Annotation>, Element> elementsByAnnotation) {
    Set<Element> elements = elementsByAnnotation.get(InjectExtra.class);
    ImmutableSetMultimap.Builder<DeclaredType, Element> registry =
        ImmutableSetMultimap.builder();

    for (Element element : elements) {
      InjectExtra injectExtra = element.getAnnotation(InjectExtra.class);
      DeclaredType declaredType = MoreTypes.asDeclared(element.asType());
      ElementKind kd1 = declaredType.asElement().getKind();
      DeclaredType keyType = MoreTypes.asDeclared(element.getEnclosingElement().asType());

//      TypeElement typeElement = MoreElements.asType(element);
      TypeElement typeElement1 = MoreTypes.asTypeElement(declaredType);
      registry.put(keyType, element);
      Logger.getLogger("DIANA").warning(element.toString());
    }

    return ImmutableSet.of();
  }
}
