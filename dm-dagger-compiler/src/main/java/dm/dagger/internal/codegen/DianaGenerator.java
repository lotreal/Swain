package dm.dagger.internal.codegen;

import com.google.common.collect.ImmutableSet;

import org.joor.Reflect;

import javax.lang.model.element.Element;

import dagger.internal.codegen.writer.MethodWriter;
import dagger.internal.codegen.writer.TypeName;

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
      String snippet = Reflect.on("dm.annotation.InjectExtraProcessor").create().call("process", element).get();
      injectMembersWriter.body().addSnippet(snippet);
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
