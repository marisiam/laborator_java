create table masini (numar_inmatriculare char(7) not null primary key, marca varchar(20) not null, anul integer,
                      culoarea varchar(10), nr_km integer);

insert into masini (numar_inmatriculare, marca, anul, culoarea, nr_km) values ("CS92RRR", "Peugeout", 2011, "Gri", 250000);
insert into masini (numar_inmatriculare, marca, anul, culoarea, nr_km) values ("CS17CRR", "Dacia", 2007, "Gri", 380125);
insert into masini (numar_inmatriculare, marca, anul, culoarea, nr_km) values ("CS82FUN", "Ford", 2002, "Gri", 150000);
