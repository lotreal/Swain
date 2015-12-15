package dm.diana.codegen;

import com.google.auto.value.AutoValue;

import javax.lang.model.element.Element;

import dagger.internal.codegen.writer.TypeName;

/**
 * A value object that pairs a {@link Element} with the style of its binding (i.e., whether it's a
 * members injector or normal contribution).
 *
 *  @author Gregory Kick
 *  @since 2.0
 */
@AutoValue
abstract class KeyType {
  /** The style of binding that makes a {@link Element} available. */
  enum Kind {
    DIANA, BUTTER_KNIFE;
  }

  static KeyType create(Kind kind, TypeName typeName) {
    return new AutoValue_KeyType(kind, typeName);
  }

  abstract Kind kind();
  abstract TypeName typeName();
}
