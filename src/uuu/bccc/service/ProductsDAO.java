package uuu.bccc.service;

import java.util.ArrayList;
import java.util.List;

import uuu.bccc.entity.Color;
import uuu.bccc.entity.Outlet;
import uuu.bccc.entity.Product;
import uuu.bccc.entity.Size;
import uuu.bccc.exception.BCCCException;

import java.sql.*;

class ProductsDAO { //DAO前面是table的名子
	private static final String SELECT_ALL_PRODUCTS="SELECT id, name, unit_price, discount, stock, photo_url"
			+ ", description,shelf_date FROM products";
	 List<Product> selectAllProducts() throws BCCCException {
		List<Product> list = new ArrayList<>();
		
		
		try(Connection connection = RDBConnection.getConnection();//1.2取得練縣
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_PRODUCTS);//準備指令
				ResultSet rs = pstmt.executeQuery();//4.執行指令
				) {
			//5.處理rs
			while(rs.next()) {
				Product p;
				int discount =rs.getInt("discount");
				if(discount>0) {
					p = new Outlet();//多型
					((Outlet)p).setDiscount(discount);//轉型
				}else {
					p =new Product();
				}
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setStock(rs.getInt("stock"));
				p.setPhotoUrl(rs.getString("photo_url"));
				p.setDescription(rs.getString("description"));
				
				list.add(p);
			}
			
			
		} catch (SQLException e) {
			throw new BCCCException("查詢全部產品失敗",e);
		}
		return list;
	}
	 
	//TODO:
	 private static final String SELECT_PRODUCTS_BY_KEYWORD="SELECT id, name, unit_price, discount, stock, photo_url"
	 		+ ", description,shelf_date FROM products WHERE name LIKE ?";
	 List<Product> selectProductsByKeyword(String keyword) throws BCCCException {
		List<Product> list = new ArrayList<>();
			try(Connection connection =  RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCTS_BY_KEYWORD);) {
				//傳入?值，前端傳來的值
				pstmt.setString(1, '%'+keyword+'%');
				
				try(ResultSet rs = pstmt.executeQuery();){//執行指令
				//處理rs
				while(rs.next()) {
					Product p;
					int discount =rs.getInt("discount");
					if(discount>0) {
						p = new Outlet();//多型
						((Outlet)p).setDiscount(discount);//轉型
					}else {
						p =new Product();
					}	
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setDescription(rs.getString("description"));
					
					list.add(p);
			
				}
					
				}
			} catch (SQLException e) {
				throw new BCCCException("關鍵字查詢產品失敗",e);
			}
		
		
		return list;
	}
	 
	 private static final String SELECT_PRODUCT_BY_ID = "SELECT id, name, unit_price, discount, stock, photo_url"
	 		+ ", description,shelf_date FROM products WHERE id = ?";
	 
	 private static final String SELECT_PRODUCT_BY_ID_JOIN = "SELECT id, name, color_name,unit_price, discount, photo_url1 AS color_photo ,product_colors.stock AS color_stock, products.stock"
	 		+ ", photo_url, products.photo_url2, products.photo_url3, description,description_photo1, description_photo2 , shelf_date, category, brand FROM products "
	 		+ " LEFT JOIN product_colors ON products.id = product_colors.product_id WHERE id = ?";
	 
	 private static final String SELECT_PRODUCT_BY_ID_JOIN2 ="SELECT id, name, product_colors.color_name, product_color_sizes.color_name AS size_color_name, size, ordinal, product_color_sizes.stock AS size_stock"
	 		+ ", product_color_sizes.unit_price AS size_unit_price ,products.unit_price, discount, photo_url1 AS color_photo "
	 		+ ",product_colors.stock AS color_stock, products.stock"
	 		+ ", photo_url, products.photo_url2, products.photo_url3, description,description_photo1, description_photo2 , shelf_date, category, brand "
	 		+ " FROM products "
	 		+ "	LEFT JOIN product_colors ON products.id = product_colors.product_id"
	 		+ "   LEFT JOIN product_color_sizes ON product_color_sizes.product_id = products.id AND "
	 		+ "   (product_color_sizes.color_name = product_colors.color_name "
	 		+ "   OR product_color_sizes.color_name='') "
	 		+ "    WHERE id = ?";
	 
	 
	 
		Product selectProductById(String id) throws BCCCException {
		Product p = null;
		
		try (Connection connection = RDBConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_PRODUCT_BY_ID_JOIN2);//prepare statement
			){
			//傳入?值
			pstmt.setString(1, id);
			
			try (ResultSet rs = pstmt.executeQuery();){
			//執行指令
				while (rs.next()) {
					if(p==null) {//因為下面有多個顏色，因此不需要繼續run
					int discount = rs.getInt("discount");
					if(discount>0) {
						p=new Outlet();
						((Outlet)p).setDiscount(discount);
					}else {
						p=new Product();
					}
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setSmallPic1(rs.getString("products.photo_url2"));
					p.setSmallPic2(rs.getString("products.photo_url3"));
					p.setDescription(rs.getString("description"));
					p.setDescriptionPhoto1(rs.getString("description_photo1"));
					p.setDescriptionPhoto2(rs.getString("description_photo2"));
					}
					
					//讀取顏色
					String colorName = rs.getString("color_name");
					if(colorName!=null) {
						Color color = new Color();
						color.setName(colorName);
						color.setStock(rs.getInt("color_stock"));
						color.setPhotoUrl(rs.getString("color_photo"));
						p.add(color);
						
					}
					
					String size = rs.getString("size");
					if(size!=null) {
						Size s = new Size();
						s.setName(rs.getString("size_color_name"));
						s.setOrdinal(rs.getInt("ordinal"));
						s.setUnitPrice(rs.getDouble("size_unit_price"));
						s.setStock(rs.getInt("size_stock"));
						
					}
					
				}
				
				
			}
			
		} catch (SQLException e) {
			throw new BCCCException("用id查詢產品失敗",e);
		}
		
		return p;
	}
		private static final String SELECT_NEWEST_PRODUCTS="SELECT id, name, unit_price, discount, stock, photo_url, description, shelf_date, category"
				+ ", brand FROM products ORDER BY shelf_date DESC LIMIT 5;";
		List<Product> selectNewestProducts() throws BCCCException {
			  
			List<Product> list = new ArrayList<>();
			
			try(Connection connection = RDBConnection.getConnection();//1.2取得練縣
					PreparedStatement pstmt = connection.prepareStatement(SELECT_NEWEST_PRODUCTS);//準備指令
					ResultSet rs = pstmt.executeQuery();//4.執行指令
					) {
				//5.處理rs
				while(rs.next()) {
					Product p;
					int discount =rs.getInt("discount");
					if(discount>0) {
						p = new Outlet();//多型
						((Outlet)p).setDiscount(discount);//轉型
					}else {
						p =new Product();
					}
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setStock(rs.getInt("stock"));
					p.setPhotoUrl(rs.getString("photo_url"));
					p.setDescription(rs.getString("description"));
					
					list.add(p);
				}
				
				
			} catch (SQLException e) {
				throw new BCCCException("查詢新上架產品失敗",e);
			}
			return list;
		}
		
		private static final String SELECT_PRICE_RANGE="SELECT id, name, unit_price, discount, stock, photo_url, description, shelf_date, category"
				+ ", brand FROM products WHERE unit_price*((100-discount)/100) BETWEEN ? AND ?;"; //修改成折扣價格搜尋
		 List<Product> selectPriceRange(String lowPrice,String heightPrice) throws BCCCException {
			 List<Product> list = new ArrayList<>();
			 try(Connection connection =  RDBConnection.getConnection();
						PreparedStatement pstmt = connection.prepareStatement(SELECT_PRICE_RANGE);) {
						//傳入?值，前端傳來的值
						pstmt.setString(1, lowPrice);
						pstmt.setString(2, heightPrice);
						
						try(ResultSet rs = pstmt.executeQuery();){//執行指令
						//處理rs
						while(rs.next()) {
							Product p;
							int discount =rs.getInt("discount");
							if(discount>0) {
								p = new Outlet();//多型
								((Outlet)p).setDiscount(discount);//轉型
							}else {
								p =new Product();
							}	
							p.setId(rs.getInt("id"));
							p.setName(rs.getString("name"));
							p.setUnitPrice(rs.getDouble("unit_price"));
							p.setStock(rs.getInt("stock"));
							p.setPhotoUrl(rs.getString("photo_url"));
							p.setDescription(rs.getString("description"));
							
							list.add(p);
					
						}
							
						}
					} catch (SQLException e) {
						throw new BCCCException("價格搜尋產品失敗",e);
					}
				
				
				return list;
		}
		private static final String SELECT_STOCK_BY_PRODUCTID="SELECT id, stock FROM products WHERE id = ?";
		int selectStock(String productId) throws BCCCException {
			
			int stock = 0;
			
			try(Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_STOCK_BY_PRODUCTID);
					
					) {
				
				pstmt.setString(1, productId);
			
				try(ResultSet rs = pstmt.executeQuery();){
					while(rs.next()) {
						stock = rs.getInt("stock");
					}
					
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new BCCCException("查詢庫存失敗");
			}
			
			return stock;
		}
		
		
		private static final String SELECT_STOCK_BY_PRRODUCT_COLOR="SELECT product_id, color_name, stock FROM product_colors WHERE product_id = ? AND color_name =?";
		int selectStock(String productId, String colorName) throws BCCCException {//沒顏色有尺寸
			int stock = 0;
			try(Connection connection = RDBConnection.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(SELECT_STOCK_BY_PRRODUCT_COLOR);
						
						) {
				pstmt.setString(1, productId);
				
				pstmt.setString(2, colorName);
					
				try(ResultSet rs = pstmt.executeQuery();){
					while(rs.next()) {
						stock = rs.getInt("stock");
					}
					
					
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new BCCCException("查詢庫存失敗");
				}
			
			
			return stock;
		}
		private static final String SELECT_STOCK_BY_COLORNAME_SIZENAME="SELECT product_id, color_name, size ,stock FROM product_color_sizes "
				+ " WHERE product_id = ? AND color_name = ? AND size = ?";
		int selectStock(String productId, String colorName, String sizeName) throws BCCCException {
			int stock = 0;
			try(Connection connection = RDBConnection.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(SELECT_STOCK_BY_COLORNAME_SIZENAME);
						
						) {
				pstmt.setString(1, productId);
				pstmt.setString(2, colorName);
				pstmt.setString(3, sizeName);
					
				try(ResultSet rs = pstmt.executeQuery();){
					while(rs.next()) {
						stock = rs.getInt(stock);
					}
					
					
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new BCCCException("查詢庫存失敗");
				}
			
			return stock;
		}
}
