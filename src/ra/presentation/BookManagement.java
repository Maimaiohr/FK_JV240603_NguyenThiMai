package ra.presentation;

import ra.busuiness.BookTypeBussiness;
import ra.entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************BOOK-MANAGEMENT******************\n" +
                    "1. Quản lý loại sách\n" +
                    "2. Quản lý sách\n" +
                    "3. Thoát \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.menuBookType(scanner);
                    break;
                case 2:
                    BookManagement.menuBook(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Sai lua chon");

            }
        }while (true);
    }
    // MENU BOOKTYPE
    public static void menuBookType(Scanner scanner){
        boolean check = true;
        do{
            System.out.println("**********************BOOKTYPE-MENU********************\n" +
                    "1. Danh sách loại sách\n" +
                    "2. Tạo mới loại sách\n" +
                    "3. Cập nhật thông tin loại sách\n" +
                    "4. Xóa loại sách\n" +
                    "5. Thống kê số lượng sách theo mã loại sách\n" +
                    "6. Thoát \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    // hien thi ds
                    BookManagement.findAllBookType();
                    break;
                case 2:
                    BookManagement.createBookType(scanner);
                    break;
                case 3:
                    break;
                case 4:
                BookManagement.deleteBookType();
                break;
                case 5:
                    break;
                case 6:
                    System.exit(0);

            }
        }while (check);
    }
    // MENU BOOK
    public static void menuBook(Scanner scanner){
        boolean check = true;
        do{

        }while (check);
    }
// BOOKTYPE
    //hien thi
    public static void findAllBookType(){
        List<BookType> bookTypes = BookTypeBussiness.getAll();
        for (BookType bookType : bookTypes){
            bookType.displayData();
        }
    }
    // them moi
    public static void createBookType(Scanner scanner){
        BookType bookType = new BookType();
        bookType.inputData(scanner);
        BookTypeBussiness.create(bookType);
    }
// cap nhat

// xoa
    public static void deleteBookType(){
        System.out.println("Nhap id can xoa");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        if(BookTypeBussiness.findById(id) != null){
            boolean result = BookTypeBussiness.delete(id);
            if(result){
                System.out.println("Xóa thành công ");
            } else {
                System.err.println("Xóa thất bại");
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
}
