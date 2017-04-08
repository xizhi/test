package x.superman.controller.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import x.helper.spring.SpringContentHelper;
import x.superman.mapper.TbkCommodityMapper;
import x.superman.mapper.TbkCommoditySettleMapper;
import x.superman.mapper.TbkUploadMapper;
import x.superman.pojo.generator.TbkCommodity;
import x.superman.pojo.generator.TbkCommoditySettle;
import x.superman.pojo.generator.TbkCommoditySettleExample;
import x.superman.pojo.generator.TbkUpload;
import x.superman.pojo.generator.TbkUploadExample;
import x.superman.service.impl.TaobaokeServiceImpl;

/**
 * 
 * 
 * @author 收藏夹
 *
 */
@Controller
@RequestMapping(PackStore.route)
public class TaobaokeController {
	private static Logger logger = LoggerFactory
	        .getLogger(TaobaokeController.class);

	@Autowired
	TaobaokeServiceImpl servicer;

	@Autowired
	TbkCommodityMapper commodityMapper;

	@Autowired
	TbkUploadMapper uploadMapper;

	@Autowired
	TbkCommoditySettleMapper csMapper;


	/**
	 * 
	 * 显示上传页面
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "taobaoke-upload.html", method = RequestMethod.GET)
	public String showUploadIndex(
	        @RequestParam(value = "page", defaultValue = "1") int page,
	        Model model) {
		int pageSize = 10;
		Page<Object> pageHelper = PageHelper.startPage(page, pageSize);
		TbkUploadExample tbkUploadExample = new TbkUploadExample();
		tbkUploadExample.setOrderByClause("creation_time desc");
		List<TbkUpload> list = uploadMapper.selectByExample(tbkUploadExample);

		model.addAttribute("list", list);
		model.addAttribute("pages", pageHelper.getPages());
		model.addAttribute("page", pageHelper.getPageNum());
		logger.info("{}",list);
		return "/tbk/tbk-upload";
	}

	/**
	 * 
	 * 显示 商品页面
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "taobaoke-commodity.html", method = RequestMethod.GET)
	public String showCommodityIndex(
	        @RequestParam(value = "page", defaultValue = "1") int page,
	        Model model) {
		logger.debug("showIndex");

		int pageSize = 100;
		Page<Object> pageHelper = PageHelper.startPage(page, pageSize);
		TbkCommoditySettleExample example = new TbkCommoditySettleExample();

		List<TbkCommoditySettle> list = csMapper.selectByExample(example);
		// logger.info("{}",list);
		model.addAttribute("list", list);
		model.addAttribute("pages", pageHelper.getPages());
		model.addAttribute("page", pageHelper.getPageNum());
		return "/tbk/tbk-commodity";
	}

	@RequestMapping("tbk-commodity-{id}.html")
	public String showCommodity(@PathVariable String id,
	        HttpServletResponse response) throws IOException {
		TbkCommodity record = commodityMapper.selectByPrimaryKey(id);
		response.sendRedirect(record.getTbklj());
		return null;
	}

	@RequestMapping(value = "taobaoke-commodity.html", method = RequestMethod.POST)
	public String handelQueryCommoditeList(
	        @RequestParam(value = "page", defaultValue = "1") int page) {
		return "";
	}

	private String session_key_upload_count = "tbk.upload.count";
	private String session_key_upload_current = "tbk.upload.current";

	/**
	 * 
	 * 接收上传文件
	 * 
	 * @return
	 */
	@RequestMapping(value = "taobaoke-upload.html", method = RequestMethod.POST)
	public String handleUpload(
	        @RequestParam(value = "file", required = false) MultipartFile file,
	        Model model,
	        @RequestParam(value = "callback", required = false) String callback,
	        HttpSession session) {
		if (session.getAttribute("tbk.upload.count") != null) {
			model.addAttribute("callback", callback);
			model.addAttribute("result", "fail");
			model.addAttribute("message", "后台正执行着一个上传任务");
			return "/common/callback-iframe";
		}

		if (file == null || file.isEmpty()) {
			model.addAttribute("callback", callback);
			model.addAttribute("result", "fail");
			model.addAttribute("message", "文件为空");
			return "/common/callback-iframe";
		}

		String fileName = file.getOriginalFilename();
		// TbkUploadExample tbkUploadExample = new TbkUploadExample();
		// tbkUploadExample.createCriteria().andNameEqualTo(fileName);
		// List<TbkUpload> selectByExample =
		// uploadMapper.selectByExample(tbkUploadExample);
		// if (selectByExample.size() != 0) {
		// model.addAttribute("callback", callback);
		// model.addAttribute("result", "fail");
		// model.addAttribute("message", "excel已经上传过");
		// return "/common/callback-iframe";
		// }

		List<TbkCommodity> commoditList = null;
		try {
			commoditList = servicer.parseExcle(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("callback", callback);
			model.addAttribute("result", "fail");
			model.addAttribute("message", "解析异常");
			return "/common/callback-iframe";
		}
		TbkUpload upload = new TbkUpload();
		upload.setName(fileName);
		uploadMapper.insertSelective(upload);
		int uploadId = upload.getId();

		// 添加任务
		InsetCommodityTask task = new InsetCommodityTask(commodityMapper,
		        uploadMapper, commoditList, uploadId);

		session.setAttribute(session_key_upload_count, commoditList.size());
		session.setAttribute(session_key_upload_current, task.count);
		task.start();

		model.addAttribute("callback", callback);
		model.addAttribute("result", "success");
		model.addAttribute("message", "上传成功");
		return "/common/callback-iframe";
	}

	@RequestMapping("tbk-upload-info.html")
	@ResponseBody
	public String queryUploadInfo(HttpSession session) {
		String r = null;
		Integer count = (Integer) session
		        .getAttribute(session_key_upload_count);
		if (count == null) {
			return "{count:-1}";
		}
		AtomicInteger current = (AtomicInteger) session
		        .getAttribute(session_key_upload_current);
		if (current.get() == count.intValue()) {
			session.removeAttribute(session_key_upload_count);
			session.removeAttribute(session_key_upload_current);
		}

		r = String.format("{count:%d,current:%d}", count.intValue(),
		        current.get());
		return r;
	}

	@RequestMapping("tbk-cs-init.html")
	@ResponseBody
	public String handleInitCommoditySettle(
	        @RequestParam(value = "uploadId", required = true) int uploadId) {
		//int result = tbkMapper.insertCommoditySettle(uploadId);
		
		DataSource dataSource = SpringContentHelper.getBean("dataSource",DataSource.class);
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM E_TBK_COMMODITY_SETTLE WHERE YHQ_JE IS NULL";
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			
			int update = 0;
			while(rs.next()){
				update++;
				//System.out.println(rs.getString(1));
				String yhqMe = rs.getString("yhq_me");
				//System.out.println(yhqMe);
				rs.updateDouble("yhq_je", getMe(yhqMe));
				rs.updateRow();   //完成更新
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(connection,ps,rs);
		}
		
		//return String.valueOf(result);
		return "10";
	}
	
	double getMe(String me){
		int index = me.indexOf("减");
		if(index != -1){
			String money = me.substring(index+1,me.length()-1);
			return Double.parseDouble(money);
		}

		index = me.indexOf("元无条件券");
		if(index != -1){
			String money = me.substring(0,index);
			return Double.parseDouble(money);
		}
		
		return 0;
	}

	/**
	 * 
	 * 
	 * 添加 商品信息任务
	 * 
	 * @author xizhi
	 *
	 */
	static class InsetCommodityTask extends Thread {
		AtomicInteger count = new AtomicInteger(0);
		TbkCommodityMapper mapper = null;
		TbkUploadMapper uploadMapper = null;
		List<TbkCommodity> list = null;
		int uploadId = 0;

		public InsetCommodityTask(TbkCommodityMapper mapper,
		        TbkUploadMapper uploadMapper, List<TbkCommodity> list,
		        int uploadId) {
			this.mapper = mapper;
			this.uploadMapper = uploadMapper;
			this.list = list;
			this.uploadId = uploadId;
		}

		@Override
		public void run() {
			for (TbkCommodity tbkCommodity : list) {
				try {
					tbkCommodity.setUploadId(uploadId);
					mapper.insert(tbkCommodity);
				} catch (Exception e) {
					e.printStackTrace();
				}
				count.addAndGet(1);
			}

			TbkUpload upload = new TbkUpload();
			upload.setId(uploadId);
			upload.setCount(count.get());
			uploadMapper.updateByPrimaryKeySelective(upload);
		}

	}
}
