CREATE DATABASE [Policy]
GO

CREATE TABLE [dbo].[Client](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Client Number]  AS ('CN'+right('00000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL,
	[First Name] [nvarchar](60) NOT NULL,
	[Last Name] [nvarchar](60) NOT NULL,
	[Gender] [varchar](30) NOT NULL,
	[Date of Birth] [date] NOT NULL,
	[Indentity Number] [varchar](30) NOT NULL,
	[Marital Status] [varchar](30) NOT NULL,
	[Address] [nvarchar](120) NOT NULL,
	[Country] [varchar](30) NOT NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[Client Number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


CREATE TABLE [dbo].[Motor](
	[ID] [INT] IDENTITY(1,1) NOT NULL,
	[Policy No] AS ('MT'+right('00000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL,
	[Inception Date] [DATE] NOT NULL,
	[Expiry Date] [DATE] NOT NULL,
	[Policy Owner] [VARCHAR](8) NOT NULL,
	[Engine No] [VARCHAR](30) NOT NULL,
	[Chassis No] [VARCHAR](30) NOT NULL,
	[Vehicle Registration No] [VARCHAR](30) NOT NULL,
	[Billing Currency] [VARCHAR](30) NOT NULL,
	[Sum Insured] [NUMERIC](17,2) NOT NULL,
	[Rate] [NUMERIC](7,5) NOT NULL,
	[Annual Premium] [NUMERIC](17,2) NULL,
	[Posted Premium] [NUMERIC](17,2) NULL,
	CONSTRAINT [PK_Motor] PRIMARY KEY CLUSTERED 
(
	[Policy No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Motor]
ADD FOREIGN KEY ([Policy Owner]) REFERENCES [dbo].[Client]([Client Number]);