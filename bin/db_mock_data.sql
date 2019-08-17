--mock基本信息
delete from employee;
INSERT INTO employee(employee_name) VALUES ('张三1');
INSERT INTO employee(employee_name) VALUES ('张三2');
INSERT INTO employee(employee_name) VALUES ('张三3');
INSERT INTO employee(employee_name) VALUES ('张三4');
INSERT INTO employee(employee_name) VALUES ('张三5');
INSERT INTO employee(employee_name) VALUES ('张三6');
INSERT INTO employee(employee_name) VALUES ('张三7');
INSERT INTO employee(employee_name) VALUES ('张三8');
INSERT INTO employee(employee_name) VALUES ('张三9');
INSERT INTO employee(employee_name) VALUES ('张三10');
INSERT INTO employee(employee_name) VALUES ('张三11');
INSERT INTO employee(employee_name) VALUES ('张三12');
INSERT INTO employee(employee_name) VALUES ('张三13');
INSERT INTO employee(employee_name) VALUES ('张三14');
INSERT INTO employee(employee_name) VALUES ('张三15');
INSERT INTO employee(employee_name) VALUES ('张三16');
INSERT INTO employee(employee_name) VALUES ('张三17');
INSERT INTO employee(employee_name) VALUES ('张三18');
INSERT INTO employee(employee_name) VALUES ('张三19');
INSERT INTO employee(employee_name) VALUES ('张三20');
INSERT INTO employee(employee_name) VALUES ('张三21');
INSERT INTO employee(employee_name) VALUES ('张三22');
INSERT INTO employee(employee_name) VALUES ('张三23');
INSERT INTO employee(employee_name) VALUES ('张三24');
INSERT INTO employee(employee_name) VALUES ('张三25');
INSERT INTO employee(employee_name) VALUES ('张三26');
INSERT INTO employee(employee_name) VALUES ('张三27');
INSERT INTO employee(employee_name) VALUES ('张三28');
INSERT INTO employee(employee_name) VALUES ('张三29');
INSERT INTO employee(employee_name) VALUES ('张三30');
INSERT INTO employee(employee_name) VALUES ('张三31');
INSERT INTO employee(employee_name) VALUES ('张三32');
INSERT INTO employee(employee_name) VALUES ('张三33');
INSERT INTO employee(employee_name) VALUES ('张三34');
INSERT INTO employee(employee_name) VALUES ('张三35');
INSERT INTO employee(employee_name) VALUES ('张三36');
INSERT INTO employee(employee_name) VALUES ('张三37');
INSERT INTO employee(employee_name) VALUES ('张三38');
INSERT INTO employee(employee_name) VALUES ('张三39');
INSERT INTO employee(employee_name) VALUES ('张三40');
INSERT INTO employee(employee_name) VALUES ('张三41');
INSERT INTO employee(employee_name) VALUES ('张三42');
INSERT INTO employee(employee_name) VALUES ('张三43');
INSERT INTO employee(employee_name) VALUES ('张三44');
INSERT INTO employee(employee_name) VALUES ('张三45');
INSERT INTO employee(employee_name) VALUES ('张三46');
INSERT INTO employee(employee_name) VALUES ('张三47');
INSERT INTO employee(employee_name) VALUES ('张三48');
INSERT INTO employee(employee_name) VALUES ('张三49');
INSERT INTO employee(employee_name) VALUES ('张三50');
INSERT INTO employee(employee_name) VALUES ('张三51');
INSERT INTO employee(employee_name) VALUES ('张三52');
INSERT INTO employee(employee_name) VALUES ('张三53');
INSERT INTO employee(employee_name) VALUES ('张三54');
INSERT INTO employee(employee_name) VALUES ('张三55');
INSERT INTO employee(employee_name) VALUES ('张三56');
INSERT INTO employee(employee_name) VALUES ('张三57');
INSERT INTO employee(employee_name) VALUES ('张三58');
INSERT INTO employee(employee_name) VALUES ('张三59');
INSERT INTO employee(employee_name) VALUES ('张三60');
INSERT INTO employee(employee_name) VALUES ('张三61');
INSERT INTO employee(employee_name) VALUES ('张三62');
INSERT INTO employee(employee_name) VALUES ('张三63');
INSERT INTO employee(employee_name) VALUES ('张三64');
INSERT INTO employee(employee_name) VALUES ('张三65');
INSERT INTO employee(employee_name) VALUES ('张三66');
INSERT INTO employee(employee_name) VALUES ('张三67');
INSERT INTO employee(employee_name) VALUES ('张三68');
INSERT INTO employee(employee_name) VALUES ('张三69');
INSERT INTO employee(employee_name) VALUES ('张三70');
INSERT INTO employee(employee_name) VALUES ('张三71');
INSERT INTO employee(employee_name) VALUES ('张三72');
INSERT INTO employee(employee_name) VALUES ('张三73');
INSERT INTO employee(employee_name) VALUES ('张三74');
INSERT INTO employee(employee_name) VALUES ('张三75');
INSERT INTO employee(employee_name) VALUES ('张三76');
INSERT INTO employee(employee_name) VALUES ('张三77');
INSERT INTO employee(employee_name) VALUES ('张三78');
INSERT INTO employee(employee_name) VALUES ('张三79');
INSERT INTO employee(employee_name) VALUES ('张三80');
INSERT INTO employee(employee_name) VALUES ('张三81');
INSERT INTO employee(employee_name) VALUES ('张三82');
INSERT INTO employee(employee_name) VALUES ('张三83');
INSERT INTO employee(employee_name) VALUES ('张三84');
INSERT INTO employee(employee_name) VALUES ('张三85');
INSERT INTO employee(employee_name) VALUES ('张三86');
INSERT INTO employee(employee_name) VALUES ('张三87');
INSERT INTO employee(employee_name) VALUES ('张三88');
INSERT INTO employee(employee_name) VALUES ('张三89');
INSERT INTO employee(employee_name) VALUES ('张三90');
INSERT INTO employee(employee_name) VALUES ('张三91');
INSERT INTO employee(employee_name) VALUES ('张三92');
INSERT INTO employee(employee_name) VALUES ('张三93');
INSERT INTO employee(employee_name) VALUES ('张三94');
INSERT INTO employee(employee_name) VALUES ('张三95');
INSERT INTO employee(employee_name) VALUES ('张三96');
INSERT INTO employee(employee_name) VALUES ('张三97');
INSERT INTO employee(employee_name) VALUES ('张三98');
INSERT INTO employee(employee_name) VALUES ('张三99');
INSERT INTO employee(employee_name) VALUES ('张三100');
INSERT INTO employee(employee_name) VALUES ('张三101');

