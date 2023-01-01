package web.search;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import org.jetbrains.annotations.NotNull;

public class WebSearchAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // System.out.println("菜单项被点击了");
        // System.out.println("=============================");
        String text = e.getPresentation().getText();
        // System.out.println("text = " + text);

        Caret caret = e.getData(CommonDataKeys.CARET);
        // System.out.println("caret = " + caret);

        if (caret == null) {
            return;
        }

        boolean hasSelection = caret.hasSelection();
        // System.out.println("hasSelection = " + hasSelection);

        if (!hasSelection) {
            return;
        }

        String selectedText = caret.getSelectedText();
        // System.out.println("selectedText = " + selectedText);

        boolean isBlank = selectedText.isBlank();
        // System.out.println("isBlank = " + isBlank);
        if (isBlank) {
            return;
        }

        switch (text) {
            case "必应搜索":
                System.out.println("必应 " + selectedText);
                break;
            case "百度搜索":
                System.out.println("百度 " + selectedText);
                break;
            case "搜狗搜索":
                System.out.println("搜狗 " + selectedText);
                break;
        }
    }
}
