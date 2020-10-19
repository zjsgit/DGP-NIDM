package cn.csu.bio.util;

import java.util.List;
import java.util.Map;

import cn.csu.bio.entry.Gene;
import cn.csu.bio.entry.Phenotype;

public class BaseInfo {
	
	private static List<Gene> geneList = null;
	private static Map phenotypeList = null;
	
	private static String baseFilePath;
	
	private BaseInfo() {};
	
	public static void setBaseFilePath(String filePath) {
		baseFilePath = filePath;
	}
	
	//	获取文件中的信息
	public static List<Gene> getGeneInfo() {
		if(geneList == null) {
			geneList = FileUtil.getGeneList(baseFilePath + "geneInfo.tab");
		}
		
		return geneList;
	}
	
	public static Map getPhenotypeInfo() {
		if(phenotypeList == null) {
			phenotypeList = FileUtil.getPhenotypeList(baseFilePath + "disInfo.tab");
		}
		
		return phenotypeList;
	}

}
