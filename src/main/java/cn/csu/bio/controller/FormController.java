package cn.csu.bio.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.csu.bio.entry.FormInfo;
import cn.csu.bio.entry.Gene;
import cn.csu.bio.entry.Phenotype;
import cn.csu.bio.util.BaseInfo;
import cn.csu.bio.util.DataProcess;

@Controller
public class FormController {
	
	@RequestMapping(value="/submmitForm")
	public @ResponseBody String formInfo(HttpServletRequest request, HttpSession session) {
		
		String id = request.getParameter("id");
		session.setAttribute("omimId", id);
		String method = request.getParameter("method");
		
		//	对topNumber进行判断
		int topNumber = 0;
		try{
			topNumber = Integer.parseInt(request.getParameter("topNumber"));
		}catch(Exception e) {
			topNumber = -1;
		}
		
		String geno = request.getParameter("geno");
		
		int genoBeginValue = 0;
		try {
			genoBeginValue = Integer.parseInt(request.getParameter("genoBeginValue"));
		}catch(Exception e) {
			genoBeginValue = -1;
		}
		 
		int genoEndValue = 0;
		try {
			genoEndValue = Integer.parseInt(request.getParameter("genoEndValue"));
		}catch(Exception e) {
			genoEndValue = -1;
		}
		
		String cyto = request.getParameter("cyto");
		
		String cytoBegin = request.getParameter("cytoBegin");
		double cytoBeginValue = 0;
		try {
			cytoBeginValue = Double.parseDouble(request.getParameter("cytoBeginValue"));
			if(cytoBegin.equals("p")) {
				cytoBeginValue = - cytoBeginValue;
			}else if(cytoBegin.equals("q")) {
				
			}
		}catch(Exception e) {
			cytoBeginValue = -1;
		}
		
		String cytoEnd = request.getParameter("cytoEnd");
		double cytoEndValue = 0;
		try {
			cytoEndValue = Double.parseDouble(request.getParameter("cytoEndValue"));
			if(cytoEnd .equals("p")) {
				cytoEndValue = - cytoEndValue;
			}
			else if(cytoBegin.equals("q")) {
				
			}
		}catch(Exception e) {
			cytoEndValue = -1;
		}
		
		
		
//		System.out.println(id + "\t" + method);
//		System.out.println(topNumber);
//		System.out.println(geno + "\t" + genoBeginValue + "\t" + genoEndValue);
//		System.out.println(cyto + "\t" + cytoBegin + "\t" + cytoBeginValue + "\t" + cytoEnd + "\t" + cytoEndValue);
		
		
		FormInfo fi = new FormInfo(id, method, topNumber, geno, genoBeginValue, genoEndValue,
			cyto, cytoBegin, cytoEnd, cytoBeginValue, cytoEndValue);
		
		session.setAttribute("formInfo", fi);
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", "OK");
		
		System.out.println(jsonObject.toString());
		
		return jsonObject.toString();
		
	}
	
