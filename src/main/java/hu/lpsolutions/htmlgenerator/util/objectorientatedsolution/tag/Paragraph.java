package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag;

import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.Element;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.ElementHolder;

public class Paragraph extends ElementHolder<Body> {

    public Paragraph(Body parent) {
        super("<p>", "</p>", parent);
    }
    public Paragraph anchor(String href, String name) {
        rows.add(new Element( "<a href=\"" + href + "\">", name, "</a>"));
        return this;
    }

    public Paragraph text(String text) {
        rows.add(new Element(null, text, null));
        return this;
    }


}
