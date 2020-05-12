package com.ujjain.asyncapi.sampleasync;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by abhishekujjain on 11/05/20.
 */

@RunWith(SpringRunner.class)
@TestExecutionListeners(listeners = {SpringBootDependencyInjectionTestExecutionListener.class})
@SpringBootTest(classes = SampleAsyncApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AsyncIntegrationTest {

    private static WireMockServer wireMockServer;


    @BeforeClass
    public static void before() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
        wireMockServer.start();
    }

    @AfterClass
    public static void tearDown() {
        wireMockServer.stop();
    }


    @Test
    public void testProductDetails() throws InterruptedException, IOException {

        URL resource = ClassLoader.getSystemClassLoader().getResource("prod-details.json");

        String jsonStr = FileUtils.readFileToString(new File(resource.getFile()));

        wireMockServer.stubFor(any(urlPathEqualTo("/product-details/33"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/json")
                        .withStatus(200)
                        .withBody(jsonStr)));


        String response = RestAssured.given().header("Content-Type", "text/json").request("POST", "/product-details/33").then().statusCode(200).extract().asString();
        Assert.assertTrue(response.contains("21-25"));
        assertThat(RestAssured.get("/product-details/33").statusCode(), is(200));
        assertThat(RestAssured.get("/product-details/33/44").statusCode(), is(404));


    }

    @Test
    public void testPriceAdd() throws InterruptedException, IOException {

        wireMockServer.stubFor(any(urlPathEqualTo("/price"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"product_id\":\"2211\",\"price\":{\"range\":\"10-15\",\"min\":10,\"max\":20}}")));


        String response = RestAssured.given().header("Content-Type", "application/json").request("POST", "/price").then().statusCode(200).extract().asString();
        Assert.assertTrue(response.contains("2211"));
        assertThat(RestAssured.get("/price").statusCode(), is(200));
        assertThat(RestAssured.get("/price/33").statusCode(), is(404));


    }


    @Test
    public void testAddProduct() throws InterruptedException, IOException {

        URL resource = ClassLoader.getSystemClassLoader().getResource("product-sample.json");

        String jsonStr = FileUtils.readFileToString(new File(resource.getFile()));

        wireMockServer.stubFor(any(urlPathEqualTo("/product"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody(jsonStr)));


        String response = RestAssured.given().header("Content-Type", "application/json").request("POST", "/product").then().statusCode(200).extract().asString();
        Assert.assertTrue(response.contains("Green and Fresh"));
        assertThat(RestAssured.get("/product").statusCode(), is(200));
        assertThat(RestAssured.get("/product/33").statusCode(), is(404));


    }
}
