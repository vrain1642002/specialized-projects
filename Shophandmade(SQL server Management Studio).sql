USE shophandmade;
GO

CREATE TABLE Khachhang (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Tentaikhoan VARCHAR(30) DEFAULT (''),
    Matkhau VARCHAR(30) NOT NULL DEFAULT (''),
    Hoten VARCHAR(30) DEFAULT (''),
    Ngaysinh DATE,
    SDT VARCHAR(10) NOT NULL,
    Email VARCHAR(30) DEFAULT (''),
    Diachi VARCHAR(50) DEFAULT (''),
    Ngaytao DATETIME,
    Ngaycapnhat DATETIME,
    Trangthai TINYINT DEFAULT (1)
);

CREATE TABLE Quantrivien (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Tentaikhoan VARCHAR(30) DEFAULT (''),
    Matkhau VARCHAR(30) NOT NULL DEFAULT (''),
    SDT VARCHAR(10) NOT NULL,
    Email VARCHAR(30) DEFAULT (''),
    Ngaytao DATETIME
);

CREATE TABLE Danhmucsanpham (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Ten NVARCHAR(30) NOT NULL DEFAULT ('')
);

CREATE TABLE Sanpham (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Ten NVARCHAR(30),
    Gia FLOAT NOT NULL CHECK (Gia >= 0),
    Hinhthunho VARCHAR(50) DEFAULT (''),
    Mota NVARCHAR(MAX) DEFAULT (''),
    Ngaytao DATETIME,
    Ngaycapnhat DATETIME,
    Ma_Danhmucsanpham INT,
    FOREIGN KEY (Ma_Danhmucsanpham) REFERENCES Danhmucsanpham (Ma)
);

CREATE TABLE Danhgia (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Ngaytao DATETIME,
    Sodiem TINYINT,
    Noidung NVARCHAR(MAX) DEFAULT (''),
    Ma_Sanpham INT,
    Ma_Khachhang INT,
    FOREIGN KEY (Ma_Sanpham) REFERENCES Sanpham (Ma),
    FOREIGN KEY (Ma_Khachhang) REFERENCES Khachhang (Ma)
);

CREATE TABLE Donhang (
    Ma INT PRIMARY KEY IDENTITY(1,1),
    Hoten_Nguoinhan NVARCHAR(30) DEFAULT (''),
    SDT_Nguoinhan VARCHAR(10) NOT NULL,
    Diachi_Nguoinhan NVARCHAR(50) DEFAULT (''),
    Emal_Khachhang VARCHAR(30) DEFAULT (''),
    Ngaydat DATETIME DEFAULT GETDATE(),
    Ngaygiaohang DATE,
    Ghichu NVARCHAR(300) DEFAULT (''),
    Phuongthucvanchuyen NVARCHAR(30),
    Phuongthucthanhtoan NVARCHAR(30),
    Sovandon VARCHAR(30) DEFAULT (''),
    TrangthaiDH NVARCHAR(50) CHECK(TrangthaiDH IN ('Đang xử lý', 'Đang chuẩn bị', 'Đang vận chuyển', 'Đang giao hàng', 'Giao hàng thành công', 'Đơn hàng đã hủy')),
    Tongtien FLOAT CHECK(Tongtien >= 0),
    Trangthai TINYINT DEFAULT (1),
    Ma_Khachhang INT,
    FOREIGN KEY (Ma_Khachhang) REFERENCES Khachhang (Ma)
);

CREATE TABLE Chitietdonhang (
    Gia FLOAT CHECK(Gia >= 0),
    Soluong INT CHECK(Soluong > 0),
    Thanhtien FLOAT CHECK(Thanhtien >= 0),
    Ma_Donhang INT,
    Ma_Sanpham INT,
    FOREIGN KEY (Ma_Donhang) REFERENCES Donhang (Ma),
    FOREIGN KEY (Ma_Sanpham) REFERENCES Sanpham (Ma)
);
