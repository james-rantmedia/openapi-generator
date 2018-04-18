package org.openapitools.codegen.bash;

import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenParameter;
import org.openapitools.codegen.DefaultCodegen;
import org.openapitools.codegen.languages.BashClientCodegen;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.parser.core.models.ParseOptions;

import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("static-method")
public class BashTest {

    @Test(description = "test basic petstore operation with Bash extensions")
    public void petstoreOperationTest() {

        final OpenAPI openAPI
            = new OpenAPIParser()
                .readLocation("src/test/resources/2_0/petstore-bash.json", null, new ParseOptions()).getOpenAPI();
        final DefaultCodegen codegen = new BashClientCodegen();
        final Operation findPetsByStatusOperation
            = openAPI.getPaths().get("/pet/findByStatus").getGet();

        final CodegenOperation op
            = codegen.fromOperation(
                "/pet/findByStatus",
                "GET",
                findPetsByStatusOperation,
                openAPI.getComponents().getSchemas(),
                openAPI);

        Assert.assertTrue(
            op.vendorExtensions.containsKey("x-code-samples"));

        Assert.assertEquals(
            op.vendorExtensions.get("x-bash-codegen-description"),
            "Multiple status 'values' can be provided with comma separated strings");

        Assert.assertEquals(op.allParams.size(), 1);
        CodegenParameter p = op.allParams.get(0);
        Assert.assertEquals(p.description, "Status values that need to be considered for filter");
    }

    @Test(description = "test basic petstore operation with example body")
    public void petstoreParameterExampleTest() {

        final OpenAPI openAPI
            = new OpenAPIParser()
                .readLocation("src/test/resources/2_0/petstore-bash.json", null, new ParseOptions()).getOpenAPI();
        final DefaultCodegen codegen = new BashClientCodegen();
        final Operation addPetOperation
            = openAPI.getPaths().get("/pet").getPost();

        final CodegenOperation op
            = codegen.fromOperation(
                "/pet",
                "POST",
                addPetOperation,
                openAPI.getComponents().getSchemas(),
                openAPI);

        Assert.assertEquals(op.bodyParams.size(), 1);

        CodegenParameter p = op.bodyParams.get(0);

        Assert.assertTrue(p.vendorExtensions
                            .containsKey("x-codegen-body-example"));
        Assert.assertEquals(p.description, "Pet object that needs to be added to the store");

    }


    @Test(description = "test Bash client codegen escapeText method")
    public void escapeTextTest() {
        final DefaultCodegen codegen = new BashClientCodegen();


        Assert.assertEquals(codegen.escapeText("\\/"), "/");

        Assert.assertEquals(codegen.escapeText("\\"), "\\\\");


        ((BashClientCodegen)codegen).setProcessMarkdown(false);

        Assert.assertEquals(codegen.escapeText("__Bold text__"), 
                            "__Bold text__");

        Assert.assertEquals(codegen.escapeText("**Bold text**"), 
                            "**Bold text**");

        Assert.assertEquals(codegen.escapeText("*Italic text*"), 
                            "*Italic text*");

        Assert.assertEquals(codegen.escapeText("_Italic text_"), 
                            "_Italic text_");


        ((BashClientCodegen)codegen).setProcessMarkdown(true);

        Assert.assertEquals(codegen.escapeText("__Bold text__"), 
                            "$(tput bold) Bold text $(tput sgr0)");

        Assert.assertEquals(codegen.escapeText("**Bold text**"), 
                            "$(tput bold) Bold text $(tput sgr0)");

        Assert.assertEquals(codegen.escapeText("*Italic text*"), 
                            "$(tput dim) Italic text $(tput sgr0)");

        Assert.assertEquals(codegen.escapeText("_Italic text_"), 
                            "$(tput dim) Italic text $(tput sgr0)");

        Assert.assertEquals(codegen.escapeText("# SECTION NAME"), 
            "\n$(tput bold)$(tput setaf 7)SECTION NAME$(tput sgr0)");

        Assert.assertEquals(codegen.escapeText("## SECTION NAME"), 
            "\n$(tput bold)$(tput setaf 7)SECTION NAME$(tput sgr0)");

        Assert.assertEquals(codegen.escapeText("### SECTION NAME"), 
            "\n$(tput bold)$(tput setaf 7)SECTION NAME$(tput sgr0)");

        Assert.assertEquals(codegen.escapeText(
                                "```\nnice -n 100 mvn test\n```"),
                                "\n---\nnice -n 100 mvn test\n---"); 
    }

    @Test(description = "test Bash client codegen escapeUnsafeCharacters method")
    public void escapeUnsafeCharactersTest() {
        final DefaultCodegen codegen = new BashClientCodegen();

        Assert.assertEquals(codegen.escapeUnsafeCharacters("`no backticks`"), 
                                                          "'no backticks'");


    }
    
    @Test(description = "test Bash client codegen escapeReservedWord method")
    public void escapeReservedWordTest() {
        final DefaultCodegen codegen = new BashClientCodegen();

        Assert.assertEquals(codegen.escapeReservedWord("case"), "_case");
    }


}