/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.webrtc.kite.wpt;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.webrtc.kite.KiteTest;
import org.webrtc.kite.WebDriverFactory;
import org.webrtc.kite.config.Browser;

import java.util.ArrayList;
import java.util.List;

public class WPTestTest extends TestCase {

  private static final String SELENIUM_SERVER_URL = "http://localhost:4444/wd/hub";
  private static final String TEST_NAME = "WPTestTest";

  private List<WebDriver> webDriverList = new ArrayList<WebDriver>();

  public void setUp() throws Exception {
    super.setUp();
    final Browser browser = new Browser("chrome");
    browser.setRemoteAddress(SELENIUM_SERVER_URL);

    webDriverList.add(WebDriverFactory.createWebDriver(browser, TEST_NAME));
  }

  public void tearDown() throws Exception {
    // Close all the browsers
    for (WebDriver webDriver : this.webDriverList)
      try {
        webDriver.quit();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  public void testTestScript() throws Exception {
    KiteTest test = new WPTest();
    test.setWebDriverList(this.webDriverList);
    //System.out.println(test.testScript());
  }
}
