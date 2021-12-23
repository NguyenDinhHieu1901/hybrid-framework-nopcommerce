package javaBasic;

public class Topic_01_Variable {
	
	/**
	 * Biến là 1 liên kết tới 1 vị trí trên bộ nhớ để chứa dữ liệu ==> mục đích của biến chính là lưu trữ dữ liệu và tái sử dụng
	 * Các loại biến:
	 * 		+ Biến cục bộ (local)
	 * 		+ Biến toàn cục (global)
	 * 		+ Biến tĩnh (static): được truy cập thông qua class thay vì đối tượng ==> không cần khởi tạo đối tượng
	 * 		+ Biến hằng số (final): quy ước đặt tên là viết hoa và giá trị của nó là không đổi
	 * @param args
	 */
	
	// Biến toàn cục (global)
	int ramSize = 10;
	String ramBrand = "Kingston";
	
	// Biến tĩnh (static)
	static int ssdSize = 128;
	static String ssdBrand = "Samsung";
	
	// Biến hằng số (final)
	final int DPIMOUSE = 10000;
	final String OSNAME = "Window";
	
	public static void main(String[] args) {
		
		// Biến cục bộ
		int hddSize = 1000;
		String hddBrand = "Kingston";
		final int VGA = 6;
		
		// Các biến static sẽ được truy cập thông qua class và trong các phương thức static
		System.out.println("Static variable: " + ssdSize);
		System.out.println("Static variable: " + ssdBrand);
		
		// còn các biến non-static chúng ta phải khởi tạo đối tượng mới truy cập được ==> truy cập thông qua đối tượng
		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println("Non static variable: " + topic.ramSize);
		System.out.println("Non static variable: " + topic.ramBrand);
		
		// biến local
		System.out.println("Local variable: " + hddSize);
		System.out.println("Local variable: " + hddBrand);
		
	
	}

}
