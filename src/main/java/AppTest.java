import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    private final String device_name;
    private final String platform_name;
    final String app_package;
    private final String app_activity;
    AndroidDriver<AndroidElement> driver;

    public AppTest(String device_name, String platform_name, String app_package, String app_activity) {
        this.device_name = device_name;
        this.platform_name = platform_name;
        this.app_package = app_package;
        this.app_activity = app_activity;
        openApp(device_name, platform_name, app_package, app_activity);
    }


    private void openApp(String device_name, String platform_name, String app_package, String app_activity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
        capabilities.setCapability("platformName", platform_name);
        capabilities.setCapability("appPackage", app_package);
        capabilities.setCapability("appActivity", app_activity);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } catch (MalformedURLException e) {
            System.err.println("Can't Open App with package: " + app_package);
            e.printStackTrace();
        }
    }

    void click(String id) {
        MobileElement el = driver.findElementById(app_package + ":id/" + id);
        el.click();
    }
}

