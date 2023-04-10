package com.shopNest.product;


public class Product {
		int pid;
		String pname;
		int price;
		public Product(int pid, String pname, int price) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.price = price;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public int getprice() {
			return price;
		}
		public void setprice(int price) {
			this.price = price;
		}
		
}
