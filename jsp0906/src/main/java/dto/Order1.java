package dto;

public class Order1 {
	  private int		costcode;
	  private String 	order_date;
	  private String 	order_desc;
	  private String 	order_status;
	  private int		sabun;
	  
	  
	  
	public int getCostcode() {
		return costcode;
	}
	public void setCostcode(int costcode) {
		this.costcode = costcode;
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
