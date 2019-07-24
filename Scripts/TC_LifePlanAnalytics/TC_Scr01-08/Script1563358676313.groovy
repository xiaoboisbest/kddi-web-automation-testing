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

KeywordLogger log = new KeywordLogger()

WebUI.callTestCase(findTestCase('TC_AddVTKT'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Tab_LifePlan/Page_LifePlanResult/btn_LifePlan'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q01_Age/Age_60'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q02_CurrentSituation/Married'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q03_Children/Children_1'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q4_FutureMarried/children_No'))

not_run: WebUI.click(findTestObject('Tab_LifePlan/Page_Q05_WhenGetMarry/Years_3'))

not_run: WebUI.click(findTestObject('Tab_LifePlan/Page_Q06_NumberOfChildrenWanToGet/Children_2'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q07_YourIncome/income_500'))

WebUI.scrollToElement(findTestObject('Tab_LifePlan/Page_Q07_YourIncome/btn_Next'), 10)

WebUI.click(findTestObject('Tab_LifePlan/Page_Q07_YourIncome/chk_PartTimeIncome'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q07_YourIncome/chk_NoRetirementPay'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q07_YourIncome/btn_Next'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q08_IncomeOfTheSpouse/income_800'))

not_run: WebUI.scrollToElement(findTestObject('Tab_LifePlan/Page_Q08_IncomeOfTheSpouse/btn_Next'), 10)

WebUI.click(findTestObject('Tab_LifePlan/Page_Q08_IncomeOfTheSpouse/chk_PartTimeIncome'))

not_run: WebUI.click(findTestObject('Tab_LifePlan/Page_Q08_IncomeOfTheSpouse/chk_NoRetirementPay'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q08_IncomeOfTheSpouse/btn_Next'))

WebUI.scrollToElement(findTestObject('Tab_LifePlan/Page_Q09_RentHouse/OwnedHouse'), 10)

WebUI.click(findTestObject('Tab_LifePlan/Page_Q09_RentHouse/RentalHouse'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q09_RentHouse/rent_3'))

WebUI.scrollToElement(findTestObject('Tab_LifePlan/Page_Q09_RentHouse/btn_Next'), 0)

WebUI.click(findTestObject('Tab_LifePlan/Page_Q09_RentHouse/btn_Next'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q10_CostOfLiving/cost_25'))

WebUI.click(findTestObject('Tab_LifePlan/Page_Q11_CurrentSavingsAmount/amount_50'))

WebUI.waitForElementPresent(findTestObject('Tab_LifePlan/Page_LifePlanResult/tv_AmountAt65'), 20)

amountAt65OnWebApp = WebUI.getText(findTestObject('Tab_LifePlan/Page_LifePlanResult/tv_AmountAt65'))

log.logInfo(amountAt65OnWebApp)

WebUI.closeBrowser()

return amountAt65OnWebApp

