package cn.silently9527.component;

import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;
import com.intellij.util.ui.JBFont;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JPanel {
    private JBTextArea textArea;

    public TextEditor() {
        this(0, 0);
    }

    public TextEditor(int rows, int columns) {
        super(new BorderLayout());
        this.setBorder(JBUI.Borders.customLine(JBColor.border()));

        textArea = new JBTextArea(rows, columns);
        textArea.setAutoscrolls(true);
        textArea.setTabSize(4);
        textArea.setFont(JBFont.getFont(JBFont.DIALOG_INPUT));

        JBScrollPane scrollPane = new JBScrollPane(textArea);
        TextLineNumber tln = new TextLineNumber(textArea);
        scrollPane.setRowHeaderView(tln);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    public JBTextArea getTextArea() {
        return textArea;
    }

    public String getTextValue() {
        return this.textArea.getText();
    }

    public void setTextValue(String text) {
        this.textArea.setText(text);
    }
}