	@RequestMapping(value="runalgo")
	public String run(HttpServletRequest request, HttpSession session) {
		
		System.out.println("this is running");
		
		//	获取基本信息
		String baseFilePath = request.getSession().getServletContext().getRealPath("/files/");
		BaseInfo.setBaseFilePath(baseFilePath);
		
		Map<String, String> phenotype = BaseInfo.getPhenotypeInfo();
		FormInfo formInfo = (FormInfo) session.getAttribute("formInfo");
		System.out.println(formInfo);
		
		//	判断提交的ID是否在文件中
		if(formInfo != null && phenotype.containsKey(formInfo.getId())) {
			List<Gene> geneList = BaseInfo.getGeneInfo();
			
			List<Gene> newGeneList = new ArrayList<>();
			
			session.setAttribute("phenotypeId", formInfo.getId());
			session.setAttribute("phenotypeIdLink", "https://omim.org/entry/" + formInfo.getId());
			session.setAttribute("phenotypeName", phenotype.get(formInfo.getId()));
			session.setAttribute("phenotypeNameIdLink", "https://omim.org/search?index=entry&start=1&limit=10&sort=score+desc%2C+prefix_sort+desc&search=" 
														+ phenotype.get(formInfo.getId()));
			
			baseFilePath = "F:/xiangju/DGP/";
			
			//	根据top参数获取对应基因
			if(formInfo.getTopNumber() != -1) {
				try {
					
					
					String targetPath = baseFilePath + formInfo.getMethod() + "/" + formInfo.getId() + ".txt";
					
					System.out.println(targetPath);
					
					Scanner scanner = new Scanner(Paths.get(targetPath));
					int index = 0;
					while(scanner.hasNextLine()) {
						double score = Double.parseDouble(scanner.nextLine());
						Gene gene = geneList.get(index);
						gene.setScore(score);
						newGeneList.add(gene);
						index ++;
					}
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				JSONArray result = DataProcess.topGene2Json(newGeneList, formInfo.getTopNumber());
				String totalGenes = "";
				
				int knowlegeGene = 0;
				for(int i=0;i<result.size();i++) {
					JSONObject gene = (JSONObject) result.get(i);
					totalGenes += gene.getString("symbol") + ",";
					double score = Double.parseDouble(gene.getString("score"));
					if(score >= 1) {
						knowlegeGene ++;
					}
				}
				
				System.out.println(result);
				session.setAttribute("totalGene", formInfo.getTopNumber());
				session.setAttribute("knownGene", knowlegeGene);
				session.setAttribute("unknown", formInfo.getTopNumber() - knowlegeGene);
				
				session.setAttribute("genes", result);
				session.setAttribute("totalGenes", totalGenes);
				
			}else if(!formInfo.getGeno().equals("select")){//	根据基因位置参数获取对应基因
				System.out.println("根据gene位置查询"+formInfo.getGeno() +
						",开始位置是" + formInfo.getGenoBeginValue() + 
						",结束位置是" + formInfo.getGenoEndValue());
				
				try {
					String targetPath = baseFilePath + formInfo.getMethod() + "/" + formInfo.getId() + ".txt";
					
					//String targetPath = baseFilePath + formInfo.getMethod() + "\\" + formInfo.getId() + ".txt";
					
					System.out.println(targetPath);
					
					Scanner scanner = new Scanner(Paths.get(targetPath));
					int index = 0;
					int knowlegeGene = 0;
					String totalGenes = "";
					while(scanner.hasNextLine()) {
						double score = Double.parseDouble(scanner.nextLine());
						Gene gene = geneList.get(index);
						if(gene.getChromId().equals(formInfo.getGeno())){  //	比较染色体的位置
							
							//	基因的位置分为三种情况
							if( gene.getGeneStart() >= formInfo.getGenoBeginValue() //	1右边界在范围中
									&&	gene.getGeneEnd() <= formInfo.getGenoEndValue() //	2左边界在范围中
							//	3左右边界均在范围内
							) {
								if(gene.getScore() == 1) {
									knowlegeGene ++;
								}
								totalGenes += gene.getSymbol() + ",";
								gene.setScore(score);
								newGeneList.add(gene);
							}
						}
						index ++;
					}
					session.setAttribute("totalGenes", totalGenes);
					session.setAttribute("totalGene", newGeneList.size());
					session.setAttribute("knownGene", knowlegeGene);
					session.setAttribute("unknown", newGeneList.size() - knowlegeGene);
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				JSONArray result = DataProcess.topGene2Json(newGeneList);
				
				System.out.println(result);
				session.setAttribute("genes", result);
				
				
			}else if(!formInfo.getCyto().equals("select")) {//	根据Cyto参数获取基因
				
				System.out.println("根据Cyto位置查询"+formInfo.getCyto() + 
						",开始位置是" + formInfo.getCytoBegin() + ":" + formInfo.getCytoBeginValue() + 
						",结束位置是" + formInfo.getCytoEnd() + ":" + formInfo.getCytoEndValue());
				
				try {
					
					String targetPath = baseFilePath + formInfo.getMethod() + "/" + formInfo.getId() + ".txt";
					
					//String targetPath = baseFilePath + formInfo.getMethod() + "\\" + formInfo.getId() + ".txt";
					
					System.out.println(targetPath);
					int knowlegeGene = 0;
					Scanner scanner = new Scanner(Paths.get(targetPath));
					int index = 0;
					String totalGenes = "";
					while(scanner.hasNextLine()) {
						double score = Double.parseDouble(scanner.nextLine());
						Gene gene = geneList.get(index);
						if(gene.getChromId().equals(formInfo.getCyto())) { //	比较染色体的位置	
							
							//	CytoLocationDigits在给定的范围内
							if (gene.getCytoLocationDigits() >= formInfo.getCytoBeginValue() 
									&& gene.getCytoLocationDigits() <= formInfo.getCytoEndValue()) {
								
								if(gene.getScore() == 1) {
									knowlegeGene ++;
								}
								
								totalGenes += gene.getSymbol() + ",";
								gene.setScore(score);
								newGeneList.add(gene);
							}
						}
						index ++;
					}
					session.setAttribute("totalGenes", totalGenes);
					session.setAttribute("totalGene", newGeneList.size());
					session.setAttribute("knownGene", knowlegeGene);
					session.setAttribute("unknown", newGeneList.size() - knowlegeGene);
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				JSONArray result = DataProcess.topGene2Json(newGeneList);
				
				System.out.println(result);
				session.setAttribute("genes", result);
				
			}
			
			
//			System.out.println(formInfo.toString());
			
			return "result";
		}else {
			//	提交的ID，在文件中不包含
			return "error";
		}
		
		
	}
	
}
