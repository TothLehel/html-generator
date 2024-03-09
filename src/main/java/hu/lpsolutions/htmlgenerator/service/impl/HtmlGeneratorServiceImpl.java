package hu.lpsolutions.htmlgenerator.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import hu.lpsolutions.htmlgenerator.dto.HtmlParamPayloadDto;
import hu.lpsolutions.htmlgenerator.service.HtmlGeneratorService;
import hu.lpsolutions.htmlgenerator.util.Builder;
import hu.lpsolutions.htmlgenerator.util.objectorientatedsolution.HtmlBuilder;
import hu.lpsolutions.htmlgenerator.util.stringbuildersolution.StringHtmlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

@Service
public class HtmlGeneratorServiceImpl implements HtmlGeneratorService {

    @Autowired
    private Configuration freemarkerConfig;
    public String generateHtmlWithParams(HtmlParamPayloadDto htmlParamPayloadDto) throws IOException, TemplateException {

        HtmlBuilder htmlBuilder = HtmlBuilder.create();

        htmlBuilder.header().title("${name} - Teszt Feladat");
        htmlBuilder.body()
                .heading(1, "Teszt feladat")
                .paragraph()
                    .anchor("${repositoryUrl}", "Megoldás")
                .end()
                .paragraph()
                    .text("A feladat elkészítőjének adatai")
                .end()
                .table("1px solid black")
                    .row()
                        .addData("Név")
                        .addData("${name}")
                    .end()
                    .row()
                        .addData("Elérhetőség")
                        .addData("${email}")
                    .end()
                .end()
                .anchor("http://lpsolutions.hu", "L&P Solutions");

        htmlBuilder.addParameter("name", htmlParamPayloadDto.getName())
                .addParameter("repositoryUrl", htmlParamPayloadDto.getRepositoryUrl())
                .addParameter("email", htmlParamPayloadDto.getEmail());

        String result = processHtmlTemplate(htmlBuilder);

        createHtmlFileFromString(result);

        return result;
    }

    @Override
    public String generateHtmlWithParamsStringBuilder(HtmlParamPayloadDto htmlParamPayloadDto) throws IOException, TemplateException {

        StringHtmlBuilder htmlBuilder = StringHtmlBuilder.create();

        htmlBuilder.startHeader().title("${name} - Teszt Feladat").closeHeader();
        htmlBuilder.startBody()
                .heading(1, "Teszt feladat")
                .startParagraph()
                    .anchor("${repositoryUrl}", "Megoldás")
                .closeParagraph()
                .addParagraph("A feladat elkészítőjének adatai")
                .startTable("1px solid black")
                    .startTr()
                        .addTd("Név")
                        .addTd("${name}")
                    .closeTr()
                    .startTr()
                        .addTd("Elérhetőség")
                        .addTd("${email}")
                    .closeTr()
                .closeTable()
                .anchor("http://lpsolutions.hu", "L&P Solutions");

        htmlBuilder.addParameter("name", htmlParamPayloadDto.getName())
                .addParameter("repositoryUrl", htmlParamPayloadDto.getRepositoryUrl())
                .addParameter("email", htmlParamPayloadDto.getEmail());

        String result = processHtmlTemplate(htmlBuilder);

        createHtmlFileFromString(result);

        return result;
    }

    private String processHtmlTemplate( Builder htmlBuilder) throws IOException, TemplateException {
        //Így nem hoz létre template fájlt a rendszerben, így törölni sem kell
        Template template = new Template("dynamic-template", htmlBuilder.build(), freemarkerConfig);
        StringWriter result = new StringWriter();
        template.process(htmlBuilder.getTemplateData(), result);
        return result.toString();
    }

    private static void createHtmlFileFromString(String result) throws IOException {
        try (FileWriter writer = new FileWriter("generated.html")) {
            writer.write(result);
        }
    }

}
