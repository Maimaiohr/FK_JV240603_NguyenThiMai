package ra.entity;

import java.util.Scanner;

public class BookType implements IBookManagement {
    private int TypeId;
    private String TypeName;
    private String Description;
    private Boolean IsDeleted;

    public BookType() {
    }

    public BookType(int typeId, String typeName, String description, Boolean isDeleted) {
        TypeId = typeId;
        TypeName = typeName;
        Description = description;
        IsDeleted = isDeleted;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getDeleted() {
        return IsDeleted;
    }

    public void setDeleted(Boolean deleted) {
        IsDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên loại sách");
        this.TypeName = scanner.nextLine();
        System.out.println("Nhập vào mô tả loại sách");
        this.Description = scanner.nextLine();
        System.out.println("Nhập vào trạng thái loại sách đã bị xóa");
    }

    @Override
    public void displayData() {
       System.out.println("Mã loại sách là:" + this.TypeId);
       System.out.println("Tên loại sách là:" + this.TypeName);
       System.out.println("Mô tả:"+this.Description);
       System.out.println("Trạng thái:"+(this.IsDeleted ? "chưa xóa" : "đã xóa"));
        };
    }
