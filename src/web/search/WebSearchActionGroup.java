package web.search;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.Caret;
import org.jetbrains.annotations.NotNull;

public class WebSearchActionGroup extends DefaultActionGroup {
    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(isEnabledAndVisible(e));
    }

    private boolean isEnabledAndVisible(@NotNull AnActionEvent e) {
        Caret caret = e.getData(CommonDataKeys.CARET);
        // System.out.println("caret = " + caret);

        if (caret == null) {
            return false;
        }

        boolean hasSelection = caret.hasSelection();
        // System.out.println("hasSelection = " + hasSelection);

        if (!hasSelection) {
            return false;
        }

        String selectedText = caret.getSelectedText();
        // System.out.println("selectedText = " + selectedText);

        boolean isBlank = selectedText.isBlank();
        // System.out.println("isBlank = " + isBlank);
        if (isBlank) {
            return false;
        }
        return true;
    }
}
