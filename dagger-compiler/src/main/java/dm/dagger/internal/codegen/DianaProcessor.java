package dm.dagger.internal.codegen;

import com.google.common.collect.ImmutableSetMultimap;

import javax.lang.model.element.Element;

import dagger.internal.codegen.writer.TypeName;
import dagger.internal.codegen.writer.TypeNames;

/**
 * Created by luotao on 15/12/15.
 */
public class DianaProcessor {
  ImmutableSetMultimap<KeyType, Element> registry;
  private ImmutableSetMultimap.Builder<KeyType, Element> registryBuilder =
      ImmutableSetMultimap.builder();

  public static DianaProcessor getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public void register(KeyType.Kind kind, Element element) {
    TypeName typeName = TypeNames.forTypeMirror(element.getEnclosingElement().asType());
    KeyType keyType = KeyType.create(kind, typeName);
    registryBuilder.put(keyType, element);
  }

  public void buildRegistry() {
    registry = registryBuilder.build();
  }

  private static class SingletonHolder {
    private static final DianaProcessor INSTANCE = new DianaProcessor();
  }
}
