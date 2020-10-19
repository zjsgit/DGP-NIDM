package cn.csu.bio.entry;

public class Gene {
	
	private String symbol;//	表示基因名字
	private String entrezId;//	表示基因ID
	private String chromId;//	表示基因在染色体的位置
	
	private long geneStart;//	表示基因在染色体的开始位置
	private long geneEnd;//	表示基因在染色体的结束位置
	
	private int strand;//	表示是否为已知基因
	private String cytoLocation;//	表示
	private double cytoLocationDigits;//	基因在染色体位置的数字化表示
	
	private double score;
	
	//	构造函数
	public Gene() {}

	public Gene(String symbol, String entrezId, String chromId, long geneStart, long geneEnd, int strand,
			String cytoLocation, double cytoLocationDigits) {
		super();
		this.symbol = symbol;
		this.entrezId = entrezId;
		this.chromId = chromId;
		this.geneStart = geneStart;
		this.geneEnd = geneEnd;
		this.strand = strand;
		this.cytoLocation = cytoLocation;
		this.cytoLocationDigits = cytoLocationDigits;
	}

	
	//	set\get方法
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getEntrezId() {
		return entrezId;
	}

	public void setEntrezId(String entrezId) {
		this.entrezId = entrezId;
	}

	public String getChromId() {
		return chromId;
	}

	public void setChromId(String chromId) {
		this.chromId = chromId;
	}

	public long getGeneStart() {
		return geneStart;
	}

	public void setGeneStart(long geneStart) {
		this.geneStart = geneStart;
	}

	public long getGeneEnd() {
		return geneEnd;
	}

	public void setGeneEnd(long geneEnd) {
		this.geneEnd = geneEnd;
	}

	public int getStrand() {
		return strand;
	}

	public void setStrand(int strand) {
		this.strand = strand;
	}

	public String getCytoLocation() {
		return cytoLocation;
	}

	public void setCytoLocation(String cytoLocation) {
		this.cytoLocation = cytoLocation;
	}

	public double getCytoLocationDigits() {
		return cytoLocationDigits;
	}

	public void setCytoLocationDigits(double cytoLocationDigits) {
		this.cytoLocationDigits = cytoLocationDigits;
	}
	
	
	//	获取对应方法的分数
	public double getScore() {
		return score;
	}
	
	//	设置对应方法的分数
	public void setScore(double score) {
		this.score = score;
	}

	//	override toString
	@Override
	public String toString() {
		return "Gene [symbol=" + symbol + ", entrezId=" + entrezId + ", chromId=" + chromId + ", geneStart=" + geneStart
				+ ", geneEnd=" + geneEnd + ", strand=" + strand + ", cytoLocation=" + cytoLocation
				+ ", cytoLocationDigits=" + cytoLocationDigits + "]";
	};
	
	
	

}
