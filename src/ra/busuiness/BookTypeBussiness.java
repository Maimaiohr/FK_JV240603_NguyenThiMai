package ra.busuiness;

import ra.entity.BookType;
import ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class BookTypeBussiness {
    //lay ve danh sachs
    public static List<BookType> getAll(){
        List<BookType> BookTypes = new ArrayList<BookType>();
        Connection connection = null;
        try{
            //mo ket noi
            connection = ConnectionDB.openConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM BookType");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                //duyet dl
                BookType BookType = new BookType();
                BookType.setTypeId(resultSet.getInt("BookId"));
                BookType.setTypeName(resultSet.getString("BookName"));
                BookType.setDescription(resultSet.getString("Description"));
                BookType.setDeleted(resultSet.getBoolean("IsDeleted"));
                BookTypes.add(BookType);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection();
        }

        return BookTypes;
    }
    //tim theo id
    public static BookType findById(int id){
        BookType bookType = null;
        Connection connection = null;
        try{
            connection = ConnectionDB.openConnection();
            PreparedStatement statement = connection.prepareStatement("select * from BookType WHERE TypeId=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            bookType= new BookType();
            int count =0;
            while (resultSet.next()){
                count++;
                bookType.setTypeId(resultSet.getInt("TypeId"));
                bookType.setTypeName(resultSet.getString("TypeName"));
                bookType.setDescription(resultSet.getString("Description"));
                bookType.setDeleted(resultSet.getBoolean("IsDeleted"));
            }
            System.out.println(count);
            if (count == 0){
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection();
        }
        return bookType;
    }
    //them moi
    public static boolean create(BookType bookType){
        Connection connection = null;
        try{
            connection = ConnectionDB.openConnection();
            String sql = "insert into BookType values(TypeName,Description,IsDeleted)  value(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,bookType.getTypeName());
            statement.setString(2,bookType.getDescription());
            statement.setBoolean(3,bookType.getDeleted());
            statement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection();
        }
        return false;
    }
    // sua
    public static boolean update(BookType bookType){
        Connection connection = null;
        try{
            connection = ConnectionDB.openConnection();
            String sql ="UPDATE BookType SET TypeName=?,Description=?,IsDeleted=? WHERE TypeId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,bookType.getTypeName());
            statement.setString(2,bookType.getDescription());
            statement.setBoolean(3,bookType.getDeleted());
            statement.setInt(4,bookType.getTypeId());
            statement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection();
        }
        return false;
    }
    // xoa
    public static boolean delete(int id){
        Connection connection = null;
        try{
            connection = ConnectionDB.openConnection();
            String sql = "delete from BookType where TypeId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection();
        }
        return false;
    }
}
