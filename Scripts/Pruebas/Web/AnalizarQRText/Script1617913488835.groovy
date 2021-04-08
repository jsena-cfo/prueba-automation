import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import javax.imageio.ImageIO as ImageIO
import java.awt.image.BufferedImage as BufferedImage
import com.google.zxing.client.j2se.BufferedImageLuminanceSource as BufferedImageLuminanceSource
import com.google.zxing.LuminanceSource as LuminanceSource
import com.google.zxing.MultiFormatReader as MultiFormatReader
import com.google.zxing.Result as Result
import com.google.zxing.BinaryBitmap as BinaryBitmap
import com.google.zxing.common.HybridBinarizer as HybridBinarizer
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join

WebUI.openBrowser('https://www.google.com')

def driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.google.com/'

String textoIngreso = 'Texto texto texto texto texto'

selenium = new WebDriverBackedSelenium(driver, baseUrl)

selenium.open('https://www.codigos-qr.com/generador-de-codigos-qr/')

WebUI.waitForPageLoad(2)

WebUI.maximizeWindow()

WebUI.waitForElementPresent(findTestObject('00-ObjectsQRCodigosTexto/a_Texto'), 5)

WebUI.click(findTestObject('00-ObjectsQRCodigosTexto/a_Texto'))

WebUI.waitForElementPresent(findTestObject('00-ObjectsQRCodigosTexto/textarea_Texto_textarea'), 5)

WebUI.sendKeys(findTestObject('00-ObjectsQRCodigosTexto/textarea_Texto_textarea'), textoIngreso)

WebUI.waitForElementPresent(findTestObject('00-ObjectsQRCodigosTexto/button_Generar Cdigo QR'), 5)

WebUI.focus(findTestObject('00-ObjectsQRCodigosTexto/button_Generar Cdigo QR'))

WebUI.click(findTestObject('00-ObjectsQRCodigosTexto/button_Generar Cdigo QR'))

WebUI.waitForElementPresent(findTestObject('00-ObjectsQRCodigoImagen/img'), 5)

String qrCodeURL = WebUI.getAttribute(findTestObject('00-ObjectsQRCodigoImagen/img'), 'src')

//Create an object of URL Class
URL url = new URL(qrCodeURL)

//Pass the URL class object to store the file as image
BufferedImage bufferedimage = ImageIO.read(url)

// Process the image
LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage)

BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource))

//To Capture details of QR code
Result result = new MultiFormatReader().decode(binaryBitmap)

def stringResult = result.getText()

System.out.println('Valor resultado: ' + stringResult)

WebUI.verifyMatch(textoIngreso, stringResult, true)

WebUI.closeBrowser()

