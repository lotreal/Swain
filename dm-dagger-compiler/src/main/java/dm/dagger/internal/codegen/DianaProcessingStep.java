package dm.dagger.internal.codegen;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.SetMultimap;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.lang.model.element.Element;
import static dm.dagger.internal.codegen.KeyType.Kind;

/**
 * Created by luotao on 15/12/14.
 */
public class DianaProcessingStep implements BasicAnnotationProcessor.ProcessingStep {
  DianaProcessor dianaProcessor = DianaProcessor.getInstance();

  ImmutableSetMultimap<Kind, String> annotationNames;
  ImmutableSetMultimap<Kind, Class<? extends Annotation>> availableAnnotations;

  public DianaProcessingStep() {
    ImmutableSetMultimap.Builder<Kind, String> annotationNameBuilder = ImmutableSetMultimap.builder();
    annotationNameBuilder.putAll(Kind.DIANA, "dm.annotation.InjectExtra");

    annotationNameBuilder.putAll(Kind.BUTTER_KNIFE,
        "butterknife.Bind",
        "butterknife.BindArray",
        "butterknife.BindBitmap",
        "butterknife.BindBool",
        "butterknife.BindColor",
        "butterknife.BindDimen",
        "butterknife.BindDrawable",
        "butterknife.BindInt",
        "butterknife.BindString",
        "butterknife.OnCheckedChanged",
        "butterknife.OnClick",
        "butterknife.OnEditorAction",
        "butterknife.OnFocusChange",
        "butterknife.OnItemClick",
        "butterknife.OnItemLongClick",
        "butterknife.OnItemSelected",
        "butterknife.OnLongClick",
        "butterknife.OnPageChange",
        "butterknife.OnTextChanged",
        "butterknife.OnTouch",
        "butterknife.Optional",
        "butterknife.Unbinder"
    );
    annotationNames = annotationNameBuilder.build();

    ImmutableSetMultimap.Builder<Kind, Class<? extends Annotation>>
        availableAnnotationBuilder = ImmutableSetMultimap.builder();
    for (Kind kind : annotationNames.keySet()) {
      for (String annotationName : annotationNames.get(kind)) {
        Optional<Class<? extends Annotation>> annotation = findAnnotation(annotationName);
        if (annotation.isPresent()) {
          availableAnnotationBuilder.put(kind, annotation.get());
        }
      }
    }
    availableAnnotations = availableAnnotationBuilder.build();
  }

  public Optional<Class<? extends Annotation>> findAnnotation(String classname) {
    try {
      Class<? extends Annotation> annotation = (Class<? extends Annotation>) Class.forName(classname);
      return Optional.<Class<? extends Annotation>>of(annotation);
    } catch (ClassNotFoundException e) {
      return Optional.absent();
    }
  }

  @Override
  public Set<? extends Class<? extends Annotation>> annotations() {
    ImmutableSet.Builder<Class<? extends Annotation>> annotationsBuilder = new ImmutableSet.Builder<>();

    for (Kind kind : availableAnnotations.keySet()) {
      for (Class<? extends Annotation> annotation : availableAnnotations.get(kind)) {
        annotationsBuilder.add(annotation);
      }
    }

    return annotationsBuilder.build();
  }

  @Override
  public Set<Element> process(
      SetMultimap<Class<? extends Annotation>, Element> elementsByAnnotation) {

    for (Kind kind : availableAnnotations.keySet()) {
      for (Class<? extends Annotation> annotation : availableAnnotations.get(kind)) {
        register(elementsByAnnotation, annotation, kind);
      }
    }

    dianaProcessor.buildRegistry();
    return ImmutableSet.of();
  }

  private void register(
      SetMultimap<Class<? extends Annotation>, Element> elementsByAnnotation,
      Class<? extends Annotation> annotation,
      Kind kind) {

    Set<Element> elements = elementsByAnnotation.get(annotation);

    for (Element element : elements) {
      dianaProcessor.register(kind, element);
    }
  }

}
