package dto;

public class Order1Detail {
    private String  	cancel;
    private int   		costcode;
	private int      	item_code;
    private String   	order_date;
    private String  	order_item_desc;
	private int     item_count;
	
    private String		custname;
    
    
    
    public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	private String		item_name;
     
    
    
    public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public int getCostcode() {
		return costcode;
	}
	public void setCostcode(int costcode) {
		this.costcode = costcode;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_item_desc() {
		return order_item_desc;
	}
	public void setOrder_item_desc(String order_item_desc) {
		this.order_item_desc = order_item_desc;
	}

}
