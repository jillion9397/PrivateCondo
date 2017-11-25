/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author POOM
 */
public class DBManagement {
    Connection conn;

    public DBManagement() {
        conn=null;
    }
    
    
    public void createConnection()
            throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/privatecondo?user=root&password=&characterEncoding=UTF-8");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db?user=root&password=&characterEncoding=UTF-8");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db?useUnicode=yes&characterEncoding=utf-8","root","");
    }
    
    public boolean disconnect() throws SQLException{
        if(conn!=null){
            conn.close();
            conn=null;
            return true;
        }
        return false;
    }
    
    public User login(String username,String password) throws SQLException {
        User user=null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM users u"
                + " JOIN usertypes ut ON u.usertype_id=ut.usertype_id WHERE username='"+username+"'"); 
        if(rs.next()){
            if(password.equals(rs.getString("password"))){ 
                user=new User(); 
                user.setUserId(rs.getInt("userID")); 
                user.setUserType(rs.getInt("userType_Id")); 
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setUsername(username); 
                user.setPassword(password); 
                user.setPhone(rs.getString("telNo")); 
                user.setLine(rs.getString("line")); 
                user.setUserTypeStr(rs.getString("ut.userType_name"));
                user.setRoomOwn(queryRoomOwn(user));
                user.setRoomLive(queryRoomlive(user));
                
            } 
        }
        return user;
    }
    
    public ArrayList<Room> queryRoomOwn(User user) throws SQLException{
        ArrayList<Room> roomOwn = new ArrayList<Room>(); 
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT r.* FROM rooms r"
                + " JOIN userroomrelation urr ON urr.rooms_roomId=r.roomId"
                + " JOiN relationtype rt ON urr.relationtype_typeid=rt.relationTypeId"
                + " WHERE user_userid='"+user.getUserId()+"' AND rt.relationTypeName='Owner'"); 
        while(rs.next()){
            Room r = new Room();
            r.setOwner(user);
            r.setRoomId(rs.getInt("r.roomId"));
            r.setFloor(rs.getInt("r.floor"));
            r.setRoomNumber(rs.getString("r.roomNum"));
            roomOwn.add(r);
        }
        return roomOwn;
    }
    
    public Room queryRoomlive(User user) throws SQLException{
        Room roomLive = new Room(); 
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT r.* FROM rooms r"
                + " JOIN userroomrelation urr ON urr.rooms_roomId=r.roomId"
                + " JOiN relationtype rt ON urr.relationtype_typeid=rt.relationTypeId"
                + " WHERE user_userid='"+user.getUserId()+"' AND rt.relationTypeName='Owner'"); 
        if(rs.next()){
            roomLive.setOwner(user);
            roomLive.setRoomId(rs.getInt("r.roomId"));
            roomLive.setFloor(rs.getInt("r.floor"));
            roomLive.setRoomNumber(rs.getString("r.roomNum"));
        }
        return roomLive;
    }
    
    //One-Side Outer Join
    public ArrayList<Problem> queryProblem() throws SQLException{
        ArrayList<Problem> problems = new ArrayList<Problem>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM problems p" +
            " JOIN users u ON u.userid=p.user_id" +
            " LEFT JOIN problemhandler ph ON ph.problem_id=p.problem_id" +
            " LEFT JOIN problemstatus ps ON ph.problemstatus_id=ps.problemstatus_id" +
            " WHERE ph.problem_id is null OR (p.problem_id,handleDate) in (SELECT problem_id,max(handleDate) FROM problemhandler GROUP BY problem_id)"); 
        
       
        while(rs.next()){
            Problem p = new Problem();
            p.setTopic(rs.getString("topic"));
            p.setDescription(rs.getString("description"));
            p.setProblemId(rs.getInt("problem_id"));
            p.setReportDate(rs.getDate("handleDate"));
            User reporter = new User();
            reporter.setUserId(rs.getInt("userId"));
            reporter.setFname(rs.getString("fname"));
            reporter.setLname(rs.getString("lname"));
            p.setReporter(reporter);
            p.setStatusType(rs.getInt("problemstatus_id"));
            p.setStatusTypeStr(rs.getString("ps.problemstatus_name"));
            problems.add(p);
        }
        return problems;
    }
    
    public ArrayList<Problem> queryProblemByUser(int userId) throws SQLException{
        ArrayList<Problem> problems = new ArrayList<Problem>();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM problems p" +
            " JOIN users u ON u.userid=p.user_id" +
            " LEFT JOIN problemhandler ph ON ph.problem_id=p.problem_id" +
            " LEFT JOIN problemstatus ps ON ph.problemstatus_id=ps.problemstatus_id" +
            " WHERE userId="+userId+" AND (ph.problem_id is null OR(p.problem_id,handleDate) in (SELECT problem_id,max(handleDate) FROM problemhandler GROUP BY problem_id))"); 
        
       
        while(rs.next()){
            Problem p = new Problem();
            p.setTopic(rs.getString("topic"));
            p.setDescription(rs.getString("description"));
            p.setProblemId(rs.getInt("problem_id"));
            p.setReportDate(rs.getDate("handleDate"));
            User reporter = new User();
            reporter.setUserId(rs.getInt("userId"));
            reporter.setFname(rs.getString("fname"));
            reporter.setLname(rs.getString("lname"));
            p.setReporter(reporter);
            p.setStatusType(rs.getInt("problemstatus_id"));
            p.setStatusTypeStr(rs.getString("ps.problemstatus_name"));
            problems.add(p);
        }
        return problems;
    }
    
    //subquery type II
    public int countNotDoneProblem() throws SQLException{
        int count = 0;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM problems p "
                + "WHERE problem_id NOT IN "
                + "(SELECT problem_id FROM problemhandler ph WHERE p.problem_id = ph.problem_id)"); 
        
        while(rs.next()){
            count++;
        }
        return count;
