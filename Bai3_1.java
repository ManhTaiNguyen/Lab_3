import java.util.Scanner;

class SACH {
    String MaSach, TenSach, TacGia, LoaiSach, NhaXuatBan;
    int SoTrang, SoTap;
    double Gia;

    public void NHAPSACH() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        MaSach = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        TenSach = scanner.nextLine();
        System.out.print("Nhap ten tac gia: ");
        TacGia = scanner.nextLine();
        System.out.print("Nhap so trang: ");
        SoTrang = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap loai sach: ");
        LoaiSach = scanner.nextLine();
        System.out.print("Nhap nha xuat ban: ");
        NhaXuatBan = scanner.nextLine();
        System.out.print("Nhap so tap: ");
        SoTap = scanner.nextInt();
        System.out.print("Nhap gia: ");
        Gia = scanner.nextDouble();
    }

    public void INSACH() {
        System.out.println("Ma sach: " + MaSach);
        System.out.println("Ten sach: " + TenSach);
        System.out.println("Ten tac gia: " + TacGia);
        System.out.println("So trang: " + SoTrang);
        System.out.println("Loai sach: " + LoaiSach);
        System.out.println("Nha xuat ban: " + NhaXuatBan);
        System.out.println("So tap: " + SoTap);
        System.out.println("Gia: " + Gia);
    }
}
public class Bai3_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong sach: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        SACH[] DSSach = new SACH[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sach thu " + (i+1) + ":");
            DSSach[i] = new SACH();
            DSSach[i].NHAPSACH();
        }
        System.out.println("Danh sach cac sach da nhap:");
        for (int i = 0; i < n; i++) {
            System.out.println("Sach thu " + (i+1) + ":");
            DSSach[i].INSACH();
        }
    }
}