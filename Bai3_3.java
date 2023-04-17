import java.util.ArrayList;
import java.util.Scanner;

class HangHoa {
    Scanner scanner = new Scanner(System.in);
    protected String ma,ten,nhaSanXuat;
    protected long gia;

    public HangHoa() {}
    public HangHoa(String ma, String ten, String nhaSanXuat, long gia) {
        this.ma = ma;
        this.ten = ten;
        this.nhaSanXuat = nhaSanXuat;
        this.gia = gia;
    }
    public void nhapThongTin() {
        System.out.print("Nhap ma hang: ");
        this.ma = scanner.next();
        System.out.print("Nhap ten hang: ");
        this.ten = scanner.next();
        System.out.print("Nhap nha san xuat: ");
        this.nhaSanXuat = scanner.next();
        System.out.print("Nhap Gia: ");
        this.gia = scanner.nextLong();
    }
    public void xuatThongTin() {
        System.out.println("Mã hàng: " + this.ma);
        System.out.println("Tên hàng: " + this.ten);
        System.out.println("Nhà sản xuất: " + this.nhaSanXuat);
        System.out.println("Giá: " + this.gia);
    }
}

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh,dienAp,congSuat;

    public HangDienMay() {}
    public HangDienMay(String ma, String ten, String nhaSanXuat, long gia, int thoiGianBaoHanh, int dienAp, int congSuat) {
        super(ma, ten, nhaSanXuat, gia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.dienAp = dienAp;
        this.congSuat = congSuat;
    }
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Thời gian bảo hành: " + this.thoiGianBaoHanh);
        System.out.println("Điện áp: " + this.dienAp);
        System.out.println("Công suất: " + this.congSuat);
    }
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Thời gian bảo hành: ");
        this.thoiGianBaoHanh = scanner.nextInt();
        System.out.print("Điện áp: ");
        this.dienAp = scanner.nextInt();
        System.out.print("Công suất: ");
        this.congSuat = scanner.nextInt();
    }
}

class HangSanhSu extends HangHoa {
    private String loaiNguyenLieu;

    public HangSanhSu() {}
    public HangSanhSu(String ma, String ten, String nhaSanXuat, long gia, String loaiNguyenLieu) {
        super(ma, ten, nhaSanXuat, gia);
        this.loaiNguyenLieu = loaiNguyenLieu;
    }
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Loại nguyên liệu: " + this.loaiNguyenLieu);
    }
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.print("Loại nguyên liệu: ");
        this.loaiNguyenLieu = scanner.next();
    }
}

class NgayThang {
    Scanner scanner = new Scanner(System.in);
    private byte ngay,thang;
    private int nam;

    public NgayThang() {}
    public NgayThang(byte ngay, byte thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }
    public void nhap() {
        System.out.print("Ngày: ");
        this.ngay = scanner.nextByte();
        System.out.print("Tháng: ");
        this.thang = scanner.nextByte();
        System.out.print("Năm: ");
        this.nam = scanner.nextInt();
    }
    public void xuat() {
        System.out.println(this.ngay + "/" + this.thang + "/" + this.nam);
    }
}

class HangThucPham extends HangHoa {
    private NgayThang ngaySanXuat,ngayHetHan;

    public HangThucPham() {
        ngaySanXuat = new NgayThang();
        ngayHetHan = new NgayThang();
    }
    public HangThucPham(String ma, String ten, String nhaSanXuat, long gia, NgayThang ngaySanXuat, NgayThang ngayHetHan) {
        super(ma, ten, nhaSanXuat, gia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.print("Ngày sản xuất: ");
        ngaySanXuat.xuat();
        System.out.print("Ngày hết hạn dùng: ");
        ngayHetHan.xuat();
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("Ngày sản xuất: ");
        ngaySanXuat.nhap();

        System.out.println("Ngày hết hạn dùng: ");
        ngayHetHan.nhap();
    }
}

public class Bai3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<HangHoa> danhSachHangHoa = new ArrayList<HangHoa>();

        System.out.print("Nhập số lượng sản phẩm: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
            System.out.print("Loại sản phẩm (D: điện máy, S: sành sứ, T: thực phẩm): ");
            String loaiSanPham = scanner.next();

            switch (loaiSanPham) {
                case "D":
                    HangDienMay hDM = new HangDienMay();
                    hDM.nhapThongTin();
                    danhSachHangHoa.add(hDM);
                    break;
                case "S":
                    HangSanhSu hSS = new HangSanhSu();
                    hSS.nhapThongTin();
                    danhSachHangHoa.add(hSS);
                    break;
                case "T":
                    HangThucPham hTP = new HangThucPham();
                    hTP.nhapThongTin();
                    danhSachHangHoa.add(hTP);
                    break;

                default:
                    System.out.println("Nhập không hợp lệ");
                    break;
            }
        }

        System.out.println("\nDanh sách các sản phẩm:");

        System.out.println("\nCác sản phẩm điện máy:");
        for (HangHoa hangHoa : danhSachHangHoa) {
            if (hangHoa instanceof HangDienMay) {
                hangHoa.xuatThongTin();
                System.out.println();
            }
        }

        System.out.println("\nCác sản phẩm sành sứ:");
        for (HangHoa hangHoa : danhSachHangHoa) {
            if (hangHoa instanceof HangSanhSu) {
                hangHoa.xuatThongTin();
                System.out.println();
            }
        }

        System.out.println("\nCác sản phẩm thực phẩm:");
        for (HangHoa hangHoa : danhSachHangHoa) {
            if (hangHoa instanceof HangThucPham) {
                hangHoa.xuatThongTin();
                System.out.println();
            }
        }
    }
}