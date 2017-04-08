package x.helper.excel.poi;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class PoiHelper {
	/**
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getValue(Cell cell){
		if(cell == null){
			return null;
		}
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BLANK:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			return "";
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String getValue2Number(Cell cell){
		if(cell == null){
			return null;
		}
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BLANK:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			return "";
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String getValue2Date(Cell cell){
		if(cell == null){
			return null;
		}
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BLANK:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			return "";
		}
		return null;
	}
	
	
	
	
	
	private static DecimalFormat doubleFormat = new DecimalFormat("0.00");
	/**
	 * 
	 * 将数字转为字符
	 * 
	 * @param str
	 * @return
	 */
	private static String getNumber(String str){
		String r = null;
		try {
			double parseDouble = Double.parseDouble(str);
			r = doubleFormat.format(parseDouble);
		} catch(Exception e){
			
		}
		return r;
	}
	
	/**
	 * 
	 * 获取excel 中的内容那个,
	 * 	expectType 期待的值
	 * 
	  * Param @param cell
	  * Param @return
	  * Return String
	 */
	@SuppressWarnings("deprecation")
	public static String getExcelValue(Cell cell, String expectType) {
		
		if("number".equals(expectType)){
			//数值
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				return doubleFormat.format(cell.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:
				return getNumber(cell.getStringCellValue());
			case Cell.CELL_TYPE_BLANK:
				return "";
			case Cell.CELL_TYPE_FORMULA:
				return "";
			default:
				return "";
			}
		} else if("date".equals(expectType)){
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				short format = cell.getCellStyle().getDataFormat();
				//DateUtil.isCellDateFormatted(cell);
				if(DateUtil.isCellDateFormatted(cell) || format == 14 || format == 31 || format == 57 || format == 58){
					Date theDate = cell.getDateCellValue();
					SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
					return sFormat.format(theDate);
				} else {
//					 double value = cell.getNumericCellValue();
//					 Date date = DateUtil.getJavaDate(value);
//					 return df.format(date);
					 return "";
				}
			case Cell.CELL_TYPE_STRING:
				String value = cell.getStringCellValue();
				return value; 
			case Cell.CELL_TYPE_BLANK:
				return "";
			case Cell.CELL_TYPE_FORMULA:
				return "";
			default:
				return "";
			}
		} else {
			//字符
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_BLANK:
				return "";
			case Cell.CELL_TYPE_FORMULA:
				return "";
			default:
				return "";
			}
		}
	}
}
