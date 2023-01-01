package web.search;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.util.io.URLUtil;
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

        String url = null;
        switch (text) {
            case "必应搜索":
                // https://cn.bing.com/search?q=test
                // https://cn.bing.com/search?q=%E6%B5%8B%E8%AF%95
                // System.out.println("必应 " + selectedText);
                url = "https://cn.bing.com/search?q=";  // query 查询
                break;
            case "百度搜索":
                // https://www.baidu.com/s?wd=test
                // https://www.baidu.com/s?wd=%E6%B5%8B%E8%AF%95
                // System.out.println("百度 " + selectedText);
                url = "https://www.baidu.com/s?wd=";  // word
                break;
            case "搜狗搜索":
                // https://sogou.com/web?query=test
                // https://sogou.com/web?query=%E6%B5%8B%E8%AF%95
                System.out.println("搜狗 " + selectedText);
                url = "https://sogou.com/web?query=";
                break;
        }
        // BrowserUtil.browse("http://www.google.com/search?q=" + URLUtil.encodeURIComponent(term));
        BrowserUtil.browse(url + URLUtil.encodeURIComponent(selectedText));
    }
}
