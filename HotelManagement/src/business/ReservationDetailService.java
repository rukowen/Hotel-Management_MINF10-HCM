package business;

import java.sql.SQLException;
import connect.sqlite.ConnectData;

public class ReservationDetailService {
	int resDetailServiceID;
	int resDetailID;
	int serviceID;
	int qtyOfService;
	ConnectData conn;
	public ReservationDetailService(){
		
	}
	
	public ReservationDetailService(int resDetailID, int serviceID, int qtyOfService){
		this.resDetailID = resDetailID;
		this.serviceID = serviceID;
		this.qtyOfService = qtyOfService;
	}
	
	public int addReservationServiceDetail(){
		conn = new ConnectData();
		conn.connect();
		
		String sql ="insert into RoomStatus values(null, "+ resDetailID + ", " + serviceID + ", " + qtyOfService +")";
		int reID = conn.queryExcuteUpdateGenerateKey(sql);
		this.resDetailServiceID = reID; 
		try {
			conn.dispose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reID;
	}
}
