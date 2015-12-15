package dm.diana.codegen;

import com.google.common.base.Joiner;

import dagger.internal.codegen.writer.MethodWriter;

/**
 * Created by luotao on 15/12/15.
 */
public class DianaGenerator {
  public static void appendInjectMembers(MethodWriter injectMembersWriter) {
    injectMembersWriter.body().addSnippet(Joiner.on('\n').join(
        "// instance.injectExtra = (Config) instance.getIntent().getSerializableExtra(\"config\");",
        "// ButterKnife.bind(instance);"
    ));
  }
}
