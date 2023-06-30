package v2_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.db.DBConnect;

public class Mall_Ex {
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	

	public static void main(String[] args) {
		DBConnect dbc = new DBConnect();
//		dbc.getConnection();  = conn
		
		System.out.println("===== 자동차 전문 판매 사이트 =====");
		
		String cate = "select cate_id, cate_name from category order by cate_id asc";
		
		try {
			pstmt = dbc.getConnection().prepareStatement(cate);
			rs = pstmt.executeQuery();
			
			System.out.println("자동차 판매 회사 카테고리를 보여줍니다.");
			System.out.println("-------------------------------");
			if(rs.next()) {
				
				do {
					System.out.println(rs.getString(2) + "(" + rs.getString(1) + ")");
				}while(rs.next());
				
			}else {
				System.out.println("등록된 카테고리가 없습니다.\n카테고리 등록 페이지로 이동합니다.");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println();
		System.out.print("카테고리 번호를 선택하세요 > ");
		String choice = "1000";
		
		System.out.println();
		System.out.println();
	
		System.out.println("자동차 정보 상세 페이지를 보여줍니다.");
		System.out.println("-------------------------------");
		System.out.println("제조사번호\t제조사명\t차종\t차량가격");
		
//		String detail = "select a.cate_id, a.cate_name, b.car_name from category a, cars b";
		String detail = "select a.cate_id, a.cate_name, b.car_name, b.car_price from category as a, cars as b where a.cate_id = b.cate_id and a.cate_id =" + choice
						+ " order by b.car_name desc";

		
		try {
			pstmt = dbc.getConnection().prepareStatement(detail);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				do {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
				}while(rs.next());
				
			}else {
				System.out.println("등록된 차랑이 없습니다.\n차량을 등록해 주셈~");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 
				
		
	}

}
