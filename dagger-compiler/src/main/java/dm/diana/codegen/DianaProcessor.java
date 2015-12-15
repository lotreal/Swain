package dm.diana.codegen;

import com.google.auto.common.MoreTypes;
import com.google.common.collect.ImmutableSetMultimap;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;

import dagger.internal.codegen.writer.TypeName;
import dagger.internal.codegen.writer.TypeNames;
import dm.diana.annotation.InjectExtra;

/**
 * Created by luotao on 15/12/15.
 */
public class DianaProcessor {
  private static class SingletonHolder {
    private static final DianaProcessor INSTANCE = new DianaProcessor();
  }
  public static DianaProcessor getInstance() { return SingletonHolder.INSTANCE; }

  private ImmutableSetMultimap.Builder<KeyType, Element> registryBuilder =
      ImmutableSetMultimap.builder();
  ImmutableSetMultimap<KeyType, Element> registry;

  public void register(KeyType.Kind kind, Element element) {
    TypeName typeName = TypeNames.forTypeMirror(element.getEnclosingElement().asType());
    KeyType keyType = KeyType.create(KeyType.Kind.DIANA, typeName);

    InjectExtra injectExtra = element.getAnnotation(InjectExtra.class);
    DeclaredType declaredType = MoreTypes.asDeclared(element.asType());
    ElementKind kd1 = declaredType.asElement().getKind();
    //DeclaredType keyType = MoreTypes.asDeclared(element.getEnclosingElement().asType());

//      TypeElement typeElement = MoreElements.asType(element);
    TypeElement typeElement1 = MoreTypes.asTypeElement(declaredType);

    registryBuilder.put(keyType, element);
  }

  public void buildRegistry() {
    registry = registryBuilder.build();
  }
}
