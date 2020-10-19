package cn.csu.bio.util;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cn.csu.bio.entry.Gene;
import cn.csu.bio.entry.Phenotype;

public class FileUtil {
	
	
	/**
	 * 	从文件中获取gene的信息
	 * @param filePath	gene信息的文件路径
	 * @return	包含所有基因信息的list
	 */
	public static List<Gene> getGeneList(String filePath){
		List<Gene> geneList = new ArrayList<>();
		
		try {
			
			Scanner scanner = new Scanner(Paths.get(filePath));
			while(scanner.hasNextLine()) {
				String[] arr = scanner.nextLine().split("\t");
				String symbol = arr[0];//	基因symbol
				String entrezId = arr[1];//	基因id
				
				
				String chromId = arr[2];//	基因位于染色体的位置
				
				long geneStart = 0;
				try {
					geneStart = Long.parseLong(arr[3]);
				}catch(Exception e) {
					
				}
				
				long geneEnd = 0;
				try {
					geneEnd = Long.parseLong(arr[4]);
				}catch(Exception e) {
					
				}
				
				int strand = 0;
				try {
					strand = Integer.parseInt(arr[5]);
				}catch(Exception e) {
					
				}
				
				String cytoLocation = arr[6];
				double cytoLocationDigits = Double.parseDouble(arr[7]);
				Gene gene = new Gene(symbol, entrezId, chromId, geneStart,
						geneEnd, strand, cytoLocation, cytoLocationDigits);
				geneList.add(gene);
			}
		}catch(IOException e) {
			System.out.println("读取gene文件出现错误!\n"+e.toString());
		}
		
		System.out.println("there are " + geneList.size() + " gene");
		
		return geneList;
	}
	
	/**
	 * 	从文件中获取疾病表型的信息
	 * @param filePath	phenotype信息的文件路径
	 * @return	包含所有表型信息的list
	 */
	public static Map getPhenotypeList(String filePath){
		Map<String, String> phenotype = new HashMap<>();
		
		try {
			Scanner scanner = new Scanner(Paths.get(filePath));
			while(scanner.hasNextLine()) {
				String [] arr = scanner.nextLine().split("\t");
				phenotype.put(arr[0], arr[1]);
			}
			scanner.close();
		}catch (IOException e) {
			System.out.println("读取表型文件出现错误!\n"+e.toString());
		}
		
		System.out.println("there are " + phenotype.size() + " phenotype");
		
		return phenotype;
	}

}
