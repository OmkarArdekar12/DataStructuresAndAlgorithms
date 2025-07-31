// Design a Text Editor

import java.util.*;

class TextEditor {
    StringBuilder textEditor;
    int cursor;
    public TextEditor() {
        this.textEditor = new StringBuilder("");
        this.cursor = 0;
    }
    
    public void addText(String text) {
        textEditor.insert(cursor, text);
        cursor += text.length();
        return;
    }
    
    public int deleteText(int k) {
        int currPosition = cursor;
        cursor = Math.max(0, cursor - k);
        textEditor.delete(cursor, currPosition);
        int deleteChars = currPosition - cursor;
        return deleteChars;
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return textEditor.substring(Math.max(0, cursor - 10), cursor);
    }
    
    public String cursorRight(int k) {
        int n = textEditor.length();
        cursor = Math.min(n, cursor + k);
        return textEditor.substring(Math.max(0, cursor - 10), cursor);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */

public class DesignATextEditor {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        TextEditor obj = new TextEditor();
        obj.addText("leetcode"); res.add("null");
        res.add(Integer.toString(obj.deleteText(4)));
        obj.addText("practice"); res.add("null");
        res.add(obj.cursorRight(3));
        res.add(obj.cursorLeft(8));
        res.add(Integer.toString(obj.deleteText(10)));
        res.add(obj.cursorLeft(2));
        res.add(obj.cursorRight(6));
        System.out.println(res);  
    }
}