package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution;

import hu.lpsolutions.htmlgenerator.util.Builder;
import hu.lpsolutions.htmlgenerator.util.HtmlFormatterUtil;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag.Body;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag.Header;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlBuilder extends Builder {
    private Header header;
    private Body body;

    private HtmlBuilder(){
        this.templateData = new HashMap<>();
        this.header = null;
        this.body = null;
    }

    public static HtmlBuilder create(){
        return new HtmlBuilder();
    }

    public Header header(){
        if(header == null) header = new Header(this);
        return  header;
    }

    public Body body(){
        if(body == null) body = new Body(this);
        return  body;
    }

    public HtmlBuilder addParameter (String key, Object value) {
        templateData.put(key, value);
        return this;
    }

    public String build(){
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html>");

        if(header != null) {
            html.append(header.toString());
        }
        if(body != null) {
            html.append(body.toString());
        }
        html.append("</html>");
        return HtmlFormatterUtil.formatHtml(html.toString());
    }




}
