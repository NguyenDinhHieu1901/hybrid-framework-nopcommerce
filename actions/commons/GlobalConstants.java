package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_NOPCOMMMERCE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_NOPCOMMMERCE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String LIVEGURU_URL = "http://live.techpanda.org/";
	public static final String PORTAL_DEV_URL = "https://dev.nopcommerce.com/";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "dowloadFiles";
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragAndDropHML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String DB_DEV_URL = "192.168.1.15:9860";
	public static final String DB_DEV_USER = "automation";
	public static final String DB_DEV_PASS = "P@ssw0rd1@";
	public static final String DB_TEST_URL = "32.18.252.185:9860";
	public static final String DB_TEST_USER = "automation";
	public static final String DB_TSEST_PASS = "P@ssw0rd1@";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 15;
	public static final long RETRY_TEST_FAIL = 3;
}
