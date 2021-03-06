USE [master]
GO
/****** Object:  Database [ClubManagerment3]    Script Date: 11/14/2018 4:46:28 PM ******/
CREATE DATABASE [ClubManagerment3]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ClubManagerment3', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.THANHSQL\MSSQL\DATA\ClubManagerment3.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ClubManagerment3_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.THANHSQL\MSSQL\DATA\ClubManagerment3_log.ldf' , SIZE = 204800KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [ClubManagerment3] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ClubManagerment3].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ClubManagerment3] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ClubManagerment3] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ClubManagerment3] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ClubManagerment3] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ClubManagerment3] SET ARITHABORT OFF 
GO
ALTER DATABASE [ClubManagerment3] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ClubManagerment3] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ClubManagerment3] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ClubManagerment3] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ClubManagerment3] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ClubManagerment3] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ClubManagerment3] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ClubManagerment3] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ClubManagerment3] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ClubManagerment3] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ClubManagerment3] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ClubManagerment3] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ClubManagerment3] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ClubManagerment3] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ClubManagerment3] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ClubManagerment3] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ClubManagerment3] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ClubManagerment3] SET RECOVERY FULL 
GO
ALTER DATABASE [ClubManagerment3] SET  MULTI_USER 
GO
ALTER DATABASE [ClubManagerment3] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ClubManagerment3] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ClubManagerment3] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ClubManagerment3] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ClubManagerment3] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ClubManagerment3', N'ON'
GO
ALTER DATABASE [ClubManagerment3] SET QUERY_STORE = OFF
GO
USE [ClubManagerment3]
GO
/****** Object:  Table [dbo].[Contest]    Script Date: 11/14/2018 4:46:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contest](
	[ContestId] [nvarchar](50) NOT NULL,
	[ContestName] [varchar](100) NULL,
	[startDateRegistration] [datetime] NULL,
	[endDateRegistration] [datetime] NULL,
	[StartDate] [datetime] NULL,
	[EndDate] [datetime] NULL,
	[ContestAddress] [nvarchar](100) NULL,
	[Status] [nvarchar](20) NULL,
	[Description] [nvarchar](1000) NULL,
 CONSTRAINT [PK__Contest__87DE0B1AF8FC4FAA] PRIMARY KEY CLUSTERED 
(
	[ContestId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContestInfo]    Script Date: 11/14/2018 4:46:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContestInfo](
	[ContestId] [nvarchar](50) NOT NULL,
	[PrizeId] [nvarchar](50) NOT NULL,
	[RewardRank] [int] NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_ContestInfo] PRIMARY KEY CLUSTERED 
(
	[ContestId] ASC,
	[PrizeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Prize]    Script Date: 11/14/2018 4:46:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prize](
	[PrizeId] [nvarchar](50) NOT NULL,
	[PrizeName] [varchar](50) NULL,
	[Price] [float] NULL,
	[Quantity] [int] NOT NULL,
	[Description] [nvarchar](1000) NULL,
 CONSTRAINT [PK__Prize__5C36F4DBF786A90F] PRIMARY KEY CLUSTERED 
(
	[PrizeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Contest]    Script Date: 11/14/2018 4:46:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Contest](
	[ContestId] [nvarchar](50) NOT NULL,
	[Username] [varchar](50) NOT NULL,
	[Rank] [varchar](50) NOT NULL,
 CONSTRAINT [PK_User_Contest_1] PRIMARY KEY CLUSTERED 
(
	[ContestId] ASC,
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 11/14/2018 4:46:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[Address] [nvarchar](100) NULL,
	[Birthdate] [date] NULL,
	[gender] [bit] NULL,
	[Role] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO1', N'chess gogo', CAST(N'2018-10-30T22:10:47.247' AS DateTime), CAST(N'2018-10-30T01:01:00.000' AS DateTime), CAST(N'2018-10-31T01:01:00.000' AS DateTime), CAST(N'2018-10-31T01:01:00.000' AS DateTime), N'FPT university', N'Not Start', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO10', N'Test Contest', CAST(N'2018-11-08T23:21:17.093' AS DateTime), CAST(N'2018-11-13T01:01:00.000' AS DateTime), CAST(N'2018-11-14T01:01:00.000' AS DateTime), CAST(N'2018-11-15T01:01:00.000' AS DateTime), N'FPT university', N'Not Start', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO15', N'Test Contest', CAST(N'2018-11-12T13:27:37.213' AS DateTime), CAST(N'2018-11-20T01:01:00.000' AS DateTime), CAST(N'2018-11-21T01:01:00.000' AS DateTime), CAST(N'2018-11-22T01:01:00.000' AS DateTime), N'FPT university', N'Not Start', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO2', N'chess meomeo', CAST(N'2018-10-25T22:15:03.587' AS DateTime), CAST(N'2018-10-26T01:01:00.000' AS DateTime), CAST(N'2018-10-27T01:01:00.000' AS DateTime), CAST(N'2018-10-27T14:02:00.000' AS DateTime), N'FPT university', N'Not Start', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO3', N'chess gogo', CAST(N'2018-10-25T22:27:23.943' AS DateTime), CAST(N'2018-10-01T01:01:00.000' AS DateTime), CAST(N'2018-10-01T14:22:00.000' AS DateTime), CAST(N'2018-10-25T14:02:00.000' AS DateTime), N'FPT university', N'Not Start', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO4', N'chess', CAST(N'2018-10-25T22:29:26.287' AS DateTime), CAST(N'2018-10-04T04:01:00.000' AS DateTime), CAST(N'2018-10-05T05:02:00.000' AS DateTime), CAST(N'2018-10-06T05:01:00.000' AS DateTime), N'FPT university', N'Not Start', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO5', N'chess gogo', CAST(N'2018-10-25T22:35:41.190' AS DateTime), CAST(N'2017-10-01T01:01:00.000' AS DateTime), CAST(N'2018-10-17T01:01:00.000' AS DateTime), CAST(N'2018-10-26T01:01:00.000' AS DateTime), N'FPT university', N'Finished', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[Contest] ([ContestId], [ContestName], [startDateRegistration], [endDateRegistration], [StartDate], [EndDate], [ContestAddress], [Status], [Description]) VALUES (N'COO6', N'chess gogo', CAST(N'2018-11-04T17:17:12.917' AS DateTime), CAST(N'2018-11-05T01:01:00.000' AS DateTime), CAST(N'2018-11-06T01:01:00.000' AS DateTime), CAST(N'2018-11-07T01:01:00.000' AS DateTime), N'FPT university', N'Doing', N'Play does not involve hidden information. Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each of the six piece types moves differently')
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO1', N'P002', 1, 2, 3000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO1', N'P003', 2, 2, 7000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO1', N'P004', 1, 3, 3000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO10', N'P002', 1, 3, 3000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO10', N'P003', 3, 3, 7000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO10', N'P004', 2, 3, 3000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO10', N'P005', 1, 10, 3000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO15', N'P002', 1, 3, 3000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO15', N'P003', 1, 3, 7000)
INSERT [dbo].[ContestInfo] ([ContestId], [PrizeId], [RewardRank], [quantity], [price]) VALUES (N'COO15', N'P004', 1, 3, 3000)
INSERT [dbo].[Prize] ([PrizeId], [PrizeName], [Price], [Quantity], [Description]) VALUES (N'P002', N'dog', 3000, 2, N'The classic mine-finding game. Search tiles to uncover clues and figure out where all the mines are. Sweep the entire area and flag all of the mines to win!

Advertisement


Advertisement


Advertisement


CARD GAMES
 Crazy Eights GameCrazy Eights
It''s the classic game. Empty your hand first!

 Hearts GameHearts
The classic card game is here!

 Magic Solitaire GameMagic Solitaire
Clear all of the cards from the table.

 FreeCell GameFreeCell
Stack the cards into the right ')
INSERT [dbo].[Prize] ([PrizeId], [PrizeName], [Price], [Quantity], [Description]) VALUES (N'P003', N'Duck', 7000, 2, N'In life, as in chess, oneÃÂ¢ÃÂÃÂs own pawns block oneÃÂ¢ÃÂÃÂs way.  A manÃÂ¢ÃÂÃÂs very wealthy, ease, leisure, children, books, which should help him to win, more often checkmate him')
INSERT [dbo].[Prize] ([PrizeId], [PrizeName], [Price], [Quantity], [Description]) VALUES (N'P004', N'Iphone', 3000, 1, N'')
INSERT [dbo].[Prize] ([PrizeId], [PrizeName], [Price], [Quantity], [Description]) VALUES (N'P005', N'samsung', 3000, 0, N'')
INSERT [dbo].[User_Contest] ([ContestId], [Username], [Rank]) VALUES (N'COO1', N'TestUser', N'None')
INSERT [dbo].[User_Contest] ([ContestId], [Username], [Rank]) VALUES (N'COO10', N'Chuoi', N'2')
INSERT [dbo].[User_Contest] ([ContestId], [Username], [Rank]) VALUES (N'COO10', N'LuLu', N'None')
INSERT [dbo].[User_Contest] ([ContestId], [Username], [Rank]) VALUES (N'COO10', N'Thuong', N'1')
INSERT [dbo].[User_Contest] ([ContestId], [Username], [Rank]) VALUES (N'COO10', N'Vinh', N'3')
INSERT [dbo].[User_Contest] ([ContestId], [Username], [Rank]) VALUES (N'COO15', N'TestUser', N'1')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'Chuoi', N'1', N'chuoi@mail.com', N'1234543211', N'Sai Gon', CAST(N'1998-11-15' AS Date), 1, N'user')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'LuLu', N'1', N'lulu@gmail.com', N'1231234543', N'HCM', CAST(N'2000-10-01' AS Date), 1, N'user')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'TestAdmin', N'1', N'testAd@gmail.com', N'1234123412', N'nha trang', CAST(N'1999-10-10' AS Date), 1, N'admin')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'TestUser', N'1', N'test@gmail.com', N'1212123456', N'ha noi', CAST(N'1998-11-11' AS Date), 0, N'user')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'Thanh', N'1', N'thanhngo@gmail.com', N'1234567890', N'HCM', CAST(N'1998-02-10' AS Date), 0, N'admin')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'Thuong', N'1', N'thuong@gmail.com', N'1234567891', N'Dong nai', CAST(N'1998-02-14' AS Date), 0, N'user')
INSERT [dbo].[Users] ([Username], [Password], [Email], [Phone], [Address], [Birthdate], [gender], [Role]) VALUES (N'Vinh', N'1', N'vinh@gmail.com', N'1123456789', N'Sai Gon', CAST(N'2000-10-29' AS Date), 0, N'user')
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Users__5C7E359EF4D3BC8A]    Script Date: 11/14/2018 4:46:28 PM ******/
ALTER TABLE [dbo].[Users] ADD UNIQUE NONCLUSTERED 
(
	[Phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Users__A9D105342EDDBC5B]    Script Date: 11/14/2018 4:46:28 PM ******/
ALTER TABLE [dbo].[Users] ADD UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Prize] ADD  CONSTRAINT [DF__Prize__Quantity__1DB06A4F]  DEFAULT ((0)) FOR [Quantity]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ('user') FOR [Role]
GO
ALTER TABLE [dbo].[ContestInfo]  WITH CHECK ADD  CONSTRAINT [FK__ContestIn__Conte__58D1301D] FOREIGN KEY([ContestId])
REFERENCES [dbo].[Contest] ([ContestId])
GO
ALTER TABLE [dbo].[ContestInfo] CHECK CONSTRAINT [FK__ContestIn__Conte__58D1301D]
GO
ALTER TABLE [dbo].[ContestInfo]  WITH CHECK ADD  CONSTRAINT [FK__ContestIn__Prize__57DD0BE4] FOREIGN KEY([PrizeId])
REFERENCES [dbo].[Prize] ([PrizeId])
GO
ALTER TABLE [dbo].[ContestInfo] CHECK CONSTRAINT [FK__ContestIn__Prize__57DD0BE4]
GO
ALTER TABLE [dbo].[User_Contest]  WITH CHECK ADD  CONSTRAINT [FK_User_Contest_Contest] FOREIGN KEY([ContestId])
REFERENCES [dbo].[Contest] ([ContestId])
GO
ALTER TABLE [dbo].[User_Contest] CHECK CONSTRAINT [FK_User_Contest_Contest]
GO
ALTER TABLE [dbo].[User_Contest]  WITH CHECK ADD  CONSTRAINT [FK_User_Contest_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[User_Contest] CHECK CONSTRAINT [FK_User_Contest_Users]
GO
USE [master]
GO
ALTER DATABASE [ClubManagerment3] SET  READ_WRITE 
GO
