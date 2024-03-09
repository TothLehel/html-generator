package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.tag;

import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element.ElementHolder;

import java.util.LinkedList;

public class Table extends ElementHolder<Body> {

    public Table(String border, Body parent) {
        this.openingTag = "<table";
        if( border != null && !border.isBlank()){
            this.openingTag += " border=\"" + border  + "\"";
        }
        this.openingTag += ">";
        this.closingTag = "</table>";
        this.rows = new LinkedList<>();
        this.parent = parent;
    }

    public TableRow row() {
        TableRow row = new TableRow(this);
        rows.add(row);
        return row;
    }

    
}
