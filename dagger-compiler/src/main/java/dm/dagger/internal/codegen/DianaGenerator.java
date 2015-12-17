package dm.dagger.internal.codegen;

import com.google.common.collect.ImmutableSet;

import javax.lang.model.element.Element;

import dagger.internal.codegen.writer.MethodWriter;
import dagger.internal.codegen.writer.TypeName;
import dm.dagger.internal.InjectExtra;

/**
 * Created by luotao on 15/12/15.
 */
public class DianaGenerator {
  public static void appendInjectMembers(
      MethodWriter injectMembersWriter, TypeName injectedTypeName) {
    DianaProcessor dianaProcessor = DianaProcessor.getInstance();

    injectDiana(injectMembersWriter, dianaProcessor, injectedTypeName);
    injectButterKnife(injectMembersWriter, dianaProcessor, injectedTypeName);

  }

  public static void injectDiana(
      MethodWriter injectMembersWriter, DianaProcessor dianaProcessor, TypeName injectedTypeName) {

    KeyType keyType = KeyType.create(KeyType.Kind.DIANA, injectedTypeName);
    ImmutableSet<Element> elements = dianaProcessor.registry.get(keyType);

    for (Element element : elements) {
      InjectExtra injectExtra = element.getAnnotation(InjectExtra.class);

      injectMembersWriter.body().addSnippet(
          "instance.%s = (%s) instance.getIntent().getSerializableExtra(\"%s\");",
          element.getSimpleName(), element.asType(), injectExtra.value()
      );
    }
  }

  public static void injectButterKnife(
      MethodWriter injectMembersWriter, DianaProcessor dianaProcessor, TypeName injectedTypeName) {

    KeyType keyType = KeyType.create(KeyType.Kind.BUTTER_KNIFE, injectedTypeName);
    ImmutableSet<Element> elements = dianaProcessor.registry.get(keyType);

    if (elements.size() > 0) {
      injectMembersWriter.body().addSnippet(
          "%s.bind(instance);", "butterknife.ButterKnife"
      );
    }
  }
}
