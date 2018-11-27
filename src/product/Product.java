package product;

public class Product {
	private int id;   //��ƷId
	private String name; //��Ʒ��
	private double price;  //��Ʒ����
	private int count; //��Ʒ����
	private boolean status;//״̬
	private String date;  //����
	
	public Product() {
		super();
	}
	public Product(int id, String name, double price, int count, boolean status,String date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.status = status;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
