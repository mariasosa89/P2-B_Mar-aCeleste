/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author USUARIO
 */
public class reportess {
    
    CREATE TABLE 'participantes' (            
                'ID' bigint(21) NOT NULL,               
                'NOMBRE' varchar(100) NOT NULL,         
                'USERNAME' varchar(100) NOT NULL,       
                'PASSWORD' varchar(100) NOT NULL,       
                'COMENTARIOS' varchar(100) default NULL,
                PRIMARY KEY  ('ID')                     
              ) ENGINE=InnoDB DEFAULT CHARSET=latin1

                insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (1,'Participante 1','par1user','part1pass','comentarios participante 1');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (2,'Participante 2','par2user','part2pass','comentarios participante 2');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (3,'Participante 3','par3user','part3pass','comentarios participante 3');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (4,'Participante 4','par4user','part4pass','comentarios respecto al participante 4');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (5,'Participante 5','par5user','part5pass','sin comentarios para el participante 5');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (6,'Participante 6','par6user','part6pass',NULL);
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (7,'Participante 7','par7user','part7pass','comentatios participante 7');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (8,'Participante 8','par8user','part8pass','comentarios participante 8');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (9,'Participante 9','par9user','part9pass','comentarios participante 9');
insert  into 'participantes'('ID','NOMBRE','USERNAME','PASSWORD','COMENTARIOS') values (10,'Participante 10','par10user','part10pass',NULL);
}
