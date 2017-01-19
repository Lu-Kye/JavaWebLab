DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(50) NOT NULL UNIQUE COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
  `name` varchar(50)  COMMENT '姓名',
  `age` int  COMMENT '年龄',
  `sex` int  COMMENT '性别',
  `birthday` datetime NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL
) ENGINE InnoDB CHARSET 'utf8' COMMENT '用户';
