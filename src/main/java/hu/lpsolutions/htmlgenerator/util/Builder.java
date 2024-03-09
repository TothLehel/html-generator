package hu.lpsolutions.htmlgenerator.util;

import lombok.Getter;

import java.util.Map;

@Getter
public abstract class Builder {
    public abstract String build();

    protected Map<String, Object> templateData;

}
