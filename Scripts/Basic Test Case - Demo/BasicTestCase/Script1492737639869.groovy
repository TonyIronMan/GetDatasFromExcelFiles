import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Script here...'

WebUI.setText(findTestObject('Basic Test Case - Demo/EmailObject'), username)

WebUI.setText(findTestObject('Basic Test Case - Demo/PasswordObject'), password)

WebUI.click(findTestObject('Basic Test Case - Demo/LoginButtonObject'))

String errormessage = WebUI.getText(findTestObject('Basic Test Case - Demo/MessageObject'))

WebUI.verifyEqual(errormessage, 'bala...bala...bala...bala')


'Annotation for methods that will run before a test case is run '
@com.kms.katalon.core.annotation.SetUp
def Setup() {
    def info = WebUI.callTestCase(findTestCase('Basic Test Case - Demo/PrepareData'), [:], FailureHandling.STOP_ON_FAILURE)

    url = info.url

    username = info.username

    password = info.password

    WebUI.openBrowser(url)
}
'Annotation for methods that will run after a test case is run'
@com.kms.katalon.core.annotation.TearDown
def Teardown() {
	WebUI.closeBrowser()
}

