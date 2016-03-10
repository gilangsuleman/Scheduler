--lab--
create table lab(
id varchar(255) primary key,
nama varchar(255) not null
)Engine=InnoDB;

--Tabel user--
create table user(
id varchar(255) primary key,
username varchar(255) not null,
email varchar(255) not null unique,
fullname varchar(255) not null
)Engine=InnoDB;

--tabel permission--
create table permission(
id varchar(255) primary key,
kode varchar(255) not null unique,
nama varchar(255) not null
)Engine=InnoDB;

--tabel dosen--
create table dosen(
id varchar(255) primary key,
nama varchar(255) not null,
nip varchar(255) not null,
nipy varchar(255) not null, 
hp varchar(255) not null,
email varchar(255) not null unique,
alamat varchar(255) not null
)Engine=InnoDB;

--tabel kelas--
create table kelas(
id varchar(255) primary key,
nama varchar(255) not null
)Engine=InnoDB;

--table matakuliah--
create table matakuliah(
id varchar(255) primary key,
kode varchar(255) not null unique,
nama varchar(255) not null,
sks varchar(255) not null,
prodi varchar(255) not null,
jam varchar(255) not null
)Engine=InnoDB;

--table program studi--
create table prodi(
id varchar(255) primary key unique,
nama varchar(255) not null,
singkatan varchar(255) not null,
ketua varchar(255) not null
)Engine=InnoDB;

--tabel ruangan--
create table ruangan(
id varchar(255) primary key,
nama varchar(255) not null,
kapasitas varchar(255) not null
)Engine=InnoDB;

--tabel semester--
create table semester(
id varchar(255) primary key,
tingkat varchar(255) not null
)Engine=InnoDB;

--tabel tahun akademik--
create table tahunakademik(
id varchar(255) primary key,
tahun varchar(255) not null
)Engine=InnoDB;