commit;

UPDATE employee e 
SET 
    e.`birthday` = DATE_ADD(MAKEDATE(1970,1), INTERVAL e.`employee_id` MONTH),
    e.`zodiac` = IF(FLOOR(0 + (RAND() * 3)) = 0, '虎', '牛'),
    e.`gender` = IF(FLOOR(0 + (RAND() * 3)) = 0, '男', '女'),
    e.`province` = IF(FLOOR(0 + (RAND() * 3)) = 0, '河南省', '安徽省'),
    e.`id_no` = IF(FLOOR(0 + (RAND() * 3)) = 0, '100000000000000000', '200000000000000000'),
    e.`height` = 160 + FLOOR(0 + RAND() * 10),
    e.`weight` = 100 - FLOOR(0 + RAND() * 15),
    e.`education` = IF(FLOOR(0 + (RAND() * 3)) = 0, '大专', '高中'),
    e.`working_age` = FLOOR(0 + RAND() * 5),
    e.`certification` = IF(FLOOR(0 + RAND() * 3) = 0, '育婴师证', '育婴师证|健康证'),
    e.`work_type` = IF(FLOOR(0 + RAND() * 3) = 0, '育婴师', '育婴师|住家保姆'),
    e.`expected_pay` = 7000 + FLOOR(1000 + RAND() * 3000),
    e.`picture_id` = 'pic_001.png',
    e.`added_by` = IF(FLOOR(0 + RAND() * 2) = 0, '王五', '李四'),
    e.`updated_by` = IF(FLOOR(0 + RAND() * 2) = 0, '王五', '李四'),
    e.`added_date` = DATE_ADD(MAKEDATE(2019,1), INTERVAL e.`employee_id` DAY),
    e.`updated_date` = DATE_ADD(MAKEDATE(2019,100), INTERVAL e.`employee_id` DAY),
    e.`mobile_no` = 13200000000 + e.`employee_id`;

UPDATE employee e SET e.`age` = FLOOR(DATEDIFF(NOW(), e.`birthday`)/365);
commit;

--mock工作经验
delete from working_history;
insert into working_history(employee_id, des, start_date, end_date, added_by, added_date, updated_by, updated_date) 
select employee_id, concat('工作经历样例', floor(0 + rand() * 10)), 
       date_sub(now(), interval (floor(0 + rand() * 10)) year), 
       date_sub(now(), interval (floor(0 + rand() * 10)) year),
       added_by, added_date, updated_by, updated_date
from employee;
