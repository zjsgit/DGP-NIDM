package cn.csu.bio.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class UtilController {

	@RequestMapping(value="/bakcHome")
	public String backHome(HttpSession session) {
		session.invalidate();
		
		return "redirect:/NID.jsp";
	}

	@RequestMapping(value="/downloadFile", method = RequestMethod.GET)
	public @ResponseBody void downloadRe(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		JSONArray result = (JSONArray) session.getAttribute("genes");
		
		BufferedWriter bw = null;
		try {
			File file = new File("result.txt");
			response.addHeader("Content-Disposition", "attachment;filename="+ new String(file.getName().getBytes()));
			bw = new BufferedWriter(response.getWriter());
			
			
			String title="rank\tsymbol\tid\tstrand\tscore\tchromosome\tcyto\tlocationBegin\tlocationEnd\n";
			bw.write(title);
			bw.flush();
			
			
			for(int i=0;i<result.size();i++) {
				JSONObject jsonObject = (JSONObject) result.get(i);
				String lineInfo = jsonObject.getString("rank") + "\t" + jsonObject.getString("symbol") + "\t"
						 + jsonObject.getString("id") + "\t" + jsonObject.getString("strand") + "\t"
						 + jsonObject.getString("score") + "\t" + jsonObject.getString("chromosome") + "\t"
						 + jsonObject.getString("cyto") + "\t" + jsonObject.getString("locationBegin") + "\t"
						 + jsonObject.getString("locationEnd");
				
				bw.write(lineInfo);
				bw.newLine();
				bw.flush();
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			bw.close();
		}
	}
	
}
