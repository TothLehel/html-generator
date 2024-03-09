package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag;

import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.HtmlBuilder;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.Element;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.ElementHolder;

public class Header extends ElementHolder<HtmlBuilder> {

    public Header(HtmlBuilder parent) {
        super("<header>", "</header>", parent);
    }
    public Header title(String titleText) {
        rows.add(new Element("<title>" , titleText ,"</title>"));
        return this;
    }


}
