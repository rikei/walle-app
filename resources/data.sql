CREATE TABLE
    `testdb`.tb_employee
(
    id INT AUTO_INCREMENT,
    last_name VARCHAR(40),
    email VARCHAR(40),
    gender INT,
    age INT,
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO tb_employee (last_name, email, gender, age) VALUES ('xiaohong', '2@qq.com', 2, 22);
INSERT INTO tb_employee (last_name, email, gender, age) VALUES ('xiaoming', '1@qq.com', 1, 20);
INSERT INTO tb_employee (last_name, email, gender, age) VALUES ('东方不败', 'dfbb@163.com', 1, 20);
INSERT INTO tb_employee (last_name, email, gender, age) VALUES ('东方不败', 'dfbb@163.com', 1, 20);
INSERT INTO tb_employee (last_name, email, gender, age) VALUES ('东方不败', 'dfbb@163.com', 1, 20);
