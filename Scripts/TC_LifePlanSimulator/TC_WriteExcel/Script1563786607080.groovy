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

String resultOnSimulator = WebUI.callTestCase(findTestCase('TC_LifePlanSimulator/TC_Scr01-01'), [('email') : 'haunguyen@teqnological.asia', ('password') : 'Duyh4uh3r0'], 
    FailureHandling.STOP_ON_FAILURE)

ExcelKeywords.setValueToCellByAddress(sheet01, 'X13', resultOnSimulator.replace('[', '').replace(']', ''))

ExcelKeywords.saveWorkbook(excelFile, lifePlanFile)



