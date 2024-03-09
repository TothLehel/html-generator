package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag;

import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.HtmlBuilder;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.Element;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.ElementHolder;

public class Body extends ElementHolder<HtmlBuilder> {


    public Body(HtmlBuilder parent) {
        super("<body>", "</body>", parent);
    }

    public Body heading(int level, String text) {
        rows.add(new Element("<h" + level + ">" ,  text, "</h" + level + ">"));
        return this;
    }

    public Paragraph paragraph() {
        Paragraph paragraph = new Paragraph(this);
        rows.add(paragraph);
        return paragraph;
    }

    public Body anchor(String href, String name) {
        rows.add(new Element( "<a href=\"" + href + "\">", name, "</a>"));
        return this;
    }

    public Table table(String border) {
        Table table = new Table(border, this);
        rows.add(table);
        return table;
    }


}
