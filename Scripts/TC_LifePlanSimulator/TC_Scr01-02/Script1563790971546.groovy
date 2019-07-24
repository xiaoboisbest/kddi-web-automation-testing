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
import googlesheet.GoogleSheetKeywords as GoogleSheetKeywords
import org.junit.After as After
import org.openqa.selenium.Keys as Keys


KeywordLogger log = new KeywordLogger()

spreadSheetID = '1F9nK4hDgeV8k0KI-QJ3RpTGP2tObC9fIluEDmbdec8o'

range = 'life_simulator!A4'

text = '1511331'

// age
B3 = '30代(age)'

// trang thai hien tai
B5 = '独身(Single)'

// da co may con
B7 = 'いない(0 kid)'

/////////////////////////////////////////////
// du dinh tuong lai
C10 = '結婚したい(yes)'

// khi nao ket hon
C12 = "わからない(i don't know)"

////////////////////////////////////////////
// muon co con hay ko?
B10 = ''

// muon co may con
B14 = ''

////////////////////////////////////////////
// thu nhap cua BAN THAN
B16 = '400万円'

// luong part time
B17 = 'パートタイム収入/partime_flag_on'

// luong huu
B18 = '退職金なし/retire_income_flag_off'

////////////////////////////////////////////
// thu nhap cua NGUOI PHOI NGAU
C16 = '300万円まで'

// luong part time
C17 = 'パートタイム収入/partime_flag_on'

// luong huu
C18 = '退職金なし/retire_income_flag_off'

////////////////////////////////////////////
// loai nha o
B20 = '持ち家'

// chi phi cho nha cua
B21 = '1万円'

////////////////////////////////////////////
// chi phi sinh hoat
B23 = '1万円'

// tien de danh
B25 = '0円'

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B3', B3)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B5', B5)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B7', B7)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!C10', C10)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!C12', C12)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B10', B10)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B14', B14)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B16', B16)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B17', B17)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B18', B18)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!C16', C16)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!C17', C17)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!C18', C18)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B20', B20)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B21', B21)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B23', B23)

GoogleSheetKeywords.setSpreadSheetRecords(spreadSheetID, 'life_simulator!B25', B25)

String result = GoogleSheetKeywords.getSpreadSheetRecords(spreadSheetID, 'life_simulator!H4')

log.logInfo(result)

return result