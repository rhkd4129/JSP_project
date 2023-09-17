package dto;

public class Order1 {  //	N쪽
	  private int		custcode;    //PK
	  private String 	order_date;
	  private String 	order_desc;
	  private String 	order_status;
	  private int		sabun;			//PK
	  
	  private String custname;
	  private String sawon_name;
	  
	  
	  
	  
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getSawon_name() {
		return sawon_name;
	}
	public void setSawon_name(String sawon_name) {
		this.sawon_name = sawon_name;
	}
	public int getCustcode() {
		return custcode;
	}
	public void setCustcode(int custcode) {
		this.custcode = custcode;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_desc() {
		return order_desc;
	}
	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
}
