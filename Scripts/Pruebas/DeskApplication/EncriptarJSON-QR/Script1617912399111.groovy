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

Windows.startApplicationWithTitle('C:\\Program Files\\BUIEncryptor\\Debug\\BUIEncryptor.exe', 'BUIEncryptor')

Windows.setText(findWindowsObject('00-ObjectsDeskApplication/InpEncryptText'), '[{\'dominio\':\'NS057LN\',\'nroServicio\':\'FAC-17-45-08227-W1F4W\',\'nroAcarreo\':\'08227\',\'tipoVehiculo\':\'03\',\'fechaHoraIngreso\':\'30/09/2019 13:02\',\'fechaHoraSalida\':\'09/10/2019 15:52\',\'fechaHoraVencimiento\':\'10/03/2020 23:04\',\'tipoDoc\':\'DNI\',\'numeroDoc\':\'30300100\',\'nombre\':\'ALAN\',\'apellido\':\'BRITO DELGADO\',\'direccion\':\'MACHO SECO 621\',\'items\':[{\'descuento\':0,\'monto\':2051.80,\'concepto\':\'32.01.09\'},{\'descuento\':59,\'monto\':1000.60,\'concepto\':\'32.01.02\'},{\'descuento\':75,\'monto\':2032.27,\'concepto\':\'32.01.15\'}]}]')

Windows.setText(findWindowsObject('00-ObjectsDeskApplication/InpSecretText'), 'secret')

Windows.delay(2)

Windows.click(findWindowsObject('00-ObjectsDeskApplication/BtnEjecutar'))

Windows.click(findWindowsObject('00-ObjectsDeskApplication/BtnVerQR'))

Windows.delay(2)

Windows.click(findWindowsObject('00-ObjectsDeskApplication/BtnDesencriptar'))

Windows.delay(2)

Windows.click(findWindowsObject('00-ObjectsDeskApplication/BtnSalir'))

