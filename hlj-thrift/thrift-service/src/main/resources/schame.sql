create table `admin` (
  `user_id` bigint(20) not null,
  `device_id` varchar(100) not null,
  `sponsor_id` bigint(20) not null default 0,
  `update_time` bigint(20) not null default 0,
  `status` int(10) not null default 0, #0:valid,-8:invalid
  KEY idx_device(`device_id`),
  PRIMARY KEY(`user_id`, `device_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
