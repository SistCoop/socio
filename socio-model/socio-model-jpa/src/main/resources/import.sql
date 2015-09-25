INSERT --
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the 'License');
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an 'AS IS' BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
INSERT INTO MONEDA_CUENTA_APORTE (ID,MONEDA,ESTADO,optlk) VALUES ('05add88c-3b1b-11e5-a151-feff819cdc9f','PEN','T','1/01/2015');

/*INSERT INTO SOCIO
(ID, TIPO_PERSONA, TIPO_DOCUMENTO,NUMERO_DOCUMENTO,
TIPO_DOCUMENTO_REPRESENTANTE_LEGAL,NUMERO_DOCUMENTO_REPRESENTANTE_LEGAL,
FECHA_INICIO,ESTADO,CUENTA_APORTE_ID,optlk) 
VALUES('05add88c-3b1b-11e5-a151-feff819cdc9f','NATURAL','DNI','46779354','DNI','11111111',''1/01/2015'','T','','1/01/2015'*/);