-----------INSERT INTO COURT -----------------------------
INSERT INTO `court` (`id`, `court_name`) VALUES (1, 'Play court 1');
INSERT INTO `court` (`id`, `court_name`) VALUES (2, 'Play court 2');
INSERT INTO `court` (`id`, `court_name`) VALUES (3, 'Play court 3');

----------INSERT INTO PLAYER------------------------------
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (100, 'first1','last1','first1.last1@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (101, 'first2','last2','first2.last2@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (102, 'first3','last3','first3.last3@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (103, 'first4','last4','first4.last4@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (104, 'first5','last5','first5.last5@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (105, 'first6','last6','first6.last6@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (106, 'first7','last7','first7.last7@gmail.com');
INSERT INTO `player` (`id`, `first_name`,`last_name`,`email`) VALUES (107, 'first8','last8','first8.last8@gmail.com');

----------INSERT INTO BOOKING-------------------------------
INSERT INTO `booking` (`id`, `court_id`,`player_id`,`booking_date`)
VALUES (1000, 1, 100, '05/09/2021');
INSERT INTO `booking` (`id`, `court_id`,`player_id`,`booking_date`)
VALUES (1001, 1, 101, '05/09/2021');
INSERT INTO `booking` (`id`, `court_id`,`player_id`,`booking_date`)
VALUES (1002, 3, 102, '05/09/2021');
INSERT INTO `booking` (`id`, `court_id`,`player_id`,`booking_date`)
VALUES (1003, 3, 103, '05/09/2021');
INSERT INTO `booking` (`id`, `court_id`,`player_id`,`booking_date`)
VALUES (1004, 3, 104, '05/09/2021');







