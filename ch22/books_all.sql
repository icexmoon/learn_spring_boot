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
('12504',1,'D:\\workspace\\learn_spring_boot\\ch21\\books\\target\\classes\\processes\\diagram.Process_0wu4lop.png','12501','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('15002',1,'processes/diagram.bpmn','15001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('15003',1,'processes/diagram.Process_0wu4lop.png','15001','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('17502',1,'processes/diagram.bpmn','17501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('17503',1,'processes/diagram.Process_0wu4lop.png','17501','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('20002',1,'processes/diagram.bpmn','20001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('20003',1,'processes/diagram.Process_0wu4lop.png','20001','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('20006',1,'processes/diagram.bpmn','20005','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('20007',1,'processes/diagram.Process_0wu4lop.png','20005','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('22502',1,'processes/diagram.bpmn','22501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\" name=\"A test process\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('22503',1,'processes/diagram.Process_0wu4lop.png','22501','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('22506',1,'processes/diagram.bpmn','22505','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\" name=\"A test process\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('22507',1,'processes/diagram.Process_0wu4lop.png','22505','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0LIDATx^��[�]�yp@/��)RBUS�������h^\"Eb��Ŏ��(2��p\0%Bm�Z$F�5��<ĲC�[j����R�Ճ���x��lfw���f<̲�3{ٿ��i���%Ϭ���g��/�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0���[o���U�6-]��Ē%K>X�xq��o�j�Z�����k��{�9������W�$�p�x����G9u�m�U?��ϫ�[�V;w��?�}L���ܜ9s�E������t��y��W_���G=��o}�z��g����vHLV,�E�,\\�pOOO���>��D��/]�f��F`<��ձc��L���vf͚U���� �P���_��O����|����O3����\"��ȿ��\nU���~���w�}��Ç�~�������o|�;�������+V�x?B���K��\'*���̜9sm�� qNc��S6�H�~�C����އҶ\0ضmے8��I���8��z�1���}�/�6\r�Ƨ��\'?�ɩV��R�&����m=z4��]����C�A)��_��i�z��~=�؞�\rh�#G��E|�����i_����3>X�dɟ�m\Zf��տ�k*�`޼y\'�Õ��6\r�t��w�iM�lٲ����i�����ǷY�`ӦM\'zzz��m\ZfѢE]�v�Lv��q�qO�4L�\Z\ZJ�����T�F�a�����\'O�}xZ����6\rw�jʈc`` U�8�����ᦜ�ؾ}���q@���SM�TeݺuC>U������rǃ>��uP�ŋ�Ӕ+Gg̘q�P��n�ܹs���*���;Z���@)�\'�����0e�o�BA�>�ܓ������m�&�4]w\0��;��`P���g<,���tlٲeW�6�s\nOX�+I�u�󁁁��F܃�]Ρd��xv����nm�̙����u��@�xX�T�<b�q:4v��\nOX��%}��<�F|��H�Sq�!��=9ק�ף������]�Ӏ�YOO���Qi<�d����ׇi&L��7�<���}���Il\'���8O��Yqeg@܍����ݱcǩC�\r�1|���������k׮|衇ތ���D`�z.��%��z���k|>�q��Eu����ӟ��b�t\0m�4�		 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0�	 ��\0&���{8�b��e���X\nӠH+�I�.p�:�6�qM4�0�\0�h�Q��0��FF���um\0��9�0�\0&mdԑN8��QG:�\"UU�i����Z�~}�v�Z���͛7�aÆ刺h��M�6U�N�8Q���{������q���:H���#h�i�m�Ǭ�_����8����qb�l�ь��C���#h��CM������9�����/V��U�_��1�չ���	��^�v��L�߿�����w�k��G�,�νE8Sp�s�p����U�7�`4,ڵfQ������\'T��E/8�>z���Ƈ?\Z�+F1/�?����Øߍٖ�+�A��?l��1�1�r���KpP��#\r�����������֧�7w����1f{j�%8(��Ǚ굵�ٞ�|	�p�����S��w�����_+���/�ٞ�|	�0^p����W~�7����c��&_��\"�ol]1&�ھ��c>Y�Q����ٞ�|	�0^p�c{����x���{y�6�ٕ��G��W���=8&0ҊÚ��?f}uv%8(�CMO	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"t;8~���V_���K/����k���~�=�nJ��ϟ_]~��Ս7�X���듞w��7W7�tS{���`5{���+��>�ϴ�;|�p������l___{�������?�xu�СjΜ9է?��v���T{�����.�A�\Z�=�\\�}��v�����u���˫\'�x���+_�ʤ�=��՞={��\"4bZ�c�=6\Z:o��F����^�^�s��\\�}��o~��z���զM�گ��կ�i�T��������w�n�a������G�i��u�&;ohhht�]v�质x=P�_}���ի�??��Ϸ����m�ԕW^9��S]��\"t;8���/�;�+F;hLy�#�p�UWMz^�>\"TbZ�F��뫯��=/F���_�r��y�>������6w�E�vp�9�z�՚5k>��G^���?\r��C�����G�Èiq��lٲ���o��=�g�]\'j�ʕ��3f�h���X�[���:�%m�T������G��h�Z��#�GN�Ɖ�8����}Ĩa֬Y�\'G,X�>̉y�.���:_|��	��̝;���g?[}�S��n��j���c�?�%8(B���Lu�80�y�[	� 8�U��\"4%8ԇ%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	� 8�U��\"�f����Y%8(��hV	��~���ĉc��U���=�a������?b��ڵk��:8���#h�\r6|�ƍ����6򘞪��?�CcW\Z1�X������5���ar��j��L+���I���PG:\r`B��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�l��&8�	�������b�t=�V���4(Ҋe����D��\r`\\�:�6�3\Zo�a�Lh�Q���:GF��t�:�6�Iu����̙s]OO�?��RCu�L�s��������6�D��ڗ��d+�[�n8O�~^]��	����μt�yb֬YWԇ\Z������V+W���n�Z�ܹ�\Z�B���1=��r�Q���~�O�`u��Roo���>cƌjٲe�޽{�!1Y�|��\'�N�\'�7P����u\Z�:;��?\\�ٳ\'̈́,�~l\'	�S���\r@AN�4FC#F	���/�8\'��d��3��9��ÓٳgW۶mK��\'\"����w��u���T�ƈ�~��#���	h�և��v�U�V��|J�~:��H�4T��:�8��M�	�ciۀ���[�t�8t8�OOr��:Y�=i��iu\\F�[L��oǨc_�F�A�������v}�1\"��َhW�V�!�۫#�5.�N���G�Ҷ\rQwҗG:�SO=��宊�w�:^N�\n4Dooo�O��Y�lْ�宊���%ڕ�h�և�{�;kڗ�*��1�8��h����t֡���/wU�#8�Ӷ\r��Q��\'O�}��b���I�\n4�����˧*@���8�\\����\npVZ��r?଴���r�Q�lL�]�{{{GC�]Ρ@�\\�և�elw�~�J��Α��@����V�e�S�$�Α���y��,���Q�|��#��Ö(O�>V�s�<a�Yqy�ʕ+��[�V;w��!?�}L�����wVl�9\r8��>��v�:�s�؎�\\�BQw�ŭ���3+�[�n�@̙3���j]/�a��8��D����\\,�n\0\0\0\0\0\0\0\0>)�|D\"8��J\0\0\0\0IEND�B`�',1),
('2502',1,'processes/diagram.bpmn','2501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:task id=\"Activity_0nt5d38\" name=\"approve\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:task>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('2503',1,'processes/diagram.svg','2501','<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!-- created with bpmn-js / http://bpmn.io -->\n<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"112\" height=\"318\" viewBox=\"154 76 112 318\" version=\"1.1\"><defs><marker id=\"sequenceflow-end-white-hsl_225_10_15_-ajryqhl6aixfklwc2k50tlfqk\" viewBox=\"0 0 20 20\" refX=\"11\" refY=\"10\" markerWidth=\"10\" markerHeight=\"10\" orient=\"auto\"><path d=\"M 1 5 L 11 10 L 1 15 Z\" style=\"fill: rgb(34, 36, 42); stroke-width: 1px; stroke-linecap: round; stroke-dasharray: 10000, 1; stroke: rgb(34, 36, 42);\"/></marker></defs><g class=\"djs-group\"><g class=\"djs-element djs-connection\" data-element-id=\"Flow_0nv17f1\" style=\"display: block;\"><g class=\"djs-visual\"><path d=\"m  210,118L210,200 \" style=\"fill: none; stroke-width: 2px; stroke: rgb(34, 36, 42); stroke-linejoin: round; marker-end: url(\'#sequenceflow-end-white-hsl_225_10_15_-ajryqhl6aixfklwc2k50tlfqk\');\"/></g><polyline points=\"210,118 210,200 \" class=\"djs-hit djs-hit-stroke\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"204\" y=\"112\" rx=\"3\" width=\"12\" height=\"94\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-connection\" data-element-id=\"Flow_1ke9x09\" style=\"display: block;\"><g class=\"djs-visual\"><path d=\"m  210,280L210,352 \" style=\"fill: none; stroke-width: 2px; stroke: rgb(34, 36, 42); stroke-linejoin: round; marker-end: url(\'#sequenceflow-end-white-hsl_225_10_15_-ajryqhl6aixfklwc2k50tlfqk\');\"/></g><polyline points=\"210,280 210,352 \" class=\"djs-hit djs-hit-stroke\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"204\" y=\"274\" rx=\"3\" width=\"12\" height=\"84\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-shape\" data-element-id=\"StartEvent_0vx5axl\" style=\"display: block;\" transform=\"matrix(1 0 0 1 192 82)\"><g class=\"djs-visual\"><circle cx=\"18\" cy=\"18\" r=\"18\" style=\"stroke: rgb(34, 36, 42); stroke-width: 2px; fill: white; fill-opacity: 0.95;\"/></g><rect class=\"djs-hit djs-hit-all\" x=\"0\" y=\"0\" width=\"36\" height=\"36\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"-6\" y=\"-6\" rx=\"3\" width=\"48\" height=\"48\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-shape\" data-element-id=\"Event_1294r00\" style=\"display: block;\" transform=\"matrix(1 0 0 1 192 352)\"><g class=\"djs-visual\"><circle cx=\"18\" cy=\"18\" r=\"18\" style=\"stroke: rgb(34, 36, 42); stroke-width: 4px; fill: white; fill-opacity: 0.95;\"/></g><rect class=\"djs-hit djs-hit-all\" x=\"0\" y=\"0\" width=\"36\" height=\"36\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"-6\" y=\"-6\" rx=\"3\" width=\"48\" height=\"48\" class=\"djs-outline\" style=\"fill: none;\"/></g></g><g class=\"djs-group\"><g class=\"djs-element djs-shape\" data-element-id=\"Activity_0nt5d38\" style=\"display: block;\" transform=\"matrix(1 0 0 1 160 200)\"><g class=\"djs-visual\"><rect x=\"0\" y=\"0\" width=\"100\" height=\"80\" rx=\"10\" ry=\"10\" style=\"stroke: rgb(34, 36, 42); stroke-width: 2px; fill: white; fill-opacity: 0.95;\"/><text lineHeight=\"1.2\" class=\"djs-label\" style=\"font-family: Arial, sans-serif; font-size: 12px; font-weight: normal; fill: rgb(34, 36, 42);\"><tspan x=\"28.154296875\" y=\"43.599999999999994\">approve</tspan></text></g><rect class=\"djs-hit djs-hit-all\" x=\"0\" y=\"0\" width=\"100\" height=\"80\" style=\"fill: none; stroke-opacity: 0; stroke: white; stroke-width: 15px;\"/><rect x=\"-6\" y=\"-6\" rx=\"3\" width=\"112\" height=\"92\" class=\"djs-outline\" style=\"fill: none;\"/></g></g></svg>',0),
('32502',1,'processes/diagram.bpmn','32501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_1kwvfrz\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0wu4lop\" isExecutable=\"true\" name=\"A test process\">\n    <bpmn:startEvent id=\"StartEvent_0vx5axl\">\n      <bpmn:outgoing>Flow_0nv17f1</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:endEvent id=\"Event_1294r00\">\n      <bpmn:incoming>Flow_1ke9x09</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:serviceTask id=\"Activity_0nt5d38\" activiti:exclusive=\"true\" name=\"approve\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask\">\n      <bpmn:incoming>Flow_0nv17f1</bpmn:incoming>\n      <bpmn:outgoing>Flow_1ke9x09</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_0nv17f1\" sourceRef=\"StartEvent_0vx5axl\" targetRef=\"Activity_0nt5d38\" />\n    <bpmn:sequenceFlow id=\"Flow_1ke9x09\" sourceRef=\"Activity_0nt5d38\" targetRef=\"Event_1294r00\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0wu4lop\">\n      <bpmndi:BPMNEdge id=\"Flow_0nv17f1_di\" bpmnElement=\"Flow_0nv17f1\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1ke9x09_di\" bpmnElement=\"Flow_1ke9x09\">\n        <di:waypoint x=\"210\" y=\"280\" />\n        <di:waypoint x=\"210\" y=\"352\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_0vx5axl\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1294r00_di\" bpmnElement=\"Event_1294r00\">\n        <dc:Bounds x=\"192\" y=\"352\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_0nt5d38_di\" bpmnElement=\"Activity_0nt5d38\">\n        <dc:Bounds x=\"160\" y=\"200\" width=\"100\" height=\"80\" />\n        <bpmndi:BPMNLabel />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('32503',1,'processes/diagram.Process_0wu4lop.png','32501','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0f�}\0\0�IDATx���[lU������[4&^⃉O��ILF\r�O�cIiK,D����%E2`$���(�F�`0�p�z*��A9 z��,��oַ�n����v���~�v�n�����[�����\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0E-�p�֭[�_�|y��ŋ����{f͚�z��|���/���K�/���7s���gKF��{�.���/TUU�ٳg��k׆���p������N�>\Z\Z\Z��W�Z�O�f̘�����UVV�i)�(q�С9+V��:ujx��w�HF}}}X�zu�<yrx�駿�4i���*��]���l�r\"#������8y�dX�lYH��SRR2��xc͚5��nF:c�#�߿?�#L�0a�%\r#\'\Zw&3�����˞e���������Z�0vOV�^���/����0�b��|�ɸ۲ܒ�\"�y��3q�d�f\Z��<�����/���_��cǎ��o߾��r��(B˖-��nݺP.�Nfۭ(\"�v��s�m���$�Tm2��q��%K��l޼9�ҥK;Ǐ��ڀ\"���������4���������ςBTTT\\7n���\nd�k��vaӦM�ǢE�ړݕ��\nd����{�;\\���>hI�q�Z���9sfzV#���ӑ���Z���F����:z���$��\nd\\����8s�Lw���V �***BWWWVf��S��u��~�Y�k׮s�����\nd�s�=���*6l8�\n����lݺ5ᨮ�>���k2n����p��L����������Z������8qb�O�~����l�5E�g�i���)h8�]�c%%%{�\r(���OL�6�`�eϜ9s.�m\\LvS��ڀ\"2k֬�z�[UU��$�c-@��og���6��t�ٳ�X�m���)S��yΜ9�v�4�E�D�e�/Z�P��;�-Z����4\Zmmm�eee��#��1c��8q⹗_~�g�f�L�	&����xTTT������>�o߾��C����tm23�Y�~���=U���?w̛7�h<��W,]��ٖ$ Ǔݗ�\n݃�}9{�l�%K�`$��oƎ{��\n�D��W$�D�0{���\r6t�ݻ��ԩS��������ݻw�Obq<�݉�1�Kq�r��{[�F<���_�\"vi�$�u��XL����Xj�o�H��\0 �p\0��p\0� �p\0 �p\0��p\0� �p\0� �p\0� \0� �p\0� �p\0� \0� �p\0��p\0� �p\0 �p\0��p\0� �p\0 �p\0� \0� �p\0� �p\0â���-������fK\nȟ]�2�p̶���:�6�A�:�6�A�:�6�A�:�6�A�:�6�A�:�6�A�:,	`гK�I�������w����O���ۍa555����e۶mS�FR�I$��!�Ghii	����0������;ză���g����p��_ݝ�@N��$��T���݆���G�>z�VR��fg��᷒��g[�3���#>��������η�~��קz��?�Sk���6�p0���������7|�8�r�dxa����#>�������{^��p�E<��Q�ϵ�y��\r���?|��y�p0�wU6�kp8���Ά/Gg�{�ó������P�t��������ц/��p�3&��g�1������?����`����]�8���}���W\0���\0�*�Czp�Ԁ������|5�ӱ���\r_8���ūF\Z�Y�?����/��p��u�7j��#��>9t�W����<�e�10��i}h����}W%��Ts������6�������p��! ��! �p �p �p�p�p�ppp��! ��a�a�a�p�p�p�a�a8>���p������*�v�maݺu���?%ӦM�]w]����C]]݀_{���<�>���&O��~��7ߜ�\\sssx뭷�ﭨ�H�o	�׫V�\n?��c���7�tS:JJJ���ǅ���-[��C��mܰ���;�իW��}����q��p������\\�|����=z4}|�w��w��_��ׇ\'�x\"}�cǎ�駟��{�1�,��ȑ#a�ܹ�{�����p�ܹtv_��~��ٳ�ǵ�^��\\�����ӯ?���ϻ�+}>���o��\r7� ��p�w�}�F�f͚~�wrq����Z����G�m��o����8�_?��C�S�L��Ϝ9s�1�Z8�q���nݺ��p�X��7*�]�����w�c�]��+W��gΜ���~��_�*֮]�>_VV�~�t���ƛ�E8 �X�lY\Z��������|0ݭ�k�G�5L�4)�E�]����t7\'���?�+��2��+����\0h����ǭ��\Z�����#����N8 ����_\0�ӱ �!�!�! ��! ��a�a�a�p�p�!�!�! ��! �p �p �p�p�p�p��J�����\0�ာ�����F������s�>z�V�y���=���6��/���H�&��d^MMͦ$�?~�̣0����������mۺ�p�跒���¾���w�ݖb�Ǐ���OF{2��m�a�a)\0� �p\0� �p\0� \0� �p\0� �p\0� �p\0 �p\0��p\0� �p\0 �p\0��p\0� �p\0� �p\0� \0� �p\0� �p\0� \0� @������P��QZZ�lI���W�ٖ0�Y��0�Y��0�Y��0�Y��0�Y��0�Y��0�Y�%��df1#	��d��\'I8�/�:ړ��O��^^^^bi���%�Hb�M�g��]��gt\'?�����,E%ƍ�p��?�X�;bxƎ{��\n#Ԙ1c��3�dW�W�1cFX�jU���\r������ӡ��!8p ��Ԅ7�x#L�:��\"��������$M}7�����0P���iX/^����ȤI����a��\"�ѕ��/\\�0;v,\\�����i��E.�ܝ�4.�6����q���G�3���~�W�0�\">�O��6�dc{��\rC!�Q��m��8g�g\Z���C)��S(b�B�����?á�n��PD.]�n����j.�G��x��������(\'O��)�mɟu���#\'rm�u(���<�Eg�\ndXii�-����WB�YG�5ٞm��Kc޼y�Pⱎ��ӽ�2�һ]Ӎ�����/g��]�n�@vwUz/��oN+�>�u�v ���}O�p�M�+�+/M�d�G�My���\Z�����p�[;��p�n�������\n[8���\n\Z�x3��O���\rǅB_��ߵ>�2,��J�p)ކ�Y(�>��uӦM\rG��i^8vZ;��p,�m�,(h8�O����2�ځ��7%�?@���\\�h� ��;.Z3�q���(�e�}.7wOȺ���%�����b�g���}n!Xa�@q�:Zr�ʕ+�5���E���tv���w��9,ш����Ə��6��f\'�?\Z���~H�?z!�Mr�/(�YG�X{nC�6mڐ�#~��ĉ�n���.�g<��C�g�nK����F|k<-l�Cq�cF~<rL/�lK��G��>gP.��9���G{�FO���<���x����|̽�-~V��\r#�ǉ>3�����{[��broɏ7�3�x7��x��~>~ܤc\Z0�2;�:��M�`�ȥ+L�����3���\"�R�H|Wm|K���y\\�DO<Kr��E��W�.��\0\0\0\0\0\0\0�P�?��?�\0z�\0\0\0\0IEND�B`�',1),
('40002',1,'processes/test2.bpmn','40001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1cydcrq</bpmn:incoming>\n      <bpmn:outgoing>Flow_1x26529</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1x26529</bpmn:incoming>\n      <bpmn:outgoing>Flow_135u817</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('40003',1,'processes/test2.Process_0hy83oz.png','40001','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0 �A�\0\0IDATx���OlT����s�����[O��������8� $���()!h!\"B�H\"�F(lS ��:�\n/��P 1q��\r���=�}?[��$�{��|>�Oq�FE�����3o~�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ȴ¯�=zp�Ν�[�n���/�Y�&���!����_{��7�7m���ڵk���\n��Ҳ���{�z��PWW������¥K�BWWW�u�V���/^}׮]a�ʕaժU�W_}�m�ҥ�ڊP!._����>]�|yػw�x$J���v�������K/}�dɒ_ڪ0wI�9r�ȍ��z���\rO��͛aǎ!	G���j�-s�<��<�f���������hѢmi�;�x6Y���x��c��N<�ZSS�d��8<ٽ{��o���|�I1J/��B<l�i�C�>|�v<<�����V�=�\\p�2��/���x\"����a6�?>�����cǎ�O>�$���͛G�U�1{2�̙3��������#^�MV7�A�l۶�p���PN����O��]]]�\Z����+k8�^�\Zr�ܰ=p����7niP[[;�`����+�r۷op�СT�c˖-��p尽)�aÆB��k\Z|��g�I8��+�r/����U�48{��P�{R.����˧�ڵkcI8��\n�\\2QCZܾ}{4����+�r���add$-+�xr�%YH��x��ؿ48s�̽\\.�k�@ʽ��k������;��@lذ���ѣ�G}}��$\'�H��7���͛S���ꑚ��*{R.>c���e�$����&���dĺu��\Z���zUUU���t���\\�bE�.�޾}�^��KS~co@��Y���\\v[�zug��� c���㷭��=gϞ�W���lٲ?�]�v�N�&�(�h��|���>�Ѿe˖0:::�������\r��͛���ŋ���[��Zy$+���-��\r�k񨭭�f��Յ�}��������_�\0sT.�ۓ�\n���{�K����Z�~��x\"4oۺ0�ū-I@:�×�\n���ܹsg`۶mWc0�U��������\n\"���ɸ�D$���\r�߿���e���{r52888��ёonn�Kbљ���񋥿��r�`�-�P#�،�Έ�/�O{8\n�k#��$��%�/�Հ[�[@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0R���j0��F.�뵥������G�-L{�a�����\0JZuXm\0%�:�6��VV@ɫ�\r��U�-���%`���ioo����\\8y�d8v�1ˣ��1455�744,�$�N$oڐ�#������ac�G��mmm�ĉ� N�>:::L��+W��&+�n�JR/.��������G�?\nޕd\"&mzF�ޕ̩pܼ��}r~|ğMt�@8CCá�op�߿��=���������M|������o����/���7�_/�o��d8����?�^K~g��o½~�*:?���]��ύW��\Z�����*�P����i�c_�?M|�@8��O&��������_��w�G�9�6������*9�I<�Y|N#�b���׊�y�?�j�pP��xܡH\\eL�����~W\0���\0�*�3zr�{�\'G���p�#�9��:M|���o\0�w�N7���:~��/Tp8����W�G��\'/w?r�y��#�v��/�C~h��*�P%ƣ���g?�v�oP4���zဧC8@8��C8@8��������\0�C8C8C8@8��C8@8�@8�@8�\0��\0��@8�@8�\0��\0�C8C8C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8��C8@8�@8�@8�C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8�����!�6c``�~�?\nޕ�^SSS�����M�8w��wI8z�+I����CI<�:;;Ǭ<�3��|����VCC�h�MޕdB��{���xؒձp��2������(��V\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�xꪪ�c(~j�r�^[\n(^]�=�p��R��WV@ɫ�\r��U��P��j(i�a�����\0J^u�@ɫ[fI����k��ͅ�\'O�cǎ�<\ZCSSSCC�2�H2��D�\rI<B6fy�����N�8Q2���ӡ���N��r��h����$��R9�ϛ�)Yy$���]I&�aҦg���]ɜ\n��;�a�\'��G��D��144z�\'���+ݓ�?O�~��@�{��*=1\Z{�v-���Bh�x#�����ƁL�#�_��W���w��&��ᠢ��ý��~߅�P��x叭���L~��U��v8�5����cx��d\"��m\r�����}w|ğ�k��_Z�L|᠒���ē���4b(��^|���G�3��\Z����U��ߋ�=�w@8�p�\"0�\'G��}r4���/G8ra��c?����*=��x��t��}�㷞���A�c`p(��xu�p�๎p�r�#����<�m�10���=䇆L~��Ub<�{��Cnw�EC8�xJ�0��C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8��������\0�������\0��\0�0��0��0��C8@8��������\0�C8C8C8@8��C8@8������C8��C8@8��������\0�C8C8C8@8��C8���\Z\Z2iS0�\'���]I�555���L��s��}���ǻ��kll<��c���s�ʣ<#�����n544�&���]I&$oؽǏ��-Y.Y��\'#��mލ0�b8l@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�(�������\Z�\\�ז�WoO#u�0�U��P��j(i�a�����\0JZuXm\0%�:�6��W�𣒕Ū$��q5�$�}���\'�\'����XMMM���}HR����䟅���k�M�\\Kuu��ۊP!,X��d�_b,;bx�ϟ�k[�y��=W\nɡ�#X�jUصkWhjj\n�.]\n]]]�֭[���#\\�x1466���?,_���\"r��9f�ҥ�&��:�c����t�����e�֭�[}|�dɒ_��0�s�)��7oׯ_O\"���~j@��@�%��IV\Z&&vMMM8p�@xZ�\n䣏>z$V��s\Z/��O�d2����0�9����{\0��ڸT��hmm\r3)��	SȰx�V�$�����l�z��|d�û=�\'�;�fK<�Q|�4��ao@6��J�!�͛7�l�W[�W�0�l���Ĥ���P|�G���^���r�*��}�����:F�H�jc�Y\Z�ׯ��uߞ�S��b?�:>Y?���PN�v��Õc���Pe���r�r_�U{���Ϥ��Ք�b����c�@z�qL>�\'�ϗ5�#�E���;��pLN�r���qe�������#>���3l�@z����p<�^��)V|U%N�r��!tU2 >cb�:t����0-\n�){����u�ƍe\r�ʕ+�UV�;�R���\'H{{{���\0䢿ǘ=)W�,�r�v>�vs�䀴����61ikkkg}���>����\ndc��?1q?���Y\rG�ꅢh|oo@F�r�����:ujV��z���7~ݤ��Zu�(�j�����F���0ɓ� 㫎�4���D^�bŌ�#~���ŋ�ϧa������x�[�Z��xڇ-��W\Z��񲰭َǪ�xL�0}ҫ-�y��\\Ay��0�V��I/���<J\rH��\\|zz�W>N|�-~W��\rs�Ǎ)+�����g[��b&>�W�i^12�ȏ����&�Ӏ�����<�p�x�9T��w���?�W.�؊P������������xP�B�J���E�ꅷ�!��\0\0\0\0\0\0\0�L�_^�E���n\0\0\0\0IEND�B`�',1),
('42508',1,'processes/test2.bpmn','42507','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1cydcrq</bpmn:incoming>\n      <bpmn:outgoing>Flow_1x26529</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n      <bpmn:incoming>Flow_1x26529</bpmn:incoming>\n      <bpmn:outgoing>Flow_135u817</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('42509',1,'processes/test2.Process_0hy83oz.png','42507','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0 �A�\0\0IDATx���OlT����s�����[O��������8� $���()!h!\"B�H\"�F(lS ��:�\n/��P 1q��\r���=�}?[��$�{��|>�Oq�FE�����3o~�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ȴ¯�=zp�Ν�[�n���/�Y�&���!����_{��7�7m���ڵk���\n��Ҳ���{�z��PWW������¥K�BWWW�u�V���/^}׮]a�ʕaժU�W_}�m�ҥ�ڊP!._����>]�|yػw�x$J���v�������K/}�dɒ_ڪ0wI�9r�ȍ��z���\rO��͛aǎ!	G���j�-s�<��<�f���������hѢmi�;�x6Y���x��c��N<�ZSS�d��8<ٽ{��o���|�I1J/��B<l�i�C�>|�v<<�����V�=�\\p�2��/���x\"����a6�?>�����cǎ�O>�$���͛G�U�1{2�̙3��������#^�MV7�A�l۶�p���PN����O��]]]�\Z����+k8�^�\Zr�ܰ=p����7niP[[;�`����+�r۷op�СT�c˖-��p尽)�aÆB��k\Z|��g�I8��+�r/����U�48{��P�{R.����˧�ڵkcI8��\n�\\2QCZܾ}{4����+�r���add$-+�xr�%YH��x��ؿ48s�̽\\.�k�@ʽ��k������;��@lذ���ѣ�G}}��$\'�H��7���͛S���ꑚ��*{R.>c���e�$����&���dĺu��\Z���zUUU���t���\\�bE�.�޾}�^��KS~co@��Y���\\v[�zug��� c���㷭��=gϞ�W���lٲ?�]�v�N�&�(�h��|���>�Ѿe˖0:::�������\r��͛���ŋ���[��Zy$+���-��\r�k񨭭�f��Յ�}��������_�\0sT.�ۓ�\n���{�K����Z�~��x\"4oۺ0�ū-I@:�×�\n���ܹsg`۶mWc0�U��������\n\"���ɸ�D$���\r�߿���e���{r52888��ёonn�Kbљ���񋥿��r�`�-�P#�،�Έ�/�O{8\n�k#��$��%�/�Հ[�[@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0R���j0��F.�뵥������G�-L{�a�����\0JZuXm\0%�:�6��VV@ɫ�\r��U�-���%`���ioo����\\8y�d8v�1ˣ��1455�744,�$�N$oڐ�#������ac�G��mmm�ĉ� N�>:::L��+W��&+�n�JR/.��������G�?\nޕd\"&mzF�ޕ̩pܼ��}r~|ğMt�@8CCá�op�߿��=���������M|������o����/���7�_/�o��d8����?�^K~g��o½~�*:?���]��ύW��\Z�����*�P����i�c_�?M|�@8��O&��������_��w�G�9�6������*9�I<�Y|N#�b���׊�y�?�j�pP��xܡH\\eL�����~W\0���\0�*�3zr�{�\'G���p�#�9��:M|���o\0�w�N7���:~��/Tp8����W�G��\'/w?r�y��#�v��/�C~h��*�P%ƣ���g?�v�oP4���zဧC8@8��C8@8��������\0�C8C8C8@8��C8@8�@8�@8�\0��\0��@8�@8�\0��\0�C8C8C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8��C8@8�@8�@8�C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8�����!�6c``�~�?\nޕ�^SSS�����M�8w��wI8z�+I����CI<�:;;Ǭ<�3��|����VCC�h�MޕdB��{���xؒձp��2������(��V\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�xꪪ�c(~j�r�^[\n(^]�=�p��R��WV@ɫ�\r��U��P��j(i�a�����\0J^u�@ɫ[fI����k��ͅ�\'O�cǎ�<\ZCSSSCC�2�H2��D�\rI<B6fy�����N�8Q2���ӡ���N��r��h����$��R9�ϛ�)Yy$���]I&�aҦg���]ɜ\n��;�a�\'��G��D��144z�\'���+ݓ�?O�~��@�{��*=1\Z{�v-���Bh�x#�����ƁL�#�_��W���w��&��ᠢ��ý��~߅�P��x叭���L~��U��v8�5����cx��d\"��m\r�����}w|ğ�k��_Z�L|᠒���ē���4b(��^|���G�3��\Z����U��ߋ�=�w@8�p�\"0�\'G��}r4���/G8ra��c?����*=��x��t��}�㷞���A�c`p(��xu�p�๎p�r�#����<�m�10���=䇆L~��Ub<�{��Cnw�EC8�xJ�0��C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8��������\0�������\0��\0�0��0��0��C8@8��������\0�C8C8C8@8��C8@8������C8��C8@8��������\0�C8C8C8@8��C8���\Z\Z2iS0�\'���]I�555���L��s��}���ǻ��kll<��c���s�ʣ<#�����n544�&���]I&$oؽǏ��-Y.Y��\'#��mލ0�b8l@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�(�������\Z�\\�ז�WoO#u�0�U��P��j(i�a�����\0JZuXm\0%�:�6��W�𣒕Ū$��q5�$�}���\'�\'����XMMM���}HR����䟅���k�M�\\Kuu��ۊP!,X��d�_b,;bx�ϟ�k[�y��=W\nɡ�#X�jUصkWhjj\n�.]\n]]]�֭[���#\\�x1466���?,_���\"r��9f�ҥ�&��:�c����t�����e�֭�[}|�dɒ_��0�s�)��7oׯ_O\"���~j@��@�%��IV\Z&&vMMM8p�@xZ�\n䣏>z$V��s\Z/��O�d2����0�9����{\0��ڸT��hmm\r3)��	SȰx�V�$�����l�z��|d�û=�\'�;�fK<�Q|�4��ao@6��J�!�͛7�l�W[�W�0�l���Ĥ���P|�G���^���r�*��}�����:F�H�jc�Y\Z�ׯ��uߞ�S��b?�:>Y?���PN�v��Õc���Pe���r�r_�U{���Ϥ��Ք�b����c�@z�qL>�\'�ϗ5�#�E���;��pLN�r���qe�������#>���3l�@z����p<�^��)V|U%N�r��!tU2 >cb�:t����0-\n�){����u�ƍe\r�ʕ+�UV�;�R���\'H{{{���\0䢿ǘ=)W�,�r�v>�vs�䀴����61ikkkg}���>����\ndc��?1q?���Y\rG�ꅢh|oo@F�r�����:ujV��z���7~ݤ��Zu�(�j�����F���0ɓ� 㫎�4���D^�bŌ�#~���ŋ�ϧa������x�[�Z��xڇ-��W\Z��񲰭َǪ�xL�0}ҫ-�y��\\Ay��0�V��I/���<J\rH��\\|zz�W>N|�-~W��\rs�Ǎ)+�����g[��b&>�W�i^12�ȏ����&�Ӏ�����<�p�x�9T��w���?�W.�؊P������������xP�B�J���E�ꅷ�!��\0\0\0\0\0\0\0�L�_^�E���n\0\0\0\0IEND�B`�',1),
('42518',1,'processes/test2.bpmn','42517','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n      <bpmn:incoming>Flow_1cydcrq</bpmn:incoming>\n      <bpmn:outgoing>Flow_1x26529</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n      <bpmn:incoming>Flow_1x26529</bpmn:incoming>\n      <bpmn:outgoing>Flow_135u817</bpmn:outgoing>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('42519',1,'processes/test2.Process_0hy83oz.png','42517','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0 �A�\0\0IDATx���OlT����s�����[O��������8� $���()!h!\"B�H\"�F(lS ��:�\n/��P 1q��\r���=�}?[��$�{��|>�Oq�FE�����3o~�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ȴ¯�=zp�Ν�[�n���/�Y�&���!����_{��7�7m���ڵk���\n��Ҳ���{�z��PWW������¥K�BWWW�u�V���/^}׮]a�ʕaժU�W_}�m�ҥ�ڊP!._����>]�|yػw�x$J���v�������K/}�dɒ_ڪ0wI�9r�ȍ��z���\rO��͛aǎ!	G���j�-s�<��<�f���������hѢmi�;�x6Y���x��c��N<�ZSS�d��8<ٽ{��o���|�I1J/��B<l�i�C�>|�v<<�����V�=�\\p�2��/���x\"����a6�?>�����cǎ�O>�$���͛G�U�1{2�̙3��������#^�MV7�A�l۶�p���PN����O��]]]�\Z����+k8�^�\Zr�ܰ=p����7niP[[;�`����+�r۷op�СT�c˖-��p尽)�aÆB��k\Z|��g�I8��+�r/����U�48{��P�{R.����˧�ڵkcI8��\n�\\2QCZܾ}{4����+�r���add$-+�xr�%YH��x��ؿ48s�̽\\.�k�@ʽ��k������;��@lذ���ѣ�G}}��$\'�H��7���͛S���ꑚ��*{R.>c���e�$����&���dĺu��\Z���zUUU���t���\\�bE�.�޾}�^��KS~co@��Y���\\v[�zug��� c���㷭��=gϞ�W���lٲ?�]�v�N�&�(�h��|���>�Ѿe˖0:::�������\r��͛���ŋ���[��Zy$+���-��\r�k񨭭�f��Յ�}��������_�\0sT.�ۓ�\n���{�K����Z�~��x\"4oۺ0�ū-I@:�×�\n���ܹsg`۶mWc0�U��������\n\"���ɸ�D$���\r�߿���e���{r52888��ёonn�Kbљ���񋥿��r�`�-�P#�،�Έ�/�O{8\n�k#��$��%�/�Հ[�[@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0R���j0��F.�뵥������G�-L{�a�����\0JZuXm\0%�:�6��VV@ɫ�\r��U�-���%`���ioo����\\8y�d8v�1ˣ��1455�744,�$�N$oڐ�#������ac�G��mmm�ĉ� N�>:::L��+W��&+�n�JR/.��������G�?\nޕd\"&mzF�ޕ̩pܼ��}r~|ğMt�@8CCá�op�߿��=���������M|������o����/���7�_/�o��d8����?�^K~g��o½~�*:?���]��ύW��\Z�����*�P����i�c_�?M|�@8��O&��������_��w�G�9�6������*9�I<�Y|N#�b���׊�y�?�j�pP��xܡH\\eL�����~W\0���\0�*�3zr�{�\'G���p�#�9��:M|���o\0�w�N7���:~��/Tp8����W�G��\'/w?r�y��#�v��/�C~h��*�P%ƣ���g?�v�oP4���zဧC8@8��C8@8��������\0�C8C8C8@8��C8@8�@8�@8�\0��\0��@8�@8�\0��\0�C8C8C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8��C8@8�@8�@8�C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8�����!�6c``�~�?\nޕ�^SSS�����M�8w��wI8z�+I����CI<�:;;Ǭ<�3��|����VCC�h�MޕdB��{���xؒձp��2������(��V\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�xꪪ�c(~j�r�^[\n(^]�=�p��R��WV@ɫ�\r��U��P��j(i�a�����\0J^u�@ɫ[fI����k��ͅ�\'O�cǎ�<\ZCSSSCC�2�H2��D�\rI<B6fy�����N�8Q2���ӡ���N��r��h����$��R9�ϛ�)Yy$���]I&�aҦg���]ɜ\n��;�a�\'��G��D��144z�\'���+ݓ�?O�~��@�{��*=1\Z{�v-���Bh�x#�����ƁL�#�_��W���w��&��ᠢ��ý��~߅�P��x叭���L~��U��v8�5����cx��d\"��m\r�����}w|ğ�k��_Z�L|᠒���ē���4b(��^|���G�3��\Z����U��ߋ�=�w@8�p�\"0�\'G��}r4���/G8ra��c?����*=��x��t��}�㷞���A�c`p(��xu�p�๎p�r�#����<�m�10���=䇆L~��Ub<�{��Cnw�EC8�xJ�0��C8@8��C8@8�@8�@8�\0��\0�0��0��0��C8@8��������\0�������\0��\0�0��0��0��C8@8��������\0�C8C8C8@8��C8@8������C8��C8@8��������\0�C8C8C8@8��C8���\Z\Z2iS0�\'���]I�555���L��s��}���ǻ��kll<��c���s�ʣ<#�����n544�&���]I&$oؽǏ��-Y.Y��\'#��mލ0�b8l@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�(�������\Z�\\�ז�WoO#u�0�U��P��j(i�a�����\0JZuXm\0%�:�6��W�𣒕Ū$��q5�$�}���\'�\'����XMMM���}HR����䟅���k�M�\\Kuu��ۊP!,X��d�_b,;bx�ϟ�k[�y��=W\nɡ�#X�jUصkWhjj\n�.]\n]]]�֭[���#\\�x1466���?,_���\"r��9f�ҥ�&��:�c����t�����e�֭�[}|�dɒ_��0�s�)��7oׯ_O\"���~j@��@�%��IV\Z&&vMMM8p�@xZ�\n䣏>z$V��s\Z/��O�d2����0�9����{\0��ڸT��hmm\r3)��	SȰx�V�$�����l�z��|d�û=�\'�;�fK<�Q|�4��ao@6��J�!�͛7�l�W[�W�0�l���Ĥ���P|�G���^���r�*��}�����:F�H�jc�Y\Z�ׯ��uߞ�S��b?�:>Y?���PN�v��Õc���Pe���r�r_�U{���Ϥ��Ք�b����c�@z�qL>�\'�ϗ5�#�E���;��pLN�r���qe�������#>���3l�@z����p<�^��)V|U%N�r��!tU2 >cb�:t����0-\n�){����u�ƍe\r�ʕ+�UV�;�R���\'H{{{���\0䢿ǘ=)W�,�r�v>�vs�䀴����61ikkkg}���>����\ndc��?1q?���Y\rG�ꅢh|oo@F�r�����:ujV��z���7~ݤ��Zu�(�j�����F���0ɓ� 㫎�4���D^�bŌ�#~���ŋ�ϧa������x�[�Z��xڇ-��W\Z��񲰭َǪ�xL�0}ҫ-�y��\\Ay��0�V��I/���<J\rH��\\|zz�W>N|�-~W��\rs�Ǎ)+�����g[��b&>�W�i^12�ȏ����&�Ӏ�����<�p�x�9T��w���?�W.�؊P������������xP�B�J���E�ꅷ�!��\0\0\0\0\0\0\0�L�_^�E���n\0\0\0\0IEND�B`�',1),
('62502',1,'processes/test3.bpmn','62501','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n             xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:activiti=\"http://activiti.org/bpmn\"\r\n             xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\r\n             xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\"\r\n             typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\"\r\n             targetNamespace=\"http://www.activiti.org/processdef\">\r\n\r\n    <process id=\"test01\" name=\"test01\" isExecutable=\"true\">\r\n        <startEvent id=\"sid-d0c54d06-2073-4018-8381-e5e43f1b5578\" name=\"Start\"/>\r\n\r\n        <serviceTask id=\"sid-0396a986-7e6b-4634-883b-1ee7db9aeb45\"\r\n                     activiti:exclusive=\"true\"\r\n                     name=\"Step1\"\r\n                     activiti:class=\"com.example.actividemo.ServiceTask1\">\r\n            <extensionElements>\r\n                <activiti:field name=\"text1\">\r\n                    <activiti:string><![CDATA[test1]]></activiti:string>\r\n                </activiti:field>\r\n            </extensionElements>\r\n        </serviceTask>\r\n\r\n        <sequenceFlow id=\"sid-05a29cc5-7a04-4282-be89-4d83f943774b\" sourceRef=\"sid-d0c54d06-2073-4018-8381-e5e43f1b5578\"\r\n                      targetRef=\"sid-0396a986-7e6b-4634-883b-1ee7db9aeb45\"/>\r\n\r\n        <serviceTask id=\"sid-c43c4370-4407-4746-893f-dcee3e4e9936\"\r\n                     activiti:exclusive=\"true\"\r\n                     name=\"Step2\"\r\n                     activiti:class=\"com.example.actividemo.ServiceTask2\">\r\n            <extensionElements>\r\n                <activiti:field name=\"text2\">\r\n                    <activiti:string><![CDATA[test2]]></activiti:string>\r\n                </activiti:field>\r\n            </extensionElements>\r\n        </serviceTask>\r\n\r\n        <endEvent id=\"sid-665b6b28-9b81-4ab7-ba77-6eb50da3c810\" name=\"End\"/>\r\n        <sequenceFlow id=\"sid-26493bea-97f7-44d4-b7ec-255266dcb8ab\" sourceRef=\"sid-0396a986-7e6b-4634-883b-1ee7db9aeb45\"\r\n                      targetRef=\"sid-c43c4370-4407-4746-893f-dcee3e4e9936\"/>\r\n        <sequenceFlow id=\"sid-9f0f635b-4e97-4e95-b1fd-c9996bf659af\" sourceRef=\"sid-c43c4370-4407-4746-893f-dcee3e4e9936\"\r\n                      targetRef=\"sid-665b6b28-9b81-4ab7-ba77-6eb50da3c810\"/>\r\n    </process>\r\n</definitions>',0),
('65002',1,'processes/test2.bpmn','65001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:exclusive=\"true\" name=\"task1\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n<!--       <bpmn:incoming>Flow_1cydcrq</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_1x26529</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text1\">\n              <activiti:string><![CDATA[test1]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:exclusive=\"true\" name=\"task2\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n<!--       <bpmn:incoming>Flow_1x26529</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_135u817</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text2\">\n              <activiti:string><![CDATA[test2]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('65003',1,'processes/test2.Process_0hy83oz.png','65001','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0 �A�\0\0�IDATx���lU����DG����K4q���Đ̅�\ZC2u��1Q��`�\rڱ	�Ca�故If���;lV�h��(/?�2���������mK���6�������I���R;������o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0@^!|oӦM���뭯��J��y�z�z����<į�?����v��⋟Ϟ=�Kưݻw�������̙3ìY���o����¾}�Bccc8z�h���{��M�_�|yx��\'CYYYϳ�>[3}���[�0F�߿��e˺��jժ4CQ[[�z���,�����裏��T�pwI�mܸ�HF�=����K����.]\Z�p�=f	C�X�bEg����.�������#��iIC�D���̠g޼y�<��*qw\'L�2eJ�%�{��[ou���!�Ʉ��4cƌ���%y����X�=����f?��O�c��v���?�@��Ç�HڳgO�e9�l䡥K��[�re\r�-�Nf���#�|��_�l���mT�O�&���AY�xqOyyyM����:����Z�\Z�;^Wq���Q\r���CIII�5y��w�ٱ`���JKK�=���?�V �-Y���u�r\"/��r&�])�V �͟?�\'��5��okM�q�Z���_�2=��v��ё�㸵9.�������\\���9.�PC�8v�Xw���V Ǖ������\\�qă�N�B���������|�ɩ���kr�s�=�3gU֬Ys�Y����oݴiSN�c޼yG�pl�V �-X��-Z��<yrה)S���q�>S�N�S���׿Z���Yk���O?�^YY9��Hv��6 OL�>}�O<1j�e�;v*�m�KvS&Z�G�z�ӣ�f��3g6$��?k�L|;{������cǎ��l�ݿ O=��c�={��(MvQ��x����>���ڗ_~9twwk4���;\'O����P\0&M�4n�ԩ�~�����#�i�|�G�{\n-�����9sf��>�gϞ/�C�URR�v23�Y�z��K=U{�̙��s�����x�҅϶$iHv_�G(tu��ĉm�/>���2>衇&X�0F$~i2�$	�f��\\�fM��ݻ�����f#���������۷�Nbѐ������{9�a�-qW#،�Έ�/�w;?z����I,�%�ω�K,5�f$�R\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0�@8\0�\0�@8\0�@8��UTT�C�u����Œ�g/\r\"�,)`г�\r`ȳ�\r`H��\r`ȳ�\r`H��\r`ȳ�\r`ȳK�Ò�BW[[[�}���-[��͛7#<*++CUUUkEE�c^���ɋ6$����������{MMMx��ză������zp�t\'3�f�Jr^�*g2n��<����UI^��F�;#��J\n*M\'Z��+��#>���q�����O��}����p�ǽ�=�N�i��c=1\ZoT�_�Y��{$���)���}ሏ����!<��̒���Z�C8����T[�����P|Ә����ŗ�m���X�U)��8�p���o�p ���Io�]U���p�m>���8>����m���XG<c~fӈ��s��c�q�E8��خH�e�����~V\0���\0�*��zp�y�G������?�����6������xX�jt��������s�p0�����ި<���>l��|�%��:�x�y�>�\r���p0�wUb<�[Z��Mn\'N���p �V/p��a�p�p�p�ppp��! ��a�a�a�p�p�!�!�! ��! �!����u�]��;��Y���?omm\r�&M�ڟȣp|�F����?w�y�e�{��ȡhdo�۶m&LW]uU����ʕ+������m������p�׆{�7���\\�����y晾?�8q�p@!�8b46n���ߟ>�uץ�ǯ��8�X�~}����o��;^}����i��~�<����\n9�\ns��	��zk�?�����W^ye��{²e�� d��+��\"��dɒa�%�#G�wG��+V���ggΜ	�6m\neee�nH���[���3f��27�|�p@!��k�I7膆���Ғ����Hdo�w�qG�xÆ\raǎ��n��(��+**�\n5���Z�����]��˗��K���(..��Յ��?�?>�M�֭[/��ڵk��>��p@���`pp��! ��! �p �p �p�p�p�ppp��! ��a�a�a�p�p�p�pp��! ��! �pP(�������hkk;����Jr^UUUOcc�\r7�Ν;%�8�UIΫ��\\���\\CC�93���L�����hEEEw��*��vջ��w[�u�|��\'#���^�0�b8,@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8�ˮ���=���FIII�%d�.^\ZD8fYR��gf��gf��ff��gf��ff��gf��g�0�Y�%#$�0����n���=[�l	�7o6FxTVV����֊��Ǽ\"��\'�mH�Z[[Cgg�1�#.������{���y��?���6��Nf �^��8U�d26��y$�ǫ����6wF\\^�T8�N���W�IG|lC�������n�����}ሏ{�?z�-�<�n��z8b4���.<��P��HxSxa�?������iCx.��%�N���p0���婶0w�g}���1����/O�������R��q��X���6|�@8:�ݓ�0<��:�i��P�|2�q|���7T7������x�$��>�C1���s��<��l�p0F�q�]�8��s���\0�!�vU����h��Ɵ���6~6�ӱ�?m��c=��x��`������6~�`����#�Qy0�ygg}ز���K��u���?|P26~�`���x4��~��N�n\r�@8��^8�2���\0��\0�0��0��0��C8@8��������\0�C8C8C8@8��C8@8�C8��n4w�u�%���R:.�S7�[o�5�7.���?�v���p|�F9~�ĉ�w������?s�m�	�s8z7��\r۶ma	᪫�\n7�xcX�re�|yyy��_}����k�\r��{o���� .L?��3���#G������(�G�Fܽؿ��u�]�>���?���~��������w�����iӦ]��̟??����O8���q�С0gΜ��D���}����+��2�s�=aٲe�������+үK�,��w�Y˷���p�\r7��\nZ8��H�~Ŋ���̙3aӦM���,\r@|��[n��;f̘����|��}�>Jw{~���QrV\n �\\sM��744������E�>F\";w�qG�xÆ\raǎ��n�����+**��������\'��ɓN�B����^�_}��|��t��4�����PWW���0~��461$[�n� k׮M?�������_�����C8C8C8@8��C8@8�������+ ��! �p �p �p�p�p�ppp��! ��!pp��! ��! �pPH�������hkk;����Jr^UUUOcc�\r7�Ν;%�8�UIΫ��\\���\\CC�93���L�����hEEEw��*��vջ��w[�u�|��\'#���^�0�b8,@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�eEEE�1_7JJJZ,) {v�� �1˒=�0�\0�<�0�\0�4�0�\0�<�0�\0�4�0�\0�<�0�\0�<�$����,ʒPlM���{�|�>?��$�x|>���)S�YZ0�wIJ�|�|���������=y���,E#~��%�C��EG�C=4�R�5iҤqq���\\�����|��PUU���\Z�ѣGC}}}ػwo���o��Fx��ǿ*\"�0��ӧ?	��|�AMMM����4,�����f�}���6�x,\"]���E���Çå��7o�����u�<���+�i��ݰ�L�֮].�8���xA<�< ��i�?��n���v���C<����b\r@~�6�e�4����p��p��X�P+{#^�~}	w[�<r�j�t���oFJ<�}�4^�am@~DcN�.JSSSI�lK������8һ��]�ѐ}�G���Z�VRR�����W����nkr{��w/��s���ud_��]���ο�5�X�򗿄�/g��]�l�@���]�ߜ6�\\�q�ځ�\rG�{RF�l�@1\\Y�8n�@���)O&��pķ�g�#c�@ocmǏwf�-]]]�\Z�x3��O������}\r�Ů���,�òϪ�\rw4��:�y ��wc]�nݨ�#��4+[���p�޻�.X�`T���Of杖Y;���M�������J4�\r�����q������\\n���&O���w�---�YG�{��[�Z+�����\r��7��pď^Ȋ��䉒��Y����u���F���7~ܤ��5�8�������\Z����n�;A��:���2��O<1l��0u��~��b-@~���x:4{�q�w[�G/d�4�[��iaK�;e���=`z�g[��>�G/8�r�]͡�f��<����y5 ��s�������F��Y��6�1�#f}������7��0��%?�(�,�ݼbd�\r�/��Ǐ�tL\n; �����q��a9����0q�2�R�1*��揄o�??��Y��gI�����R���\0\0\0\0\0\0\0\0.�n�m��w�\0\0\0\0IEND�B`�',1),
('70002',1,'processes/test2.bpmn','70001','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n                    xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\"\n                    xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\"\n                    xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\"\n                    xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\"\n                    xmlns:activiti=\"http://activiti.org/bpmn\"\n                    id=\"Definitions_13909a0\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"bpmn-js (https://demo.bpmn.io)\" exporterVersion=\"9.3.2\">\n  <bpmn:process id=\"Process_0hy83oz\" isExecutable=\"true\" name=\"A test process 2\">\n    <bpmn:startEvent id=\"StartEvent_07jmeqi\">\n      <bpmn:outgoing>Flow_1cydcrq</bpmn:outgoing>\n    </bpmn:startEvent>\n    <bpmn:serviceTask id=\"Activity_1tlvosh\" activiti:exclusive=\"true\" name=\"task1\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask2\">\n<!--       <bpmn:incoming>Flow_1cydcrq</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_1x26529</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text1\">\n              <activiti:string><![CDATA[test1]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1cydcrq\" sourceRef=\"StartEvent_07jmeqi\" targetRef=\"Activity_1tlvosh\" />\n    <bpmn:serviceTask id=\"Activity_00xge6t\" activiti:exclusive=\"true\" name=\"task2\" activiti:class=\"cn.icexmoon.demo.books.book.entity.task.MyTestTask3\">\n<!--       <bpmn:incoming>Flow_1x26529</bpmn:incoming> -->\n<!--       <bpmn:outgoing>Flow_135u817</bpmn:outgoing> -->\n      <bpmn:extensionElements>\n          <activiti:field name=\"text2\">\n              <activiti:string><![CDATA[test2]]></activiti:string>\n          </activiti:field>\n      </bpmn:extensionElements>\n    </bpmn:serviceTask>\n    <bpmn:sequenceFlow id=\"Flow_1x26529\" sourceRef=\"Activity_1tlvosh\" targetRef=\"Activity_00xge6t\" />\n    <bpmn:endEvent id=\"Event_0j69tgw\">\n      <bpmn:incoming>Flow_135u817</bpmn:incoming>\n    </bpmn:endEvent>\n    <bpmn:sequenceFlow id=\"Flow_135u817\" sourceRef=\"Activity_00xge6t\" targetRef=\"Event_0j69tgw\" />\n  </bpmn:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_0hy83oz\">\n      <bpmndi:BPMNEdge id=\"Flow_1cydcrq_di\" bpmnElement=\"Flow_1cydcrq\">\n        <di:waypoint x=\"210\" y=\"118\" />\n        <di:waypoint x=\"210\" y=\"180\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_1x26529_di\" bpmnElement=\"Flow_1x26529\">\n        <di:waypoint x=\"210\" y=\"260\" />\n        <di:waypoint x=\"210\" y=\"310\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_135u817_di\" bpmnElement=\"Flow_135u817\">\n        <di:waypoint x=\"210\" y=\"390\" />\n        <di:waypoint x=\"210\" y=\"462\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_07jmeqi\">\n        <dc:Bounds x=\"192\" y=\"82\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1tlvosh_di\" bpmnElement=\"Activity_1tlvosh\">\n        <dc:Bounds x=\"160\" y=\"180\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_00xge6t_di\" bpmnElement=\"Activity_00xge6t\">\n        <dc:Bounds x=\"160\" y=\"310\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_0j69tgw_di\" bpmnElement=\"Event_0j69tgw\">\n        <dc:Bounds x=\"192\" y=\"462\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn:definitions>\n',0),
('70003',1,'processes/test2.Process_0hy83oz.png','70001','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0�\0\0\0 �A�\0\0�IDATx���lU����DG����K4q���Đ̅�\ZC2u��1Q��`�\rڱ	�Ca�故If���;lV�h��(/?�2���������mK���6�������I���R;������o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0@^!|oӦM���뭯��J��y�z�z����<į�?����v��⋟Ϟ=�Kưݻw�������̙3ìY���o����¾}�Bccc8z�h���{��M�_�|yx��\'CYYYϳ�>[3}���[�0F�߿��e˺��jժ4CQ[[�z���,�����裏��T�pwI�mܸ�HF�=����K����.]\Z�p�=f	C�X�bEg����.�������#��iIC�D���̠g޼y�<��*qw\'L�2eJ�%�{��[ou���!�Ʉ��4cƌ���%y����X�=����f?��O�c��v���?�@��Ç�HڳgO�e9�l䡥K��[�re\r�-�Nf���#�|��_�l���mT�O�&���AY�xqOyyyM����:����Z�\Z�;^Wq���Q\r���CIII�5y��w�ٱ`���JKK�=���?�V �-Y���u�r\"/��r&�])�V �͟?�\'��5��okM�q�Z���_�2=��v��ё�㸵9.�������\\���9.�PC�8v�Xw���V Ǖ������\\�qă�N�B���������|�ɩ���kr�s�=�3gU֬Ys�Y����oݴiSN�c޼yG�pl�V �-X��-Z��<yrה)S���q�>S�N�S���׿Z���Yk���O?�^YY9��Hv��6 OL�>}�O<1j�e�;v*�m�KvS&Z�G�z�ӣ�f��3g6$��?k�L|;{������cǎ��l�ݿ O=��c�={��(MvQ��x����>���ڗ_~9twwk4���;\'O����P\0&M�4n�ԩ�~�����#�i�|�G�{\n-�����9sf��>�gϞ/�C�URR�v23�Y�z��K=U{�̙��s�����x�҅϶$iHv_�G(tu��ĉm�/>���2>衇&X�0F$~i2�$	�f��\\�fM��ݻ�����f#���������۷�Nbѐ������{9�a�-qW#،�Έ�/�w;?z����I,�%�ω�K,5�f$�R\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0�@8\0�\0�@8\0�@8��UTT�C�u����Œ�g/\r\"�,)`г�\r`ȳ�\r`H��\r`ȳ�\r`H��\r`ȳ�\r`ȳK�Ò�BW[[[�}���-[��͛7#<*++CUUUkEE�c^���ɋ6$����������{MMMx��ză������zp�t\'3�f�Jr^�*g2n��<����UI^��F�;#��J\n*M\'Z��+��#>���q�����O��}����p�ǽ�=�N�i��c=1\ZoT�_�Y��{$���)���}ሏ����!<��̒���Z�C8����T[�����P|Ә����ŗ�m���X�U)��8�p���o�p ���Io�]U���p�m>���8>����m���XG<c~fӈ��s��c�q�E8��خH�e�����~V\0���\0�*��zp�y�G������?�����6������xX�jt��������s�p0�����ި<���>l��|�%��:�x�y�>�\r���p0�wUb<�[Z��Mn\'N���p �V/p��a�p�p�p�ppp��! ��a�a�a�p�p�!�!�! ��! �!����u�]��;��Y���?omm\r�&M�ڟȣp|�F����?w�y�e�{��ȡhdo�۶m&LW]uU����ʕ+������m������p�׆{�7���\\�����y晾?�8q�p@!�8b46n���ߟ>�uץ�ǯ��8�X�~}����o��;^}����i��~�<����\n9�\ns��	��zk�?�����W^ye��{²e�� d��+��\"��dɒa�%�#G�wG��+V���ggΜ	�6m\neee�nH���[���3f��27�|�p@!��k�I7膆���Ғ����Hdo�w�qG�xÆ\raǎ��n��(��+**�\n5���Z�����]��˗��K���(..��Յ��?�?>�M�֭[/��ڵk��>��p@���`pp��! ��! �p �p �p�p�p�ppp��! ��a�a�a�p�p�p�pp��! ��! �pP(�������hkk;����Jr^UUUOcc�\r7�Ν;%�8�UIΫ��\\���\\CC�93���L�����hEEEw��*��vջ��w[�u�|��\'#���^�0�b8,@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8�ˮ���=���FIII�%d�.^\ZD8fYR��gf��gf��ff��gf��ff��gf��g�0�Y�%#$�0����n���=[�l	�7o6FxTVV����֊��Ǽ\"��\'�mH�Z[[Cgg�1�#.������{���y��?���6��Nf �^��8U�d26��y$�ǫ����6wF\\^�T8�N���W�IG|lC�������n�����}ሏ{�?z�-�<�n��z8b4���.<��P��HxSxa�?������iCx.��%�N���p0���婶0w�g}���1����/O�������R��q��X���6|�@8:�ݓ�0<��:�i��P�|2�q|���7T7������x�$��>�C1���s��<��l�p0F�q�]�8��s���\0�!�vU����h��Ɵ���6~6�ӱ�?m��c=��x��`������6~�`����#�Qy0�ygg}ز���K��u���?|P26~�`���x4��~��N�n\r�@8��^8�2���\0��\0�0��0��0��C8@8��������\0�C8C8C8@8��C8@8�C8��n4w�u�%���R:.�S7�[o�5�7.���?�v���p|�F9~�ĉ�w������?s�m�	�s8z7��\r۶ma	᪫�\n7�xcX�re�|yyy��_}����k�\r��{o���� .L?��3���#G������(�G�Fܽؿ��u�]�>���?���~��������w�����iӦ]��̟??����O8���q�С0gΜ��D���}����+��2�s�=aٲe�������+үK�,��w�Y˷���p�\r7��\nZ8��H�~Ŋ���̙3aӦM���,\r@|��[n��;f̘����|��}�>Jw{~���QrV\n �\\sM��744������E�>F\";w�qG�xÆ\raǎ��n�����+**��������\'��ɓN�B����^�_}��|��t��4�����PWW���0~��461$[�n� k׮M?�������_�����C8C8C8@8��C8@8�������+ ��! �p �p �p�p�p�ppp��! ��!pp��! ��! �pPH�������hkk;����Jr^UUUOcc�\r7�Ν;%�8�UIΫ��\\���\\CC�93���L�����hEEEw��*��vջ��w[�u�|��\'#���^�0�b8,@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�\0�\0�@8\0�\0@8\0�\0�\0�\0�@8\0�\0@8\0�\0�@8\0�@8\0�\0�@8\0�\0�@8\0�@8\0�\0�@8\0�\0�eEEE�1_7JJJZ,) {v�� �1˒=�0�\0�<�0�\0�4�0�\0�<�0�\0�4�0�\0�<�0�\0�<�$����,ʒPlM���{�|�>?��$�x|>���)S�YZ0�wIJ�|�|���������=y���,E#~��%�C��EG�C=4�R�5iҤqq���\\�����|��PUU���\Z�ѣGC}}}ػwo���o��Fx��ǿ*\"�0��ӧ?	��|�AMMM����4,�����f�}���6�x,\"]���E���Çå��7o�����u�<���+�i��ݰ�L�֮].�8���xA<�< ��i�?��n���v���C<����b\r@~�6�e�4����p��p��X�P+{#^�~}	w[�<r�j�t���oFJ<�}�4^�am@~DcN�.JSSSI�lK������8һ��]�ѐ}�G���Z�VRR�����W����nkr{��w/��s���ud_��]���ο�5�X�򗿄�/g��]�l�@���]�ߜ6�\\�q�ځ�\rG�{RF�l�@1\\Y�8n�@���)O&��pķ�g�#c�@ocmǏwf�-]]]�\Z�x3��O������}\r�Ů���,�òϪ�\rw4��:�y ��wc]�nݨ�#��4+[���p�޻�.X�`T���Of杖Y;���M�������J4�\r�����q������\\n���&O���w�---�YG�{��[�Z+�����\r��7��pď^Ȋ��䉒��Y����u���F���7~ܤ��5�8�������\Z����n�;A��:���2��O<1l��0u��~��b-@~���x:4{�q�w[�G/d�4�[��iaK�;e���=`z�g[��>�G/8�r�]͡�f��<����y5 ��s�������F��Y��6�1�#f}������7��0��%?�(�,�ݼbd�\r�/��Ǐ�tL\n; �����q��a9����0q�2�R�1*��揄o�??��Y��gI�����R���\0\0\0\0\0\0\0\0.�n�m��w�\0\0\0\0IEND�B`�',1);

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
('15001','示例流程',NULL,'Process_0wu4lop','','2022-09-01 16:15:04.963',NULL),
('17501','示例流程',NULL,'Process_0wu4lop','','2022-09-01 17:05:53.503',NULL),
('20001','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:48:51.816',NULL),
('20005','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:50:30.672',NULL),
('22501','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:51:30.564',NULL),
('22505','A example process',NULL,'Process_0wu4lop','','2022-09-08 09:52:23.886',NULL),
('2501','示例流程',NULL,'Process_0wu4lop','','2022-08-31 14:46:47.723',NULL),
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
  `type` tinyint NOT NULL DEFAULT '5' COMMENT '书籍类型 1艺术 2小说 3科幻 4历史 5其它',
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
(6,'海底两万里','这是一本很好看的科幻小说',1,5,'',0),
(7,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(8,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(9,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(10,'八十天环游地球','凡尔纳写的一本科幻小说',2,5,'',0),
(11,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(12,'lalala','zhe shi yi ben hao shu.',1,5,'',0),
(13,'自由与和平','自由与和平习近平',1,5,'',0),
(14,'自由与和平','自由与和平习近平',1,5,'',0),
(15,'自由与和平','自由与和平',1,5,'',0),
(16,'自由与和平','自由与和平',1,5,'',0),
(17,'自由与和平','自由与和平',1,1,'',0),
(18,'自由与和平','自由与和平',1,1,'{}',0),
(19,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(20,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(21,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(22,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(23,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(24,'自由与和平','自由与和平',1,1,'{\"publisher\":\"海南出版社\"}',0),
(25,'自由与和平','自由与和平',1,1,'{\"iSBN\":\"111-222\",\"publisher\":\"海南出版社\"}',0),
(26,'自由与和平','自由与和平',1,1,'{\"iSBN\":\"111-222\",\"publisher\":\"海南出版社\"}',0);

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
  `open_id` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信openId',
  `real_name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名或昵称',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `del_flag` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`open_id`,`real_name`,`icon`,`del_flag`) values 
(1,'icexmoon','123','','','',0),
(2,'lalala','123','','','',0),
(3,'dd6524a9b91ce3508e968d18a6be588b','','o05bW5rgwlafHnCJ1zpMBQWqtzww','魔芋红茶?','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIv3gkJ4uclR5rmJS9icoCt2zkFDiaoVkORDrkOiaMv1772IwnXUeicvDNjycOYoM7OeN82z5au2c46lw/132',0);

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
