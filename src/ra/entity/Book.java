package ra.entity;

import java.util.Scanner;

public class Book implements IBookManagement{
    private int BookId;
    private String BookName;
    private String Tittle;
    private String Author;
    private int TotalPages;
    private String Content;
    private String Publisher;
    private float Price;
    private int TypeId;
    private boolean IsDeleted;

    public Book() {
    }

    public Book(int bookId, String bookName, String tittle, String author, int totalPages, String content, String publisher, float price, int typeId, boolean isDeleted) {
        BookId = bookId;
        BookName = bookName;
        Tittle = tittle;
        Author = author;
        TotalPages = totalPages;
        Content = content;
        Publisher = publisher;
        Price = price;
        TypeId = typeId;
        IsDeleted = isDeleted;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(int totalPages) {
        TotalPages = totalPages;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên sách");
        this.BookName=scanner.nextLine();
        System.out.println("Nhập vào tiêu đề sách");
        this.Tittle=scanner.nextLine();
        System.out.println("Nhập vào tác giả");
        this.Author=scanner.nextLine();
        System.out.println("Nhập vào số trang ");
        this.TotalPages=scanner.nextInt();
        System.out.println("Nhập vào nội dung sách");
        this.Content=scanner.nextLine();
        System.out.println("Nhập vào nhà xuất bản");
        this.Publisher=scanner.nextLine();
        System.out.println("Nhập vào giá sách");
        this.Price=scanner.nextFloat();
        System.out.println("Nhập vào mã loại sách");
        this.TypeId=scanner.nextInt();
        System.out.println("Nhập vào trạng thái");
        this.IsDeleted=scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách:" + this.BookId);
        System.out.println("Tên sách:"+this.BookName);
        System.out.println("Tiêu đề sách:"+this.Tittle);
        System.out.println("Tác giả sách:"+this.Author);
        System.out.println("Số trang sách"+this.TotalPages);
        System.out.println("Nội dung sách:"+this.Content);
        System.out.println("Nhà xuất bản:"+this.Publisher);
        System.out.println("Giá sách:"+this.Price);
        System.out.println("Mã loại sách");
        System.out.println("Trạng thái:"+ (this.IsDeleted ? "chưa xóa": "đã xóa"));
    }
}
