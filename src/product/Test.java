package product;

public class Test {
	
	public static void printProduct(Product[] products){
		for(Product product : products){
			System.out.println("��Ʒ����"+ product.getName());
			System.out.println("���ۣ�"+ product.getPrice());
			System.out.println("������"+ product.getCount());
			System.out.println("״̬��"+ product.isStatus());
			System.out.println("���ڣ�"+product.getDate());
			System.out.println("--------------------------");
		}
	}
	
	public static void main(String[] args) {
		Product p1 = new Product(111, "PSP", 1000, 10, true,"2018-2-1");
		Product p2 = new Product(211, "New 3DSLL", 1800, 0, false,"2018-3-2");
		Product p3 = new Product(321, "Sony 4K����", 5599, 8, true,"2018-2-5");
		Product p4 = new Product(322, "Sony 4K����", 6599, 8, true,"2018-10-20");
		Product p5 = new Product(134, "HTC VIVE", 4888, 5, true,"2018-1-20");
		Product p6 = new Product(554, "Swtich", 2188, 6, true,"2018-5-4");
		Product p7 = new Product(126, "Xbox one", 2800, 0, false,"2018-6-8");
		Product p8 = new Product(127, "Xbox one", 1800, 5, true,"2018-7-7");
		Product p9 = new Product(329, "PS VR", 2599, 3, true,"2018-4-24");
		Product p10 = new Product(140, "PS4", 1999, 5, true,"2018-9-9");
		
		IProductDao ipd = new ProductDaoImpl();
		
		ipd.save(p1);
		ipd.save(p2);
		ipd.save(p3);
		ipd.save(p4);
		ipd.save(p5);
		ipd.save(p6);
		ipd.save(p7);
		ipd.save(p8);
		ipd.save(p9);
		ipd.save(p10);
		System.out.println("-------------save--------------");
		printProduct(ipd.queryAll());
		
		System.out.println("-------------delete------------");
		ipd.delete(111);
		printProduct(ipd.queryAll());
		
		System.out.println("-------------modById------------");
		Product product1 = ipd.modById(322);
		product1.setPrice(6299);
		product1.setCount(7);
		System.out.println("��Ʒ����"+ product1.getName());
		System.out.println("���ۣ�"+ product1.getPrice());
		System.out.println("������"+ product1.getCount());
		System.out.println("״̬��"+ product1.isStatus());
		
		System.out.println("-------------queryById------------");
		Product product2 = ipd.queryById(554);
		if(null != product2){
			System.out.println("��Ʒ����"+ product2.getName());
			System.out.println("���ۣ�"+ product2.getPrice());
			System.out.println("������"+ product2.getCount());
			System.out.println("״̬��"+ product2.isStatus());
		}
		
		System.out.println("-------------queryByName------------");
		Product[] product3 = ipd.queryByName("Xbox one");
		printProduct(product3);
		
		System.out.println("-------------queryByPrice------------");
		Product[] product4 = ipd.queryByPrice(5000, 2000);
		printProduct(product4);
		
		System.out.println("-------------queryByStatus------------");
		Product[] product5 = ipd.queryByStatus(false);
		printProduct(product5);
		
		System.out.println("-------------queryByCount------------");
		printProduct(ipd.queryByCount(ipd.queryAll()));
		
		System.out.println("--------------sortByDate--------------");
		printProduct(ipd.sortByDate(ipd.queryAll()));
	}
}
