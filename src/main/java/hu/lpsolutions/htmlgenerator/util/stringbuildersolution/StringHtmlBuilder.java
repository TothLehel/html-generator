package hu.lpsolutions.htmlgenerator.util.stringbuildersolution;

import hu.lpsolutions.htmlgenerator.util.Builder;
import hu.lpsolutions.htmlgenerator.util.HtmlFormatterUtil;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.Element;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag.Body;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag.Header;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringHtmlBuilder  extends Builder {
    private StringBuilder html;
    @Getter
    private Map<String, Object> templateData;

    private StringHtmlBuilder(){
        this.html = new StringBuilder();
        this.templateData = new HashMap<>();
        this.html.append("<!DOCTYPE html>");
        this.html.append("<html>");
    }

    public static StringHtmlBuilder create(){
        return new StringHtmlBuilder();
    }

    public StringHtmlBuilder startHeader(){
        html.append("<header>");
        return this;
    }
    public StringHtmlBuilder closeHeader(){
        html.append("</header>");
        return this;
    }

    public StringHtmlBuilder title(String title){
        html.append("<title>").append(title).append("</title>");
        return this;
    }


    public StringHtmlBuilder startBody(){
        html.append("<body>");
        return this;
    }
    public StringHtmlBuilder closeBody(){
        html.append("</body>");
        return this;
    }

    public StringHtmlBuilder startTable(String border){
        html.append("<table");
        if (border != null && !border.isEmpty() ) html.append( " border=\"").append(border).append("\"");
        return this;
    }
    public StringHtmlBuilder closeTable(){
        html.append("</table>");
        return this;
    }

    public StringHtmlBuilder startTr(){
        html.append("<tr>");
        return this;
    }
    public StringHtmlBuilder closeTr(){
        html.append("</tr>");
        return this;
    }

    public StringHtmlBuilder addTd(String data){
        html.append("<td>").append(data).append("</td>");
        return this;
    }

    public StringHtmlBuilder addParagraph(String data){
        html.append("<p>").append(data).append("</p>");
        return this;
    }

    public StringHtmlBuilder startParagraph(){
        html.append("<p>");
        return this;
    }
    public StringHtmlBuilder closeParagraph(){
        html.append("</p>");
        return this;
    }

    public StringHtmlBuilder heading(int level, String text) {
        html.append("<h").append(level).append(">").append(text).append("</h").append(level).append(">");
        return this;
    }

    public StringHtmlBuilder anchor(String href, String name) {
        html.append("<a href=\"").append(href).append("\">").append(name).append("</a>");
        return this;
    }

    public StringHtmlBuilder addParameter (String key, Object value) {
        templateData.put(key, value);
        return this;
    }


    @Override
    public String build() {
        html.append("</html>");
        return HtmlFormatterUtil.formatHtml(html.toString());
    }
}
