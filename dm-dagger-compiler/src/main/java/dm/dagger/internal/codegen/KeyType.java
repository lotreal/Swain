package dm.dagger.internal.codegen;

import com.google.auto.value.AutoValue;

import javax.lang.model.element.Element;

import dagger.internal.codegen.writer.TypeName;

@AutoValue
abstract class KeyType {
  static KeyType create(Kind kind, TypeName typeName) {
    return new AutoValue_KeyType(kind, typeName);
  }

  abstract Kind kind();

  abstract TypeName typeName();

  /**
   * The style of binding that makes a {@link Element} available.
   */
  enum Kind {
    DIANA, BUTTER_KNIFE;
  }
}
