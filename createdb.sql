CREATE TABLE NhanCong (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    ngaySinh DATE,
    diaChi VARCHAR(255),
    email VARCHAR(255),
    maNC VARCHAR(255) UNIQUE
);

CREATE TABLE DauViec (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    moTa TEXT,
    thoiHan DATE,
    maDV VARCHAR(255) UNIQUE
);

CREATE TABLE NhanCongDauViec (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idNhanCong INT,
    idDauViec INT,
    FOREIGN KEY (idNhanCong) REFERENCES NhanCong(id),
    FOREIGN KEY (idDauViec) REFERENCES DauViec(id)
);