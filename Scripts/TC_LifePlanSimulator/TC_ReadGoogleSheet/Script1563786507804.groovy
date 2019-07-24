import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import readgooglesheet.ReadGoogleSheet as ReadGoogleSheet
import readgooglesheet.ReadGoogleSheet

import org.junit.After as After
import org.openqa.selenium.Keys as Keys

not_run: WebUI.openBrowser('https://docs.google.com/spreadsheets/d/11ndVuO0_FencfmSuEtY_OHOjEPnbhgC6GGsQVF8MJJM/edit#gid=483842148')

not_run: WebUI.waitForPageLoad(10)

not_run: WebUI.setText(findTestObject('LifePlanSimulator/Page_LifePlanSimulator/edt_Email'), email)

not_run: WebUI.sendKeys(findTestObject('LifePlanSimulator/Page_LifePlanSimulator/edt_Email'), Keys.chord(Keys.ENTER))

not_run: WebUI.setText(findTestObject('LifePlanSimulator/Page_LifePlanSimulator/edt_Password'), password)

not_run: WebUI.sendKeys(findTestObject('LifePlanSimulator/Page_LifePlanSimulator/edt_Password'), Keys.chord(Keys.ENTER))

not_run: WebUI.waitForPageLoad(20)

KeywordLogger log = new KeywordLogger()

spreadSheetID = '1uehfyP9dnU0uIDepQaAo4jwQAQfXCOh3pkCTKiJjwBk'

range = 'demo!A2'
text = '1511331'

String text = readgooglesheet.ReadGoogleSheet.getSpreadSheetRecords(spreadSheetID, range)

log.logInfo(text)

