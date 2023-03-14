package com.solvd.saucedemoproxy;

import com.solvd.saucedemoproxy.db.domain.Item;
import com.solvd.saucedemoproxy.db.domain.User;
import com.solvd.saucedemoproxy.db.service.UserService;
import com.solvd.saucedemoproxy.db.service.impl.UserServiceImpl;
import com.solvd.saucedemoproxy.pages.CompletePage;
import com.solvd.saucedemoproxy.pages.HomePage;
import com.solvd.saucedemoproxy.pages.LoginPage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.proxy.browserup.ProxyPool;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.browserup.bup.BrowserUpProxy;

public class SaucedemoProxyTest implements IAbstractTest {

    BrowserUpProxy proxy;

    @BeforeMethod(alwaysRun = true)
    public void startProxy() {
        R.CONFIG.put("browserup_proxy", "true");
        R.CONFIG.put("proxy_type", "DYNAMIC", true);
        R.CONFIG.put("proxy_port", "0", true);
        getDriver();
        proxy = ProxyPool.getProxy();
    }

    @Test(description = "Check that success message should become, when customer try to order selected items from the shopping cart.")
    @MethodOwner(owner = "qpsdemo")
    public void checkOrderingCustomerItemsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Cookie cookie = new Cookie("session-username", "standard_user");
        getDriver().manage().addCookie(cookie);

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        UserService userService = new UserServiceImpl();
        User user = userService.read(1L, 1L);
        user.getOrders().stream()
                .flatMap(order -> order.getItems().stream())
                .map(Item::getName)
                .forEach(homePage::clickAddToCartBtn);

        CompletePage completePage = homePage.clickShoppingCart()
                .clickCheckoutBtn()
                .typeFirstname(user.getFirstName())
                .typeLastname(user.getLastName())
                .typePostalcode(user.getPostalCode())
                .clickContinueBtn()
                .clickContinueBtn();

        Assert.assertTrue(completePage.isPageOpened(), "Complete page wasn't opened");
        Assert.assertEquals(completePage.getCompleteMsg(), "Thank you for your order!", "Actual message does not equal expected message");
    }
}