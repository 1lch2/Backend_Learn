# 数据库 - 事务
## 概念
事务（Transaction）是并发控制的基本单位。

将一组操作看作一个单元，这一单元可以全部成功，在部分失败的情况下，可以完全回滚，就像没有发生，这一组操作称为事务（Transaction）

## 事务的特性（ACID）
### 原子性（Atomicity）
事务中的原子性，并不是指事务具有不被中断影响的特点，它仅仅是指，事务中的所有操作应该被看作不可分割的一组指令，任何一个指令不能独立存在，要么全部成功执行，要么全部不发生（也就是回滚）

原子性不止为开发者保证了事务的可靠性（不会因为数据库出错而产生脏数据），还能让开发者手动回滚，提供了业务的便利性。

### 一致性（Consistency）
一致性是指事务是否产生非预期中间状态或结果。

比如脏读和不可重复读，产生了非预期中间状态，脏写与丢失修改则产生了非预期结果。

一致性实际上是由隔离性去进一步保证的，隔离性达到要求，则可以满足一致性。也就是说，**隔离不足会导致事务不满足一致性要求**。

### 隔离性（Isolation）
隔离性就是多个事务互不影响，感觉不到对方存在，这个特性就是为了做并发控制。

为了达到串行效果，目前采用的方式一般是两阶段加锁（Two Phase Locking），但是读写都加锁效率非常低，读写之间只能排队执行，有时候为了效率，原则是可以妥协的，于是隔离性并不严格，它被分为了多种级别，从高到低分别为：

- 可串行化（Serializable）
    - 在隔离级别为Serializable时，就会感觉到事务像一个完完全全的原子操作，不被任何中断、并发所影响。
- 可重复读（Read Repeatable）
- 已提交读（Read Committed）
- 未提交读（Read Uncommitted）

SQL标准对各个隔离级别允许出现的问题如下表所示：
| 隔离级别                     | 脏读         | 不可重复读   | 幻读         |
|------------------------------|--------------|--------------|--------------|
| 未提交读（read uncommitted） | possible     | possible     | possible     |
| 已提交读（read committed）   | not possible | possible     | possible     |
| 可重复读（repeatable read）  | not possible | not possible | possible     |
| 可串行化（serializable）     | not possible | not possible | not possible |

### 持久性（Duration）
事务成功提交后，对数据的修改永久的，即使系统发生故障，也不会丢失。
