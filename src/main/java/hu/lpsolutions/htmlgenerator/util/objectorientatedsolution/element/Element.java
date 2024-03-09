package hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.element;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Element  {

    protected String openingTag;
    protected String innerText;
    protected String closingTag;
    @Override
    public String toString(){
        String returnString = "";

        if(openingTag != null && !openingTag.isBlank()){
            returnString += openingTag;
        }
        if(innerText != null &&  !innerText.isBlank()){
            returnString += innerText;
        }
        if(closingTag != null && !closingTag.isBlank()){
            returnString += closingTag;
        }
        return  returnString;
    }
}
