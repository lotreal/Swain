package dm.annotation;

import javax.lang.model.element.Element;

/**
 * Created by luotao on 15/12/22.
 */
public class InjectExtraProcessor {
  public InjectExtraProcessor() {
  }

  public String process(Element element) {
    InjectExtra injectExtra = element.getAnnotation(InjectExtra.class);
    return String.format(
        "instance.%s = (%s) instance.getIntent().getSerializableExtra(\"%s\");",
        element.getSimpleName(), element.asType(), injectExtra.value()
    );
  }
}
