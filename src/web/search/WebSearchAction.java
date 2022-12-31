package web.search;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class WebSearchAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        System.out.println("菜单项被点击了");
    }
}
