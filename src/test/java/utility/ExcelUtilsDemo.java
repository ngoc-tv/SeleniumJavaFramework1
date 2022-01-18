package utility;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String projectpath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectpath+"/excel/data.xlsx", "Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}

}
