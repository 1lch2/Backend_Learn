# MySQL 存储引擎
通过 show engines 命令来查看 MySQL 支持的所有存储引擎

MySQL默认的存储引擎为 InnoDB

## 存储引擎架构
MySQL 存储引擎采用的是插件式架构，支持多种存储引擎，我们甚至可以为不同的数据库表设置不同的存储引擎以适应不同场景的需要。

存储引擎是基于**表**的，而不是数据库。

MySQL 5.5.5 之前，MyISAM 是 MySQL 的默认存储引擎。5.5.5 版本之后，InnoDB 是 MySQL 的默认存储引擎。

