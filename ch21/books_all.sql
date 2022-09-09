/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.29 : Database - books
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `books`;

/*Table structure for table `act_evt_log` */

DROP TABLE IF EXISTS `act_evt_log`;

CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_evt_log` */

/*Table structure for table `act_ge_bytearray` */

DROP TABLE IF EXISTS `act_ge_bytearray`;

CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ge_bytearray` */

insert  into `act_ge_bytearray`(`ID_`,`REV_`,`NAME_`,`DEPLOYMENT_ID_`,`BYTES_`,`GENERATED_`) values 
('12502',1,'D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\diagram.bpmn','12501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('12503',1,'D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\one-task-process.bpmn20.xml','12501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<definitions\r\n        xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\r\n        xmlns:activiti=\"http://activiti.org/bpmn\"\r\n        targetNamespace=\"Examples\">\r\n\r\n    <process id=\"oneTaskProcess\" name=\"The One Task Process\">\r\n        <startEvent id=\"theStart\" />\r\n        <sequenceFlow id=\"flow1\" sourceRef=\"theStart\" targetRef=\"theTask\" />\r\n        <userTask id=\"theTask\" name=\"my task\" />\r\n        <sequenceFlow id=\"flow2\" sourceRef=\"theTask\" targetRef=\"theEnd\" />\r\n        <endEvent id=\"theEnd\" />\r\n    </process>\r\n\r\n</definitions>',0),
('12504',1,'D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\diagram.Process_0wu4lop.png','12501','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('15002',1,'processes/diagram.bpmn','15001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('15003',1,'processes/diagram.Process_0wu4lop.png','15001','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('17502',1,'processes/diagram.bpmn','17501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('17503',1,'processes/diagram.Process_0wu4lop.png','17501','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('20002',1,'processes/diagram.bpmn','20001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('20003',1,'processes/diagram.Process_0wu4lop.png','20001','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('20006',1,'processes/diagram.bpmn','20005','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('20007',1,'processes/diagram.Process_0wu4lop.png','20005','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('22502',1,'processes/diagram.bpmn','22501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\" name=\"A test process\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('22503',1,'processes/diagram.Process_0wu4lop.png','22501','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('22506',1,'processes/diagram.bpmn','22505','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\" name=\"A test process\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('22507',1,'processes/diagram.Process_0wu4lop.png','22505','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0LIDATx^íÝ[Œ]Õyp@/©¸)RBUSÔ”‡¼„Òžh^\"EbÎØÅŽíà(2ì¨p\0%Bm’Z$F¡5‰”<Ä²Cä[j«¡»æRœÕƒÛÔöxÆølfwÏô°f<Ì²™3{Ù¿ŸôiÎÙ×%Ï¬¿×ÞgŸ½/º\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ŠöÖ[oýùªU«6-]ºôÄ’%K>X¼xqõío»jµZÕüùó«»îºkøž{î9õÀì¿ûî»ï«W¹$Ýpxá…þõ‘G9uÛm·U?ÿùÏ«­[·V;wî¬«?ã}Lù±Üœ9sªE‹êííý«t›ÀyêÕW_½ÿÑG=õ­o}«zöÙg«vHLV,ëE€,\\¸pOOOÏõé>€óDÝç/]³fÍÿF`<ñÄÕ±cÇÒLÈëÇvfÍšUõõõý ÝP¸ºŸ_÷ä“O¾ÿï|§êïïO3àœÄö\"ŒêÈ¿§û\nU÷íë~üãßwß}ÕáÃ‡Ó~ÿ‰ˆíÆùo|ã;Óý…©ûô¥+V¬x?Bã½÷ÞKûû\'*¶ŸÀÌœ9smÚ  qNcÁ‚S6ÒHÅ~êC–áÞÞÞ‡Ò¶\0Ø¶mÛ’8÷ðIŸÓø8±¿zÔ1üµ¯}í/Ó6\r¹Æ§Óá\'?ùÉ©V«õRÚ& Áââ®m=z4íÓ]ûíëë‹C‰A)âŠÐ_üâiîªz´ó~=êØž¶\rh #GŽüE|ÇäàÁƒi_îªØÿŒ3>X²dÉŸ¤m\ZfõêÕ¿‰k*š`Þ¼y\'ëÃ•ÛÒ6\r³téÒwãiM°lÙ²õáÊói†‰¯ÆÇ·Y›`Ó¦M\'zzzö§m\ZfÑ¢E]¿vãLvìØq²qOÛ4Lœ\Z\ZJûð´®ƒãTÚF aúúúª“\'O¦}xZÔíˆà¨Ò6\rwôjÊˆc`` UŒ8 éî¼óÎá¦œãØ¾}ûÛÎq@î½÷ÞSMùTeÝºuC>UÜÿýû›rÇƒ>¸ÏuP€Å‹ßÓ”+GgÌ˜qÂ•£P€ønÈÜ¹s§ý»*ûöí;Z‡†ïª@)â¹\'ÓýíØú0e—oÇBAâ>ñÜ“éºÇÐÐÐñm¸&–4]w\0»ãŽ;þè`P ¸çg<,©Û×tlÙ²eWŒ6Üs\nOX‹+I»u—ó·ê‘FÜƒÃ]Î¡dñ„µøxvªŸ«ònmæÌ™ÇëàøuÚ @ñ„µxXÒT<b¤q:4v¤û\nOX‹‡%}Òç<âœF|‘ÍHÎSqî!–Ï=9×§Õ×£—ãñéÉé]Ó€óYOOÏõñQi<÷dùòåï×‡i&LèÍ7ß<ú½ï}¯ýÉIl\'¶—î8OÅÅYqeg@Ü¼…¼÷Ý±cÇ©C‡\r×1|ðàÁ“¯½öÚÛk×®|è¡‡ÞŒïžÔëD`Äz.î‚Ø%·Þzëüøk|>îŸqúœEuúçñÓÓŸåbùt\0mé4€		 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0²	 ›à\0&ÔÛÛ{8‚b¢ŠeÒõ€X\nÓ H+–I×.p:Œ6€qM4ê0Ú\0Îh¼Q‡Ñ0¡ñFFÀÇêum\0“Ò9ê0Ú\0&mdÔ‘N8£‘QG:˜\"UUýiÿžçŸ¾Z¿~}µvíZÕåŠ÷Í›7°aÃ†ï§¿h¤M›6U¨Nœ8Q½÷Þ{ªËÿîñï¿qãÆá:H–¤¿#hœiÄmúÇ¬º_û÷ïà8žþŽ qb˜l¤ÑŒŠßCº¤¿#hœøCMÿ€Õô•à 9Áñî‰·«Ý/VÿóŸU»_þ·1óÕ¹—à “	ŽÃ^¯v¿ôLõß¿þ»êåÕw·kÇæGÆ,§Î½E8Sp¼sìpµï÷ÏUÛ7ü`4,ÚµfQÕÿâòêø\'T§¢E/8Þ>z°úýÆ‡?\Z§+F1/­?üæïëÃ˜ßÙ–Ê+ÁAÆŽ?lúÇ11™rÞãÜKpP„ñ‚#\r„ñªÿÅ©ÞØòäÿ×Ö§ª7w¬­ïß1f{jò%8(ÂÙÇ™êµµŒÙžš|	Šp¶ÁñúüSµówÿü‘Úõ_+«Á½/Ùžš|	Š0^p¼ò«¿“©W~õ7ÕÑÁÝc¶§&_‚ƒ\"Œol]1&ÒÚ¾áûc>Y‰QÈÛÇÙžš|	Š0^püc{ô†ÅxÁÃî{yÌ6ÔÙ•à ãGÔà¾Wª×Ö=8&0ÒŠÃšÃû?f}uv%8(Â™‚CMO	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"t;8~ûÛßV_øÂªK/½´ºæškª§Ÿ~º=½nJ»æÏŸ_]~ùåÕ7ÞX½þúë“žwóÍ7W7ÝtS{Úàà`5{öìêŠ+®¨>ó™Ï´×;|øpõ³Ÿý¬½l___{¹¯ýëí÷?þxuèÐ¡jÎœ9Õ§?ýévõôôT{÷îÓþ©.ÁAº\ZÏ=÷\\µ}ûöv§ŽÓãuÔòåË«\'žx¢ýú+_ùÊ¤ç=ûì³Õž={ÚÓ\"4bZÅc=6\Z:o¼ñFûõµ×^Û^îsŸû\\û}õÍo~³ýzýúõÕ¦M›Ú¯¿úÕ¯ŽiÿT—à ÝŽè¤ßýîw«n¸a´ÓÇô‘×GŽiâuŒ&;ohhht—]vÙè´¨x=P×_}ûýêÕ«Û??ÿùÏ·§Çü‘mÔ•W^9¦ýS]‚ƒ\"t;8¾øÅ/¶;åŠ+F;hLy‡#ápÕUWMz^ç>\"TbZ„F¶Äë«¯¾º=/FñþË_þrûç¼yó>²ÎÀÀÀ˜6w³EèvpÄ9Šz·Õš5k>ÒéG^ÿô§?\r•‘C…ÉÌëÜGœÃˆiq¨²lÙ²öëÛo¿½=ï™gž]\'jåÊ•íé3fÌh¿ÿáX­[·®ý:Â%mÿT—à ÝŽýèGíðhµZéô#¯GN€Æ‰Î8¬™ì¼Î}Ä¨aÖ¬Y£\'G,XÐ>Ì‰y¨.¹ä’ö:_|ñè	ÐÍÌ;·úìg?[}êSŸªn¹å–j÷îÝcÚ?Õ%8(B·ƒãLuÑ80™yç[	Š 8šU‚ƒ\"4%8Ô‡%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š 8šU‚ƒ\"Žf•à ‚£Y%8(‚àhV	Š°~ýúêÄ‰cþ€U÷«þ=œaóæÍÄÜÓ?bÕýÚµk×î:8Ž§¿#hœ\r6|ãÆÃû÷ï6ò˜žªÿÝ?¨CcW\Z1âX’þŽ ‘â5þ§‹ar©ÕjµÆL+¬âßIú»¦PG:\r`B‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€l‚È&8€	õööŽ ˜¨b™t=àV‡ÂÂ4(ÒŠeÒõ€ÜD££\r`\\:Œ6€3\ZoÔa´Lh¼Q‡Ñð±:GFÀ¤tŽ:Œ6€Iu¤ÓÚæÌ™s]OOÏ?ÔõRCuLÎsÄû¡˜ËÅòé6€D‹ëÚ—„Äd+Ö[œn8OÕ~^]ÇÆ	ƒ³©ØÎ¼tÀybÖ¬YWÔ‡\Z¯ŽÓù«…V+W®¬¶nÝZíÜ¹³\Z¬BüŒ÷1=æÇréºQ±ÝØ~ºO `uçþRooï‰ÎÎ>cÆŒjÙ²eÕÞ½{Û!1Y±|¬ë\'òNì\'Ý7P ºƒÿu\Z§:;ùÃ?\\íÙ³\'Í„,±~l\'	S±¿´\r@AN4FC#F	¿üå/Ó8\'±½dôû3ò€Å9‡ÎÃ“Ù³gWÛ¶mKûý\'\"¶Ûïwœó€užÁT…ÆˆØ~çÈ#öŸ¶	h°Ö‡¹ŽvâU«V¥ý|JÄ~:÷íHÛ4T«ã:8ÙMÉ	ÓciÛ€ºõÖ[tÜ8t8×OOrÅþ:Y¢=i†iu\\F×[L‡ØoÇ¨c_ÚF Aúúúþ¬£Ãv}´1\"öÛÙŽhWÚV !âÛ«#5.ŸN—§G»Ò¶\rQwÒ—G:ëSO=•öå®ŠýwŒ:^NÛ\n4DoooÜO£ÝY·lÙ’öå®Šý´%Ú•¶hˆÖ‡—{·;kÚ—»*öß1â8•¶hˆºƒtÖ¡¡¡´/wUì¿#8†Ó¶\rÑÑQ«“\'O¦}¹«bÿíIÛ\n4„­åË§*@¶–ë8€\\®²ù®\npVZ¾är?à¬´ÜÈÕrÏQàlLÇ]Î{{{GCÃ]Î¡@ñ\\“Ö‡elwä©~®J½¿Î‘†çª@©êü¥VÇeèSõ$·Î‘Æéýy’”,žåÚQž|¬Ó#ÑÃ–(O«>Vœsè<aÚYqyøÊ•+«­[·V;wî¬Û!?ã}Lù—‘wVl×9\r8µ>ü¨vô:s¬ØŽ\\áBQwøÅ­ŽËÓ3+Ö[œn¸@Ì™3çºøöj]/Õa÷ó8™„D¼Šù±\\,Ÿn\0\0\0\0\0\0\0\0>)ÿ|D\"8ŽòJ\0\0\0\0IEND®B`‚',1),
('2502',1,'processes/diagram.bpmn','2501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('2503',1,'processes/diagram.svg','2501','<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!-- created with bpmn-js / http://bpmn.io -->\n<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"112\" height=\"318\" viewBox=\"154 76 112 318\" version=\"1.1\"><defs><marker id=\"sequenceflow-end-white-hsl_225_10_15_-ajryqhl6aixfklwc2k50tlfqk\" viewBox=\"0 0 20 20\" refX=\"11\" refY=\"10\" markerWidth=\"10\" markerHeight=\"10\" orient=\"auto\"><path d=\"M 1 5 L 11 10 L 1 15 Z\" style=\"fill: rgb(34, 36, 42); stroke-width: 1px; stroke-linecap: round; stroke-dasharray: 10000, 1; stroke: rgb(34, 36, 42);\"/></marker></defs><g class=\"djs-group\"><g class=\"djs-element djs-connection\" data-element-id=\"Flow_0nv17f1\" style=\"display: block;\"><g class=\"djs-visual\"><path d=\"m  210,118L210,200 \" style=\"fill: none; stroke-width: 2px; stroke: rgb(34, 36, 42); stroke-linejoin: round; marker-end: url(\'#sequenceflow-end-white-hsl_225_10_15_-ajryqhl6aixfklwc2k50tlfqk\');\"/></g><polyline points=\"210,118 210,200 \" class=\"djs-hit djs-hit-stroke\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"204\" y=\"112\" rx=\"3\" width=\"12\" height=\"94\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-connection\" data-element-id=\"Flow_1ke9x09\" style=\"display: block;\"><g class=\"djs-visual\"><path d=\"m  210,280L210,352 \" style=\"fill: none; stroke-width: 2px; stroke: rgb(34, 36, 42); stroke-linejoin: round; marker-end: url(\'#sequenceflow-end-white-hsl_225_10_15_-ajryqhl6aixfklwc2k50tlfqk\');\"/></g><polyline points=\"210,280 210,352 \" class=\"djs-hit djs-hit-stroke\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"204\" y=\"274\" rx=\"3\" width=\"12\" height=\"84\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-shape\" data-element-id=\"StartEvent_0vx5axl\" style=\"display: block;\" transform=\"matrix(1 0 0 1 192 82)\"><g class=\"djs-visual\"><circle cx=\"18\" cy=\"18\" r=\"18\" style=\"stroke: rgb(34, 36, 42); stroke-width: 2px; fill: white; fill-opacity: 0.95;\"/></g><rect class=\"djs-hit djs-hit-all\" x=\"0\" y=\"0\" width=\"36\" height=\"36\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"-6\" y=\"-6\" rx=\"3\" width=\"48\" height=\"48\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-shape\" data-element-id=\"Event_1294r00\" style=\"display: block;\" transform=\"matrix(1 0 0 1 192 352)\"><g class=\"djs-visual\"><circle cx=\"18\" cy=\"18\" r=\"18\" style=\"stroke: rgb(34, 36, 42); stroke-width: 4px; fill: white; fill-opacity: 0.95;\"/></g><rect class=\"djs-hit djs-hit-all\" x=\"0\" y=\"0\" width=\"36\" height=\"36\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"-6\" y=\"-6\" rx=\"3\" width=\"48\" height=\"48\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-shape\" data-element-id=\"Activity_0nt5d38\" style=\"display: block;\" transform=\"matrix(1 0 0 1 160 200)\"><g class=\"djs-visual\"><rect x=\"0\" y=\"0\" width=\"100\" height=\"80\" rx=\"10\" ry=\"10\" style=\"stroke: rgb(34, 36, 42); stroke-width: 2px; fill: white; fill-opacity: 0.95;\"/><text lineHeight=\"1.2\" class=\"djs-label\" style=\"font-family: Arial, sans-serif; font-size: 12px; font-weight: normal; fill: rgb(34, 36, 42);\"><tspan x=\"28.154296875\" y=\"43.599999999999994\">approve</tspan></text></g><rect class=\"djs-hit djs-hit-all\" x=\"0\" y=\"0\" width=\"100\" height=\"80\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"-6\" y=\"-6\" rx=\"3\" width=\"112\" height=\"92\" class=\"djs-outline\" style=\"fill: none;\"/></g></g></svg>',0),
('32502',1,'processes/diagram.bpmn','32501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\" name=\"A test process\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:serviceTask id=\"Activity_0nt5d38\" activiti:exclusive=\"true\" name=\"approve\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('32503',1,'processes/diagram.Process_0wu4lop.png','32501','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0Ž\0\0\0fí}\0\0—IDATxÚíÝ[lUå‚Àñ£ÆÄÄ[4&^âƒ‰OÆ“ILF\r‰OŽcIiK,DÀÊÅà %E2`$ÄÁà(Fð`0Êp‘z*ŽA9 zŠ¬,ìÒoÖ·Ân¶µÛÁv¯Ýþ~Év÷n…¬Õõ÷[—½öŸþ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0E-„pËÖ­[ß_¾|yËâÅ‹»«««{fÍšžzê©ÿ|þùç/¾ôÒK/¾øâ7sæÌùgKF±½{÷.ýõ×/TUU…Ù³g‡µk×†ÚÚÚpðàÁÐØØNŸ>\Z\Z\ZÂÒçW­Z¦OŸfÌ˜Ñóì³ÏÖUVVÞi)Â(qèÐ¡9+V¬èž:ujx÷ÝwÓHF}}}X½zu˜<yrxúé§¿œ4iÒõ–*ŒÜ]’«·lÙr\"#Îš››Ãå8yòdX¶lYHÂÑSRR2Å†xcÍš5ÉnF:cø#íß¿?Æ#L˜0a¥%\r#\'\Zw&3ƒžêêêËžeü–¸»¦–——×Zâ0vOV¯^ÝõÂ/„ööö0”b”ž|òÉ¸Û²Ü’‡\"¶yóæ3q÷d¨f\ZýÍ<üñà˜©/¿üò_ãÐcÇŽ…á´oß¾¸ËrÑÙ(BË–-»¸nÝºP.ìNfÛ­(\"»víúsœm´¶¶$ñTm2ëèq‘‘%K–ôlÞ¼9ÒÒ¥K;Ç¿ÓÚ€\"ÐØØøñºŠóçÏ4‡¥¥¥Ö÷ßÏ‚BTTT\\7nÜÃÖ\ndÜk¯½vaÓ¦M™Ç¢E‹Ú“Ý•ÍÖ\ndÜüùó{â;\\³àƒ>hIÂqØZŒ›9sfzV#öìÙÓ‘„£ÉZŒ‹F‡úòò:zôèÅ$íÖ\nd\\²¡†¬8sæLwòïé¶V ã***BWWWVfñà¨S²uñö~ñ¶Y°k×®s¥¥¥ÍÖ\ndÜsÏ=—™³*6l8ë¬\nùóç·lÝº5á¨®®>‘„ãk2nÁ‚ÿ¾páÂL„£¬¬¬«¼¼¼ÄZŒ‹÷Á˜8qbÁOÉ~ûí·ÍÉlã‚5Eâ™gži«©©)h8’]¦c%%%{­\r(•••OL›6­`§eÏœ9s.™m\\LvSþÁÚ€\"2kÖ¬ó…z³[UUÕñ$ÿc-@‘‰ogŸ¶6Ü×tìÙ³çXœm¸û©)S¦üyÎœ9Ãv 4ÙE‰Dãeæ/ZúPÜÇ;ê-Zº»»‡4\Zmmmeee­î¿#À˜1c®ž8qâ¹—_~¹g¨fÉLã§	&¸÷Œ´xTTTü­ªªªç>æ±oß¾ïãî‰C€ª´´tm23èY¿~ýÅË=UûóÏ?wÌ›7ïh<šŒW,]ÁâÙ–$ Ç“Ý—ø\nÝƒÝ}9{ölë’%KÇ`$³ŒoÆŽ{¯¥\n£D²áW$ãD‘0{öìÎ\r6tìÝ»·ëÔ©S½³‘¶¶¶î†††öÝ»wŸObq<ÙÝ‰Ç1âKq÷rÅâ{[â®F<°ïß_ï\"viô$ÏuÅç“XL¾ž—XjÀoÍH‚¥\0 €p\0Â€p\0Â €p\0 €p\0Â€p\0Â €p\0Â €p\0Â \0Â €p\0Â €p\0Â \0Â €p\0Â€p\0Â €p\0 €p\0Â€p\0Â €p\0 €p\0Â \0Â €p\0Â €p\0Ã¢¤¤¤-†âïÒÒÒfK\nÈŸ]¼2€pÌ¶¤€Ï:Ì6€AÏ:Ì6€AÍ:Ì6€AÏ:Ì6€AÍ:Ì6€AÏ:Ì6€AÏ:,	`Ð³K†Iáêúúú£»wïîùä“OÂöíÛa555¡¶¶¶eÛ¶mSüFR¾I$¿´!‰Ghii	Æ0¸ÜëêêÂŽ;zÄƒ¢ðÙgŸ…††pÆ×_ÝÌ@Nù­$óâT¹½½Ý†›‘™G²>züVRá°ÑfgÄõá·’Ž“g[Â3ëö¥#>¶¡Âñ«ÑÑÑšÎ·õ~ýé×§zÃçž?ýSkøéç6¾p0ÚÃ£±ö¿†ç7|¶8þrèdxaãÿö†#>ŽÏô×ãá¹ä{^Ûò·p®E<„ƒQŽÏµ†yë¿ê\rÅï¹ÿ¹?|ÿãy¿p0ÚwU6ïkp8ÖïþÎ†/Ggº{’Ã³ïîÿñù±Pê§tÄÇñ¹Üëÿµ¿Ñ†/ŒæpÄ3&ñàgþ1Š¾ßŸË?æÆÙá`”†£¿]‘8Ëèû}ñ¹þ¾W\0„áá\0»*ÂCzpôÔ€ŽÆïµáÂ¶|5ðÓ±þõ¸\r_8íáˆ€Å«F\ZŽY¿?½ôÜÆ/Œâp´¶u„7j§»#ïÑ>9têW—œÇë<âeç10ÿöi}hïè°ñ£}W%ÆãTsËï¾Éíìù6Ñ„ÃÛê…þ pÂÂ! ÂÂ! †p †p †p€p‡p€pÂpÂpÂÂ! ÂÂaÂaÂa‡p€p‡pÂaÂa8>ÿüópï½÷†«®º*ÜvÛmaÝºuéóÉ?%Ó¦M×]w]¸ÿþûC]]Ý€_{øá‡Ã<>×ÔÔ&Ožœ~ïÍ7ßœþ\\sssxë­·Òï­¨¨H¿oÂ„	é×«V­\n?þøc¨¬¬7ÝtS:JJJÂñãÇ…²Ž-[¶„C‡¥mÜ°óðÎ;ï„Õ«W§}ôÑ¿¶qãÆpòäÉô¹\\Þ|óÍÞè=z4}|Çw¤ßwûí·§_×××‡\'žx\"}¼cÇŽðé§Ÿ¦{ì1á€,„ãÈ‘#aîÜ¹áž{îéÝèópîÜ¹tv_ýõ~íìÙ³½Çµ×^Ûû\\ùºûî»Ó¯?úè£ôÏ»îº+}>¾žûoåÆ\r7Ü …pÜwß}éF¹fÍš~Ãwrq¸ñÆüZþß£’GÜm‰o¹å–ôµ8óˆ_?ôÐCéŸS¦LùÅÏœ9sÆ1ÈZ8âq‡¸nÝºµßp¬X±¢7*¹]…¼–ÿwÄc¹]••+W¦gÎœ™¾¶~ýú_Ì*Ö®]›>_VV–~½téÒÜÆ›ÆE8 áX¶lY\ZñãÇ÷ŽÜÐ|0Ý­èkùGœ5Lš4)EÄ]ªªªt7\'¾öÃ?„+¯¼2ý™+®¸¢÷\0hœÍÄÙÇ­·Þ\Z®¹æšðÈ#„ï¾ûN8 áø­Ñ_\0òšÓ± Â!‡!‡! ÂÂ! ÂÂaÂaÂa‡p€p‡!‡!‡! ÂÂ! †p †p †p€p‡p€p‡ßJ„Ã„Ãá\0áá€¬†£££ÃF›ÑÚÚús²>züV’yµµµ=6ÜŒ/¾øâHŽ&¿•d^MMÍ¦$?~ÑÌ£0£½½½§®®îô¶mÛº“p¼è·’¢üÂ¾ûñÇwÅÝ–bãÇÅüïOF{2–øm„aÃa)\0Â €p\0Â €p\0Â \0Â €p\0Â €p\0Â €p\0 €p\0Â€p\0Â €p\0 €p\0Â€p\0Â €p\0Â €p\0Â \0Â €p\0Â €p\0Â \0Â @•””´ÅPü½QZZÚlIù³‹WŽÙ–0àY‡Ù0èY‡Ù0¨Y‡Ù0èY‡Ù0¨Y‡Ù0èY‡Ù0èY‡%ü¦df1#	ÅÎdŽ»\'I8º/Í:Ú“ÑŸOžÛ^^^^biÁèÞ%©HbðMògÏï]üÕgt\'?··¬¬ìŸ,E%Æ÷p²ñ?ÈXô;bxÆŽ{¯¥\n#Ô˜1c®Ž3…dWäW˜1cFXµjU¨­­\ráôéÓ¡¡¡!8p ÔÔÔ„7Þx#L:õ·\"²Ù†¦²²òÎ$M}7øƒººº0PÝÝÝiX/^ÜßìãÈ¤I“®·´aˆÇ\"’Ñ•¿‘/\\¸0;v,\\Žêêê¾i±ëE.™ÜÌ4.ä6ìòòò°qãÆðG‰3·ß~ûWñ0ó€\">¦O­æ6èdc{÷î\rC!‰QÊßm± 8góg\Zû÷ïC)ÆÃS(bñB­üøÃ?Ã¡ïn‹ãPD.]í™n¼¯¾új.ñ˜GþÓx‡µÅ¹ù»(\'OžÃ)žmÉŸu¸ÂŠ#\'rmÜu(„üë<âEgÖ\ndXiié-ùÿ·WBŸYG·5ÙžmôÞKcÞ¼y¡Pâ±ŽüËÓ½«2ìÒ»]Óõ½÷Þ…/gÏÛ]Ùní@vwUz/øŠoN+¤>×u¶v »áè}OÊpŸMé+†+/MÖd÷GïMyÚÛÛ\ZŽø–ü¼p´[;Ýpôn¬…ÖÔÔäÌ\n[8ººº\n\ZŽx3 ¼O§µÙ\rÇ…B_ÃÑßµ>Ÿ2,ÿ¬JÜp)Þ†ÐY(ñ>¹uÓ¦M\rG¼‡i^8vZ;Ýp,Ïm¬,(h8¦OŸž¿«2ÃÚŒŠ7%Î?@ÚÜÜ\\hÄ çý;.Z3qù÷â(Ôeç}.7wOÈº²²²%¹¶¢¢bØgñîé}n!Xa­@qÌ:ZrîÊ•+‡5ñ£ò¢ñ½µE¢´´tvþÿõwîÜ9,Ñˆ½ÿ÷Æ›´6 ¸f\'ò?\Z¡¾¾~H£?z!ÙMrç/(òYG¼X{nCž6mÚÅ#~ôÂÄ‰ñnØø¹.Ög<ˆ§CógônKüè…ü™F|k<-léCqÇcF~<rL/÷lK¼ßGüè…>gP.¸«9Œ¬™G{þFOÕÆë<øæ¹x÷ôü|Ì½‘-~V­¥\r#ï˜Ç‰>3„ÞËÓã{[âãbroÉ7Š3‹x7¯™xäþ~>~Ü¤c\Z0²2;ÿ:ËMî`£È¥+L›þŸÁˆ3—¹–\"ŒRñH|Wm|Kþ¥ûy\\ÈDO<KréøEüè…Wâ.¥\0\0\0\0\0\0\0ÀPù?¤¿?Î\0z—\0\0\0\0IEND®B`‚',1),
('40002',1,'processes/test2.bpmn','40001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1cydcrq</bpmn:incoming>\n      <bpmn:outgoing>Flow_1x26529</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1x26529</bpmn:incoming>\n      <bpmn:outgoing>Flow_135u817</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('40003',1,'processes/test2.Process_0hy83oz.png','40001','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0ü\0\0\0 ëA·\0\0IDATxÚíÝOlT÷Àñsì­ÇÜöØ[O»¤Þö²ÌØ8 $””Ä()!h!\"B‘H\"¡F(lS ¥˜:Ð\n/ÄÁP 1q Ž\rÄŒí±=¿}?[³†$ž{Þó|>ÒOq¦FEïÍï›ßû3o~ñ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0È´Â¯Ž=zpçÎý[·n­¯¯/¬Y³&¼øâ‹!þóõ×_{óÍ7‡7mÚôõÚµkÿÃƒ\nÖÒÒ²ó½÷Þ{°zõêPWWöìÙšššÂ¥K—BWWW¸uëVèèè/^}×®]aåÊ•aÕªU…W_}µméÒ¥ÏÚŠP!._¾¼öƒ>]¾|yØ»wïx$JÑÞÞvïÞžþùðÒK/}¹dÉ’_Úª0wIž9räÈŒ¸zèíí\rOâæÍ›aÇŽ!	G¡ªªj™-sð<ÆÇ<œfŒ¯ž¦ÖÖÖ°hÑ¢mi˜;Ñx6YêëëŸx•ñcâáN<™ZSSÓd‹Ã8<Ù½{÷Èo¼òù|˜I1J/¼ðB<lÙiËC†>|øv<<™©•ÆãVÏ=÷\\pÎ2êË/¿ü¯x\"ôúõëa6?>²Œ¹Ú´cÇŽ±O>ù$”ÃæÍ›G“UÇ1{2äÌ™3Š«²„#^ªMV7‰A†lÛ¶­pøðáPNï¾ûîðÂ…OÙ]]]ÿ\Zï«èëë+k8®^½\Zr¹Ü°=pðàÁ³7niP[[;¶`Á‚ßÚ+rÛ·opèÐ¡T„cË–-ùäpå°½)·aÃ†Bü„k\Z|öÙgýI8®Ú+r/¿üòøU48{öìPŽ{R.žéÛË§ëÚµkcI8òö\n¤\\2QCZÜ¾}{4ùûŒÚ+rµµµadd$-+ŽxrÔ%YH»øx¿øØ¿48sæÌ½\\.×k¯@Ê½öÚk©¹ª²ÿþ;®ª@lØ°¡ÿèÑ£©G}}ý$\'íH¹7þ÷æÍ›SŽêêê‘ššš*{R.>cñâÅe¿$ûí·ßö&«ödÄºuëË\ZŽäézUUU‹½±téÒÿ\\±bEÙ.ËÞ¾}û^²ÚKS~co@†¬Y³¦¯\\v[½zugŽÿ± câÇÙã·­Íö=gÏž½WžþµlÙ²?­]»vÖN”&‡(ñ„h¼Í|“­Ù>ßÑ¾eË–0:::£Ñ®®®ðü\r˜æÍ›÷ÌâÅ‹ï½õÖ[…™Zy$+»‹-òì\r˜kñ¨­­ýfõêÕ…§}ÎãüùóßÇÃ_‡\0sT.—Û“¬\nûöí{ÒKµ÷ïßZ¿~ýµx\"4oÛº0‡Å«-I@:“Ã—ø\n£¥¾Ü¹sg`Û¶mWc0’UÆ×óçÏÿµ­\n\"™øµÉ¸‘D$ÔÕÕ\rïß¿¨¥¥e¤»»{r52888ÚÑÑ‘onnîKbÑ™îÄóñ‹¥¿óôr¨`ñ³-ñP#žØŒÏÎˆŸ/‰O{8\nÉk#ñõ$—’%ž/±Õ€[‘[@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0R«ªªj0†â§F.—ëµ¥€âÕÅÛÓG-L{Õaµ”¼ê°Ú\0JZuXm\0%¯:¬6€’VV@É««\r äU‡-”¼ê°%`–„žioo¿ÖÜÜ\\8yòd8vì˜1Ë£±±1455õ744,óŽ$¾N$oÚÄ#ô÷÷‡ááac–GÜîmmmáÄ‰ñ NŸ>:::LàŒ+W®Œ&+nïJR/.•óù¼‰›’•G²?\nÞ•d\"&mzFÜÞ•Ì©pÜ¼ÓÖ}r~|ÄŸMtá@8CCÃ¡§opòß¿¸Ò=ŽøóÄë·î„»÷M|á ÒÃ£±ço×Âëû/„†‹7Â_/ßoøÇd8âÏñõ?Õ^K~gû‘oÂ½~ñ*:?Üë÷]˜ÅÏWþØ\Z¾ÿ¡Ïä*ýPåðù®i‡c_ó?M|á@8†ÇO&ÂðêÞÖð‡¿_íÝwÇGü9¾6ñ¿ÿ¥µËÄ*9ñŠI<ùY|N#†bêïÅ×ŠÏyÄ?ãj‹pP¡áxÜ¡H\\eLý½øÚã~W\0„áá\0‡*Â3zr´{Ú\'GãïšøÂp„#¦9öó¯:M|á ÒÃo\0‹wN7¿Û×:~ë¹É/Tp8‡ÂûWÇGžë\'/w?rËy¼Ï#Þvóû/ÚC~hÈä*ýP%Æ£»·ÿg?äv§oP4„áð±zá€§C8@8„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8á@8á@8á\0áá\0áá@8á@8á\0áá\0áC8C8C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„„C8@8á@8á@8„C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„ÊŽ¡¡!“6c``à~²?\nÞ•¤^SSS¡««ËÄMÁ8wîÜwI8z¼+I½ÆÆÆCI<Æ:;;Ç¬<Ê3òù|¡­­íVCCÃhŽMÞ•dBò†Ý{üøñ‘xØ’Õ±páÂå¿2òÉØæÝ³(†ÃV\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„xêªªªc(~jär¹^[\n(^]¼=pÔÙRÀ´WV@É««\r ¤U‡ÕPòªÃj(iÕaµ”¼ê°Ú\0J^uØ@É«[fIá™ööökÍÍÍ…“\'O†cÇŽ³<\ZCSSSCCÃ2ïH2áëDò¦\rI<B6fyÄíÞÖÖNœ8Q2áôéÓ¡££ÃNÁ¸råÊh²éö®$õâR9ŸÏ›¸)Yy$û£à]I&ÂaÒ¦gÄýá]Éœ\nÇÍ;ýaÝ\'çÇGüÙD„ã‘144zú\'ÿý‹+Ý“áˆ?O¼~ëî@¸{ÐÄ*=1\Z{þv-¼¾ÿBh¸x#üõòÍðÆL†#þ_ÿóWáµäw¶ù&Üëá ¢ÃñÃ½°~ß…ÉPüÜxå­áûúL~á ÒUŸïšv8ö5ÿÓÄ„cxüðd\"¯îm\røûõÐÞ}w|ÄŸãkÿû_Z»L|á ’Ã¯˜Ä“ŸÅç4b(¦þ^|­øœGü3®¶\ZŽÇŠÄUÆÔß‹¯=îw@8áp¨\"0£\'G»§}r4þ®‰/G8raú—c?ÿªÓÄ*=ñ°x×ètÃñ»}­ã·ž›üÂA‡c`p(¼ßxuüpäà¹Žpòr÷#·œÇû<âmç10¿ÿ¢=ä‡†L~á ÒUb<º{ûöCnwúEC8«xJá0„„C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áá„Ã„Ãá\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8„„Ã„Ã„C8„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8 œá\Z\Z2iS0î\'û£à]Iê555ºººLÜŒsçÎ}—„£Ç»’Ôkll<”Äc¬³³sÌÊ£<#ŸÏÚÚÚn544Œ&áØä]I&$oØ½Ç‰‡-Y.Yþû\'#ŸŒmÞ0‹b8l@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„(³ªªªÁŠŸ\Z¹\\®×–ŠWoO#u¶0íU‡ÕPòªÃj(iÕaµ”¼ê°Ú\0JZuXm\0%¯:¬6€’W¶ð£’•Åª$§’q5ž$ÿ}¸êÈ\'£\'¾žÄäXMMM•­•}HR›ÄàëäŸ…Ÿ»ùkÊMþ\\Kuuõ¿ÛŠP!,XðÛdò_b,;bxæÏŸÿk[æ¨yóæ=W\nÉ¡È#XµjUØµkWhjj\n—.]\n]]]áÖ­[¡££#\\¼x1466†÷ß?,_¾üÇ\"rØ†9féÒ¥Ï&Áè™:ácÚÚÚÂtŽŽŽ‡eëÖ­[}|·dÉ’_ÚÚ0ÄsÉ)žä›7o×¯_O\"¤¾¾~j@úº@Æ%«€IV\Z&&vMMM8pà@xZâ\nä£>z$Vás\Z/­ŽOèd2‡–––0â9¥âÃ{\0²¹Ú¸T¼Òhmm\r3)ÆÃ	SÈ°x£Vñ$þüóÏÃl˜zØâ|dÈÃ»=Ç\'ï;ï¼fK<çQ|Â4Þçao@6¢ñJñ!ÊÍ›7ÃlŠW[ŠWî0…l„ãÆÄ¤‡åP|ŸG¼éÌ^Ëår¿*þ¯}¼û³¦¬:FíH÷jcòY\Zë×¯åÏußžîSµb?í:>Y?ýôÓPNñvö¢Ã•cö¤÷Peò†¯øá´ršr_ÇU{ÒŽÉÏ¤ÌöÕ”©b¸ŠÂÑcï@zÏqL>”\'ŸÏ—5ñ#ùEáÈÛ;ÞpLNÖrëééqe²Ž‘‘‘²†#>¨èï3lï@zÃñ Ü÷p<î^ßÏ)V|U%NÜrŠ!tU2 >cb²:t¨¬áˆÏ0-\nÇ){ÒŽ“uãÆe\rÇÊ•+‹UVÙ;Rñ¡ÄÅ\'H{{{Ëø\0ä¢¿Ç˜=)Wü,ŽrÝv>åvsÏä€´«®®Þ61ikkkg}ÕŸž>å‚µö\ndcÕÑ?1q?üðÃY\rGüê…¢h|oo@Fär¹ºâÿêŸ:ujV¢¿z¡øÿ7~Ý¤½ÙZuÜ(þj„öööFüê…ä0É“¿ ã«Žø4°üÄD^±bÅŒÅ#~õÂâÅ‹ÿÏ§aã÷ºØÍxü[¼Z¼òxÚ‡-ñ«ŠW\Zñ£ýñ²°­ÙŽÇªâxLœ0}Ò«-ñyñ«¦\\Ayà©æ0·VùâI/ÕÆû<J\rHüð\\|zzñW>N|-~W­­\rsïœÇ)+„ÉÛÓãg[âãb&>’Wñi^12ñÈûóñë&Ó€¹ºâû<žpôx‚9T‡w˜öü?ƒW.¯ØŠP¡âø©Úø‘ü‡ÏóxPˆB¼JòðüEüê…·ã!­\0\0\0\0\0\0\0ÀLù_^üEˆ¹ân\0\0\0\0IEND®B`‚',1),
('42508',1,'processes/test2.bpmn','42507','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1cydcrq</bpmn:incoming>\n      <bpmn:outgoing>Flow_1x26529</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n      <bpmn:incoming>Flow_1x26529</bpmn:incoming>\n      <bpmn:outgoing>Flow_135u817</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('42509',1,'processes/test2.Process_0hy83oz.png','42507','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0ü\0\0\0 ëA·\0\0IDATxÚíÝOlT÷Àñsì­ÇÜöØ[O»¤Þö²ÌØ8 $””Ä()!h!\"B‘H\"¡F(lS ¥˜:Ð\n/ÄÁP 1q Ž\rÄŒí±=¿}?[³†$ž{Þó|>ÒOq¦FEïÍï›ßû3o~ñ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0È´Â¯Ž=zpçÎý[·n­¯¯/¬Y³&¼øâ‹!þóõ×_{óÍ7‡7mÚôõÚµkÿÃƒ\nÖÒÒ²ó½÷Þ{°zõêPWWöìÙšššÂ¥K—BWWW¸uëVèèè/^}×®]aåÊ•aÕªU…W_}µméÒ¥ÏÚŠP!._¾¼öƒ>]¾|yØ»wïx$JÑÞÞvïÞžþùðÒK/}¹dÉ’_Úª0wIž9räÈŒ¸zèíí\rOâæÍ›aÇŽ!	G¡ªªj™-sð<ÆÇ<œfŒ¯ž¦ÖÖÖ°hÑ¢mi˜;Ñx6YêëëŸx•ñcâáN<™ZSSÓd‹Ã8<Ù½{÷Èo¼òù|˜I1J/¼ðB<lÙiËC†>|øv<<™©•ÆãVÏ=÷\\pÎ2êË/¿ü¯x\"ôúõëa6?>²Œ¹Ú´cÇŽ±O>ù$”ÃæÍ›G“UÇ1{2äÌ™3Š«²„#^ªMV7‰A†lÛ¶­pøðáPNï¾ûîðÂ…OÙ]]]ÿ\Zï«èëë+k8®^½\Zr¹Ü°=pðàÁ³7niP[[;¶`Á‚ßÚ+rÛ·opèÐ¡T„cË–-ùäpå°½)·aÃ†Bü„k\Z|öÙgýI8®Ú+r/¿üòøU48{öìPŽ{R.žéÛË§ëÚµkcI8òö\n¤\\2QCZÜ¾}{4ùûŒÚ+rµµµadd$-+ŽxrÔ%YH»øx¿øØ¿48sæÌ½\\.×k¯@Ê½öÚk©¹ª²ÿþ;®ª@lØ°¡ÿèÑ£©G}}ý$\'íH¹7þ÷æÍ›SŽêêê‘ššš*{R.>cñâÅe¿$ûí·ßö&«ödÄºuëË\ZŽäézUUU‹½±téÒÿ\\±bEÙ.ËÞ¾}û^²ÚKS~co@†¬Y³¦¯\\v[½zugŽÿ± câÇÙã·­Íö=gÏž½WžþµlÙ²?­]»vÖN”&‡(ñ„h¼Í|“­Ù>ßÑ¾eË–0:::£Ñ®®®ðü\r˜æÍ›÷ÌâÅ‹ï½õÖ[…™Zy$+»‹-òì\r˜kñ¨­­ýfõêÕ…§}ÎãüùóßÇÃ_‡\0sT.—Û“¬\nûöí{ÒKµ÷ïßZ¿~ýµx\"4oÛº0‡Å«-I@:“Ã—ø\n£¥¾Ü¹sg`Û¶mWc0’UÆ×óçÏÿµ­\n\"™øµÉ¸‘D$ÔÕÕ\rïß¿¨¥¥e¤»»{r52888ÚÑÑ‘onnîKbÑ™îÄóñ‹¥¿óôr¨`ñ³-ñP#žØŒÏÎˆŸ/‰O{8\nÉk#ñõ$—’%ž/±Õ€[‘[@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0R«ªªj0†â§F.—ëµ¥€âÕÅÛÓG-L{Õaµ”¼ê°Ú\0JZuXm\0%¯:¬6€’VV@É««\r äU‡-”¼ê°%`–„žioo¿ÖÜÜ\\8yòd8vì˜1Ë£±±1455õ744,óŽ$¾N$oÚÄ#ô÷÷‡ááac–GÜîmmmáÄ‰ñ NŸ>:::LàŒ+W®Œ&+nïJR/.•óù¼‰›’•G²?\nÞ•d\"&mzFÜÞ•Ì©pÜ¼ÓÖ}r~|ÄŸMtá@8CCÃ¡§opòß¿¸Ò=ŽøóÄë·î„»÷M|á ÒÃ£±ço×Âëû/„†‹7Â_/ßoøÇd8âÏñõ?Õ^K~gû‘oÂ½~ñ*:?Üë÷]˜ÅÏWþØ\Z¾ÿ¡Ïä*ýPåðù®i‡c_ó?M|á@8†ÇO&ÂðêÞÖð‡¿_íÝwÇGü9¾6ñ¿ÿ¥µËÄ*9ñŠI<ùY|N#†bêïÅ×ŠÏyÄ?ãj‹pP¡áxÜ¡H\\eLý½øÚã~W\0„áá\0‡*Â3zr´{Ú\'GãïšøÂp„#¦9öó¯:M|á ÒÃo\0‹wN7¿Û×:~ë¹É/Tp8‡ÂûWÇGžë\'/w?rËy¼Ï#Þvóû/ÚC~hÈä*ýP%Æ£»·ÿg?äv§oP4„áð±zá€§C8@8„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8á@8á@8á\0áá\0áá@8á@8á\0áá\0áC8C8C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„„C8@8á@8á@8„C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„ÊŽ¡¡!“6c``à~²?\nÞ•¤^SSS¡««ËÄMÁ8wîÜwI8z¼+I½ÆÆÆCI<Æ:;;Ç¬<Ê3òù|¡­­íVCCÃhŽMÞ•dBò†Ý{üøñ‘xØ’Õ±páÂå¿2òÉØæÝ³(†ÃV\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„xêªªªc(~jär¹^[\n(^]¼=pÔÙRÀ´WV@É««\r ¤U‡ÕPòªÃj(iÕaµ”¼ê°Ú\0J^uØ@É«[fIá™ööökÍÍÍ…“\'O†cÇŽ³<\ZCSSSCCÃ2ïH2áëDò¦\rI<B6fyÄíÞÖÖNœ8Q2áôéÓ¡££ÃNÁ¸råÊh²éö®$õâR9ŸÏ›¸)Yy$û£à]I&ÂaÒ¦gÄýá]Éœ\nÇÍ;ýaÝ\'çÇGüÙD„ã‘144zú\'ÿý‹+Ý“áˆ?O¼~ëî@¸{ÐÄ*=1\Z{þv-¼¾ÿBh¸x#üõòÍðÆL†#þ_ÿóWáµäw¶ù&Üëá ¢ÃñÃ½°~ß…ÉPüÜxå­áûúL~á ÒUŸïšv8ö5ÿÓÄ„cxüðd\"¯îm\røûõÐÞ}w|ÄŸãkÿû_Z»L|á ’Ã¯˜Ä“ŸÅç4b(¦þ^|­øœGü3®¶\ZŽÇŠÄUÆÔß‹¯=îw@8áp¨\"0£\'G»§}r4þ®‰/G8raú—c?ÿªÓÄ*=ñ°x×ètÃñ»}­ã·ž›üÂA‡c`p(¼ßxuüpäà¹Žpòr÷#·œÇû<âmç10¿ÿ¢=ä‡†L~á ÒUb<º{ûöCnwúEC8«xJá0„„C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áá„Ã„Ãá\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8„„Ã„Ã„C8„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8 œá\Z\Z2iS0î\'û£à]Iê555ºººLÜŒsçÎ}—„£Ç»’Ôkll<”Äc¬³³sÌÊ£<#ŸÏÚÚÚn544Œ&áØä]I&$oØ½Ç‰‡-Y.Yþû\'#ŸŒmÞ0‹b8l@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„(³ªªªÁŠŸ\Z¹\\®×–ŠWoO#u¶0íU‡ÕPòªÃj(iÕaµ”¼ê°Ú\0JZuXm\0%¯:¬6€’W¶ð£’•Åª$§’q5ž$ÿ}¸êÈ\'£\'¾žÄäXMMM•­•}HR›ÄàëäŸ…Ÿ»ùkÊMþ\\Kuuõ¿ÛŠP!,XðÛdò_b,;bxæÏŸÿk[æ¨yóæ=W\nÉ¡È#XµjUØµkWhjj\n—.]\n]]]áÖ­[¡££#\\¼x1466†÷ß?,_¾üÇ\"rØ†9féÒ¥Ï&Áè™:ácÚÚÚÂtŽŽŽ‡eëÖ­[}|·dÉ’_ÚÚ0ÄsÉ)žä›7o×¯_O\"¤¾¾~j@úº@Æ%«€IV\Z&&vMMM8pà@xZâ\nä£>z$Vás\Z/­ŽOèd2‡–––0â9¥âÃ{\0²¹Ú¸T¼Òhmm\r3)ÆÃ	SÈ°x£Vñ$þüóÏÃl˜zØâ|dÈÃ»=Ç\'ï;ï¼fK<çQ|Â4Þçao@6¢ñJñ!ÊÍ›7ÃlŠW[ŠWî0…l„ãÆÄ¤‡åP|ŸG¼éÌ^Ëår¿*þ¯}¼û³¦¬:FíH÷jcòY\Zë×¯åÏußžîSµb?í:>Y?ýôÓPNñvö¢Ã•cö¤÷Peò†¯øá´ršr_ÇU{ÒŽÉÏ¤ÌöÕ”©b¸ŠÂÑcï@zÏqL>”\'ŸÏ—5ñ#ùEáÈÛ;ÞpLNÖrëééqe²Ž‘‘‘²†#>¨èï3lï@zÃñ Ü÷p<î^ßÏ)V|U%NÜrŠ!tU2 >cb²:t¨¬áˆÏ0-\nÇ){ÒŽ“uãÆe\rÇÊ•+‹UVÙ;Rñ¡ÄÅ\'H{{{Ëø\0ä¢¿Ç˜=)Wü,ŽrÝv>åvsÏä€´«®®Þ61ikkkg}ÕŸž>å‚µö\ndcÕÑ?1q?üðÃY\rGüê…¢h|oo@Fär¹ºâÿêŸ:ujV¢¿z¡øÿ7~Ý¤½ÙZuÜ(þj„öööFüê…ä0É“¿ ã«Žø4°üÄD^±bÅŒÅ#~õÂâÅ‹ÿÏ§aã÷ºØÍxü[¼Z¼òxÚ‡-ñ«ŠW\Zñ£ýñ²°­ÙŽÇªâxLœ0}Ò«-ñyñ«¦\\Ayà©æ0·VùâI/ÕÆû<J\rHüð\\|zzñW>N|-~W­­\rsïœÇ)+„ÉÛÓãg[âãb&>’Wñi^12ñÈûóñë&Ó€¹ºâû<žpôx‚9T‡w˜öü?ƒW.¯ØŠP¡âø©Úø‘ü‡ÏóxPˆB¼JòðüEüê…·ã!­\0\0\0\0\0\0\0ÀLù_^üEˆ¹ân\0\0\0\0IEND®B`‚',1),
('42518',1,'processes/test2.bpmn','42517','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1cydcrq</bpmn:incoming>\n      <bpmn:outgoing>Flow_1x26529</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n      <bpmn:incoming>Flow_1x26529</bpmn:incoming>\n      <bpmn:outgoing>Flow_135u817</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('42519',1,'processes/test2.Process_0hy83oz.png','42517','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0ü\0\0\0 ëA·\0\0IDATxÚíÝOlT÷Àñsì­ÇÜöØ[O»¤Þö²ÌØ8 $””Ä()!h!\"B‘H\"¡F(lS ¥˜:Ð\n/ÄÁP 1q Ž\rÄŒí±=¿}?[³†$ž{Þó|>ÒOq¦FEïÍï›ßû3o~ñ\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0È´Â¯Ž=zpçÎý[·n­¯¯/¬Y³&¼øâ‹!þóõ×_{óÍ7‡7mÚôõÚµkÿÃƒ\nÖÒÒ²ó½÷Þ{°zõêPWWöìÙšššÂ¥K—BWWW¸uëVèèè/^}×®]aåÊ•aÕªU…W_}µméÒ¥ÏÚŠP!._¾¼öƒ>]¾|yØ»wïx$JÑÞÞvïÞžþùðÒK/}¹dÉ’_Úª0wIž9räÈŒ¸zèíí\rOâæÍ›aÇŽ!	G¡ªªj™-sð<ÆÇ<œfŒ¯ž¦ÖÖÖ°hÑ¢mi˜;Ñx6YêëëŸx•ñcâáN<™ZSSÓd‹Ã8<Ù½{÷Èo¼òù|˜I1J/¼ðB<lÙiËC†>|øv<<™©•ÆãVÏ=÷\\pÎ2êË/¿ü¯x\"ôúõëa6?>²Œ¹Ú´cÇŽ±O>ù$”ÃæÍ›G“UÇ1{2äÌ™3Š«²„#^ªMV7‰A†lÛ¶­pøðáPNï¾ûîðÂ…OÙ]]]ÿ\Zï«èëë+k8®^½\Zr¹Ü°=pðàÁ³7niP[[;¶`Á‚ßÚ+rÛ·opèÐ¡T„cË–-ùäpå°½)·aÃ†Bü„k\Z|öÙgýI8®Ú+r/¿üòøU48{öìPŽ{R.žéÛË§ëÚµkcI8òö\n¤\\2QCZÜ¾}{4ùûŒÚ+rµµµadd$-+ŽxrÔ%YH»øx¿øØ¿48sæÌ½\\.×k¯@Ê½öÚk©¹ª²ÿþ;®ª@lØ°¡ÿèÑ£©G}}ý$\'íH¹7þ÷æÍ›SŽêêê‘ššš*{R.>cñâÅe¿$ûí·ßö&«ödÄºuëË\ZŽäézUUU‹½±téÒÿ\\±bEÙ.ËÞ¾}û^²ÚKS~co@†¬Y³¦¯\\v[½zugŽÿ± câÇÙã·­Íö=gÏž½WžþµlÙ²?­]»vÖN”&‡(ñ„h¼Í|“­Ù>ßÑ¾eË–0:::£Ñ®®®ðü\r˜æÍ›÷ÌâÅ‹ï½õÖ[…™Zy$+»‹-òì\r˜kñ¨­­ýfõêÕ…§}ÎãüùóßÇÃ_‡\0sT.—Û“¬\nûöí{ÒKµ÷ïßZ¿~ýµx\"4oÛº0‡Å«-I@:“Ã—ø\n£¥¾Ü¹sg`Û¶mWc0’UÆ×óçÏÿµ­\n\"™øµÉ¸‘D$ÔÕÕ\rïß¿¨¥¥e¤»»{r52888ÚÑÑ‘onnîKbÑ™îÄóñ‹¥¿óôr¨`ñ³-ñP#žØŒÏÎˆŸ/‰O{8\nÉk#ñõ$—’%ž/±Õ€[‘[@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0R«ªªj0†â§F.—ëµ¥€âÕÅÛÓG-L{Õaµ”¼ê°Ú\0JZuXm\0%¯:¬6€’VV@É««\r äU‡-”¼ê°%`–„žioo¿ÖÜÜ\\8yòd8vì˜1Ë£±±1455õ744,óŽ$¾N$oÚÄ#ô÷÷‡ááac–GÜîmmmáÄ‰ñ NŸ>:::LàŒ+W®Œ&+nïJR/.•óù¼‰›’•G²?\nÞ•d\"&mzFÜÞ•Ì©pÜ¼ÓÖ}r~|ÄŸMtá@8CCÃ¡§opòß¿¸Ò=ŽøóÄë·î„»÷M|á ÒÃ£±ço×Âëû/„†‹7Â_/ßoøÇd8âÏñõ?Õ^K~gû‘oÂ½~ñ*:?Üë÷]˜ÅÏWþØ\Z¾ÿ¡Ïä*ýPåðù®i‡c_ó?M|á@8†ÇO&ÂðêÞÖð‡¿_íÝwÇGü9¾6ñ¿ÿ¥µËÄ*9ñŠI<ùY|N#†bêïÅ×ŠÏyÄ?ãj‹pP¡áxÜ¡H\\eLý½øÚã~W\0„áá\0‡*Â3zr´{Ú\'GãïšøÂp„#¦9öó¯:M|á ÒÃo\0‹wN7¿Û×:~ë¹É/Tp8‡ÂûWÇGžë\'/w?rËy¼Ï#Þvóû/ÚC~hÈä*ýP%Æ£»·ÿg?äv§oP4„áð±zá€§C8@8„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8á@8á@8á\0áá\0áá@8á@8á\0áá\0áC8C8C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„„C8@8á@8á@8„C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„ÊŽ¡¡!“6c``à~²?\nÞ•¤^SSS¡««ËÄMÁ8wîÜwI8z¼+I½ÆÆÆCI<Æ:;;Ç¬<Ê3òù|¡­­íVCCÃhŽMÞ•dBò†Ý{üøñ‘xØ’Õ±páÂå¿2òÉØæÝ³(†ÃV\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„xêªªªc(~jär¹^[\n(^]¼=pÔÙRÀ´WV@É««\r ¤U‡ÕPòªÃj(iÕaµ”¼ê°Ú\0J^uØ@É«[fIá™ööökÍÍÍ…“\'O†cÇŽ³<\ZCSSSCCÃ2ïH2áëDò¦\rI<B6fyÄíÞÖÖNœ8Q2áôéÓ¡££ÃNÁ¸råÊh²éö®$õâR9ŸÏ›¸)Yy$û£à]I&ÂaÒ¦gÄýá]Éœ\nÇÍ;ýaÝ\'çÇGüÙD„ã‘144zú\'ÿý‹+Ý“áˆ?O¼~ëî@¸{ÐÄ*=1\Z{þv-¼¾ÿBh¸x#üõòÍðÆL†#þ_ÿóWáµäw¶ù&Üëá ¢ÃñÃ½°~ß…ÉPüÜxå­áûúL~á ÒUŸïšv8ö5ÿÓÄ„cxüðd\"¯îm\røûõÐÞ}w|ÄŸãkÿû_Z»L|á ’Ã¯˜Ä“ŸÅç4b(¦þ^|­øœGü3®¶\ZŽÇŠÄUÆÔß‹¯=îw@8áp¨\"0£\'G»§}r4þ®‰/G8raú—c?ÿªÓÄ*=ñ°x×ètÃñ»}­ã·ž›üÂA‡c`p(¼ßxuüpäà¹Žpòr÷#·œÇû<âmç10¿ÿ¢=ä‡†L~á ÒUb<º{ûöCnwúEC8«xJá0„„C8@8„„C8@8á@8á@8á\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áá„Ã„Ãá\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8„„Ã„Ã„C8„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8 œá\Z\Z2iS0î\'û£à]Iê555ºººLÜŒsçÎ}—„£Ç»’Ôkll<”Äc¬³³sÌÊ£<#ŸÏÚÚÚn544Œ&áØä]I&$oØ½Ç‰‡-Y.Yþû\'#ŸŒmÞ0‹b8l@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„(³ªªªÁŠŸ\Z¹\\®×–ŠWoO#u¶0íU‡ÕPòªÃj(iÕaµ”¼ê°Ú\0JZuXm\0%¯:¬6€’W¶ð£’•Åª$§’q5ž$ÿ}¸êÈ\'£\'¾žÄäXMMM•­•}HR›ÄàëäŸ…Ÿ»ùkÊMþ\\Kuuõ¿ÛŠP!,XðÛdò_b,;bxæÏŸÿk[æ¨yóæ=W\nÉ¡È#XµjUØµkWhjj\n—.]\n]]]áÖ­[¡££#\\¼x1466†÷ß?,_¾üÇ\"rØ†9féÒ¥Ï&Áè™:ácÚÚÚÂtŽŽŽ‡eëÖ­[}|·dÉ’_ÚÚ0ÄsÉ)žä›7o×¯_O\"¤¾¾~j@úº@Æ%«€IV\Z&&vMMM8pà@xZâ\nä£>z$Vás\Z/­ŽOèd2‡–––0â9¥âÃ{\0²¹Ú¸T¼Òhmm\r3)ÆÃ	SÈ°x£Vñ$þüóÏÃl˜zØâ|dÈÃ»=Ç\'ï;ï¼fK<çQ|Â4Þçao@6¢ñJñ!ÊÍ›7ÃlŠW[ŠWî0…l„ãÆÄ¤‡åP|ŸG¼éÌ^Ëår¿*þ¯}¼û³¦¬:FíH÷jcòY\Zë×¯åÏußžîSµb?í:>Y?ýôÓPNñvö¢Ã•cö¤÷Peò†¯øá´ršr_ÇU{ÒŽÉÏ¤ÌöÕ”©b¸ŠÂÑcï@zÏqL>”\'ŸÏ—5ñ#ùEáÈÛ;ÞpLNÖrëééqe²Ž‘‘‘²†#>¨èï3lï@zÃñ Ü÷p<î^ßÏ)V|U%NÜrŠ!tU2 >cb²:t¨¬áˆÏ0-\nÇ){ÒŽ“uãÆe\rÇÊ•+‹UVÙ;Rñ¡ÄÅ\'H{{{Ëø\0ä¢¿Ç˜=)Wü,ŽrÝv>åvsÏä€´«®®Þ61ikkkg}ÕŸž>å‚µö\ndcÕÑ?1q?üðÃY\rGüê…¢h|oo@Fär¹ºâÿêŸ:ujV¢¿z¡øÿ7~Ý¤½ÙZuÜ(þj„öööFüê…ä0É“¿ ã«Žø4°üÄD^±bÅŒÅ#~õÂâÅ‹ÿÏ§aã÷ºØÍxü[¼Z¼òxÚ‡-ñ«ŠW\Zñ£ýñ²°­ÙŽÇªâxLœ0}Ò«-ñyñ«¦\\Ayà©æ0·VùâI/ÕÆû<J\rHüð\\|zzñW>N|-~W­­\rsïœÇ)+„ÉÛÓãg[âãb&>’Wñi^12ñÈûóñë&Ó€¹ºâû<žpôx‚9T‡w˜öü?ƒW.¯ØŠP¡âø©Úø‘ü‡ÏóxPˆB¼JòðüEüê…·ã!­\0\0\0\0\0\0\0ÀLù_^üEˆ¹ân\0\0\0\0IEND®B`‚',1),
('62502',1,'processes/test3.bpmn','62501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n             xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\"\r\n             xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\r\n             xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\"\r\n             typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\"\r\n             targetNamespace=\"http://www.activiti.org/processdef\">\r\n\r\n    <process id=\"test01\" name=\"test01\" isExecutable=\"true\">\r\n        <startEvent id=\"sid-d0c54d06-2073-4018-8381-e5e43f1b5578\" name=\"Start\"/>\r\n\r\n        <serviceTask id=\"sid-0396a986-7e6b-4634-883b-1ee7db9aeb45\"\r\n                     activiti:exclusive=\"true\"\r\n                     name=\"Step1\"\r\n                     activiti:class=\"com.example.actividemo.ServiceTask1\">\r\n            <extensionElements>\r\n                <activiti:field name=\"text1\">\r\n                    <activiti:string><![CDATA[test1]]></activiti:string>\r\n                </activiti:field>\r\n            </extensionElements>\r\n        </serviceTask>\r\n\r\n        <sequenceFlow id=\"sid-05a29cc5-7a04-4282-be89-4d83f943774b\" sourceRef=\"sid-d0c54d06-2073-4018-8381-e5e43f1b5578\"\r\n                      targetRef=\"sid-0396a986-7e6b-4634-883b-1ee7db9aeb45\"/>\r\n\r\n        <serviceTask id=\"sid-c43c4370-4407-4746-893f-dcee3e4e9936\"\r\n                     activiti:exclusive=\"true\"\r\n                     name=\"Step2\"\r\n                     activiti:class=\"com.example.actividemo.ServiceTask2\">\r\n            <extensionElements>\r\n                <activiti:field name=\"text2\">\r\n                    <activiti:string><![CDATA[test2]]></activiti:string>\r\n                </activiti:field>\r\n            </extensionElements>\r\n        </serviceTask>\r\n\r\n        <endEvent id=\"sid-665b6b28-9b81-4ab7-ba77-6eb50da3c810\" name=\"End\"/>\r\n        <sequenceFlow id=\"sid-26493bea-97f7-44d4-b7ec-255266dcb8ab\" sourceRef=\"sid-0396a986-7e6b-4634-883b-1ee7db9aeb45\"\r\n                      targetRef=\"sid-c43c4370-4407-4746-893f-dcee3e4e9936\"/>\r\n        <sequenceFlow id=\"sid-9f0f635b-4e97-4e95-b1fd-c9996bf659af\" sourceRef=\"sid-c43c4370-4407-4746-893f-dcee3e4e9936\"\r\n                      targetRef=\"sid-665b6b28-9b81-4ab7-ba77-6eb50da3c810\"/>\r\n    </process>\r\n</definitions>',0),
('65002',1,'processes/test2.bpmn','65001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:exclusive=\"true\" name=\"task1\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n<!--       <bpmn:incoming>Flow_1cydcrq</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_1x26529</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text1\">\n              <activiti:string><![CDATA[test1]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:exclusive=\"true\" name=\"task2\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n<!--       <bpmn:incoming>Flow_1x26529</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_135u817</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text2\">\n              <activiti:string><![CDATA[test2]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('65003',1,'processes/test2.Process_0hy83oz.png','65001','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0ü\0\0\0 ëA·\0\0‚IDATxÚíÝlUåÁÀñ¹DG¢™ü£K4qÿ½ÆÄÌ…ó\ZC2u‹‰1Q“¶`‡\rÚ±	ŠCa†æ•…If²Åà;lV h±¢(/?¤2À••²ÚÒ„ò£ímKéóžç„6·µ´½÷öóIžôöR;çžïžóãžû­o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0@^!|oÓ¦Mï¼þúë­¯¼òJ÷¼yózžzê©ðóŸÿ<Ä¯Ï?ÿü¹…v¾øâ‹ŸÏž=ûKÆ°Ý»w¿þûßÿþìÌ™3Ã¬Y³ÂÛo¿ªªªÂ¾}ûBccc8zôh¨¯¯{÷îMŸ_¾|yxòÉ\'CYYYÏ³Ï>[3}úôï[Š0Fìß¿ö²eËºüñ°jÕª4CQ[[Þzë­ð³Ÿý,üâ¿Øõè£Ž·T¡pwIÆmÜ¸ñHFœ=´´´„KÑÔÔ–.]\Z’pô=f	CÇX±bEg²›‘Î.§êêêðÈ#¼iICáDãûÉÌ gÞ¼y—<Ëø*qw\'L2eJ•%°{òÖ[ou½ðÂ!“É„á£4cÆŒ¸Ûòº%y¬¼¼üXÜ=®™ÆÅf?ýéOƒc§víÚõ?ñ@èáÃ‡ÃHÚ³gOÜe9çlä¡¥K—ž[¹re\r‹-êNf›­È#Ÿ|òÉ_ãl£­­mTÂOÕ&³Ž‰AY¼xqOyyyM¿ûÝï:‹‹‹·Z\Zÿ;^WqúôéQ\rÇÁƒCIII§5yàwÞÙ±`Á‚JKKÏ=üðÃ?²V Ç-Y²äìºuër\"/¿ür&Ù])·V ÇÍŸ?¿\'¾Ã5üíokMÂqÐZ÷Ë_þ2=«‘vìØÑ‘„ã¸µ9.îËË«®®î\\ŽŒµ9.ÙPC®8vìXwòïé¶V Ç•––†®®®\\™qÄƒ£NÉB®‹·÷‹·ýËŸ|òÉ©’’’krÜsÏ=—3gUÖ¬YsÂYÈóçÏoÝ´iSN„cÞ¼yG’pl±V Ç-X°à-Z”á˜<yr×”)SŠ¬Èqñ>S§NõS²ÿú×¿Z’ÙÆYkòÄÓO?Ý^YY9ªáHv™í¶6 OLŸ>}ÚO<1j§e;v*™mœKvS&ZGžzê©Ó£õf·™3g6$áø?kòL|;{ü´µ‘¾¦cÇŽ‡ãlÃÝ¿ O=öØc={öˆ(MvQâÑx™ù‹–>ä÷ñŽÚ—_~9twwk4ÚÛÛ;\'OžÜæþP\0&Mš4nêÔ©§~ó›ßô×Ì#™iœ|ä‘GÜ{\n-¥¥¥ÿœ9sfÏå>æ±gÏž/âî‰C€URRòv23èY½zõ¹K=U{æÌ™Ž¹sçÖÅ¡ÉxÉÒ…Ï¶$iHv_âG(tu÷åÄ‰m‹/>ƒ‘Ì2>è¡‡&Xª0F$~i2Ž$	³fÍê\\³fMÇîÝ»»š››ûf#íííÝõõõ™íÛ·ŸNbÑìîÄãñƒ¥¹{9Œañ½-qW#ØŒ÷Îˆï/‰w;?z’çºâóI,ö%ßÏ‰ÇK,5à«f$ÁR\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0„@8\0á\0„@8\0„@8€œUTTÔCñu£¤¤¤Å’²g/\r\"³,)`Ð³³\r`È³³\r`H³³\r`È³³\r`H³³\r`È³³\r`È³Kò¬Ã’€BW[[[·}ûöž-[¶„Í›7#<*++CUUUkEEÅc^‘ä…ÏÉ‹6$ñ­­­¡³³Óá—{MMMxï½÷zÄƒ¼ðá‡†úúzpŒt\'3f¯Jr^œ*g2nŽÌ<’õÑãUI^„ÃF›;#®¯J\n*M\'ZÃÓ+÷¤#>¶¡ÂqÁèèèÇO·÷}ÿÁæ¾pÄÇ½Ï=ÙNži·ác=1\ZoTž_óY¨Ø{$¼¿¿)¼°ö}áˆãóÿ´!<—üÌ’ÿ§ZÅC8ÓáøòT[˜»ú³¾P|Ó˜óçêðÅ—§müÂÁXßU)ßÓ8èp¬Þþo¾p éîIož]Uþ´íp¨m>™Žø8>×ûçªmøÂÁXG<c~fÓˆ¡øsñ¹ìcñ¿q¶E8£á¸Ø®Hœeü¹øÜÅ~V\0„áá\0»*ÂÃzp´yÐGãÏÚð…á?üéØõŸ6Øð…ƒ±ŽxX¼jt°áøÕêêôÒs¿p0†ÃÑÖÞÞ¨<˜îŽ¼³³>lÙß|Á%çñ:xÙyÌ>¨\r™Ž¿p0ÖwUb<š[Z¿ñMn\'N·‹†p ÞV/p™Âa‡p€p‡p€pÂpÂpÂÂ! ÂÂaÂaÂa‡p€p‡!‡!‡! ÂÂ! Â!Ç²áÜu×]—ô;’ÿYéøª?omm\r“&MúÚŸÈ£p|ÓF©¿ãã?wÞyçeù{„áÈ¡hdoÔÛ¶m&LW]uU¸ñÆÃÊ•+ÓçËËËÃm·Ý®¾úêpíµ×†{ï½7ÔÔÔ\\Ž…¦Ÿyæ™¾?›8q¢p@!Ï8b46nÜöïßŸ>Ýu×¥ÏÇ¯ñû8ƒX¿~}úøöÛoï÷;^}õÕôë´iÓú~ß<ššš„\n9‡\nsæÌ	·Þzk¿?»ûî»ÓÇW^ye¸çž{Â²eËÒ dÿŽ+®¸\"ýºdÉ’aÙ%„#GÃwGâ÷+V¬è÷ggÎœ	›6m\neeeá†nHŸ¿å–[úýŽ3f¤»27ß|³p@!‡ãšk®I7è†††ÐÒÒ’¿ˆßÇHdoìwÜqGúxÃ†\raÇŽéã›nºé‚(¥+**„\n5¯½öZ¸þúëÓ]åË—‡¥K—¦ñ(..î·±×ÕÕ…ûï¿?Œ?>MÉÖ­[/ˆÂÚµkÓÇ>ø p@¡†Ã`ÂpÂpÂÂ! ÂÂ! †p †p †p€p‡p€pÂpÂpÂÂ! ÂÂaÂaÂa‡p€p‡p€pÂpÂÂ! ÂÂ! †pP(áèèè°ÑæÀhkk;“¬¯Jr^UUUOcc£\r7ÆÎ;%á8îUIÎ«¬¬\\—Äã\\CCÃ93Ñ™L¦§¦¦æhEEEwŽ½*ÉÉvÕ»ï¾Ûw[òu‡|þ÷\'#“ŒÅ^0‚b8,@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8€Ë®¨¨¨=†âëFIII‹%dÏ.^\ZD8fYRÀ gfÀgfÀffÀgfÀffÀgfÀg–0äY‡%#$„0®¶¶¶nûöí=[¶l	›7o6FxTVV†ªªªÖŠŠŠÇ¼\"ÉŸ\'’mHâZ[[Cgg§1Â#.÷šššðÞ{ïõˆyáÃ?õõõ6àèNf Í^•ä¼8UÎd26Ü™y$ë£Ç«’¼‡6wF\\^•T8šN´†§WîIG|lC„ã‚ÑÑÑŽŸnïûþƒÍ}áˆ{Ÿ?z²-œ<ÓnÃÆz8b4Þþ¨.<¿æ³P±÷HxSxaí?úÂÇçÿþiCx.ù™%ÿNµŠ‡p0¦Ãñå©¶0wõg}¡ø¦1çÏÕá‹/OÛø…ƒ±¾«R¾§qÐáX½ýß6|á@8:ÓÝ“Þ0<»ª:üiÛáPÛ|2ñq|®÷Ï7T7Úð…ƒ±ŽxÆ$üÌ>¦C1ðçâsÙÇ<âãl‹p0FÃq±]‘8Ëøsñ¹‹ý¬\0Â!ÂvU„†õàhó ŽÆŸµáÂ6~6øÓ±ë?m°ác=ñ°xÕè`Ãñ«ÕÕé¥ç6~á`‡£­½#¼Qy0Ýygg}Ø²¿ù‚KÎãuñ²ó˜?|P26~á`¬ïªÄx4·´~ã›ÜNœn\rá@8¼­^8à2…Ãá\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8„C8Ž¡n4wÝu×%ýŽäR:.úS7†[o½5Œ7.üð‡?»víÈ÷p|ÝF9~ÇÄ‰Ãw¾óðþûï§?sÛm·	äs8z7øì\rÛ¶maÂ„	áª«®\n7ÞxcX¹reú|yyyºÑ_}õÕáÚk¯\r÷Þ{o¨©©¹ .L?óÌ3ýþ®#GŽ¤Ï÷»ß(´GŒFÜ½Ø¿úüu×]—>¿Æï?þøã°~ýúôñí·ßÞïw¼úê«é×iÓ¦]ð÷ÌŸ??ý³ûî»O8 ÐÂqèÐ¡0gÎœô¸DöŸÝ}÷Ýéã+¯¼2ÜsÏ=aÙ²e¡©©©ßï¸âŠ+Ò¯K–,é÷wÄYË·¿ýípÃ\r7„ƒ\nZ8âîHü~ÅŠýþìÌ™3aÓ¦M¡¬¬,\r@|þ–[né÷;fÌ˜‘îÊÜ|óÍ}¿ï£>Jw{~ðƒ¤QrV\n ×\\sMºÑ744„–––ôøEü>F\";wÜqGúxÃ†\raÇŽéã›nºé‚ø¥+**Òïüã‡Ÿüä\'áäÉ“NÇB¡„ãµ×^×_}º²|ùò°téÒ4ÅÅÅý‚PWWî¿ÿþ0~üø461$[·n½ k×®M?øàƒýŽôŽ_ÿú×ÂùC8C8C8@8„„C8@8„„Ã„Ã„Ã+ ÂÂ! †p †p †p€p‡p€pÂpÂpÂÂ! ÂÂ!ÂpÂpÂÂ! ÂÂ! †pPHáèèè°ÑæÀhkk;“¬¯Jr^UUUOcc£\r7ÆÎ;%á8îUIÎ«¬¬\\—Äã\\CCÃ93Ñ™L¦§¦¦æhEEEwŽ½*ÉÉvÕ»ï¾Ûw[òu‡|þ÷\'#“ŒÅ^0‚b8,@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„eEEEí1_7JJJZ,) {vñÒ Â1Ë’=ë0Û\0†<ë0Û\0†4ë0Û\0†<ë0Û\0†4ë0Û\0†<ë0Û\0†<ë°$€¯”Ì,Ê’PlMÆÁ¸{’|í>?ëÈ$ãx|>‰Éæ)S¦YZ0¶wIJ“|ž|íù¦‹¿Œîä¿Û=yòäû,E#~øá%ÿCŒÅEGÏC=4ÁR…5iÒ¤qq¦ìŠ\\€²²²°|ùòPUUöíÛ\ZÃÑ£GC}}}Ø»wo¨¬¬o¼ñFxüñÇ¿*\"å–0˜éÓ§?	Æñ|ŒAMMM¬îîî4,¯¼òÊÅf‡}ôÑñ–6€x,\"]Ùù¢E‹ÂáÃ‡Ã¥ˆ™7oÞÀ€´Úu<—Ìþ+™iœíÝ°§L™Ö®].—8ùãÿxA<Ì< iœ?µšnÐÉÆvïÞ†C<£”½Ûb\r@~Î6öeÏ4ª««ÃpŠñpÀòX¼P+{#^¿~}	w[ï€<rþjÏtãýíoFJ<æ‘}À4^çam@~DcNö.JSSSIñlKö¬Ã¦á8Ò»ÑÆ]‡Ñ}G¼èÌZVRRò½ìÿ·WŽ†³Žnkr{¶Ñw/¹sç†Ñud_žî]µÃÎ¿Û5ÝXÿò—¿„Ñ/gÏÚ]Ùlí@îîªô]ðßœ6š\\×qÐÚÜ\rGß{RFúlÊ@1\\Yá8ní@îãè»)O&“ÕpÄ·äg…#cí@î†£ocmÇwfò-]]]£\ZŽx3 ¬O§µ¹Ž³£}\rÇÅ®åðù,Ã²ÏªÄ\rw4ÅÛ:«y Þ£wc]·nÝ¨†#ÞÃ4+[­ÈÝp¼Þ»±.X°`TÃñä“Ofïª”Y;£âM‰³¶´´ŒJ4â\r³þç¬ÈqÙ÷â­ËÎ\\nîžë&Ož¼¸w£---ñYG¼{ú€[–Z+³ŽÖÞ\r÷Í7ßÑpÄ^ÈŠÆÖä‰’’’YÙÿ¯¿uëÖ‰Füè…ì¿7~Ü¤µù5ë8’ýÑµµµÃ\ZøÑÉn’;AžÏ:âÝÀ2½òO<1lñˆ½0uêÔ~ï†Ÿëb-@~ÆãÎx:4{æq¹w[âG/dÏ4â[ûãiaKò;eÙñè=`z©g[âý>âG/8ƒrÖ]Í¡°f™ì<žª×y5 ñÍsñîéÙùØûF¶øYµ–6Þ1#f}—§Ç÷¶Ä7ÆÅ0ô¾%?Þ(Î,âÝ¼bdâ\r/ößÇ›tL\n; ³²¯ó¸ÄqÜÌa9…éñÿ0qæ2ÇR„1*ž‰ïªoÉ??³Yè‰gIÎ¿ˆ½ðRÜå±Ô\0\0\0\0\0\0\0\0.ÿným…³w\0\0\0\0IEND®B`‚',1),
('70002',1,'processes/test2.bpmn','70001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:exclusive=\"true\" name=\"task1\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n<!--       <bpmn:incoming>Flow_1cydcrq</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_1x26529</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text1\">\n              <activiti:string><![CDATA[test1]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:exclusive=\"true\" name=\"task2\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n<!--       <bpmn:incoming>Flow_1x26529</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_135u817</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text2\">\n              <activiti:string><![CDATA[test2]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('70003',1,'processes/test2.Process_0hy83oz.png','70001','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0ü\0\0\0 ëA·\0\0‚IDATxÚíÝlUåÁÀñ¹DG¢™ü£K4qÿ½ÆÄÌ…ó\ZC2u‹‰1Q“¶`‡\rÚ±	ŠCa†æ•…If²Åà;lV h±¢(/?¤2À••²ÚÒ„ò£ímKéóžç„6·µ´½÷öóIžôöR;çžïžóãžû­o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0@^!|oÓ¦Mï¼þúë­¯¼òJ÷¼yózžzê©ðóŸÿ<Ä¯Ï?ÿü¹…v¾øâ‹ŸÏž=ûKÆ°Ý»w¿þûßÿþìÌ™3Ã¬Y³ÂÛo¿ªªªÂ¾}ûBccc8zôh¨¯¯{÷îMŸ_¾|yxòÉ\'CYYYÏ³Ï>[3}úôï[Š0Fìß¿ö²eËºüñ°jÕª4CQ[[Þzë­ð³Ÿý,üâ¿Øõè£Ž·T¡pwIÆmÜ¸ñHFœ=´´´„KÑÔÔ–.]\Z’pô=f	CÇX±bEg²›‘Î.§êêêðÈ#¼iICáDãûÉÌ gÞ¼y—<Ëø*qw\'L2eJ•%°{òÖ[ou½ðÂ!“É„á£4cÆŒ¸Ûòº%y¬¼¼üXÜ=®™ÆÅf?ýéOƒc§víÚõ?ñ@èáÃ‡ÃHÚ³gOÜe9çlä¡¥K—ž[¹re\r‹-êNf›­È#Ÿ|òÉ_ãl£­­mTÂOÕ&³Ž‰AY¼xqOyyyM¿ûÝï:‹‹‹·Z\Zÿ;^WqúôéQ\rÇÁƒCIII§5yàwÞÙ±`Á‚JKKÏ=üðÃ?²V Ç-Y²äìºuër\"/¿ür&Ù])·V ÇÍŸ?¿\'¾Ã5üíokMÂqÐZ÷Ë_þ2=«‘vìØÑ‘„ã¸µ9.îËË«®®î\\ŽŒµ9.ÙPC®8vìXwòïé¶V Ç•––†®®®\\™qÄƒ£NÉB®‹·÷‹·ýËŸ|òÉ©’’’krÜsÏ=—3gUÖ¬YsÂYÈóçÏoÝ´iSN„cÞ¼yG’pl±V Ç-X°à-Z”á˜<yr×”)SŠ¬Èqñ>S§NõS²ÿú×¿Z’ÙÆYkòÄÓO?Ý^YY9ªáHv™í¶6 OLŸ>}ÚO<1j§e;v*™mœKvS&ZGžzê©Ó£õf·™3g6$áø?kòL|;{ü´µ‘¾¦cÇŽ‡ãlÃÝ¿ O=öØc={öˆ(MvQâÑx™ù‹–>ä÷ñŽÚ—_~9twwk4ÚÛÛ;\'OžÜæþP\0&Mš4nêÔ©§~ó›ßô×Ì#™iœ|ä‘GÜ{\n-¥¥¥ÿœ9sfÏå>æ±gÏž/âî‰C€URRòv23èY½zõ¹K=U{æÌ™Ž¹sçÖÅ¡ÉxÉÒ…Ï¶$iHv_âG(tu÷åÄ‰m‹/>ƒ‘Ì2>è¡‡&Xª0F$~i2Ž$	³fÍê\\³fMÇîÝ»»š››ûf#íííÝõõõ™íÛ·ŸNbÑìîÄãñƒ¥¹{9Œañ½-qW#ØŒ÷Îˆï/‰w;?z’çºâóI,ö%ßÏ‰ÇK,5à«f$ÁR\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0„@8\0á\0„@8\0„@8€œUTTÔCñu£¤¤¤Å’²g/\r\"³,)`Ð³³\r`È³³\r`H³³\r`È³³\r`H³³\r`È³³\r`È³Kò¬Ã’€BW[[[·}ûöž-[¶„Í›7#<*++CUUUkEEÅc^‘ä…ÏÉ‹6$ñ­­­¡³³Óá—{MMMxï½÷zÄƒ¼ðá‡†úúzpŒt\'3f¯Jr^œ*g2nŽÌ<’õÑãUI^„ÃF›;#®¯J\n*M\'ZÃÓ+÷¤#>¶¡ÂqÁèèèÇO·÷}ÿÁæ¾pÄÇ½Ï=ÙNži·ác=1\ZoTž_óY¨Ø{$¼¿¿)¼°ö}áˆãóÿ´!<—üÌ’ÿ§ZÅC8ÓáøòT[˜»ú³¾P|Ó˜óçêðÅ—§müÂÁXßU)ßÓ8èp¬Þþo¾p éîIož]Uþ´íp¨m>™Žø8>×ûçªmøÂÁXG<c~fÓˆ¡øsñ¹ìcñ¿q¶E8£á¸Ø®Hœeü¹øÜÅ~V\0„áá\0»*ÂÃzp´yÐGãÏÚð…á?üéØõŸ6Øð…ƒ±ŽxX¼jt°áøÕêêôÒs¿p0†ÃÑÖÞÞ¨<˜îŽ¼³³>lÙß|Á%çñ:xÙyÌ>¨\r™Ž¿p0ÖwUb<š[Z¿ñMn\'N·‹†p ÞV/p™Âa‡p€p‡p€pÂpÂpÂÂ! ÂÂaÂaÂa‡p€p‡!‡!‡! ÂÂ! Â!Ç²áÜu×]—ô;’ÿYéøª?omm\r“&MúÚŸÈ£p|ÓF©¿ãã?wÞyçeù{„áÈ¡hdoÔÛ¶m&LW]uU¸ñÆÃÊ•+ÓçËËËÃm·Ý®¾úêpíµ×†{ï½7ÔÔÔ\\Ž…¦Ÿyæ™¾?›8q¢p@!Ï8b46nÜöïßŸ>Ýu×¥ÏÇ¯ñû8ƒX¿~}úøöÛoï÷;^}õÕôë´iÓú~ß<ššš„\n9‡\nsæÌ	·Þzk¿?»ûî»ÓÇW^ye¸çž{Â²eËÒ dÿŽ+®¸\"ýºdÉ’aÙ%„#GÃwGâ÷+V¬è÷ggÎœ	›6m\neeeá†nHŸ¿å–[úýŽ3f¤»27ß|³p@!‡ãšk®I7è†††ÐÒÒ’¿ˆßÇHdoìwÜqGúxÃ†\raÇŽéã›nºé‚(¥+**„\n5¯½öZ¸þúëÓ]åË—‡¥K—¦ñ(..î·±×ÕÕ…ûï¿?Œ?>MÉÖ­[/ˆÂÚµkÓÇ>ø p@¡†Ã`ÂpÂpÂÂ! ÂÂ! †p †p †p€p‡p€pÂpÂpÂÂ! ÂÂaÂaÂa‡p€p‡p€pÂpÂÂ! ÂÂ! †pP(áèèè°ÑæÀhkk;“¬¯Jr^UUUOcc£\r7ÆÎ;%á8îUIÎ«¬¬\\—Äã\\CCÃ93Ñ™L¦§¦¦æhEEEwŽ½*ÉÉvÕ»ï¾Ûw[òu‡|þ÷\'#“ŒÅ^0‚b8,@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8€Ë®¨¨¨=†âëFIII‹%dÏ.^\ZD8fYRÀ gfÀgfÀffÀgfÀffÀgfÀg–0äY‡%#$„0®¶¶¶nûöí=[¶l	›7o6FxTVV†ªªªÖŠŠŠÇ¼\"ÉŸ\'’mHâZ[[Cgg§1Â#.÷šššðÞ{ïõˆyáÃ?õõõ6àèNf Í^•ä¼8UÎd26Ü™y$ë£Ç«’¼‡6wF\\^•T8šN´†§WîIG|lC„ã‚ÑÑÑŽŸnïûþƒÍ}áˆ{Ÿ?z²-œ<ÓnÃÆz8b4Þþ¨.<¿æ³P±÷HxSxaí?úÂÇçÿþiCx.ù™%ÿNµŠ‡p0¦Ãñå©¶0wõg}¡ø¦1çÏÕá‹/OÛø…ƒ±¾«R¾§qÐáX½ýß6|á@8:ÓÝ“Þ0<»ª:üiÛáPÛ|2ñq|®÷Ï7T7Úð…ƒ±ŽxÆ$üÌ>¦C1ðçâsÙÇ<âãl‹p0FÃq±]‘8Ëøsñ¹‹ý¬\0Â!ÂvU„†õàhó ŽÆŸµáÂ6~6øÓ±ë?m°ác=ñ°xÕè`Ãñ«ÕÕé¥ç6~á`‡£­½#¼Qy0Ýygg}Ø²¿ù‚KÎãuñ²ó˜?|P26~á`¬ïªÄx4·´~ã›ÜNœn\rá@8¼­^8à2…Ãá\0áá\0á0„á0„á0„„C8@8„„Ã„Ã„Ãá\0áC8C8C8@8„„C8@8„C8Ž¡n4wÝu×%ýŽäR:.úS7†[o½5Œ7.üð‡?»víÈ÷p|ÝF9~ÇÄ‰Ãw¾óðþûï§?sÛm·	äs8z7øì\rÛ¶maÂ„	áª«®\n7ÞxcX¹reú|yyyºÑ_}õÕáÚk¯\r÷Þ{o¨©©¹ .L?óÌ3ýþ®#GŽ¤Ï÷»ß(´GŒFÜ½Ø¿úüu×]—>¿Æï?þøã°~ýúôñí·ßÞïw¼úê«é×iÓ¦]ð÷ÌŸ??ý³ûî»O8 ÐÂqèÐ¡0gÎœô¸DöŸÝ}÷Ýéã+¯¼2ÜsÏ=aÙ²e¡©©©ßï¸âŠ+Ò¯K–,é÷wÄYË·¿ýípÃ\r7„ƒ\nZ8âîHü~ÅŠýþìÌ™3aÓ¦M¡¬¬,\r@|þ–[né÷;fÌ˜‘îÊÜ|óÍ}¿ï£>Jw{~ðƒ¤QrV\n ×\\sMºÑ744„–––ôøEü>F\";wÜqGúxÃ†\raÇŽéã›nºé‚ø¥+**Òïüã‡Ÿüä\'áäÉ“NÇB¡„ãµ×^×_}º²|ùò°téÒ4ÅÅÅý‚PWWî¿ÿþ0~üø461$[·n½ k×®M?øàƒýŽôŽ_ÿú×ÂùC8C8C8@8„„C8@8„„Ã„Ã„Ã+ ÂÂ! †p †p †p€p‡p€pÂpÂpÂÂ! ÂÂ!ÂpÂpÂÂ! ÂÂ! †pPHáèèè°ÑæÀhkk;“¬¯Jr^UUUOcc£\r7ÆÎ;%á8îUIÎ«¬¬\\—Äã\\CCÃ93Ñ™L¦§¦¦æhEEEwŽ½*ÉÉvÕ»ï¾Ûw[òu‡|þ÷\'#“ŒÅ^0‚b8,@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„\0á\0„@8\0á\0@8\0á\0„\0á\0„@8\0á\0@8\0á\0„@8\0„@8\0á\0„@8\0á\0„@8\0„@8\0á\0„@8\0á\0„eEEEí1_7JJJZ,) {vñÒ Â1Ë’=ë0Û\0†<ë0Û\0†4ë0Û\0†<ë0Û\0†4ë0Û\0†<ë0Û\0†<ë°$€¯”Ì,Ê’PlMÆÁ¸{’|í>?ëÈ$ãx|>‰Éæ)S¦YZ0¶wIJ“|ž|íù¦‹¿Œîä¿Û=yòäû,E#~øá%ÿCŒÅEGÏC=4ÁR…5iÒ¤qq¦ìŠ\\€²²²°|ùòPUUöíÛ\ZÃÑ£GC}}}Ø»wo¨¬¬o¼ñFxüñÇ¿*\"å–0˜éÓ§?	Æñ|ŒAMMM¬îîî4,¯¼òÊÅf‡}ôÑñ–6€x,\"]Ùù¢E‹ÂáÃ‡Ã¥ˆ™7oÞÀ€´Úu<—Ìþ+™iœíÝ°§L™Ö®].—8ùãÿxA<Ì< iœ?µšnÐÉÆvïÞ†C<£”½Ûb\r@~Î6öeÏ4ª««ÃpŠñpÀòX¼P+{#^¿~}	w[ï€<rþjÏtãýíoFJ<æ‘}À4^çam@~DcNö.JSSSIñlKö¬Ã¦á8Ò»ÑÆ]‡Ñ}G¼èÌZVRRò½ìÿ·WŽ†³Žnkr{¶Ñw/¹sç†Ñud_žî]µÃÎ¿Û5ÝXÿò—¿„Ñ/gÏÚ]Ùlí@îîªô]ðßœ6š\\×qÐÚÜ\rGß{RFúlÊ@1\\Yá8ní@îãè»)O&“ÕpÄ·äg…#cí@î†£ocmÇwfò-]]]£\ZŽx3 ¬O§µ¹Ž³£}\rÇÅ®åðù,Ã²ÏªÄ\rw4ÅÛ:«y Þ£wc]·nÝ¨†#ÞÃ4+[­ÈÝp¼Þ»±.X°`TÃñä“Ofïª”Y;£âM‰³¶´´ŒJ4â\r³þç¬ÈqÙ÷â­ËÎ\\nîžë&Ož¼¸w£---ñYG¼{ú€[–Z+³ŽÖÞ\r÷Í7ßÑpÄ^ÈŠÆÖä‰’’’YÙÿ¯¿uëÖ‰Füè…ì¿7~Ü¤µù5ë8’ýÑµµµÃ\ZøÑÉn’;AžÏ:âÝÀ2½òO<1lñˆ½0uêÔ~ï†Ÿëb-@~ÆãÎx:4{æq¹w[âG/dÏ4â[ûãiaKò;eÙñè=`z©g[âý>âG/8ƒrÖ]Í¡°f™ì<žª×y5 ñÍsñîéÙùØûF¶øYµ–6Þ1#f}—§Ç÷¶Ä7ÆÅ0ô¾%?Þ(Î,âÝ¼bdâ\r/ößÇ›tL\n; ³²¯ó¸ÄqÜÌa9…éñÿ0qæ2ÇR„1*ž‰ïªoÉ??³Yè‰gIÎ¿ˆ½ðRÜå±Ô\0\0\0\0\0\0\0\0.ÿným…³w\0\0\0\0IEND®B`‚',1);

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL,
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values 
('cfg.execution-related-entities-count','false',1),
('next.dbid','72501',30),
('schema.history','create(6.0.0.4)',1),
('schema.version','6.0.0.4',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_actinst` */

insert  into `act_hi_actinst`(`ID_`,`PROC_DEF_ID_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`ACT_ID_`,`TASK_ID_`,`CALL_PROC_INST_ID_`,`ACT_NAME_`,`ACT_TYPE_`,`ASSIGNEE_`,`START_TIME_`,`END_TIME_`,`DURATION_`,`DELETE_REASON_`,`TENANT_ID_`) values 
('12509','oneTaskProcess:1:12506','12507','12508','theStart',NULL,NULL,NULL,'startEvent',NULL,'2022-08-31 14:58:17.758','2022-08-31 14:58:17.760',2,NULL,''),
('12510','oneTaskProcess:1:12506','12507','12508','theTask','12511',NULL,'my task','userTask',NULL,'2022-08-31 14:58:17.762',NULL,NULL,NULL,''),
('17507','Process_0wu4lop:4:17504','17505','17506','StartEvent_0vx5axl',NULL,NULL,NULL,'startEvent',NULL,'2022-09-01 17:07:55.014','2022-09-01 17:07:55.015',1,NULL,''),
('17508','Process_0wu4lop:4:17504','17505','17506','Activity_0nt5d38',NULL,NULL,'approve','manualTask',NULL,'2022-09-01 17:07:55.016','2022-09-01 17:07:55.017',1,NULL,''),
('17509','Process_0wu4lop:4:17504','17505','17506','Event_1294r00',NULL,NULL,NULL,'endEvent',NULL,'2022-09-01 17:07:55.017','2022-09-01 17:07:55.017',0,NULL,''),
('30003','Process_0wu4lop:9:25004','30001','30002','StartEvent_0vx5axl',NULL,NULL,NULL,'startEvent',NULL,'2022-09-08 14:27:21.811','2022-09-08 14:27:21.813',2,NULL,''),
('30004','Process_0wu4lop:9:25004','30001','30002','Activity_0nt5d38',NULL,NULL,'approve','manualTask',NULL,'2022-09-08 14:27:21.814','2022-09-08 14:27:21.814',0,NULL,''),
('30005','Process_0wu4lop:9:25004','30001','30002','Event_1294r00',NULL,NULL,NULL,'endEvent',NULL,'2022-09-08 14:27:21.814','2022-09-08 14:27:21.814',0,NULL,''),
('32507','Process_0wu4lop:9:32504','32505','32506','StartEvent_0vx5axl',NULL,NULL,NULL,'startEvent',NULL,'2022-09-08 15:08:09.481','2022-09-08 15:08:09.483',2,NULL,''),
('32508','Process_0wu4lop:9:32504','32505','32506','Activity_0nt5d38',NULL,NULL,'approve','serviceTask',NULL,'2022-09-08 15:08:09.484','2022-09-08 15:08:09.486',2,NULL,''),
('32509','Process_0wu4lop:9:32504','32505','32506','Event_1294r00',NULL,NULL,NULL,'endEvent',NULL,'2022-09-08 15:08:09.486','2022-09-08 15:08:09.486',0,NULL,''),
('40007','Process_0hy83oz:1:40004','40005','40006','StartEvent_07jmeqi',NULL,NULL,NULL,'startEvent',NULL,'2022-09-09 13:47:17.462','2022-09-09 13:47:17.464',2,NULL,''),
('40008','Process_0hy83oz:1:40004','40005','40006','Activity_1tlvosh',NULL,NULL,NULL,'serviceTask',NULL,'2022-09-09 13:47:17.466','2022-09-09 13:47:17.468',2,NULL,''),
('40009','Process_0hy83oz:1:40004','40005','40006','Activity_00xge6t',NULL,NULL,NULL,'serviceTask',NULL,'2022-09-09 13:47:17.469','2022-09-09 13:47:17.469',0,NULL,''),
('40010','Process_0hy83oz:1:40004','40005','40006','Event_0j69tgw',NULL,NULL,NULL,'endEvent',NULL,'2022-09-09 13:47:17.469','2022-09-09 13:47:17.469',0,NULL,''),
('42503','Process_0hy83oz:1:40004','42501','42502','StartEvent_07jmeqi',NULL,NULL,NULL,'startEvent',NULL,'2022-09-09 13:49:45.570','2022-09-09 13:49:45.572',2,NULL,''),
('42504','Process_0hy83oz:1:40004','42501','42502','Activity_1tlvosh',NULL,NULL,NULL,'serviceTask',NULL,'2022-09-09 13:49:45.573','2022-09-09 13:49:45.575',2,NULL,''),
('42505','Process_0hy83oz:1:40004','42501','42502','Activity_00xge6t',NULL,NULL,NULL,'serviceTask',NULL,'2022-09-09 13:49:45.575','2022-09-09 13:49:45.575',0,NULL,''),
('42506','Process_0hy83oz:1:40004','42501','42502','Event_0j69tgw',NULL,NULL,NULL,'endEvent',NULL,'2022-09-09 13:49:45.575','2022-09-09 13:49:45.576',1,NULL,''),
('42513','Process_0hy83oz:2:42510','42511','42512','StartEvent_07jmeqi',NULL,NULL,NULL,'startEvent',NULL,'2022-09-09 13:50:26.164','2022-09-09 13:50:26.164',0,NULL,''),
('42514','Process_0hy83oz:2:42510','42511','42512','Activity_1tlvosh',NULL,NULL,NULL,'serviceTask',NULL,'2022-09-09 13:50:26.165','2022-09-09 13:50:26.165',0,NULL,''),
('42515','Process_0hy83oz:2:42510','42511','42512','Activity_00xge6t',NULL,NULL,NULL,'serviceTask',NULL,'2022-09-09 13:50:26.165','2022-09-09 13:50:26.165',0,NULL,''),
('42516','Process_0hy83oz:2:42510','42511','42512','Event_0j69tgw',NULL,NULL,NULL,'endEvent',NULL,'2022-09-09 13:50:26.165','2022-09-09 13:50:26.165',0,NULL,''),
('70007','Process_0hy83oz:5:70004','70005','70006','StartEvent_07jmeqi',NULL,NULL,NULL,'startEvent',NULL,'2022-09-09 15:18:39.758','2022-09-09 15:18:39.760',2,NULL,''),
('70008','Process_0hy83oz:5:70004','70005','70006','Activity_1tlvosh',NULL,NULL,'task1','serviceTask',NULL,'2022-09-09 15:18:39.762','2022-09-09 15:18:39.765',3,NULL,''),
('70011','Process_0hy83oz:5:70004','70005','70006','Activity_00xge6t',NULL,NULL,'task2','serviceTask',NULL,'2022-09-09 15:18:39.766','2022-09-09 15:18:39.766',0,NULL,''),
('70013','Process_0hy83oz:5:70004','70005','70006','Event_0j69tgw',NULL,NULL,NULL,'endEvent',NULL,'2022-09-09 15:18:39.766','2022-09-09 15:18:39.766',0,NULL,'');

/*Table structure for table `act_hi_attachment` */

DROP TABLE IF EXISTS `act_hi_attachment`;

CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_detail` */

insert  into `act_hi_detail`(`ID_`,`TYPE_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`TASK_ID_`,`ACT_INST_ID_`,`NAME_`,`VAR_TYPE_`,`REV_`,`TIME_`,`BYTEARRAY_ID_`,`DOUBLE_`,`LONG_`,`TEXT_`,`TEXT2_`) values 
('70010','VariableUpdate','70005','70005',NULL,'70008','text','string',0,'2022-09-09 15:18:39.765',NULL,NULL,NULL,'test1',NULL),
('70012','VariableUpdate','70005','70005',NULL,'70011','text','string',0,'2022-09-09 15:18:39.766',NULL,NULL,NULL,'test1test2',NULL);

/*Table structure for table `act_hi_identitylink` */

DROP TABLE IF EXISTS `act_hi_identitylink`;

CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_identitylink` */

/*Table structure for table `act_hi_procinst` */

DROP TABLE IF EXISTS `act_hi_procinst`;

CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_procinst` */

insert  into `act_hi_procinst`(`ID_`,`PROC_INST_ID_`,`BUSINESS_KEY_`,`PROC_DEF_ID_`,`START_TIME_`,`END_TIME_`,`DURATION_`,`START_USER_ID_`,`START_ACT_ID_`,`END_ACT_ID_`,`SUPER_PROCESS_INSTANCE_ID_`,`DELETE_REASON_`,`TENANT_ID_`,`NAME_`) values 
('12507','12507',NULL,'oneTaskProcess:1:12506','2022-08-31 14:58:17.756',NULL,NULL,NULL,'theStart',NULL,NULL,NULL,'',NULL),
('17505','17505',NULL,'Process_0wu4lop:4:17504','2022-09-01 17:07:55.012','2022-09-01 17:07:55.045',33,NULL,'StartEvent_0vx5axl','Event_1294r00',NULL,NULL,'',NULL),
('30001','30001',NULL,'Process_0wu4lop:9:25004','2022-09-08 14:27:21.796','2022-09-08 14:27:21.847',51,NULL,'StartEvent_0vx5axl','Event_1294r00',NULL,NULL,'',NULL),
('32505','32505',NULL,'Process_0wu4lop:9:32504','2022-09-08 15:08:09.478','2022-09-08 15:08:09.501',23,NULL,'StartEvent_0vx5axl','Event_1294r00',NULL,NULL,'',NULL),
('40005','40005',NULL,'Process_0hy83oz:1:40004','2022-09-09 13:47:17.457','2022-09-09 13:47:17.536',79,NULL,'StartEvent_07jmeqi','Event_0j69tgw',NULL,NULL,'',NULL),
('42501','42501',NULL,'Process_0hy83oz:1:40004','2022-09-09 13:49:45.554','2022-09-09 13:49:45.597',43,NULL,'StartEvent_07jmeqi','Event_0j69tgw',NULL,NULL,'',NULL),
('42511','42511',NULL,'Process_0hy83oz:2:42510','2022-09-09 13:50:26.164','2022-09-09 13:50:26.178',14,NULL,'StartEvent_07jmeqi','Event_0j69tgw',NULL,NULL,'',NULL),
('70005','70005',NULL,'Process_0hy83oz:5:70004','2022-09-09 15:18:39.755','2022-09-09 15:18:39.786',31,NULL,'StartEvent_07jmeqi','Event_0j69tgw',NULL,NULL,'',NULL);

/*Table structure for table `act_hi_taskinst` */

DROP TABLE IF EXISTS `act_hi_taskinst`;

CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_taskinst` */

insert  into `act_hi_taskinst`(`ID_`,`PROC_DEF_ID_`,`TASK_DEF_KEY_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`NAME_`,`PARENT_TASK_ID_`,`DESCRIPTION_`,`OWNER_`,`ASSIGNEE_`,`START_TIME_`,`CLAIM_TIME_`,`END_TIME_`,`DURATION_`,`DELETE_REASON_`,`PRIORITY_`,`DUE_DATE_`,`FORM_KEY_`,`CATEGORY_`,`TENANT_ID_`) values 
('12511','oneTaskProcess:1:12506','theTask','12507','12508','my task',NULL,NULL,NULL,NULL,'2022-08-31 14:58:17.771',NULL,NULL,NULL,NULL,50,NULL,NULL,NULL,'');

/*Table structure for table `act_hi_varinst` */

DROP TABLE IF EXISTS `act_hi_varinst`;

CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_hi_varinst` */

insert  into `act_hi_varinst`(`ID_`,`PROC_INST_ID_`,`EXECUTION_ID_`,`TASK_ID_`,`NAME_`,`VAR_TYPE_`,`REV_`,`BYTEARRAY_ID_`,`DOUBLE_`,`LONG_`,`TEXT_`,`TEXT2_`,`CREATE_TIME_`,`LAST_UPDATED_TIME_`) values 
('70009','70005','70005',NULL,'text','string',0,NULL,NULL,NULL,'test1test2',NULL,'2022-09-09 15:18:39.765','2022-09-09 15:18:39.766');

/*Table structure for table `act_id_group` */

DROP TABLE IF EXISTS `act_id_group`;

CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_id_group` */

/*Table structure for table `act_id_info` */

DROP TABLE IF EXISTS `act_id_info`;

CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_id_info` */

/*Table structure for table `act_id_membership` */

DROP TABLE IF EXISTS `act_id_membership`;

CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_id_membership` */

/*Table structure for table `act_id_user` */

DROP TABLE IF EXISTS `act_id_user`;

CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_id_user` */

/*Table structure for table `act_procdef_info` */

DROP TABLE IF EXISTS `act_procdef_info`;

CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_procdef_info` */

/*Table structure for table `act_re_deployment` */

DROP TABLE IF EXISTS `act_re_deployment`;

CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

insert  into `act_re_deployment`(`ID_`,`NAME_`,`CATEGORY_`,`KEY_`,`TENANT_ID_`,`DEPLOY_TIME_`,`ENGINE_VERSION_`) values 
('12501','SpringAutoDeployment',NULL,NULL,'','2022-08-31 14:58:16.500',NULL),
('15001','ç¤ºä¾‹æµç¨‹',NULL,'Process_0wu4lop','','2022-09-01 16:15:04.963',NULL),
('17501','ç¤ºä¾‹æµç¨‹',NULL,'Process_0wu4lop','','2022-09-01 17:05:53.503',NULL),
('20001','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:48:51.816',NULL),
('20005','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:50:30.672',NULL),
('22501','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:51:30.564',NULL),
('22505','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:52:23.886',NULL),
('2501','ç¤ºä¾‹æµç¨‹',NULL,'Process_0wu4lop','','2022-08-31 14:46:47.723',NULL),
('32501','A example process',NULL,'Process_0wu4lop','','2022-09-08 15:07:37.301',NULL),
('40001','A example process',NULL,'Process_0hy83oz','','2022-09-09 13:46:52.971',NULL),
('42507','A example process',NULL,'Process_0hy83oz','','2022-09-09 13:50:15.885',NULL),
('42517','A example process',NULL,'Process_0hy83oz','','2022-09-09 13:59:41.575',NULL),
('62501','A example process',NULL,'test01','','2022-09-09 15:08:04.105',NULL),
('65001','A example process',NULL,'Process_0hy83oz','','2022-09-09 15:13:40.024',NULL),
('70001','A example process',NULL,'Process_0hy83oz','','2022-09-09 15:18:18.084',NULL);

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_re_model` */

/*Table structure for table `act_re_procdef` */

DROP TABLE IF EXISTS `act_re_procdef`;

CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint DEFAULT NULL,
  `SUSPENSION_STATE_` int DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_re_procdef` */

insert  into `act_re_procdef`(`ID_`,`REV_`,`CATEGORY_`,`NAME_`,`KEY_`,`VERSION_`,`DEPLOYMENT_ID_`,`RESOURCE_NAME_`,`DGRM_RESOURCE_NAME_`,`DESCRIPTION_`,`HAS_START_FORM_KEY_`,`HAS_GRAPHICAL_NOTATION_`,`SUSPENSION_STATE_`,`TENANT_ID_`,`ENGINE_VERSION_`) values 
('Process_0hy83oz:1:40004',1,'http://bpmn.io/schema/bpmn','A test process 2','Process_0hy83oz',1,'40001','processes/test2.bpmn','processes/test2.Process_0hy83oz.png',NULL,0,1,1,'',NULL),
('Process_0hy83oz:2:42510',1,'http://bpmn.io/schema/bpmn','A test process 2','Process_0hy83oz',2,'42507','processes/test2.bpmn','processes/test2.Process_0hy83oz.png',NULL,0,1,1,'',NULL),
('Process_0hy83oz:3:42520',1,'http://bpmn.io/schema/bpmn','A test process 2','Process_0hy83oz',3,'42517','processes/test2.bpmn','processes/test2.Process_0hy83oz.png',NULL,0,1,1,'',NULL),
('Process_0hy83oz:4:65004',1,'http://bpmn.io/schema/bpmn','A test process 2','Process_0hy83oz',4,'65001','processes/test2.bpmn','processes/test2.Process_0hy83oz.png',NULL,0,1,1,'',NULL),
('Process_0hy83oz:5:70004',1,'http://bpmn.io/schema/bpmn','A test process 2','Process_0hy83oz',5,'70001','processes/test2.bpmn','processes/test2.Process_0hy83oz.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:1:2504',1,'http://bpmn.io/schema/bpmn',NULL,'Process_0wu4lop',1,'2501','processes/diagram.bpmn','processes/diagram.svg',NULL,0,1,1,'',NULL),
('Process_0wu4lop:2:12505',1,'http://bpmn.io/schema/bpmn',NULL,'Process_0wu4lop',2,'12501','D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\diagram.bpmn','D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:3:15004',1,'http://bpmn.io/schema/bpmn',NULL,'Process_0wu4lop',3,'15001','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:4:17504',1,'http://bpmn.io/schema/bpmn',NULL,'Process_0wu4lop',4,'17501','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:5:20004',1,'http://bpmn.io/schema/bpmn',NULL,'Process_0wu4lop',5,'20001','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:6:20008',1,'http://bpmn.io/schema/bpmn',NULL,'Process_0wu4lop',6,'20005','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:7:22504',1,'http://bpmn.io/schema/bpmn','A test process','Process_0wu4lop',7,'22501','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:8:22508',1,'http://bpmn.io/schema/bpmn','A test process','Process_0wu4lop',8,'22505','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('Process_0wu4lop:9:32504',1,'http://bpmn.io/schema/bpmn','A test process','Process_0wu4lop',9,'32501','processes/diagram.bpmn','processes/diagram.Process_0wu4lop.png',NULL,0,1,1,'',NULL),
('oneTaskProcess:1:12506',1,'Examples','The One Task Process','oneTaskProcess',1,'12501','D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\one-task-process.bpmn20.xml',NULL,NULL,0,0,1,'',NULL),
('test01:1:62503',1,'http://www.activiti.org/processdef','test01','test01',1,'62501','processes/test3.bpmn',NULL,NULL,0,0,1,'',NULL);

/*Table structure for table `act_ru_deadletter_job` */

DROP TABLE IF EXISTS `act_ru_deadletter_job`;

CREATE TABLE `act_ru_deadletter_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_deadletter_job` */

/*Table structure for table `act_ru_event_subscr` */

DROP TABLE IF EXISTS `act_ru_event_subscr`;

CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_event_subscr` */

/*Table structure for table `act_ru_execution` */

DROP TABLE IF EXISTS `act_ru_execution`;

CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint DEFAULT NULL,
  `IS_CONCURRENT_` tinyint DEFAULT NULL,
  `IS_SCOPE_` tinyint DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint DEFAULT NULL,
  `IS_MI_ROOT_` tinyint DEFAULT NULL,
  `SUSPENSION_STATE_` int DEFAULT NULL,
  `CACHED_ENT_STATE_` int DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint DEFAULT NULL,
  `EVT_SUBSCR_COUNT_` int DEFAULT NULL,
  `TASK_COUNT_` int DEFAULT NULL,
  `JOB_COUNT_` int DEFAULT NULL,
  `TIMER_JOB_COUNT_` int DEFAULT NULL,
  `SUSP_JOB_COUNT_` int DEFAULT NULL,
  `DEADLETTER_JOB_COUNT_` int DEFAULT NULL,
  `VAR_COUNT_` int DEFAULT NULL,
  `ID_LINK_COUNT_` int DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE,
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_execution` */

insert  into `act_ru_execution`(`ID_`,`REV_`,`PROC_INST_ID_`,`BUSINESS_KEY_`,`PARENT_ID_`,`PROC_DEF_ID_`,`SUPER_EXEC_`,`ROOT_PROC_INST_ID_`,`ACT_ID_`,`IS_ACTIVE_`,`IS_CONCURRENT_`,`IS_SCOPE_`,`IS_EVENT_SCOPE_`,`IS_MI_ROOT_`,`SUSPENSION_STATE_`,`CACHED_ENT_STATE_`,`TENANT_ID_`,`NAME_`,`START_TIME_`,`START_USER_ID_`,`LOCK_TIME_`,`IS_COUNT_ENABLED_`,`EVT_SUBSCR_COUNT_`,`TASK_COUNT_`,`JOB_COUNT_`,`TIMER_JOB_COUNT_`,`SUSP_JOB_COUNT_`,`DEADLETTER_JOB_COUNT_`,`VAR_COUNT_`,`ID_LINK_COUNT_`) values 
('12507',1,'12507',NULL,NULL,'oneTaskProcess:1:12506',NULL,'12507',NULL,1,0,1,0,0,1,NULL,'',NULL,'2022-08-31 14:58:17.756',NULL,NULL,0,0,0,0,0,0,0,0,0),
('12508',1,'12507',NULL,'12507','oneTaskProcess:1:12506',NULL,'12507','theTask',1,0,0,0,0,1,NULL,'',NULL,'2022-08-31 14:58:17.756',NULL,NULL,0,0,0,0,0,0,0,0,0);

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_identitylink` */

/*Table structure for table `act_ru_job` */

DROP TABLE IF EXISTS `act_ru_job`;

CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_job` */

/*Table structure for table `act_ru_suspended_job` */

DROP TABLE IF EXISTS `act_ru_suspended_job`;

CREATE TABLE `act_ru_suspended_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_suspended_job` */

/*Table structure for table `act_ru_task` */

DROP TABLE IF EXISTS `act_ru_task`;

CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_task` */

insert  into `act_ru_task`(`ID_`,`REV_`,`EXECUTION_ID_`,`PROC_INST_ID_`,`PROC_DEF_ID_`,`NAME_`,`PARENT_TASK_ID_`,`DESCRIPTION_`,`TASK_DEF_KEY_`,`OWNER_`,`ASSIGNEE_`,`DELEGATION_`,`PRIORITY_`,`CREATE_TIME_`,`DUE_DATE_`,`CATEGORY_`,`SUSPENSION_STATE_`,`TENANT_ID_`,`FORM_KEY_`,`CLAIM_TIME_`) values 
('12511',1,'12508','12507','oneTaskProcess:1:12506','my task',NULL,NULL,'theTask',NULL,NULL,NULL,50,'2022-08-31 14:58:17.762',NULL,NULL,1,'',NULL,NULL);

/*Table structure for table `act_ru_timer_job` */

DROP TABLE IF EXISTS `act_ru_timer_job`;

CREATE TABLE `act_ru_timer_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_TIMER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TIMER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_timer_job` */

/*Table structure for table `act_ru_variable` */

DROP TABLE IF EXISTS `act_ru_variable`;

CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `act_ru_variable` */

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `user_id` int NOT NULL,
  `type` tinyint NOT NULL DEFAULT '5' COMMENT 'ä¹¦ç±ç±»åž‹ 1è‰ºæœ¯ 2å°è¯´ 3ç§‘å¹» 4åŽ†å² 5å…¶å®ƒ',
  `extra` text NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`description`,`user_id`,`type`,`extra`,`del_flag`) values 
(1,'test','sdfdsfdsfsdf',1,5,'',0),
(2,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(3,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(4,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(5,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(6,'æµ·åº•ä¸¤ä¸‡é‡Œ','è¿™æ˜¯ä¸€æœ¬å¾ˆå¥½çœ‹çš„ç§‘å¹»å°è¯´',1,5,'',0),
(7,'å…«åå¤©çŽ¯æ¸¸åœ°çƒ','å‡¡å°”çº³å†™çš„ä¸€æœ¬ç§‘å¹»å°è¯´',2,5,'',0),
(8,'å…«åå¤©çŽ¯æ¸¸åœ°çƒ','å‡¡å°”çº³å†™çš„ä¸€æœ¬ç§‘å¹»å°è¯´',2,5,'',0),
(9,'å…«åå¤©çŽ¯æ¸¸åœ°çƒ','å‡¡å°”çº³å†™çš„ä¸€æœ¬ç§‘å¹»å°è¯´',2,5,'',0),
(10,'å…«åå¤©çŽ¯æ¸¸åœ°çƒ','å‡¡å°”çº³å†™çš„ä¸€æœ¬ç§‘å¹»å°è¯´',2,5,'',0),
(11,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(12,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(13,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³ä¹ è¿‘å¹³',1,5,'',0),
(14,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³ä¹ è¿‘å¹³',1,5,'',0),
(15,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,5,'',0),
(16,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,5,'',0),
(17,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'',0),
(18,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{}',0),
(19,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(20,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(21,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(22,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(23,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(24,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(25,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"iSBN\":\"111-222\",\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0),
(26,'è‡ªç”±ä¸Žå’Œå¹³','è‡ªç”±ä¸Žå’Œå¹³',1,1,'{\"iSBN\":\"111-222\",\"publisher\":\"æµ·å—å‡ºç‰ˆç¤¾\"}',0);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`,`del_flag`) values 
(1,'book',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`del_flag`) values 
(1,'guest',0),
(2,'manager',0);

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `perm_id` int NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role_permission` */

insert  into `role_permission`(`id`,`role_id`,`perm_id`,`del_flag`) values 
(1,1,1,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `open_id` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'å¾®ä¿¡openId',
  `real_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'å§“åæˆ–æ˜µç§°',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`open_id`,`real_name`,`icon`,`del_flag`) values 
(1,'icexmoon','123','','','',0),
(2,'lalala','123','','','',0),
(3,'dd6524a9b91ce3508e968d18a6be588b','','o05bW5rgwlafHnCJ1zpMBQWqtzww','é­”èŠ‹çº¢èŒ¶?','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIv3gkJ4uclR5rmJS9icoCt2zkFDiaoVkORDrkOiaMv1772IwnXUeicvDNjycOYoM7OeN82z5au2c46lw/132',0);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`,`del_flag`) values 
(1,1,1,0),
(2,1,2,0),
(3,2,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
