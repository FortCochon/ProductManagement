package product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDaoImpl implements IProductDao{
	private Product[] products;
	private int index = 0;
	
	public ProductDaoImpl() {
		products = new Product[10];
	}
	public ProductDaoImpl(int size) {
		products = new Product[size];
	}

	@Override
	public boolean save(Product product) {
		if( index < products.length) {
			products[index++] = product;
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		for( int i = 0; i < index; i++ ) {
			if( products[i].getId() == id) {
				for( int j = i+1; j < index; j++) {
					products[j-1] = products[j];
				}
				index--;
			}
		}
		return false;
	}

	@Override
	public Product modById(int id) {
		for(int i = 0;i < index; i++){
			if(products[i].getId() == id) {
				return products[i];
			}
		}
		return null;
	}

	@Override
	//查询所有商品
	public Product[] queryAll() {
		Product[] p = new Product[index];
		System.arraycopy(products, 0, p, 0, index);
		return p;
	}
	//按照id查询商品信息
	@Override
	public Product queryById(int id) {
		for(int i = 0; i < index ; i++) {
			if(products[i].getId() == id) { 
				return products[i];
			}
		}
		return null;
	}
	//按照name查询商品信息
	@Override
	public Product[] queryByName(String name) {
		int count = 0;  
		for(int i = 0; i < index ; i++) {
			if(products[i].getName().equals(name)) {
				count++;
			}
		}
		if(0 == count) {
			return null;
		}
		Product[] p = new Product[count];
		for(int i = 0; i < index; i++) {
			if(products[i].getName().equals(name)) {
				p[--count] = products[i];
			}
		}
		return p;
	}

	@Override
	public Product[] queryByPrice(int max,int min) {
		int count = 0;
		for(int i = 0; i < index;i++){
			if(products[i].getPrice() > min && products[i].getPrice() < max) {
				count++;
			}
		}
		if(0 == count){
			return null;
		}
		Product[] p = new Product[count];
		for(int i = 0;i<index;i++) {
			if(products[i].getPrice() > min && products[i].getPrice() < max) {
				p[--count] = products[i];
			}
		}
		return p;
	}
	//根据status查询商品
	@Override
	public Product[] queryByStatus(boolean status) {
		int count = 0;
		for(int i = 0; i < index; i++) {
			if(products[i].isStatus() == status) {
				count++;
			}
		}
		if(0 == count){
			return null;
		}
		Product[] p = new Product[count];
		for(int i = 0;i<index;i++) {
			if(products[i].isStatus() == status) {
				p[--count] = products[i];
			}
		}
		return p;
	}
	//根据count数量降序排序
	@Override
	public Product[] queryByCount(Product[] product) {
		for(int i = 0; i < index-1; i++) {
			for(int j = i+1; j  < index; j++) {
				if(product[j].getCount() > product[i].getCount()) {
					Product temp = product[j];
					product[j] = product[i];
					product[i] = temp;
				}
			}
		}
		return product ;
	}
	//入库时间排序 从远到近
	public Product[] sortByDate(Product[] product) {
		for(int i = 0; i < index - 1; i++) {
			for(int j = i+1; j < index; j++) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   //封装类
				Date d1,d2;
				try{
					d1 = sdf.parse(product[j].getDate());
					d2 = sdf.parse(product[i].getDate());
					if(d1.before(d2)) {
						Product temp = product[j];
						product[j] = product[i];
						product[i] = temp;
					}
				}catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return product;
	}
}