import java.util.Scanner;
import java.lang.Math;

class DIEM {
    protected double x, y;

    public void NHAPDIEM() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap toa do x: ");
        x = sc.nextDouble();
        System.out.print("Nhap toa do y: ");
        y = sc.nextDouble();
    }

    public double tinhKhoangCach(DIEM d) {
        return Math.sqrt(Math.pow(x - d.x, 2) + Math.pow(y - d.y, 2));
    }
}

class TAMGIAC extends DIEM {
    private DIEM d1, d2, d3;

    public void NHAPTG() {
        d1 = new DIEM();
        System.out.println("Nhap diem thu nhat cua tam giac: ");
        d1.NHAPDIEM();
        d2 = new DIEM();
        System.out.println("Nhap diem thu hai cua tam giac: ");
        d2.NHAPDIEM();
        d3 = new DIEM();
        System.out.println("Nhap diem thu ba cua tam giac: ");
        d3.NHAPDIEM();
    }

    public boolean KIEMTRA() {
        double a = d1.tinhKhoangCach(d2);
        double b = d2.tinhKhoangCach(d3);
        double c = d3.tinhKhoangCach(d1);
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public double tinhChuVi() {
        double a = d1.tinhKhoangCach(d2);
        double b = d2.tinhKhoangCach(d3);
        double c = d3.tinhKhoangCach(d1);
        return a + b + c;
    }

    public double tinhDienTich() {
        double a = d1.tinhKhoangCach(d2);
        double b = d2.tinhKhoangCach(d3);
        double c = d3.tinhKhoangCach(d1);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class DUONGTRON extends DIEM {
    private DIEM tam;
    private double banKinh;

    public void NHAPDT() {
        tam = new DIEM();
        System.out.println("Nhap toa do tam cua duong tron: ");
        tam.NHAPDIEM();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ban kinh cua duong tron: ");
        banKinh = sc.nextDouble();
    }

    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
}

public class Bai3_2 {
    public static void main(String[] args) {
        TAMGIAC ABC = new TAMGIAC();
        ABC.NHAPTG();
        if(ABC.KIEMTRA()) System.out.println("ABC la Tam Giac");
        else System.out.print("ABC Khong Phai Tam Giac");
        System.out.println("Chu Vi Tam Giac la:" + ABC.tinhChuVi()); 
        System.out.println("Dien Tich Tam Giac la:" + ABC.tinhDienTich()); 

        DUONGTRON O = new DUONGTRON();
        O.NHAPDT();
        System.out.println("Chu Vi Duong Tron la:" + O.tinhChuVi()); 
        System.out.println("Dien Tich Duong Tron la:" + O.tinhDienTich()); 
    }
}