//        SELECT * FROM problems p WHERE problem_id NOT IN (SELECT problem_id FROM problemhandler ph WHERE p.problem_id = ph.problem_id)
    }
    
    public void updateStatusProblem(Problem p,int statusid,int adminId) throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Statement stm=null;
        stm = conn.createStatement();
        stm.execute("insert into problemhandler (problem_id,problemstatus_id,admin_id,handleDate)"
                + " value ("+p.getProblemId()+","+statusid+","+adminId+",'"+sdf.format(new Date())+"')");
    }
    
    public void addNews(News n,int ancId) throws SQLException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        String datestr = sdf.format(n.getAnnounceDate());
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into news (news_topic,news_description,announceDate,announcer_Id) value (?,?,?,?)");
        
        psm.setString(1, n.getTopic());
        psm.setString(2, n.getDescription());
        System.out.println(datestr);
        psm.setDate(3, new java.sql.Date(n.getAnnounceDate().getTime()));
        psm.setInt(4, ancId);
        
        psm.executeUpdate();
    }
    
    public void editNews(News news) throws SQLException{
        Statement stm=null;
        System.out.println("1"+news.toString());
        stm = conn.createStatement();
        System.out.println("2"+news.toString());
        stm.execute("UPDATE news SET news_topic='"+news.getTopic()+"' ,news_description='"+news.getDescription()+"' WHERE news_id="+news.getNewsId());
        System.out.println("3"+news.toString());
        
    }
    
    public void deleteNews(News news) throws SQLException{
        Statement stm=null;
        stm = conn.createStatement();
        stm.execute("DELETE FROM News" +
            " WHERE news_id="+news.getNewsId());
    }
    
    public void addProblem(Problem p) throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        String datestr = sdf.format(p.getReportDate());
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into problems (topic,description,reportDate,user_id,room_id) value (?,?,?,?,?)");
        
        psm.setString(1, p.getTopic());
        psm.setString(2, p.getDescription());
        psm.setDate(3, new java.sql.Date(p.getReportDate().getTime()));
        psm.setInt(4, p.getReporter().getUserId());
        psm.setInt(5, p.getReporter().getRoomLive().getRoomId());
        
        psm.executeUpdate();
    }
    
    public ArrayList<ServiceReservation> queryReserve() throws SQLException{
        
        ArrayList<ServiceReservation> services = new ArrayList<ServiceReservation>(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM servicereservation sr"
                + " JOIN worktimes w ON sr.worktime_id=w.worktimeid"
                + " JOIN roomservicestaffs rs ON rs.staffId=w.worktime_staffId"
                + " JOIN rooms r ON r.roomId=sr.rooms_roomId"
                + " JOIN userroomrelation ur ON r.roomId=ur.rooms_roomId"
                + " JOIN Users u ON u.userId=ur.user_userId"
                + " WHERE serviceDate>='"+sdf.format(new Date())+"' ORDER BY serviceDate"
                        + " AND relationtype_typeid=1"); 
        while(rs.next()){
            ServiceReservation s = new ServiceReservation();
            Room r = new Room();
            WorkTime wt = new WorkTime();
            User u = new User();
            RoomServiceStaff staff = new RoomServiceStaff();
            staff.setFname(rs.getString("rs.fname"));
            staff.setLname(rs.getString("rs.lname"));
            wt.setStartTime(rs.getTime("startTime"));
            wt.setEndTime(rs.getTime("endTime"));
            wt.setWorkTimeId(rs.getInt("worktimeid"));
            wt.setStaff(staff);
            u.setFname(rs.getString("u.fname"));
            u.setFname(rs.getString("u.lname"));
            r.setRoomNumber(rs.getString("roomNum"));
            r.setOwner(u);
            s.setWorkTime(wt);
            s.setReserveDate(rs.getDate("serviceDate"));
            s.setRoom(r);
            s.setReserveDate(rs.getDate("serviceDate"));
            s.setReserveId(rs.getInt("reserveId"));
            services.add(s);
        }
        return services;
        
    }
    
    public void addRoomReserve(Date serviceDate,int roomId,int worktimeId) throws SQLException{
        
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into news (serviceDate,rooms_roomId,worktime_id) value (?,?,?,?)");
        
        psm.setDate(1, new java.sql.Date(serviceDate.getTime()));
        psm.setInt(2, roomId);
        psm.setInt(3, worktimeId);
        
        psm.executeUpdate();
    }
    
    //One-side Full Outer JOIN
    //using null
    public ArrayList<WorkTime> queryWorkTime() throws SQLException{
        ArrayList<WorkTime> worktimeList = new ArrayList<WorkTime>(); 
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM worktimes wt"
                + " JOIN roomservicestaffs rs ON rs.staffId=wt.worktime_staffId"
                + " LEFT JOIN servicereservation ss ON wt.worktimeid=ss.worktime_id"
                + " WHERE ss.worktime_id is null"); 
        while(rs.next()){
            WorkTime wt = new WorkTime();
            RoomServiceStaff staff = new RoomServiceStaff();
            staff.setFname(rs.getString("rs.fname"));
            staff.setLname(rs.getString("rs.lname"));
            staff.setStaffId(rs.getInt("staffId"));
            wt.setStartTime(rs.getTime("startTime"));
            wt.setEndTime(rs.getTime("endTime"));
            wt.setWorkTimeId(rs.getInt("worktimeid"));
            wt.setStaff(staff);
            wt.setDayId(rs.getInt("worktime_dayid"));

            worktimeList.add(wt);
        }
        return worktimeList;
    }
    
    public static void main(String[] args) throws Exception {
        //test ja 
        DBManagement dbm = new DBManagement();
        dbm.createConnection();
        User activeuser = dbm.login("jillion", "1234");
        System.out.println(dbm.queryProblemByUser(2));
//        Problem  p = new Problem();
//        p.setProblemId(1);
//        dbm.updateStatusProblem(p, "Done");
//        System.out.println(dbm.queryReserve());
        
//        Room r = new Room();
//        r.setRoomId(13);
//        User usr = new User();
//        usr.setUserId(2);
//        usr.setFname("jirapa");
//        usr.setRoomLive(r);
//        Problem p = new Problem();
//        
//        p.setReporter(usr);
//        p.setTopic("ฝ้าในห้องหลุด");
//        p.setDescription("ในห้องมีฝ้าหลุดประมาณ2-3แผ่นค่ะ");
//        p.setReportDate(new Date());
//        
//        dbm.addProblem(p);
//        News news = new News();
//        news.setNewsId(2);
//        news.setTopic("test");
//        news.setDescription("weeeeeeeeeeeeeeeeeeeee");
//        news.setAnnounceDate(new Date());
//        dbm.addNews(news,2);
//        dbm.editNews(news);

//        ArrayList<News> list = dbm.queryNews();
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.toArray()[i]);
//            
//        }
        dbm.disconnect();
        
        
    }
    
    public ArrayList<News> queryNews() throws SQLException{
         ArrayList<News> news = new ArrayList<News>(); 
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM news Order By announceDate DESC"); 
        while(rs.next()){
            News n = new News();
            n.setNewsId(rs.getInt("news_id"));
            n.setTopic(rs.getString("news_topic"));
            n.setDescription(rs.getString("news_description"));
            n.setAnnounceDate(rs.getDate("announceDate"));
            news.add(n);
        }
        return news;
    }
    /*public int insertItem(String itemName, String itemDesc,int ownerId,int itemCate,String date)
                throws SQLException{ 
        Statement stm=null;
        int itemId=-1;
        stm = conn.createStatement();
        stm.execute("insert into item (itemName,itemDes,DateStart,Account_userID,Cate_cateId) "
                + "value ('"+itemName+"','"+itemDesc+"','"+date+"','"+ownerId+"','"+itemCate+"')",Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        while(rs.next()){
            itemId=rs.getInt(1);  
        }
             
        return itemId;
    }
    
    public LostItem[] queryItem(String filter,String orderBy,String locationFilter) 
            throws SQLException, InterruptedException{ 
        ArrayList<LostItem> allLostItem = new ArrayList<LostItem>(); 
        String locationJOIN = "";
        if(!locationFilter.equals("")){
            locationJOIN=" INNER JOIN itemlocation ON itemlocation.ItemStatus_itemStatusId=itemstatus.itemStatusId";
        }
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select item.itemId ,cate.cateName ,account.userName ,item.itemName "
                + ",item.itemDes ,account.userID as OwnerId ,account.userName as Owner_name ,item.dateStart"
                + ",item.dateEnd ,itemstatus.itemStatusDate ,picture.picturePath from item"
                + " INNER JOIN cate ON item.Cate_cateId=cate.cateId"
                + " INNER JOIN itemstatus ON itemstatus.Item_itemId=item.itemId"
                + " INNER JOIN account ON item.Account_userID=Account.userID"
                + locationJOIN                
                + " LEFT JOIN picture ON picture.Item_itemId=item.itemId"
                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate)"
                + " IN (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) "+filter+locationFilter
                + " ORDER BY itemstatus.itemStatusDate "+orderBy);                
        while(rs.next()){
            LostItem tmp = new LostItem();
            tmp.setItemId(rs.getInt("itemId"));
            tmp.setCate(rs.getString("cateName"));
            tmp.setItemName(rs.getString("itemName"));
            tmp.setItemDescription(rs.getString("itemDes"));
            Timestamp timestamp = rs.getTimestamp("DateStart");
            if(timestamp!=null){
                tmp.setDateStart(new java.util.Date(timestamp.getTime()));
            }
            timestamp = rs.getTimestamp("dateEnd");
            if(timestamp!=null){
                tmp.setDateEnd(new java.util.Date(timestamp.getTime()));
            }
            tmp.setOwnerName(rs.getString("Owner_name"));
            tmp.setOwnerId(rs.getInt("OwnerId"));
            String imgName = rs.getString("picturePath");
            if(imgName==null){
                imgName="noImg";
            }
            tmp.setImg(Picture.getImg(imgName));
            tmp.setStatus(queryStatus(tmp.getItemId()));            
            allLostItem.add(tmp);
        }
        
        return allLostItem.toArray(new LostItem[allLostItem.size()]);
    } 
    
    public void updateItem(LostItem item,String date) throws SQLException{ 
        Statement stm=null;
        stm = conn.createStatement();
        if(date==null){
            stm.execute("UPDATE item SET DateEnd="+date+" WHERE itemId="+item.getItemId());
        }else{
            stm.execute("UPDATE item SET DateEnd='"+date+"' WHERE itemId="+item.getItemId());
        }
        
    }
    
    public int insertStatus(int itemId,int accountId,int status)
                throws SQLException,ClassNotFoundException{        
        Statement stm=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String statusDate = sdf.format(new Date());
        stm = conn.createStatement();
        stm.execute("insert into itemstatus (itemStatusDate,Item_itemId,Account_userID,Status_statusID)"
                + "value ('"+statusDate+"',"+itemId+","+accountId+","+status+")",Statement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = stm.getGeneratedKeys();
        int statusId=-1;
        while(rs.next()){
            statusId=rs.getInt(1);  
        }
        
        
        return statusId;
    }
    
    
    public ItemStatus queryStatus(int itemId)
            throws SQLException{
        ItemStatus stat = new ItemStatus(); 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("select itemstatus.itemStatusId,itemstatus.itemStatusDate as lastUpdate"
                + ",itemstatus.Item_itemId,account.userName"
                + ",status.statusName from itemstatus"
                + " INNER JOIN account ON itemstatus.Account_userID=account.userID"
                + " INNER JOIN status ON itemstatus.Status_statusId=status.statusId"
                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate) IN"
                + " (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) AND itemstatus.Item_itemId="+itemId);
        
        rs.next();
        stat.setStatusId(rs.getInt("itemStatusId"));
        stat.setLastUpdate(rs.getDate("lastUpdate")); 
        stat.setItemId(rs.getInt("Item_itemId"));
        stat.setOwnerName(rs.getString("userName"));
        stat.setStatusName(rs.getString("statusName"));
        queryItemLocation(stat);
//        stat.setLocationId(rs.getInt("locationId"));
        
         
        return stat;
    }
    
    public ItemStatus queryStatusSpecifyType(int itemId,int statusType)
            throws SQLException{
        ItemStatus stat = null; 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("select itemstatus.itemStatusId,itemstatus.itemStatusDate"
                + " ,itemstatus.Item_itemId ,status.statusName from itemstatus"
                + " INNER JOIN account ON itemstatus.Account_userID=account.userID"
                + " INNER JOIN status ON itemstatus.Status_statusId=status.statusId"
                + " WHERE itemstatus.Status_statusId="+statusType
                + " AND itemstatus.Item_itemId="+itemId);
        
        while(rs.next()){
            stat = new ItemStatus();
            stat.setStatusId(rs.getInt("itemStatusId"));
            stat.setLastUpdate(rs.getDate("itemStatusDate")); 
            stat.setItemId(rs.getInt("Item_itemId"));
            stat.setStatusName(rs.getString("statusName"));
            queryItemLocation(stat);
        }
        
        return stat;
    }
    
    public void deleteStatusSpecifyType(int itemId,int statusType)
            throws SQLException{
        ItemStatus stat = new ItemStatus(); 
        Statement stm = conn.createStatement();
        
        stm.executeUpdate("DELETE FROM itemstatus WHERE itemstatus.Status_statusId="+statusType
                + " AND itemstatus.Item_itemId="+itemId);

    }
    
    public void insertItemLocation(ArrayList<Integer> locationIds,int ItemStatusId)
                throws SQLException{ 
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into itemlocation (Location_locationId,ItemStatus_itemStatusId) value (?,?)");
        
        for(int i=0;i<locationIds.size();i++){
            psm.setInt(1, locationIds.get(i)+1);
            psm.setInt(2, ItemStatusId);
            psm.executeUpdate();
        }
    }
    public void insertItemLocation(int locationId,int ItemStatusId)
                throws SQLException{ 
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into itemlocation (Location_locationId,ItemStatus_itemStatusId) value (?,?)");
        
        psm.setInt(1, locationId+1);
        psm.setInt(2, ItemStatusId);
        psm.executeUpdate();
        
    }
     public void queryItemLocation(ItemStatus stat)
            throws SQLException{
        String[] location=null;
        ArrayList<String> locationName = new ArrayList<String>(); 
        ArrayList<Integer> locationId = new ArrayList<Integer>();
        Statement stm = conn.createStatement();
        String command = "SELECT Location_locationId,location.locationName FROM itemlocation"
                + " INNER JOIN location ON itemlocation.Location_locationId=location.locationId"
                + " WHERE ItemStatus_itemStatusId="+stat.getStatusId();
        ResultSet rs = stm.executeQuery(command);
        
        while(rs.next()){
            locationName.add(rs.getString("locationName"));
            locationId.add(rs.getInt("Location_locationId"));
        }
        
        if(locationName.size()>0){
            stat.setLocationName(locationName);
            stat.setLocationId(locationId);
            
        }
         
    }
    
    public void insertImage(String imgName,int ItemId)
                throws SQLException{ 
        Statement stm=null;
        stm = conn.createStatement();
        stm.executeUpdate("insert into Picture (picturePath,Item_itemId) "
                + "value ('"+imgName+"',"+ItemId+")");             
    }
    
    public String[] queryImage(int itemId)
            throws SQLException{
        String[] imgName=null;
        ArrayList<String> temp = new ArrayList<String>(); 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("SELECT picture.picturePath FROM picture WHERE picture.Item_itemId="+itemId);
        
        while(rs.next()){
            temp.add(rs.getString("picturePath"));
        }
        
        if(temp.size()>0){
            imgName=temp.toArray(new String[temp.size()]);
        }
         
        return imgName;
    }
    
    public String[] queryLocation() throws SQLException{
        ArrayList<String> temp = new ArrayList<String>();
        String[] allLocate = null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT location.locationName FROM location");       
        while(rs.next()){
            temp.add(rs.getString("locationName"));
        }
        
        if(temp.size()>0){
            allLocate=temp.toArray(new String[temp.size()]);
        }
        
        return allLocate;
    }
    
    public Account queryAccount(int accId) throws SQLException {
        Account acc=null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT userName,name,surname,userType,userPhone,"
                + "userEmail,userLine,AccountType_accTypeID FROM account WHERE userID="+accId); 
        if(rs.next()){
                acc=new Account(); 
                acc.setAccId(accId); 
                acc.setAccType(rs.getInt("AccountType_accTypeID")); 
                acc.setName(rs.getString("name"));
                acc.setSurname(rs.getString("surname"));
                acc.setUsername(rs.getString("userName")); 
                acc.setEmail(rs.getString("userEmail")); 
                acc.setPhone(rs.getString("userPhone")); 
                acc.setLine(rs.getString("userLine")); 
                acc.setAccTypeStr(rs.getString("userType"));
        }
        return acc;
    }
    
    public Account login(String username,String password) throws SQLException {
        Account acc=null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM account WHERE userName='"+username+"'"); 
        if(rs.next()){
            if(password.equals(rs.getString("password"))){ 
                acc=new Account(); 
                acc.setAccId(rs.getInt("userID")); 
                acc.setAccType(rs.getInt("AccountType_accTypeID")); 
                acc.setName(rs.getString("name"));
                acc.setSurname(rs.getString("surname"));
                acc.setUsername(username); 
                acc.setPassword(password); 
                acc.setEmail(rs.getString("userEmail")); 
                acc.setPhone(rs.getString("userPhone")); 
                acc.setLine(rs.getString("userLine")); 
                acc.setAccTypeStr(rs.getString("userType"));
            } 
        }
        return acc;
    }
    
    public void deleteItem(int itemId) throws SQLException{
        Statement stm=null;
        stm = conn.createStatement();
        stm.executeUpdate("DELETE FROM item WHERE itemId = "+itemId);    
    }
    */
    
    
    public Connection getCn() {
        return conn;
    }

    public void setCn(Connection cn) {
        this.conn = conn;
    }
    
}
