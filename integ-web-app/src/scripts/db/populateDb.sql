insert into geoarea VALUES
  (null, 'IN', 'India'),
  (null, 'KA', 'Karnataka'),
  (null, 'BLR', 'Bangalore'),
  (null, 'MYS', 'Mysore');

insert into country VALUES
  ((select `id` from geoarea where `name` = 'India'));

insert into state VALUES
  ((select `id` from geoarea where `name` = 'Karnataka'),(select c.`id` from country c, geoarea g where g.id = c.id and g.`name` = 'India'));

insert into city VALUES
  ((select `id` from geoarea where `name` = 'Bangalore'), (select s.`id` from state s, geoarea g where g.id = s.id and g.`name` = 'Karnataka')),
  ((select `id` from geoarea where `name` = 'Mysore'), (select s.`id` from state s, geoarea g where g.id = s.id and g.`name` = 'Karnataka'));


