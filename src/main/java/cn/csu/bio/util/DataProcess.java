package cn.csu.bio.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.csu.bio.entry.Gene;

public class DataProcess {

	/**
	 * 	将基因对象转化为JSON格式
	 * @param geneList
	 * @param topNum
	 * @return
	 */
	public static JSONArray topGene2Json(List<Gene> geneList, int topNum) {
		
		JSONArray jsonArray = new JSONArray();

		
		//	对某方法的疾病基因根据评分进行排序
		Collections.sort(geneList, new Comparator<Gene>() {

			@Override
			public int compare(Gene arg0, Gene arg1) {
				// TODO Auto-generated method stub
				if (arg0.getScore() != arg1.getScore()) {
					if (arg0.getScore() - arg1.getScore() < 0) {
						return 1;
					} else {
						return -1;
					}
				}
				return 0;
			}

		});

		//	在控制台中打印基因及其分数
		for (int i = 0; i < topNum; i++) {
			
			JSONObject gene = new JSONObject();
			gene.put("rank", i+1);
			gene.put("symbol", geneList.get(i).getSymbol());
			gene.put("id", geneList.get(i).getEntrezId());
			gene.put("strand", geneList.get(i).getStrand());
			gene.put("score", geneList.get(i).getScore());
			gene.put("chromosome", geneList.get(i).getChromId());
			gene.put("cyto", geneList.get(i).getCytoLocation());
			gene.put("locationBegin", geneList.get(i).getGeneStart());
			gene.put("locationEnd", geneList.get(i).getGeneEnd());
			
			gene.put("omimInfo", "<a href='https://omim.org/search?index=entry&sort=score+desc%2C+prefix_sort+desc&start=1&limit=10&search=" 
						+ geneList.get(i).getSymbol()+"' target='_blank'>Link</a>");
			gene.put("genecards", "<a href='https://www.genecards.org/cgi-bin/carddisp.pl?gene=" + geneList.get(i).getSymbol() 
						+ "' target='_blank'>Link</a>");
			gene.put("bioGPS", "<a href='http://biogps.org/#goto=genereport&id=" + geneList.get(i).getEntrezId() 
						+ "' target='_blank'>Link</a>");
			
			gene.put("visualization", "<a href='./vis.jsp?geneSymbol=" + geneList.get(i).getSymbol() +
						"' target='_blank'>Vis</a>");
			
			
			jsonArray.add(gene);
		}
	
		return jsonArray;

	}

	/**
	 * 	将基因对象转化为json格式
	 * @param geneList
	 * @return
	 */
	public static JSONArray topGene2Json(List<Gene> geneList) {
		
		JSONArray jsonArray = new JSONArray();

		
		//	对某方法的疾病基因根据评分进行排序
		Collections.sort(geneList, new Comparator<Gene>() {

			@Override
			public int compare(Gene arg0, Gene arg1) {
				// TODO Auto-generated method stub
				if (arg0.getScore() != arg1.getScore()) {
					if (arg0.getScore() - arg1.getScore() < 0) {
						return 1;
					} else {
						return -1;
					}
				}
				return 0;
			}

		});

		//	在控制台中打印基因及其分数
		for (int i = 0; i < geneList.size(); i++) {
			JSONObject gene = new JSONObject();
			gene.put("rank", i+1);
			gene.put("symbol", geneList.get(i).getSymbol());
			gene.put("id", geneList.get(i).getEntrezId());
			gene.put("score", geneList.get(i).getScore());
			gene.put("chromosome", geneList.get(i).getChromId());
			gene.put("cyto", geneList.get(i).getCytoLocation());
			gene.put("locationBegin", geneList.get(i).getGeneStart());
			gene.put("locationEnd", geneList.get(i).getGeneEnd());
			
			gene.put("omimInfo", "<a href='https://omim.org/search?index=entry&sort=score+desc%2C+prefix_sort+desc&start=1&limit=10&search=" 
					+ geneList.get(i).getSymbol()+"' target='_blank'>Link</a>");
			gene.put("genecards", "<a href='https://www.genecards.org/cgi-bin/carddisp.pl?gene=" + geneList.get(i).getSymbol() 
					+ "' target='_blank'>Link</a>");
			gene.put("bioGPS", "<a href='http://biogps.org/#goto=genereport&id=" + geneList.get(i).getEntrezId() 
					+ "' target='_blank'>Link</a>");
			
			gene.put("visualization", "<a href='./vis.jsp?geneSymbol=" + geneList.get(i).getSymbol() +
					"' target='_blank'>Vis</a>");
			
			jsonArray.add(gene);
		}
	
		return jsonArray;

	}
}
