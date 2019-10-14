package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.BannerRender;
import com.tws.refactoring.extract_variable.PriceCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_check_browser_if_MAC_or_IE() {
        String platform =  "MAC";
        String browser = "IE";

        BannerRender bannerRender = new BannerRender();
        String actualResult = bannerRender.renderBanner(platform, browser);
        String expectedResult = "IE on Mac?";

        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_check_banner() {
        String platform =  "IE";
        String browser = "MAC";

        BannerRender bannerRender = new BannerRender();
        String actualResult = bannerRender.renderBanner(platform, browser);
        String expectedResult = "banner";

        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_calculate_price() {
        PriceCalculator priceCalculator = new PriceCalculator();
        int quantity = 5;
        int price = 20;
        double actualResult = priceCalculator.getPrice(quantity, price);
        double expectedResult = 110.0;

        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void printOwing() {

        OwingPrinter owingPrinter = new OwingPrinter();
        String orderName = "Dunkin Donut";
        List<Order> priceList = new ArrayList<>();
        Order price = new Order(35.0);
        priceList.add(price);

        owingPrinter.printOwing(orderName, priceList);

        String expectedResult = "*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                "*****************************\r\n" +
                "name: Dunkin Donut\r\n" +
                "amount: 35.0\r\n";

        assertThat(outContent.toString(), is(expectedResult));
    }
}