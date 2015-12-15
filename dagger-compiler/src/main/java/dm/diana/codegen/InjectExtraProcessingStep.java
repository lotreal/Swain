package dm.diana.codegen;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.SetMultimap;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.lang.model.element.Element;

// TODO: import butterknife.Bind;
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
    register(elementsByAnnotation, InjectExtra.class, KeyType.Kind.DIANA);
    // register(elementsByAnnotation, Bind.class, KeyType.Kind.BUTTER_KNIFE);

    DianaProcessor.getInstance().buildRegistry();
    return ImmutableSet.of();
  }

  private void register(SetMultimap<Class<? extends Annotation>, Element> elementsByAnnotation,
                        Class<? extends Annotation> annotation,
                        KeyType.Kind kind) {
    Set<Element> elements = elementsByAnnotation.get(annotation);
    DianaProcessor dianaProcessor = DianaProcessor.getInstance();

    for (Element element : elements) {
      dianaProcessor.register(kind, element);
    }
  }

}
