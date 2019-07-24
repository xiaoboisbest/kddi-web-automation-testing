import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dev.pfm.wallet.auone.jp/life_plan/')

WebUI.maximizeWindow()

Cookie ck = new Cookie('VTKT', 'rtm0wCOc6hTIFjf19P7KEEn-NB7Jp8k5QvzBE7r1OxqcIYMRdmnbLGJqQYL7Lnv_Z7-e796XbNYuZ-AS_eJwPNQgQ4Kz3YSmcqmHm1CSCJAtHREgQ8GKcl29Banngbs4XK1ZuH_eUsCeXHVH0I8mIQ')

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(ck)

WebUI.waitForPageLoad(10)

WebUI.refresh()

