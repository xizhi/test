package x.superman.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;

@Controller
public class CommonController {

	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	/**
	 * 上传文件,回调firame
	 */
	@RequestMapping(value = "/comm-upload.html", params = "type=ifr")
	public String upload(@RequestParam(value = "file", required = true) MultipartFile file, Model model,
			@RequestParam(value = "callback", required = false) String callback) {
		return null;
	}

	/**
	 * 上传文件,返回json
	 */
	@RequestMapping("/comm-upload.html")
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = true) MultipartFile file) {
		return null;
	}

	/**
	 * 下载
	 */
	@RequestMapping("/comm-download.html")
	public void download(@RequestParam(value = "fileId", required = false) String fileId, HttpServletRequest request,
			HttpServletResponse response) {
		
		String[] downloadInfo = null;
		if (Strings.isNullOrEmpty(fileId)) {
			downloadInfo = getDownloadInfoBySession(request);
		} else {
			downloadInfo = getDownloadInfoByDb(fileId);
		}

		if (downloadInfo == null && downloadInfo.length != 2) {
			return;
		}
		
		String fileName = downloadInfo[0];
		String filePath = downloadInfo[1];
		
		
		
	}

	private String[] getDownloadInfoByDb(String fileId) {
		String[] r = null;
		return r;
	}

	private String[] getDownloadInfoBySession(HttpServletRequest request) {
		String[] r = null;
		return r;

	}
}
