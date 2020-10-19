package cn.csu.bio.entry;

public class Phenotype {
	
	/**
	 * 	表示疾病表型
	 */
	
	private String disId;//	表示疾病表型ID
	private String disName;//	表示疾病表型名字
	
	//	构造函数
	public Phenotype() {}

	public Phenotype(String disId, String disName) {
		super();
		this.disId = disId;
		this.disName = disName;
	}

	//	set\get构造函数
	public String getDisId() {
		return disId;
	}

	public void setDisId(String disId) {
		this.disId = disId;
	}

	public String getDisName() {
		return disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	//	toString函数
	@Override
	public String toString() {
		return "Phenotype [disId=" + disId + ", disName=" + disName + "]";
	};
	
	
	
	

}
