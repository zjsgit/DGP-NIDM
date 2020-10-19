package cn.csu.bio.entry;

public class FormInfo {

	private String id;//	表示表型ID
	private String method;//	表示选择的方法
	private int topNumber;//	表示查询的top值
	
	private String geno;//	表示染色体的位置
	private long genoBeginValue;//	表示基因在开始的位置
	private long genoEndValue;//	表示基因结束的位置
	
	private String cyto;//	表示染色体的位置
	private String cytoBegin;
	private String cytoEnd;
	private double cytoBeginValue;//	表示cyto的起始位置值
	private double cytoEndValue;//	表示cyto的终止位置值
	
	
	public FormInfo() {}


	public FormInfo(String id, String method, int topNumber, String geno, long genoBeginValue, long genoEndValue,
			String cyto, String cytoBegin, String cytoEnd, double cytoBeginValue, double cytoEndValue) {
		super();
		this.id = id;
		this.method = method;
		this.topNumber = topNumber;
		
		this.geno = geno;
		this.genoBeginValue = genoBeginValue;
		this.genoEndValue = genoEndValue;
		
		this.cyto = cyto;
		this.cytoBegin = cytoBegin;
		this.cytoEnd = cytoEnd;
		this.cytoBeginValue = cytoBeginValue;
		this.cytoEndValue = cytoEndValue;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public int getTopNumber() {
		return topNumber;
	}


	public void setTopNumber(int topNumber) {
		this.topNumber = topNumber;
	}


	public String getGeno() {
		return geno;
	}


	public void setGeno(String geno) {
		this.geno = geno;
	}


	public long getGenoBeginValue() {
		return genoBeginValue;
	}


	public void setGenoBeginValue(long genoBeginValue) {
		this.genoBeginValue = genoBeginValue;
	}


	public long getGenoEndValue() {
		return genoEndValue;
	}


	public void setGenoEndValue(long genoEndValue) {
		this.genoEndValue = genoEndValue;
	}


	public String getCyto() {
		return cyto;
	}


	public void setCyto(String cyto) {
		this.cyto = cyto;
	}


	public String getCytoBegin() {
		return cytoBegin;
	}


	public void setCytoBegin(String cytoBegin) {
		this.cytoBegin = cytoBegin;
	}


	public String getCytoEnd() {
		return cytoEnd;
	}


	public void setCytoEnd(String cytoEnd) {
		this.cytoEnd = cytoEnd;
	}


	public double getCytoBeginValue() {
		return cytoBeginValue;
	}


	public void setCytoBeginValue(double cytoBeginValue) {
		this.cytoBeginValue = cytoBeginValue;
	}


	public double getCytoEndValue() {
		return cytoEndValue;
	}


	public void setCytoEndValue(double cytoEndValue) {
		this.cytoEndValue = cytoEndValue;
	}


	@Override
	public String toString() {
		return "FormInfo [id=" + id + ", method=" + method + ", topNumber=" + topNumber + ", geno=" + geno
				+ ", genoBeginValue=" + genoBeginValue + ", genoEndValue=" + genoEndValue + ", cyto=" + cyto
				+ ", cytoBegin=" + cytoBegin + ", cytoEnd=" + cytoEnd + ", cytoBeginValue=" + cytoBeginValue
				+ ", cytoEndValue=" + cytoEndValue + "]";
	};
	
	
	
	
	
}
