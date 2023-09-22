USE [master]
GO
/****** Object:  Database [GAME_MANAGER_DB]    Script Date: 22/09/2023 16:45:16 ******/
CREATE DATABASE [GAME_MANAGER_DB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GAME_MANAGER_DB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\GAME_MANAGER_DB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'GAME_MANAGER_DB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\GAME_MANAGER_DB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [GAME_MANAGER_DB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GAME_MANAGER_DB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GAME_MANAGER_DB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET ARITHABORT OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET RECOVERY FULL 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET  MULTI_USER 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GAME_MANAGER_DB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [GAME_MANAGER_DB] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'GAME_MANAGER_DB', N'ON'
GO
ALTER DATABASE [GAME_MANAGER_DB] SET QUERY_STORE = OFF
GO
USE [GAME_MANAGER_DB]
GO
/****** Object:  User [devadel]    Script Date: 22/09/2023 16:45:16 ******/
CREATE USER [devadel] FOR LOGIN [devadel] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[forget_passwords]    Script Date: 22/09/2023 16:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[forget_passwords](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[code] [varchar](10) NOT NULL,
	[user_id] [bigint] NOT NULL,
	[date_created] [datetime] NULL,
 CONSTRAINT [pk_forget_passwords] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[games]    Script Date: 22/09/2023 16:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[games](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[company] [varchar](50) NOT NULL,
	[category] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[releaseDate] [datetime] NULL,
	[age] [tinyint] NOT NULL,
	[format] [varchar](10) NOT NULL,
	[version] [varchar](5) NOT NULL,
	[img] [varchar](100) NULL,
 CONSTRAINT [pk_games] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 22/09/2023 16:45:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[username] [varchar](30) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[email] [varchar](100) NULL,
	[date_created] [datetime] NULL,
 CONSTRAINT [pk_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_USERNAME_USERS] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[forget_passwords] ADD  DEFAULT (getdate()) FOR [date_created]
GO
ALTER TABLE [dbo].[users] ADD  DEFAULT (getdate()) FOR [date_created]
GO
ALTER TABLE [dbo].[forget_passwords]  WITH CHECK ADD  CONSTRAINT [fk_forget_passwords] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[forget_passwords] CHECK CONSTRAINT [fk_forget_passwords]
GO
USE [master]
GO
ALTER DATABASE [GAME_MANAGER_DB] SET  READ_WRITE 
GO
