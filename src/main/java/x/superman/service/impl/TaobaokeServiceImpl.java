package x.superman.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import x.helper.UuidHelper;
import x.helper.excel.poi.PoiHelper;
import x.superman.pojo.generator.TbkCommodity;

@Service
public class TaobaokeServiceImpl {

	public List<TbkCommodity> parseExcle(byte[] bytes) throws IOException {
		POIFSFileSystem fs = new POIFSFileSystem(new ByteArrayInputStream(bytes));
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheetAt(0);
		List<TbkCommodity> commodities = new ArrayList<TbkCommodity>();
		Iterator<Row> iterator = sheet.rowIterator(); 
		iterator.next();
		while (iterator.hasNext()) {
			Row row = iterator.next();
			TbkCommodity taobaoke = new TbkCommodity();
			taobaoke.setId(UuidHelper.getId());
			taobaoke.setSpid(getExcelValue(row.getCell(0)));
			taobaoke.setSpmc(getExcelValue(row.getCell(1)));
			taobaoke.setSpzt(getExcelValue(row.getCell(2)));
			taobaoke.setSpxqy(getExcelValue(row.getCell(3)));
			taobaoke.setSmyjlm(getExcelValue(row.getCell(4)));
			taobaoke.setTbklj(getExcelValue(row.getCell(5)));
			taobaoke.setSpjg(getExcelValue(row.getCell(6)));
			taobaoke.setSpysl(getExcelValue(row.getCell(7)));
			taobaoke.setSrbl(getExcelValue(row.getCell(8)));
			taobaoke.setYj(getExcelValue(row.getCell(9)));
			taobaoke.setMjww(getExcelValue(row.getCell(10)));
			taobaoke.setMjid(getExcelValue(row.getCell(11)));
			taobaoke.setDpmc(getExcelValue(row.getCell(12)));
			taobaoke.setPtlx(getExcelValue(row.getCell(13)));
			taobaoke.setYhqid(getExcelValue(row.getCell(14)));
			taobaoke.setYhqzl(getExcelValue(row.getCell(15)));
			taobaoke.setYhqsyl(getExcelValue(row.getCell(16)));
			taobaoke.setYhqme(getExcelValue(row.getCell(17)));
			taobaoke.setYhqkssj(getExcelValue(row.getCell(18)));
			taobaoke.setYhqjssj(getExcelValue(row.getCell(19)));
			taobaoke.setYhqlj(getExcelValue(row.getCell(20)));
			taobaoke.setSpyhqtglj(getExcelValue(row.getCell(21)));

			commodities.add(taobaoke);
			//break;
		}

		return commodities;
	}
	
	private static String getExcelValue(Cell cell){
		String r = null;
		r = PoiHelper.getValue(cell);
//		if(r != null){
//			r = r.replaceAll("[\\u10000-\\u10FFFF]", "");
//		}
		return r;
	}


	public boolean save(List<Map<String, String>> data) {
		return false;
	}

}
