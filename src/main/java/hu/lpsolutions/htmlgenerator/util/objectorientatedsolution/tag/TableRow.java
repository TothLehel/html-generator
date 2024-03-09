package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag;

import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.Element;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.ElementHolder;

public class TableRow extends ElementHolder<Table> {

    public TableRow(Table parent) {
        super("<tr>","</tr>", parent);
    }

    public TableRow addData(String data) {
        rows.add(new Element("<td>", data, "</td>"));
        return this;
    }

    
}
