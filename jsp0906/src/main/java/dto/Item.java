package dto;

import java.util.Date;

public class Item {
	private int 		item_code;
	private String 		item_name;
	private String 		item_kind;
	private String 		item_desc;
	private int 		item_price;
	private Date 		item_birth;
	
	
	
	public int getItem() {
		return item_code;
	}
	public void setItem(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_kind() {
		return item_kind;
	}
	public void setItem_kind(String item_kind) {
		this.item_kind = item_kind;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public Date getItem_birth() {
		return item_birth;
	}
	public void setItem_birth(Date item_birth) {
		this.item_birth = item_birth;
	}
}
