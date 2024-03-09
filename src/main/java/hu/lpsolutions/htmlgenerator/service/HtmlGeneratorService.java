package hu.lpsolutions.htmlgenerator.service;

import freemarker.template.TemplateException;
import hu.lpsolutions.htmlgenerator.dto.HtmlParamPayloadDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface HtmlGeneratorService {
    String generateHtmlWithParams(HtmlParamPayloadDto htmlParamPayloadDto) throws IOException, TemplateException;

    String generateHtmlWithParamsStringBuilder(HtmlParamPayloadDto htmlParamPayloadDto) throws IOException, TemplateException;
}
