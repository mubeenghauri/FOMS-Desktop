
create table allOrders (
    ORDERID      varchar(10)  NOT NULL,
    CUSTOMERNAME varchar(24)  NOT NULL,
    PHONE        varchar(12)  NOT NULL,
    ADDRESS      varchar(12)  NOT NULL,
    ITEMS        varchar(512) NOT NULL,
    BILLAMMOUNT  int(5)       NOT NULL
);

CREATE TABLE admin (

  ADMINID varchar(10) NOT NULL,

  ADMINNAME varchar(40) NOT NULL,

  ADMINPASSWORD varchar(40) NOT NULL

):

​

-- --------------------------------------------------------

​

--

-- Table structure for table `foodorder`

--

​

CREATE TABLE foodorder (

  `ORDERNUM` int(11) NOT NULL,

  `ORDERID` varchar(10) NOT NULL,

  `CUSTOMERNAME` varchar(40) NOT NULL,

  `PRICE` int(11) NOT NULL

);

​

-- --------------------------------------------------------

​

--

-- Table structure for table `operator`

--

​

CREATE TABLE operator (

  OPERATORID varchar(10) NOT NULL,

  OPERATORNAME varchar(40) NOT NULL,

  OPERATORPASSWORD varchar(40) NOT NULL

);

​

-- --------------------------------------------------------

​

--

-- Table structure for table `sales`

--

CREATE TABLE sales (

  ORDERID varchar(10) NOT NULL,

  OPERATORID varchar(10) NOT NULL,

  TOTALBILL int(11) NOT NULL

):


create table approvedOrders(
    ORDERID varchar(10) NOT NULL,
    OPERATORID varchar(10) NOT NULL,
    ACCEPTDATE DATE NOT NULL
)
​

--

-- Indexes for dumped tables

--

​

--

-- Indexes for table `admin`

--

ALTER TABLE admin ADD PRIMARY KEY (`ADMINID`):

​

--

-- Indexes for table `foodorder`

--

ALTER TABLE foodorder ADD PRIMARY KEY (`ORDERID`):

​

--

-- Indexes for table `operator`

--

ALTER TABLE operator ADD PRIMARY KEY (`OPERATORID`):

​

--

-- Indexes for table `sales`

--

ALTER TABLE sales

  ADD KEY `ORDERID` (`ORDERID`),

  ADD KEY `OPERATORID` (`OPERATORID`),

  ADD KEY `ORDERID_2` (`ORDERID`);

COMMIT;


-- insertions

insert into operator(OPERATORID, OPERATORNAME, OPERATORPASSWORD) VALUES ('O-123','mubeen','beengh');


​

-- /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */

-- !40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS 

-- /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */


