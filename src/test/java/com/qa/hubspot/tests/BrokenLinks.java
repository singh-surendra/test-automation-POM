package com.qa.hubspot.tests;

import com.qa.hubspot.baseTest.BaseTestBrokenLinks;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.qa.hubspot.Base.BasePage.getDriver;

@Slf4j
public class BrokenLinks extends BaseTestBrokenLinks {



    @AfterTest(alwaysRun = true)
    static void tearDown() {
        log.info("Closing Browser");
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @Test
    public void testBrokenLinks() {

        String homePage = "https://www.toolsqa.com/automation-practice-switch-windows/";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        driver.get(homePage);

        //Links All the links usually are in image <img /> and
        // anchor tags <a/> on a web page. Also, all links are mentioned as href attribute of the element tag.

        List<WebElement> links1 = driver.findElements(By.tagName("a"));
        List<WebElement> links2 = driver.findElements(By.tagName("img"));
        links1.addAll(links2);
        System.out.println("Total no. of links are: " + links1.size());
        Iterator<WebElement> itr = links1.iterator();

            while (itr.hasNext()) {

                url = itr.next().getAttribute("href");
                if (url == null || url.isEmpty()) {
                    System.out.println(url+"URL is either not configured for anchor tag/image tag or it is empty");
                    continue;
                }
//
//                if (!url.startsWith(homePage)) {
//                    System.out.println("URL belongs to another domain, skipping it.");
//                    continue;
//                }

                try {
                    huc = (HttpURLConnection) (new URL(url).openConnection());
                    huc.setRequestMethod("HEAD");
                    huc.connect();
                    respCode = huc.getResponseCode();
                    if (respCode >= 400) {
                        System.out.println(url + " is a broken link");
                    } else {
                        System.out.println(url + " is a valid link");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

        }


    }


    public static void main(String[] args) {
            // keep this function call here
            Scanner s = new Scanner(System.in);
//            int test= SimpleAdding(s.nextInt());
//            System.out.print(SimpleAdding(s.nextInt()));
//        System.out.print(SimpleFactorial(s.nextInt()));

        System.out.print(TimeConverttoHourMinute(s.nextInt()));

        }


    public static int SimpleAdding(int num) {
        // code goes here

        int count=num;
        int sum=0;
        while(count>0){
            sum=sum+count;
            count--;
        }

        return sum;
    }


    public static int SimpleFactorial(int num) {
        // code goes here

        int count=num;
        int temp=1;
        while(count>0){
           temp = temp*count;
            count--;
        }

        return temp;
    }

    public static String TimeConverttoHourMinute(int numInMinutes) {
        // code goes here
        /*

        Have the function TimeConvert(num) take the num parameter being passed
        and return the number of hours and minutes the parameter converts to
        (ie. if num = 63 then the output should be 1:3). Separate the number of hours and minutes with a colon.
         */

        int hour = numInMinutes/60;
        int minute = numInMinutes%60;

        String  hour1 = Integer.toString(hour);
        String minute1 = Integer.toString(minute);

        String test=  hour1+":"+minute1;
        return test;

    }
}



