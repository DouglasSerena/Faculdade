/* ========================================================== */
DROP VIEW viagens_do_dia_view;
CREATE VIEW viagens_do_dia_view
	AS SELECT * FROM viagens WHERE DATE(data_inicio) = DATE(NOW()); 

SELECT * FROM viagens_do_dia_view;

/* ========================================================== */

DROP VIEW viagens_iniciadas_view;
CREATE VIEW viagens_iniciadas_view
	AS SELECT * FROM viagens WHERE status = 'INICIADA'; 

SELECT * FROM viagens_iniciadas_view;

/* ========================================================== */

DROP VIEW viagens_em_espera_view;
CREATE VIEW viagens_em_espera_view
	AS SELECT * FROM viagens WHERE status = 'AGUARDANDO'; 

SELECT * FROM viagens_em_espera_view;

/* ========================================================== */

DROP VIEW viagens_finalizadas_view;
CREATE VIEW viagens_finalizadas_view
	AS SELECT * FROM viagens WHERE status = 'FINALIZADA'; 

SELECT * FROM viagens_finalizadas_view;

/* ========================================================== */
