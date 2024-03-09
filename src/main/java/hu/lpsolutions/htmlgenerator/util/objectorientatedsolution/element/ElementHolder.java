package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element;

import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;


@NoArgsConstructor
public abstract class ElementHolder <T> extends Element{

    protected Queue<Element> rows;
    protected T parent;

    public ElementHolder(String openingTag, String closingTag, T parent) {
        super( openingTag, null,closingTag);
        this.rows = new LinkedList<>();
        this.parent = parent;
    }

    public T end(){
        return parent;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.openingTag != null) builder.append(openingTag);
        while (!rows.isEmpty()){
            Element element = rows.poll();
            builder.append(element.toString());
        }
        if(this.closingTag != null) builder.append(closingTag);
        return builder.toString();
    }
}
