package googlesheet


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.*;





import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable


public class GoogleSheetKeywords {
	/** Application name. */
	private static final String APPLICATION_NAME = "Test";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/client_secret.json");


	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	private static final String Resource_Path = 'C:/Users/HAU NGUYEN -TEQ/Desktop/client_secret/client_secret.json';

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	static GoogleClientSecrets clientSecrets = LoadClientSecrets();

	/** Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials
	 * at ~/.credentials/sheets.googleapis.com-java-quickstart
	 */
	//private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);
	static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Creates an authorized Credential object.
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static Credential authorize() throws IOException, GeneralSecurityException {
		// Load client secrets.

		File currentFolder = new File (System.getProperty("user.dir"));
		System.out.println currentFolder.toString()
		//InputStream inputStream       = ReadGoogleSheets.class.getResourceAsStream('D://katalon//client_secrets.json');

		//InputStream inn = ReadGoogleSheets.class.getResourceAsStream("D:\\katalon\\client_secrets.json")

		//	Reader      inputStreamReader = new InputStreamReader(inn);

		clientSecrets = LoadClientSecrets();

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).build();

		//GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).build();

		def Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		//	System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	private static GoogleClientSecrets LoadClientSecrets(){

		try{
			InputStream inputStream = new FileInputStream(new File(Resource_Path));

			System.out.println("Total file size to read (in bytes) : "+ inputStream.available());

			clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(inputStream));


			return clientSecrets;
		}
		catch (Exception e) {
			System.out.println("Could not load file Client secrets" );
			e.printStackTrace();
		}


		return clientSecrets;
	}


	static GoogleClientSecrets getClientCredential() throws IOException {
		if (clientSecrets == null) {
		}
		return clientSecrets;
	}


	/**
	 * Build and return an authorized Sheets API client service.
	 * @return an authorized Sheets API client service
	 * @throws IOException
	 */


	public static Sheets getSheetsService() throws IOException {
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME)
				.build();
	}

	@Keyword
	static List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
		Sheets service = getSheetsService();
		ValueRange response = service.spreadsheets().values()
				.get(spreadsheetId, range)
				.execute();
		List<List<Object>> values = response.getValues();
		if (values != null && values.size() != 0) {
			return values;
		} else {
			System.out.println("No data found.");
			return null;
		}
	}

	@Keyword
	static void setSpreadSheetRecords(String spreadsheetId, String range, String text) throws IOException, GeneralSecurityException {
		Sheets service = getSheetsService();

		List<List<Object>> values = Arrays.asList(
				Arrays.asList(text)
				// Additional rows ...
				);

		ValueRange response = new ValueRange().setValues(values)
		//ValueRange response = new ValueRange().setValues(Arrays.asList(Arrays.asList(text)));

		UpdateValuesResponse result = service.spreadsheets().values()
				.update(spreadsheetId, range, response)
				.setValueInputOption('RAW')
				.execute()

	}
}
