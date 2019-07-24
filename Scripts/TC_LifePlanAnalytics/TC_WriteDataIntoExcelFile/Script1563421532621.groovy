import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.poi.ss.usermodel.Sheet as Sheet
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.EKeyboard as EKeyboard
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import internal.GlobalVariable as GlobalVariable

KeywordLogger log = new KeywordLogger()

String excelFile = 'C:\\Users\\HAU NGUYEN -TEQ\\Katalon Studio\\KDDI\\CheckLogic_lifeplan.xlsx'

String sheetName = 'changeLogic_1207'

lifePlanFile = ExcelKeywords.getWorkbook(excelFile)

sheet01 = ExcelKeywords.getExcelSheet(lifePlanFile, sheetName)

not_run: String cellIndex = ExcelKeywords.getCellIndexByAddress(sheet01, 'Y13')

String amountAt65OnWebApp

for (int i = 1; i <= 32; i++) {
	
	if (i < 10) {
		
		amountAt65OnWebApp = WebUI.callTestCase(findTestCase('TC_LifePlanAnalytics/TC_Scr01-0' + i), [:], FailureHandling.OPTIONAL)
		
	} else {
	
		amountAt65OnWebApp = WebUI.callTestCase(findTestCase('TC_LifePlanAnalytics/TC_Scr01-' + i), [:], FailureHandling.OPTIONAL)
	
	}
	
	log.logInfo('TC_Scr01-' + i + ' = ' + amountAt65OnWebApp)
	
    ExcelKeywords.setValueToCellByIndex(sheet01, 11 + i, 24, amountAt65OnWebApp)
}

ExcelKeywords.saveWorkbook(excelFile, lifePlanFile)

