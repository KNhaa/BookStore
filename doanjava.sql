-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 21, 2020 lúc 07:47 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `doanjava`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctnhap`
--

CREATE TABLE `ctnhap` (
  `masach` int(11) NOT NULL,
  `manhap` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `gianhap` int(11) DEFAULT NULL,
  `thanhtien` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ctnhap`
--

INSERT INTO `ctnhap` (`masach`, `manhap`, `soluong`, `gianhap`, `thanhtien`, `trangthai`) VALUES
(1, 5, 10, 62000, 620000, 1),
(2, 5, 10, 62000, 620000, 1),
(3, 5, 10, 62000, 620000, 1),
(3, 12, 2, 56000, 112000, 1),
(3, 18, 3, 56000, 168000, 1),
(4, 5, 10, 62000, 620000, 1),
(5, 6, 10, 62000, 620000, 1),
(6, 6, 10, 62000, 620000, 1),
(6, 13, 5, 56000, 280000, 1),
(6, 14, 5, 56000, 280000, 1),
(7, 6, 10, 62000, 620000, 1),
(7, 13, 5, 56000, 280000, 1),
(7, 14, 5, 56000, 280000, 1),
(8, 6, 10, 62000, 620000, 1),
(8, 16, 11, 56000, 616000, 1),
(9, 7, 10, 62000, 620000, 1),
(10, 8, 10, 110000, 1100000, 1),
(11, 3, 10, 127000, 1270000, 1),
(11, 12, 5, 104000, 520000, 1),
(12, 1, 10, 73000, 730000, 1),
(13, 8, 10, 85000, 850000, 1),
(14, 4, 5, 195000, 975000, 1),
(15, 4, 5, 195000, 975000, 1),
(16, 4, 5, 217000, 1085000, 1),
(17, 2, 5, 220000, 1100000, 1),
(18, 4, 5, 225000, 1125000, 1),
(19, 4, 5, 218000, 1090000, 1),
(20, 2, 5, 240000, 1200000, 1),
(21, 3, 10, 72000, 720000, 1),
(21, 21, 5, 60000, 300000, 1),
(22, 8, 10, 65000, 650000, 1),
(23, 8, 10, 240000, 2400000, 1),
(24, 8, 10, 240000, 2400000, 1),
(25, 3, 5, 227000, 1135000, 1),
(25, 15, 5, 184000, 920000, 1),
(25, 17, 5, 184000, 920000, 1),
(25, 20, 5, 184000, 920000, 1),
(27, 20, 5, 64000, 320000, 1),
(28, 19, 5, 36000, 180000, 1),
(28, 22, 5, 36000, 180000, 1),
(29, 11, 5, 80000, 400000, 1),
(29, 22, 5, 80000, 400000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_hd`
--

CREATE TABLE `ct_hd` (
  `mahd` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `thanhtien` int(11) DEFAULT NULL,
  `tienkm` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ct_hd`
--

INSERT INTO `ct_hd` (`mahd`, `masach`, `soluong`, `thanhtien`, `tienkm`, `trangthai`) VALUES
(1, 17, 2, 460, 20, 1),
(1, 22, 3, 230000, 30000, 1),
(2, 11, 1, 130000, 0, 1),
(3, 2, 3, 70000, 0, 1),
(3, 24, 1, 250000, 0, 1),
(4, 1, 1, 70000, 0, 1),
(5, 14, 1, 200000, 0, 1),
(5, 23, 1, 250000, 0, 1),
(6, 19, 1, 220000, 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` int(11) NOT NULL,
  `ngaylap` date NOT NULL,
  `tongtien` int(11) DEFAULT NULL,
  `tienkm` int(11) DEFAULT NULL,
  `thuctra` int(11) DEFAULT NULL,
  `makm` int(11) DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `makh` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `ngaylap`, `tongtien`, `tienkm`, `thuctra`, `makm`, `manv`, `makh`, `trangthai`) VALUES
(1, '2020-05-10', 600000, 20, 580000, 0, 1, 1, 1),
(2, '2020-06-20', 130000, 0, 130000, 0, 1, 4, 1),
(3, '2020-06-21', 460000, 23000, 437000, 1, 1, 11, 1),
(4, '2020-06-21', 70000, 0, 70000, 0, 3, 9, 1),
(5, '2020-06-21', 450000, 22500, 427500, 1, 3, 12, 1),
(6, '2020-06-21', 220000, 11000, 209000, 1, 2, 14, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `hokh` varchar(255) DEFAULT NULL,
  `tenkh` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `hokh`, `tenkh`, `sdt`, `diachi`, `trangthai`) VALUES
(1, 'Nguyễn Cao ', 'Phong', '0924151679', '23 Ngô Gia Tự, P2, Q10', 1),
(2, 'Vy Văn', 'Chính', '0896846538', '54 Lí Thường Kiệt,P5,Q11', 1),
(3, 'Vy Văn', 'Chinh', '0896846538', '54 Lí Thường Kiệt,P5,Q11', 1),
(4, 'Hoàng', 'Thùy', '0795995953', '123 Cao Thắng, P10, Q10', 1),
(5, 'Hoàng', 'Thùy', '0795995953', '123 Cao Thắng, P10, Q10', 1),
(6, 'Nguyễn Thị', 'Vân', '0311110000', '54 Lí Thường Kiệt, P6, Q11', 1),
(7, 'Nguyễn Thị', 'Vân', '0311110000', '54 Lí Thường Kiệt, P6, Q11', 1),
(8, 'Ngô Phi', 'Long', '0896696994', '54 Lê Trọng Tấn, P10, Q.Tân Phú', 1),
(9, 'Ngô Phi', 'Long', '0896696994', '54 Lê Trọng Tấn, P10, Q.Tân Phú', 1),
(10, 'Nguyễn Thị', 'Lan', '0807997970', '87 Âu Cơ, P7, Q11', 1),
(11, 'Nguyễn Thị', 'Lan Anh', '0807997970', '87 Âu Cơ, P7, Q11', 1),
(12, 'Cao', 'Vân', '0899669611', '34 Sư Vạn Hạnh,P7,Q10', 1),
(13, 'Cao', 'Vân', '0899669611', '34 Sư Vạn Hạnh,P7,Q10', 1),
(14, 'Ngô', 'Hà', '0899089611', '39 Sư Vạn Hạnh,P3,Q10', 1),
(15, 'Đỗ', 'An', '1234567890', '46 Lê Đức Thọ, GV', 1),
(16, 'Đỗ', 'Mụi', '0123456789', '113 abc', 1),
(17, 'Lai', 'Sâm', '9876543201', '123 Nguyễn Văn Lượng', 1),
(18, 'Nguyễn', 'Đông', '0987654321', '1345', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `makm` int(11) NOT NULL,
  `tenkm` varchar(255) DEFAULT NULL,
  `quidinh` int(11) NOT NULL,
  `tilegiam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`makm`, `tenkm`, `quidinh`, `tilegiam`) VALUES
(0, 'Không có KM', 0, 0),
(1, 'KM hóa đơn trên 200,000', 200000, 5),
(2, 'KM hóa đơn trên 500,000', 500000, 8),
(3, 'KM hóa đơn trên 1,000,000', 1000000, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisach`
--

CREATE TABLE `loaisach` (
  `maloai` int(11) NOT NULL,
  `tenloai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisach`
--

INSERT INTO `loaisach` (`maloai`, `tenloai`) VALUES
(1, 'Tiểu thuyết'),
(2, 'Tản văn'),
(3, 'Kỹ năng sống'),
(4, 'Văn học - TIểu thuyết'),
(5, 'Văn học'),
(6, 'Trinh thám');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacc`
--

CREATE TABLE `nhacc` (
  `mancc` int(11) NOT NULL,
  `tenncc` varchar(255) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhacc`
--

INSERT INTO `nhacc` (`mancc`, `tenncc`, `diachi`, `sdt`) VALUES
(1, 'Nhà cung cấp ABC', '123 Trần Quốc Thảo quận 3, TPHCM', '093334567'),
(2, 'Nhà cung cấp Nhân Văn', '1 Trường Chinh, Tân Bình, TPHCM', '0226568905'),
(3, 'Nhà cung cấp Đông A', '14 Nguyễn Văn Bình, quận 1, TPHCM', '086678552');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `honv` varchar(255) DEFAULT NULL,
  `tennv` varchar(255) DEFAULT NULL,
  `sdt` varchar(11) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `luong` int(11) DEFAULT NULL,
  `tentk` varchar(255) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `honv`, `tennv`, `sdt`, `diachi`, `luong`, `tentk`, `trangthai`) VALUES
(1, 'Hoàng', 'Gia Hân', '0905012345', '252 Phạm Ngũ Lão, Q1,TPHCM', 3000000, 'AD01', 1),
(2, 'Ngô ', 'Gia Khánh', '0905678598', '23 Kinh Dương Vương, P5,Q6', 3000000, 'NV01', 1),
(3, 'Nguyễn ', 'Thái Hà', '09058574487', '16 Nguyễn Thị Minh Khai, P3, Q1', 3000000, 'NV02', 1),
(4, 'Phan', 'Linh', '0377426641', '45 Nguyen Van Luong', 4000000, 'NV03', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nxb`
--

CREATE TABLE `nxb` (
  `manxb` int(11) NOT NULL,
  `tennxb` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nxb`
--

INSERT INTO `nxb` (`manxb`, `tennxb`) VALUES
(0, 'NXB Lao động'),
(1, 'Nhã Nam'),
(2, 'NXB Trẻ'),
(3, 'NXB Văn hóa-Thông tin'),
(4, 'NXB Phụ Nữ'),
(5, 'NXB Thế giới'),
(6, 'NXB Văn hóa-Văn nghệ'),
(7, 'NXB Văn học');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `manhap` int(11) NOT NULL,
  `ngaynhap` date DEFAULT NULL,
  `tongtien` float(11,0) DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `mancc` int(11) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`manhap`, `ngaynhap`, `tongtien`, `manv`, `mancc`, `trangthai`) VALUES
(1, '2020-05-02', 730000, 1, 1, 1),
(2, '2020-05-02', 2300000, 2, 2, 1),
(3, '2020-04-15', 1990000, 3, 3, 1),
(4, '2020-04-12', 5250000, 1, 1, 1),
(5, '2020-03-09', 2480000, 3, 2, 1),
(6, '2020-04-16', 2480000, 1, 2, 1),
(7, '2020-03-11', 620000, 1, 2, 1),
(8, '2020-05-01', 7400000, 3, 3, 1),
(9, '2020-06-10', 140000, 1, 1, 1),
(10, '2020-06-18', 1600000, 1, 1, 1),
(11, '2020-06-19', 400000, 1, 3, 1),
(12, '2020-06-21', 632000, 1, 1, 1),
(13, '2020-06-21', 560000, 1, 1, 1),
(14, '2020-06-21', 560000, 1, 1, 1),
(15, '2020-06-21', 920000, 1, 1, 1),
(16, '2020-06-21', 616000, 1, 1, 1),
(17, '2020-06-21', 920000, 1, 1, 1),
(18, '2020-06-21', 168000, 1, 1, 1),
(19, '2020-06-21', 180000, 1, 3, 1),
(20, '2020-06-21', 1240000, 2, 2, 1),
(21, '2020-06-21', 300000, 2, 1, 1),
(22, '2020-06-21', 580000, 1, 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `masach` int(11) NOT NULL,
  `tensach` varchar(255) DEFAULT NULL,
  `soluong` int(255) DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL,
  `matg` int(11) DEFAULT NULL,
  `maloai` int(11) DEFAULT NULL,
  `manxb` int(11) DEFAULT NULL,
  `mancc` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`masach`, `tensach`, `soluong`, `dongia`, `matg`, `maloai`, `manxb`, `mancc`, `trangthai`) VALUES
(1, 'Kính Vạn Hoa tập 1', 8, 70000, 1, 4, 2, 1, 1),
(2, 'Kính Vạn Hoa tập 2', 8, 70000, 1, 4, 2, 1, 1),
(3, 'Kính Vạn Hoa tập 3', 10, 70000, 1, 4, 2, 1, 1),
(4, 'Kính Vạn Hoa tập 4', 10, 70000, 1, 4, 2, 1, 1),
(5, 'Kính Vạn Hoa tập 5', 10, 70000, 1, 4, 2, 1, 1),
(6, 'Kính Vạn Hoa tập 6', 18, 70000, 1, 4, 2, 1, 1),
(7, 'Kính Vạn Hoa tập 7', 20, 70000, 1, 4, 2, 1, 1),
(8, 'Kính Vạn Hoa tập 8', 20, 70000, 1, 4, 2, 1, 1),
(9, 'Kính Vạn Hoa tập 9', 10, 70000, 1, 4, 2, 1, 1),
(10, 'Nợ nhau lời tạm biệt', 10, 120000, 2, 2, 4, 2, 1),
(11, 'Cúc họa mi', 15, 130000, 2, 5, 5, 2, 1),
(12, 'Cà phê cùng Tony', 27, 75000, 3, 3, 2, 3, 1),
(13, 'Trên đường băng ', 10, 90000, 3, 3, 2, 3, 1),
(14, 'Harry Potter và Hòn đá Phù Thủy', 4, 200000, 4, 1, 2, 3, 1),
(15, 'Harry Potter và Phòng chứa Bí Mật', 5, 200000, 4, 1, 2, 3, 1),
(16, 'Harry Potter và Tên tù nhân ngục Azkaban', 5, 220000, 4, 1, 2, 3, 1),
(17, 'Harry Potter và Chiếc cốc lửa', 5, 230000, 4, 1, 2, 3, 1),
(18, 'Harry Potter và Hội Phượng Hoàng', 5, 230000, 4, 1, 2, 3, 1),
(19, 'Harry Potter và Hoàng Tử Lai', 4, 220000, 4, 1, 2, 3, 1),
(20, 'Harry Potter và Bảo bối Tử thần', 5, 250000, 4, 1, 2, 1, 1),
(21, 'Can trường bước tiếp ', 15, 75000, 5, 1, 6, 1, 1),
(22, 'Sẽ có cách đừng lo', 10, 70000, 5, 1, 7, 1, 1),
(23, 'Pháo đài số', 14, 250000, 6, 6, 3, 2, 1),
(24, 'Mật mã Da Vinci', 10, 250000, 6, 1, 3, 2, 1),
(25, 'Hỏa ngục', 30, 230000, 6, 1, 3, 2, 1),
(26, 'Thiên thần và ác quỷ', 6, 220000, 6, 1, 5, 1, 1),
(27, 'Chuyến tàu Viễn Đông', 15, 80000, 6, 6, 6, 2, 1),
(28, 'Bảy bước tới mùa hè', 20, 45000, 1, 1, 4, 3, 1),
(29, 'Homo sapien', 20, 100000, 6, 6, 7, 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `matg` int(11) NOT NULL,
  `tentg` varchar(255) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`matg`, `tentg`, `trangthai`) VALUES
(1, 'Nguyễn Nhật Ánh', 1),
(2, 'Liêu Hà Trinh', 1),
(3, 'Tony Buổi Sáng', 1),
(4, 'J.K.Rowling', 1),
(5, 'Tuệ Nghi', 1),
(6, 'Dan Brown', 1),
(7, 'Agatha Christie', 1),
(8, 'Đoàn Giỏi', 1),
(9, 'Mario Puzzo', 1),
(10, 'Anne', 0),
(11, 'Vikas Squarzt', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `tentk` varchar(255) NOT NULL,
  `matkhau` varchar(32) NOT NULL,
  `vaitro` varchar(255) DEFAULT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`tentk`, `matkhau`, `vaitro`, `trangthai`) VALUES
('abc', 'abc', 'User', 0),
('AD01', 'admin001', 'Admin', 1),
('NV01', 'user001', 'User', 1),
('NV02', 'user002', 'User', 1),
('NV03', 'user003', 'User', 1),
('NV04', 'abc', 'User', 0),
('xyz', 'xyz', 'User', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctnhap`
--
ALTER TABLE `ctnhap`
  ADD PRIMARY KEY (`masach`,`manhap`),
  ADD KEY `manhap` (`manhap`);

--
-- Chỉ mục cho bảng `ct_hd`
--
ALTER TABLE `ct_hd`
  ADD PRIMARY KEY (`mahd`,`masach`),
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `makm` (`makm`),
  ADD KEY `makh` (`makh`),
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`makm`);

--
-- Chỉ mục cho bảng `loaisach`
--
ALTER TABLE `loaisach`
  ADD PRIMARY KEY (`maloai`);

--
-- Chỉ mục cho bảng `nhacc`
--
ALTER TABLE `nhacc`
  ADD PRIMARY KEY (`mancc`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`),
  ADD KEY `tentk` (`tentk`);

--
-- Chỉ mục cho bảng `nxb`
--
ALTER TABLE `nxb`
  ADD PRIMARY KEY (`manxb`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`manhap`),
  ADD KEY `mancc` (`mancc`),
  ADD KEY `manv` (`manv`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`masach`),
  ADD KEY `matg` (`matg`),
  ADD KEY `maloai` (`maloai`),
  ADD KEY `manxb` (`manxb`),
  ADD KEY `mancc` (`mancc`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`matg`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`tentk`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `nhacc`
--
ALTER TABLE `nhacc`
  MODIFY `mancc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `manhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `masach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `matg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctnhap`
--
ALTER TABLE `ctnhap`
  ADD CONSTRAINT `ctnhap_ibfk_1` FOREIGN KEY (`manhap`) REFERENCES `phieunhap` (`manhap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ctnhap_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ct_hd`
--
ALTER TABLE `ct_hd`
  ADD CONSTRAINT `ct_hd_ibfk_1` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ct_hd_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`makm`) REFERENCES `khuyenmai` (`makm`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`tentk`) REFERENCES `taikhoan` (`tentk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`mancc`) REFERENCES `nhacc` (`mancc`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`matg`) REFERENCES `tacgia` (`matg`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`maloai`) REFERENCES `loaisach` (`maloai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`manxb`) REFERENCES `nxb` (`manxb`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_4` FOREIGN KEY (`mancc`) REFERENCES `nhacc` (`mancc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
