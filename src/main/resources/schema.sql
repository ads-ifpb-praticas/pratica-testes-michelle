/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  miolivc
 * Created: Aug 15, 2017
 */

CREATE TABLE FILME (
    ID SERIAL PRIMARY KEY,
    TITULO VARCHAR(50) NOT NULL,
    GENERO VARCHAR(20) NOT NULL,
    DURACAO INTEGER NOT NULL
);


