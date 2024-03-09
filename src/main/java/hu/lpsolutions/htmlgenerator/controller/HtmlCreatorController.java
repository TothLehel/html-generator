package hu.lpsolutions.htmlgenerator.controller;

import freemarker.template.TemplateException;
import hu.lpsolutions.htmlgenerator.dto.HtmlParamPayloadDto;
import hu.lpsolutions.htmlgenerator.service.HtmlGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/html", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HtmlCreatorController {

    @Autowired
    HtmlGeneratorService generatorService;
    @PostMapping("/create")
    public ResponseEntity<String> cretateHtmlWithParams(@RequestBody HtmlParamPayloadDto htmlParamPayloadDto){
        String response = "";
        try {
            response = generatorService.generateHtmlWithParams(htmlParamPayloadDto);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/create-with-simple")
    public ResponseEntity<String> cretateHtmlWithParamsWithStringBuilder(@RequestBody HtmlParamPayloadDto htmlParamPayloadDto){
        String response = "";
        try {
            response = generatorService.generateHtmlWithParamsStringBuilder(htmlParamPayloadDto);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
